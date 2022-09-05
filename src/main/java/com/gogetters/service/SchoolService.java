package com.gogetters.service;

import com.gogetters.database.Database;
import com.gogetters.entity.Course;
import com.gogetters.entity.School;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolService implements CRUDService<School> {

    @Override
    public School findById(int id) {
       return  Database.schoolList.stream()
               .filter(x->x.getId()==id).findFirst()
               .orElseThrow(()->new RuntimeException("The ID does not exist"));
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
    public void update(School o) {
        Database.schoolList.stream()
                .filter(school -> school.getId()== o.getId())
                .forEach(school -> Database.schoolList.set(Database.schoolList.indexOf(school),o));


    }

    @Override
    public void deleteById(Long id) {
        Database.schoolList.removeIf(x->x.getId() == id);

    }
}
