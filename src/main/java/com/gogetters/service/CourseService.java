package com.gogetters.service;

import com.gogetters.database.Database;
import com.gogetters.entity.Course;
import com.gogetters.service.CRUDService;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;

public class CourseService implements CRUDService<Course> {


    @Override
    public Course findById(int id) {
        return Database.courseList.stream()
                .filter(course -> course.id == id)
                .findFirst().orElseThrow();
    }

    @Override
    public List<Course> findAll() {
        return Database.courseList;
    }

    @Override
    public void deleteById(Long id) {
        Database.courseList.removeIf(p->p.id == id);
    }

    @Override
    public void update(Course course) {
        Database.courseList.stream()
                .filter(i -> i.getId() == course.getId())
                .forEach(i -> Database.courseList.set(Database.courseList.indexOf(i),course));
    }

    @Override
    public void save(Course course) {
        Database.courseList.add(course);
    }
}
