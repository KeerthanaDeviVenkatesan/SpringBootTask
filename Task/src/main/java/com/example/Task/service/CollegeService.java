package com.example.Task.service;

import com.example.Task.entity.College;
import com.example.Task.entity.Student;

import java.util.List;

public interface CollegeService {
    College saveCollege(College college);

    List<College> getAllCollege();

    College getCollegeById(Long college_id);

    College updateCollege(College college);
    void deleteCollege(Long college_id);
}
