package dk.lundudvikling.springthings.people.implementations.services;


import dk.lundudvikling.springthings.fakes.FakeDataProvider;
import dk.lundudvikling.springthings.people.exceptions.JpaException;
import dk.lundudvikling.springthings.people.models.Person;
import dk.lundudvikling.springthings.people.repositories.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl systemUnderTest;

    @MockBean private PersonRepository personRepository;

    private FakeDataProvider fakeDataProvider;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        fakeDataProvider = new FakeDataProvider();
    }

    @Test
    public void should_getListOfPeople_WhenGetPeopleIsCalled() throws JpaException {
        when(personRepository.findAll()).thenReturn(fakeDataProvider.getFakePeople());
        List<Person> testPeople = systemUnderTest.getPeople();
        Assert.assertEquals(1, testPeople.size());
        Assert.assertEquals("Test", testPeople.get(0).getFirstName());
    }

    @Test(expected = JpaException.class)
    public void should_throwJpaException_whenErrorHappenedInGetPeople() throws JpaException {
        doThrow(RuntimeException.class).when(personRepository).findAll();
        List<Person> testPeople = systemUnderTest.getPeople();
        Assert.assertEquals(0, testPeople.size());
    }

    @Test
    public void should_getOnePerson_WhenGetPersonByIdIsCalled() throws JpaException {
        String expectedName = "Test";
        when(personRepository.getPersonById(anyLong())).thenReturn(fakeDataProvider.getFakePerson());
        Person testPerson = systemUnderTest.getPerson(123L);
        Assert.assertEquals(expectedName, testPerson.getFirstName());
    }

    @Test(expected = JpaException.class)
    public void should_throwJpaException_whenErrorHappenedInGetPersonById() throws JpaException {
        doThrow(RuntimeException.class).when(personRepository).getPersonById(anyLong());
        Person testPerson = systemUnderTest.getPerson(123L);
        Assert.assertNull(testPerson);
    }

    @Test
    public void should_createPerson_WhenCreatePersonIsCalled() throws JpaException {
        String expectedName = "Test";
        when(personRepository.save(any())).thenReturn(fakeDataProvider.getFakePerson());
        Person testPerson = systemUnderTest.createPerson(new Person());
        Assert.assertEquals(expectedName, testPerson.getFirstName());
    }

    @Test(expected = JpaException.class)
    public void should_throwJpaException_whenErrorHappenedInCreatePerson() throws JpaException {
        doThrow(RuntimeException.class).when(personRepository).save(any());
        Person testPerson = systemUnderTest.createPerson(new Person());
        Assert.assertNull(testPerson);
    }

    @Test
    public void should_updatePerson_WhenUpdatePersonIsCalled() throws JpaException {
        String expectedName = "Test";
        when(personRepository.save(any())).thenReturn(fakeDataProvider.getFakePerson());
        Person testPerson = systemUnderTest.updatePerson(new Person());
        Assert.assertEquals(expectedName, testPerson.getFirstName());
    }

    @Test(expected = JpaException.class)
    public void should_throwJpaException_whenErrorHappenedInUpdatePerson() throws JpaException {
        doThrow(RuntimeException.class).when(personRepository).save(any());
        Person testPerson = systemUnderTest.updatePerson(new Person());
        Assert.assertNull(testPerson);
    }

    @Test
    public void should_deletePerson_WhenDeletePersonIsCalled() throws JpaException {
        systemUnderTest.deletePerson(123L);
        verify(personRepository, times(1)).deletePersonById(123L);
    }

    @Test(expected = JpaException.class)
    public void should_throwJpaException_whenErrorHappenedInDeletePerson() throws JpaException {
        doThrow(RuntimeException.class).when(personRepository).deletePersonById(anyLong());
        systemUnderTest.deletePerson(123L);
    }
}
