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
public class Exercise9 {

    public static void main(String args[]) {

        StudentDAO studentDAO = new StudentDAO();


        System.exit(0);
        // ******************************************

    }

    private static void printStudents(List<Student> studentList) {
        for (Student student: studentList) {
            System.out.println( student.toString() );
        }
    }

}
