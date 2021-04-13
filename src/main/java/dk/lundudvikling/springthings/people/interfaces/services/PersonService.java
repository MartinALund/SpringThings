package dk.lundudvikling.springthings.people.interfaces.services;

import dk.lundudvikling.springthings.people.exceptions.JpaException;
import dk.lundudvikling.springthings.people.models.Person;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    Person getPerson(long id) throws JpaException;
    List<Person> getPeople() throws JpaException;
    Page<Person> getPeopleByFirstNamePaging(String firstName) throws JpaException;
    Person createPerson (Person person) throws JpaException;
    Person updatePerson(Person person) throws JpaException;
    void deletePerson(long id) throws JpaException;
}
