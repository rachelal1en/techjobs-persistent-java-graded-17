package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    //TODO Task 2 Part 6 - Add a private field to utilize EmployerRepository
    @Autowired
    private EmployerRepository employerRepository;

    //TODO Task 2 Part 7 - Add a method that responds with a list of all of the employers
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("employers", employerRepository.findAll());
        return "employers/index";
    }

    //form to add new employers
    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }
    //TODO Task 2 Part 8 - Add method using repository to save valid object
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        } else {
            employerRepository.save(newEmployer);
            return "redirect:";
        }
    }

    //TODO Task 2 Part 9 - add method to render view of individual employer object
    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional<Employer> optEmployer = employerRepository.findById(employerId);

        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

    }
}
