package com.gogetters.service;

import com.gogetters.database.Database;
import com.gogetters.entity.Student;

import java.util.List;
import java.util.Optional;

import static com.gogetters.database.Database.studentList;

public class StudentService implements CRUDService<Student>{

    @Override
    public Student findById(int id) {
        return Database.studentList.stream()
                .filter(student -> student.getId()==id)
                .findFirst().orElseThrow();
    }

    @Override
    public List<Student> findAll() {
        return Database.studentList;
    }

    @Override
    public void save(Student student) {
        Database.studentList.add(student);
    }

    @Override
    public void update(Student student) {
        Database.studentList.stream()
                .filter(x -> x.getId()==student.getId())
                .forEach(x-> studentList.set(studentList.indexOf(x), student));
    }

    @Override
    public long deleteById(Long id) {
        Database.studentList.stream()
                .filter(student -> student.getId()==id)
                .findFirst().orElseThrow();
        return 0;
    }
}
