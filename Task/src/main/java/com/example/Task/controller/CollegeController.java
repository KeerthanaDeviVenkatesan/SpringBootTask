package com.example.Task.controller;

import com.example.Task.entity.College;
import com.example.Task.service.Impl.CollegeServiceIml;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    private static final Logger logger = LogManager.getLogger(CollegeController.class);
    @Autowired
    CollegeServiceIml collegeServiceIml;

    @PostMapping("/add")
    public College addCollege(@RequestBody College college) {
        logger.info("Received request to add a new College: {}", college);
        College addedColleges = collegeServiceIml.saveCollege(college);
        logger.info("Added new College with ID: {}", addedColleges.getCollege_id());
        return addedColleges;
    }


    @GetMapping("/collegeById/{college_id}")
    public College getCollegeById(@PathVariable Long college_id) {
        logger.info("Received request to get college by ID: {}", college_id);
        College college = collegeServiceIml.getCollegeById(college_id);
        logger.info("Returned college by ID: {}", college);
        return college;
    }

    @GetMapping("/allColleges")
    public List<College> getAllCollege() {
        logger.info("Received request to get all college.");
        List<College> college = collegeServiceIml.getAllCollege();
        logger.info("Returned {} courses.", college.size());
        return college;
    }

    @PutMapping("/{college_id}")
    public College updateCollege(@PathVariable Long college_id, @RequestBody College college) {
        logger.info("Received request to update College with ID: {}", college_id);
        college.setCollege_id(college_id);
        College updatedCollege = collegeServiceIml.updateCollege(college);
        logger.info("Updated college with ID: {}", college_id);
        return updatedCollege;
    }

    @DeleteMapping("/{college_id}")
    public void deleteCollege(@PathVariable Long college_id) {
        logger.info("Received request to delete college with ID: {}", college_id);
        collegeServiceIml.deleteCollege(college_id);
        logger.info("Deleted College with ID: {}", college_id);
    }

}
