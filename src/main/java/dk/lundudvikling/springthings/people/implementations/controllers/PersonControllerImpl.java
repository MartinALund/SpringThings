package dk.lundudvikling.springthings.people.implementations.controllers;

import dk.lundudvikling.springthings.people.exceptions.JpaException;
import dk.lundudvikling.springthings.people.implementations.services.PersonServiceImpl;
import dk.lundudvikling.springthings.people.interfaces.controllers.PersonController;
import dk.lundudvikling.springthings.people.interfaces.services.PersonService;
import dk.lundudvikling.springthings.people.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonControllerImpl implements PersonController {

    private PersonService personService;

    public PersonControllerImpl(PersonServiceImpl personServiceImpl) {
        this.personService = personServiceImpl;
    }

    @Override
    public ResponseEntity<List<Person>> getPeople(){
        try {
            return new ResponseEntity<>(personService.getPeople(), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Page<Person>> getPeopleByFirstNamePaging(String firstName) {
        try {
            return new ResponseEntity<>(personService.getPeopleByFirstNamePaging(firstName), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        try {
            return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        try {
            return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deletePersonById(@PathVariable("id") long id){
        try {
            personService.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (JpaException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
