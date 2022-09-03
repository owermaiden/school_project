package com.gogetters.service;

import com.gogetters.database.Database;
import com.gogetters.entity.School;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolService implements CRUDService<School> {

    @Override
    public School findById(int id) {
       return  Database.schoolList.stream().filter(x->x.getId()==id).findFirst().orElseThrow(()->new RuntimeException("The ID does not exist"));
    }

    @Override
    public List<School> findAll() {
        return Database.schoolList;

    }

    @Override
    public void save(School school) {
        System.out.println(Database.schoolList.add(school));

    }

    @Override
    public void update(School courseName) {
        Database.schoolList.stream()
                .filter(course->course.getName().equals("English"))
                .findFirst()
                .ifPresent(course->course.setName("German"));




    }

    @Override
    public void deleteById(Long id) {
        Database.schoolList.removeIf(x->x.getId() == id);

    }
}
