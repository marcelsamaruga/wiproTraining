package com.wipro.training.hibernate;

import com.wipro.training.hibernate.dao.DefaultDAO;
import com.wipro.training.hibernate.entity.Scholarship;
import com.wipro.training.hibernate.entity.Student;

import java.util.List;

/**
 * Created by e068636 on 6/28/2017.
 */
public class Exercise3Error {

    public static void main(String args[]) {

        DefaultDAO defaultDAO = new DefaultDAO(Student.class);

        Scholarship scholarship = new Scholarship();
        Student student = new Student();

        scholarship.setAmount(1);
        scholarship.setDescription("desc");

        student.setName("Marcel");
        student.setRegistrationNumber(1);
        student.setScholarship(scholarship);
        scholarship.setGrantedTo(student);

        defaultDAO.save(scholarship);

        List<Scholarship> listScholar = defaultDAO.findAll();
        System.out.println( listScholar.size() );

        List<Student> listStudent = defaultDAO.findAll();
        System.out.println( listScholar.size() );

       System.exit(0);


    }

}
