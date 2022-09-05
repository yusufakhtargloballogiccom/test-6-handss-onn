package com.Q2.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Q2.demo.model.Student;
import com.Q2.demo.service.StudentRepo;

@RestController
public class ControlSwagger {
@Autowired
private StudentRepo srepo;
//getting all data
@RequestMapping(value="/studentdeatils" ,method=RequestMethod.GET,produces="application/json")
public List<Student> getdata()
{
	return srepo.findAll();
}
//creating and storing into data
@PostMapping("/createData")
public Student CreateData(@RequestBody Student student)
{
	return srepo.save(student);

}
//deleting a data by by id
@DeleteMapping("/student/{id}")
public void delete(@PathVariable("id") int id)
{
	srepo.deleteById(id);
}
//updating all data by finding the id of the student
@PutMapping("/student/{id}")
public Student updatedata(@PathVariable("id") int id, @RequestBody Student student)
{
	
	Optional<Student> std1=srepo.findById(id);
	Student toset=std1.get();
	toset.setName(student.getName());
	toset.setStandard(student.getStandard());
	toset.setFees(student.getFees());
	return srepo.save(toset);
	
}
//getting only a data by specifying only id;
@GetMapping("/studdent/{id}")
public Optional<Student>getstudentyId(@PathVariable("id") int id){
	        Optional<Student>  std=srepo.findById(id);
	        return std;
	    }





}
