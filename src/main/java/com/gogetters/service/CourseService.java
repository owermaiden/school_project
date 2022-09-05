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

        for (Course course : Database.courseList) {

            if (course.getId() == id){
                return course;
            }
        }

        throw new Exception("Course could not find!");
    }

    @Override
    public List<Course> findAll() {

        return Database.courseList;
    }

    @Override
    public void save(Course course) {

        Database.courseList.add(course);

    }

    @Override
    public void update(Course course) throws Exception {

        /*

            for (Course eachCourse : Database.courseList) {

                if (eachCourse.getId() == course.getId()){
                    Database.courseList.set(course.getId()-1, course);
                    return;
                }

            }

        throw new Exception("Course could not updated because the given id does not match!" + " Course id : " + course.id);


         */

        Database.courseList.stream()
                .filter(course1 -> course1.getId()==course.id)
                .forEach(course1 -> Database.courseList.set(Database.courseList.indexOf(course1),course));


    }

    @Override
    public void deleteById(Long id) throws Exception {

        for (Course course : Database.courseList) {

            if (course.getId() == id){
                Database.courseList.removeIf(c -> c.getId()== id);
                return;
            }

        }

        throw new Exception("Course could not found because the given id does not match!");


    }


}
