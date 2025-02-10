package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//TODO Task 2 Part 5 - Create new interface to map skill to database also extending crud
@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
