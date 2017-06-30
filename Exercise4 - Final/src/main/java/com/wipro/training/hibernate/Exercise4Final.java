package com.wipro.training.hibernate;

import com.google.common.collect.Lists;
import com.wipro.training.hibernate.dao.DefaultDAO;
import com.wipro.training.hibernate.entity.ExamResult;
import com.wipro.training.hibernate.entity.Student;

import java.util.Calendar;
import java.util.List;

/**
 * Created by e068636 on 6/28/2017.
 */
public class Exercise4Final {

    public static void main(String args[]) {

        DefaultDAO defaultDAO = new DefaultDAO(Student.class);

        Student student = new Student();
        student.setName("Marcel - ExamResult");
        student.setRegistrationNumber(01);

        ExamResult examResult = new ExamResult();
        examResult.setId( Math.round( Math.random()*100 ) );
        examResult.setExamDate(Calendar.getInstance().getTime() );
        examResult.setExamLocation("Exam1");
        examResult.setMark(1);

        ExamResult examResult2 = new ExamResult();
        examResult2.setId( Math.round( Math.random()*100 ) );
        examResult2.setExamDate(Calendar.getInstance().getTime() );
        examResult2.setExamLocation("Exam2");
        examResult2.setMark(2);

        student.setExamResults(Lists.newArrayList(examResult, examResult2) );

        defaultDAO.save( student );

        //
        List<Student> listStudent = defaultDAO.findAll();
        System.out.println( listStudent.size() );

        //
        DefaultDAO examResultDAO = new DefaultDAO(ExamResult.class);
        List<ExamResult> listExamResult = examResultDAO.findAll();
        System.out.println( listExamResult.size() );

        System.exit(0);

    }

}
