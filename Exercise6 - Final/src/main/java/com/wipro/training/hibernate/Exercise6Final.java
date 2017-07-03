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
public class Exercise6Final {

    public static void main(String args[]) {

        DefaultDAO courseDAO = new DefaultDAO(Course.class);

        Course course = (Course) courseDAO.find(1L);

        System.out.println("\n**************************************\n");
        System.out.print( course.getStudents() );


        System.exit(0);

    }

}
