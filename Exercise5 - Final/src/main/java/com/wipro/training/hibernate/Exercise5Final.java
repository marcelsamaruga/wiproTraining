package com.wipro.training.hibernate;

import com.google.common.collect.Lists;
import com.wipro.training.hibernate.dao.DefaultDAO;
import com.wipro.training.hibernate.dao.StudentDAO;
import com.wipro.training.hibernate.entity.Course;
import com.wipro.training.hibernate.entity.ExamResult;
import com.wipro.training.hibernate.entity.Student;

import java.util.Calendar;
import java.util.List;

/**
 * Created by e068636 on 6/28/2017.
 */
public class Exercise5Final {

    public static void main(String args[]) {

        DefaultDAO courseDAO = new DefaultDAO(Course.class);
        StudentDAO studentDAO = new StudentDAO();

        List<Student> studentList = studentDAO.findAll();
        Course course = (Course) courseDAO.find(1L);

        course.setStudents(studentList);

        studentDAO.merge(studentList.get(0));

        //
        List<Course> listCourse = courseDAO.findAll();

        for (Course course1 : listCourse) {
            System.out.println( course1.getStudents().size() );
        }

        System.exit(0);

    }

}
