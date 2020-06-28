package com.jpa.StandardJPA.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
	
   private StudentserviceImpl studentService;
   
   @Autowired
   public StudentController(StudentserviceImpl studentService)
   {
	   this.studentService=studentService;
   }

   @GetMapping("/stud")
   public List<Student> get()
   {
	   return studentService.findAll();
   }
   
   @GetMapping("/delete/{id}")
   public void delete(@PathVariable("id") Integer id)
   {
	   studentService.deleteById(id);
   }
   
   @PostMapping("/save")
   public String add(@RequestBody Student stu)
   {
	  stu= studentService.save(stu);
	   if(stu!=null)
		   return("Given student entity added");
	   else
		   return ("Given student entity not added");
   }
   
   @GetMapping("/stud/{id}")
   public Student find(@PathVariable("id") Integer id)
   {
	   Optional<Student> stu =studentService.findById(id);
	   if(stu!=null)
		   return stu.get();
	   else
		   return null;
   }
}