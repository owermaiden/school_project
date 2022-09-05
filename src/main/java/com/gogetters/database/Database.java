package com.gogetters.database;

import com.gogetters.SchoolMainRunner;
import com.gogetters.entity.Course;
import com.gogetters.entity.Parent;
import com.gogetters.entity.School;
import com.gogetters.entity.Student;
import com.gogetters.enums.WeekDays;

import java.util.ArrayList;
import java.util.List;

public class Database extends SchoolMainRunner {

    public static List<Course> courseList = new ArrayList<>(List.of(
            new Course(1,"English", 40, List.of(WeekDays.MONDAY, WeekDays.THURSDAY)),
            new Course(2,"Math",50, List.of(WeekDays.values())),
            new Course(3,"Java",80, List.of(WeekDays.WEDNESDAY))
    ));

    public static List<Parent> parentList = new ArrayList<>(List.of(
            new Parent(1,"John", "Wayne"),
            new Parent(2,"Mike", "Junior")
    ));

    public static List<Student> studentList = new ArrayList<>(List.of(
            new Student(1,12345L, "Jayne", "Smith", parentList.get(0), courseList ),
            new Student(2, 12346L, "Candy", "Brown", parentList.get(1),courseList )
    ));

    public static List<School> schoolList = new ArrayList<>(List.of(
            new School(1,"ABC_School", studentList,courseList),
            new School(2,"Java_School", studentList,courseList)
    ));






}
