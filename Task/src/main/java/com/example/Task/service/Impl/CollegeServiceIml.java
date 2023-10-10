package com.example.Task.service.Impl;

import com.example.Task.repository.CollegeRepo;
import com.example.Task.entity.College;
import com.example.Task.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(value = {"Local","Dev","Prod"})
public class CollegeServiceIml implements CollegeService {
    @Autowired
    CollegeRepo collegeRepo;
    @Override
    public College saveCollege(College college) {
        return collegeRepo.save(college);
    }

    @Override
    public List<College> getAllCollege() {
        return collegeRepo.findAll();
    }

    @Override
    public College getCollegeById(Long college_id) {
        return collegeRepo.findById(college_id).orElse(null);
    }

    @Override
    public College updateCollege(College college) {
        return collegeRepo.save(college);
    }

    @Override
    public void deleteCollege(Long college_id) {
        collegeRepo.deleteById(college_id);
    }
}
