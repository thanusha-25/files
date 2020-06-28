package com.jpa.StandardJPA.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
	
   private StudentServiceImpl studentService;
   
   @Autowired
   public StudentController(StudentServiceImpl studentService)
   {
	   this.studentService=studentService;
   }

   @GetMapping("/students")
   public List<Student> get()
   {
	   return studentService.getAll();
   }
   
   @GetMapping("/delete/{id}")
   public String delete(Integer id)
   {
	   int i=id.intValue();
	   return studentService.remove(i);
   }
   
   @GetMapping("/students/{id}")
   public Student find(@PathVariable Integer id)
   {
	   return  studentService.findById(id);
   }
   
   @GetMapping("/students/name/{name}")
   public Student find(@PathVariable String name)
   {
	   return  studentService.findByName(name);
   }
}