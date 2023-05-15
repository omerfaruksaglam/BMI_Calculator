/**
 * @author Ömer Faruk Sağlam
 * @date 12.05.2023
 * @description This class is used to handle and manage web requests in a Spring Boot application.
 */
package com.example.bmi_app.controller;

import com.example.bmi_app.DataAccessLayer.PersonRepository;
import com.example.bmi_app.DataAccessLayer.ViewDao;
import com.example.bmi_app.Entity.Person;
import com.example.bmi_app.Entity.ViewEntity;
import com.example.bmi_app.Exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin("http://localhost:3000")
public class Controller {

    private final PersonRepository personRepository;
    final private ViewDao viewDao;

    public Controller(PersonRepository personRepository, ViewDao viewDao) {
        this.personRepository = personRepository;
        this.viewDao = viewDao;
    }

    @GetMapping("/persons/{id}")
    public Person getPerson(@PathVariable(value = "id") int id){
        return personRepository.findById(id).get();
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public void createPerson(@RequestBody Person new_person){
        personRepository.save(new_person);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") int id, @RequestBody Person personDetails) throws ResourceNotFoundException {
        Person updatedPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not exist with id : " + id));

        updatedPerson.setId(personDetails.getId());
        updatedPerson.setFirstName(personDetails.getFirstName());
        updatedPerson.setLastName(personDetails.getLastName());
        updatedPerson.setGender(personDetails.getGender());
        updatedPerson.setHeight(personDetails.getHeight());
        updatedPerson.setWeight(personDetails.getWeight());
        updatedPerson.setDateOfBirth(personDetails.getDateOfBirth());

        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/persons/{id}")
    public Map<String ,Boolean> deletePerson(@PathVariable(value = "id") int id) {
        Person person = personRepository.findById(id).orElseThrow(() ->new ResolutionException("Person not found for this id  :" + id ));
        personRepository.delete(person);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PostMapping("/")
    public String calculateBMI(@ModelAttribute("person") Person person, Model model) {
        double heightInMeters = person.getHeight() / 100.0;
        double bmi = person.getWeight() / (heightInMeters * heightInMeters);
        model.addAttribute("bmi", bmi);
        return "result";
    }

    // View useage
    @GetMapping("/get_bmi")
    public List<ViewEntity> get_bmi(){
        return viewDao.getBmiFromView();
    }

}
