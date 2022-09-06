package com.gogetters;

import com.gogetters.database.Database;
import com.gogetters.entity.Course;
import com.gogetters.entity.Parent;
import com.gogetters.entity.School;
import com.gogetters.entity.Student;
import com.gogetters.enums.WeekDays;
import com.gogetters.service.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolMainRunner {


    public static CRUDService<School> schoolService;
    public static CRUDService<Course> courseService;
    public static CRUDService<Parent> parentService;
    public static CRUDService<Student> studentService;

    static {
        SchoolMainRunner.schoolService = new SchoolService();
        SchoolMainRunner.courseService = new CourseService();
        SchoolMainRunner.parentService = new ParentService();
        SchoolMainRunner.studentService = new StudentService();
    }

    public static void main(String[] args) {
        Course course = new Course(40,"HTML",90,List.of(WeekDays.THURSDAY));
        courseService.save(course);
        System.out.println(Database.courseList);

        System.out.println(schoolService.findById(1));
        System.out.println(schoolService.findAll());

    }
        System.out.println(schoolService.findById(90));

        Course course1 = new Course(40,"HTML",80,List.of(WeekDays.THURSDAY,WeekDays.WEDNESDAY));
        courseService.update(course1);
        System.out.println(Database.courseList);
    }

}
