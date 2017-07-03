package com.wipro.training.hibernate;

import com.google.common.collect.Lists;
import com.wipro.training.hibernate.dao.DefaultDAO;
import com.wipro.training.hibernate.dao.StudentDAO;
import com.wipro.training.hibernate.entity.Course;
import com.wipro.training.hibernate.entity.ExamResult;
import com.wipro.training.hibernate.entity.Scholarship;
import com.wipro.training.hibernate.entity.Student;

import java.util.Calendar;
import java.util.List;

/**
 * Created by e068636 on 6/28/2017.
 */
public class Exercise8 {

    public static void main(String args[]) {

        DefaultDAO<Course> courseDAO = new DefaultDAO<Course>(Course.class);

        // -> TRANSIENT
        Course course = new Course();

        // set values
        course.setTitle("My new course");
        course.setCourseNumber("0016");

        System.out.println( course.toString() );
        System.out.println( courseDAO.getState(course) );

        // TRANSIENT -> MANAGED
        courseDAO.save( course );

        System.out.println( course.toString() );
        System.out.println( courseDAO.getState(course) );


        // ******************************************


        // -> MANAGED
        Course course2 = courseDAO.find( 1L );
        System.out.println( course2.toString() );
        System.out.println( courseDAO.getState(course2) );

        // MANAGED -> DETACHED
        courseDAO.detach( course2 );
        System.out.println( course2.toString() );
        System.out.println( courseDAO.getState(course2) );

        course2.setTitle("Title updated");
        System.out.println( course2.toString() );
        System.out.println( courseDAO.getState(course2) );


        courseDAO.merge( course2 );
        System.out.println( course2.toString() );
        System.out.println( courseDAO.getState(course2) );


        // ******************************************

        course2.setTitle("Title update again!");

        // DETACHED -> MANAGED
        course2 = courseDAO.merge( course2 );
        System.out.println( course2.toString() );
        System.out.println( courseDAO.getState(course2) );


        System.exit(0);
        // ******************************************

    }

}
