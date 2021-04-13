package dk.lundudvikling.springdemo.people.interfaces.controllers;

import dk.lundudvikling.springdemo.people.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("people")
@CrossOrigin("http://localhost:4200")
public interface PersonController {

    @GetMapping()
    default ResponseEntity<List<Person>> getPeople(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("pages/{firstName}")
    default ResponseEntity<Page<Person>> getPeopleByFirstNamePaging(@PathVariable("firstName") String firstName){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping()
    default ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping()
    default ResponseEntity<Person> updatePerson(@RequestBody Person person){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("{id}")
    default ResponseEntity<Person> getPersonById(@PathVariable("id") long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("{id}")
    default ResponseEntity<?> deletePersonById(@PathVariable("id") long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
