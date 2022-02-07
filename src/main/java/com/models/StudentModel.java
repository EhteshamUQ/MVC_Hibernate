package com.models;

import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import java.util.List;

public class StudentModel {
    public List<Student> getData(){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        List<Student> studentList = null;
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            studentList = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return studentList;
    }

    public boolean addStudent(String firstName , String lastName , String email){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Student student = new Student(firstName , lastName , email);
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteStudent(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class , id);
            session.delete(student);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Student getStudent(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

            Student student;
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            student = session.get(Student.class , id);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return student;
    }

    public boolean updateStudent(int id , String firstName , String lastName , String email){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Student student = session.get(Student.class , id);
            student.setLastName(lastName);
            student.setEmail(email);
            student.setFirstName(firstName);
            session.save(student);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
