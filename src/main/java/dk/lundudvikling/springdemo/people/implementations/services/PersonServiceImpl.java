package dk.lundudvikling.springdemo.people.implementations.services;

import dk.lundudvikling.springdemo.people.exceptions.JpaException;
import dk.lundudvikling.springdemo.people.interfaces.services.PersonService;
import dk.lundudvikling.springdemo.people.models.Person;
import dk.lundudvikling.springdemo.people.repositories.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person getPerson(long id) throws JpaException {
        /* psuedo old way
        try{
            return person = repository.getPersonById(id).get();
        }catch (Exception e){
            throw NotFoundException();
        }
         */
        return  repository.getPersonById(id).orElseThrow
                ( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Message"));
    }

    @Override
    public List<Person> getPeople() throws JpaException {
        try{
            return repository.findAll();
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public Page<Person> getPeopleByFirstNamePaging(String firstName) throws JpaException {
        Page<Person> pages = repository.findByFirstName(firstName,
                PageRequest.of(0, 4, Sort.Direction.ASC, "lastName"));
        try{
            return pages;
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public Person createPerson(Person person) throws JpaException {
        try{
            return repository.save(person);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public Person updatePerson(Person person) throws JpaException {
        try{
            return repository.save(person);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }

    @Override
    public void deletePerson(long id) throws JpaException {
        try{
            repository.deletePersonById(id);
        }catch(Exception e){
            throw new JpaException(e.getMessage());
        }
    }
}
