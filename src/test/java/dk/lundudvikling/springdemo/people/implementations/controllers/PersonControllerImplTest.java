package dk.lundudvikling.springdemo.people.implementations.controllers;

import dk.lundudvikling.springdemo.fakes.FakeDataProvider;
import dk.lundudvikling.springdemo.people.exceptions.JpaException;
import dk.lundudvikling.springdemo.people.implementations.services.PersonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonControllerImplTest {

    @InjectMocks
    private PersonControllerImpl systemUnderTest;

    @MockBean
    PersonServiceImpl mockedService;
    private FakeDataProvider fakeDataProvider;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        fakeDataProvider = new FakeDataProvider();
    }

    @Test
    public void should_returnHttpStatus200_whenGetPeopleIsCalled() throws JpaException {
        when(mockedService.getPeople()).thenReturn(fakeDataProvider.getFakePeople());
        Assert.assertEquals(200, systemUnderTest.getPeople().getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus500_whenGetPeopleCallFailsUnexpectedly() throws JpaException {
        doThrow(JpaException.class).when(mockedService).getPeople();
        Assert.assertEquals(500, systemUnderTest.getPeople().getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus201_whenCreatePersonIsCalled() throws JpaException{
        when(mockedService.createPerson(any())).thenReturn(fakeDataProvider.getFakePerson());
        Assert.assertEquals(201, systemUnderTest.createPerson(fakeDataProvider.getFakePerson()).getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus500_whenCreatePersonFailsUnexpectedly() throws JpaException{
        doThrow(JpaException.class).when(mockedService).createPerson(any());
        Assert.assertEquals(500, systemUnderTest.createPerson(fakeDataProvider.getFakePerson()).getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus200_whenUpdatePersonIsCalled() throws JpaException{
        when(mockedService.updatePerson(any())).thenReturn(fakeDataProvider.getFakePerson());
        Assert.assertEquals(200, systemUnderTest.updatePerson(fakeDataProvider.getFakePerson()).getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus500_whenUpdatePersonFailsUnexpectedly() throws JpaException{
        doThrow(JpaException.class).when(mockedService).updatePerson(any());
        Assert.assertEquals(500, systemUnderTest.updatePerson(fakeDataProvider.getFakePerson()).getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus200_whenGetPersonByIdIsCalled() throws JpaException{
        when(mockedService.getPerson(anyLong())).thenReturn(fakeDataProvider.getFakePerson());
        Assert.assertEquals(200, systemUnderTest.getPersonById(123L).getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus500_whenGetPersonByIdFailsUnexpectedly() throws JpaException{
        doThrow(JpaException.class).when(mockedService).getPerson(anyLong());
        Assert.assertEquals(500, systemUnderTest.getPersonById(123L).getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus204_whenGetDeletePersonByIdIsCalled(){
        Assert.assertEquals(204, systemUnderTest.deletePersonById(123L).getStatusCodeValue());
    }

    @Test
    public void should_returnHttpStatus500_whenDeletePersonByIdFailsUnexpectedly() throws JpaException{
        doThrow(JpaException.class).when(mockedService).deletePerson(anyLong());
        Assert.assertEquals(500, systemUnderTest.deletePersonById(123L).getStatusCodeValue());
    }

}
