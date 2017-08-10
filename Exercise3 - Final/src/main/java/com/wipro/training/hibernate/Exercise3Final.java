package com.wipro.training.hibernate;

import com.wipro.training.hibernate.dao.DefaultDAO;
import com.wipro.training.hibernate.entity.Scholarship;
import com.wipro.training.hibernate.entity.Student;

import java.util.List;

/**
 * Created by e068636 on 6/28/2017.
 */
public class Exercise3Final {

    public static void main(String args[]) {

        DefaultDAO defaultDAO = new DefaultDAO(Student.class);
        DefaultDAO defaultDAO2 = new DefaultDAO(Scholarship.class);

        Student student = new Student();
        student.setName("Marcel");
        student.setRegistrationNumber(1);

        Scholarship scholarship = new Scholarship();
        scholarship.setAmount(1);
        scholarship.setDescription("desc");

        defaultDAO2.save(scholarship);

        student.setScholarship(scholarship);

        defaultDAO.save(student);

        List<Scholarship> listScholar = defaultDAO.findAll();
        System.out.println( listScholar.size() );

        List<Student> listStudent = defaultDAO.findAll();
        System.out.println( listScholar.size() );

       System.exit(0);


    }

}
