package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//TODO Task 2 Part 4 - Create new interface to map employer to the database
//interface is extending crud respiratory which can create/read/update/delete
@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}
