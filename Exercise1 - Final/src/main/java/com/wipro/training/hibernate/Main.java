package com.wipro.training.hibernate;

import com.wipro.training.hibernate.dao.DefaultDAO;
import com.wipro.training.hibernate.entity.Course;

import java.util.List;

/**
 * Created by e068636 on 6/28/2017.
 */
public class Main {

    public static void main(String args[]) {

        DefaultDAO defaultDAO = new DefaultDAO(Course.class);

        Course course = new Course();
        course.setCourseNumber("001");
        course.setTitle("Title");
        //course.setId(1L);

        defaultDAO.insert(course);

        List<Course> listCourse = defaultDAO.findAll();
        System.out.print(listCourse.size());

        System.exit(0);

    }

}
