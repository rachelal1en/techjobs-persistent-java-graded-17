package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    //TODO Task 3 Part 4 - add employer respiratory field
    @Autowired
    private EmployerRepository employerRepository;

    //TODO Task 4 Part 3 - wire in skills objects
    @Autowired
    public SkillRepository skillRepository;

    @Autowired
    public JobRepository jobRepository;

    //main page with a list of all jobs
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "MyJobs");
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    //form to add new job
    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	    model.addAttribute("title", "Add Job");
        model.addAttribute("job", new Job());
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    //TODO Task 3 Part 5 - Add code to select the employer associated with the new job
    //process form to add jobs, and validates
    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model,
                                    @RequestParam int employerId,
                                    @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
	    model.addAttribute("title", "Add Job");
            return "add";
        } else {
            Optional<Employer> optEmployer = employerRepository.findById(employerId);

            if (optEmployer.isPresent()) { //if the employer exists retreives it
                Employer employer = optEmployer.get();
                newJob.setEmployer(employer); //assigns it to the new job object
            } else {
                newJob.setEmployer(new Employer()); //if employer doesn't exist sets new empty employer to new job object
            }
            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills); //lists skills
            newJob.setSkills(skillObjs); //sets skills to job object
            jobRepository.save(newJob); //saves to database

            return "redirect:"; //if validation errors redirects to default
        }
    }

    //displays single job by ID
    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional <Job> optJob = jobRepository.findById(jobId);
            if (optJob.isEmpty()){
                return "redirect:";
            } else {
                model.addAttribute("job", optJob.get());
                return "view";
            }
    }

}
