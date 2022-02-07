package com.controllers;

import com.entity.Student;
import com.models.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @RequestMapping("/display")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        StudentModel studentModel = new StudentModel();
        List<Student> studentList = studentModel.getData();
        modelAndView.setViewName("display");
        modelAndView.addObject("studentList",studentList);
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("firstName") String firstName ,
                            @RequestParam("lastName") String lastName ,
                            @RequestParam("email") String email){
        ModelAndView modelAndView = new ModelAndView();
        StudentModel studentModel = new StudentModel();
        boolean status = studentModel.addStudent(firstName , lastName , email);
        modelAndView.setViewName("add");
        modelAndView.addObject("status",status);
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        StudentModel studentModel = new StudentModel();
        boolean status = studentModel.deleteStudent(id);
        modelAndView.setViewName("delete");
        modelAndView.addObject("status",status);
        return modelAndView;
    }

    @RequestMapping("/getDetails")
    public ModelAndView getDetails(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        StudentModel studentModel = new StudentModel();
        Student student = studentModel.getStudent(id);
        modelAndView.setViewName("getDetails");
        modelAndView.addObject("firstName", student.getFirstName());
        modelAndView.addObject("lastName", student.getLastName());
        modelAndView.addObject("email", student.getEmail());
        modelAndView.addObject("id", student.getId());
        return modelAndView;
    }


    @RequestMapping("/update")
    public ModelAndView add(@RequestParam("id") int id,
            @RequestParam("firstName") String firstName ,
                            @RequestParam("lastName") String lastName ,
                            @RequestParam("email") String email){
        ModelAndView modelAndView = new ModelAndView();
        StudentModel studentModel = new StudentModel();
        boolean status = studentModel.updateStudent(id , firstName , lastName , email);
        modelAndView.setViewName("updated");
        modelAndView.addObject("status",status);
        return modelAndView;
    }
}
