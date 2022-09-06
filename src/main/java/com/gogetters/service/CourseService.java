package com.gogetters.service;

import com.gogetters.database.Database;
import com.gogetters.entity.Course;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseService implements CRUDService<Course>{


    @Override
    public Course findById(int id) throws Exception {

        return Database.courseList.stream().filter(course -> course.getId() == id)
                .findFirst().orElseThrow( ()-> new Exception("Course could not find!"));

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
