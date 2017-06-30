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
public class Exercise7 {

    public static void main(String args[]) {

        DefaultDAO scholarshipDAO = new DefaultDAO(Scholarship.class);
        StudentDAO studentDAO = new StudentDAO();

        Scholarship scholarship = new Scholarship();
        scholarship.setDescription("scholarship");
        scholarship.setAmount(50);

        // how to save the scholarship object removing the line below
        scholarshipDAO.save( scholarship );

        Student student = new Student();
        student.setName("New Student");
        student.setRegistrationNumber(2);
        student.setScholarship(scholarship);

        studentDAO.save(student);


        System.out.print(student.toString());

        System.exit(0);
    }

}
