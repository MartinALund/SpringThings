package dk.lundudvikling.springthings.people.interfaces;

import dk.lundudvikling.springthings.fakes.FakeDataProvider;
import dk.lundudvikling.springthings.people.interfaces.controllers.PersonController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonControllerTest implements PersonController {

    private FakeDataProvider fakeDataProvider;

    @Before
    public void setup(){
        fakeDataProvider = new FakeDataProvider();
    }

    @Test
    public void should_defaultToHttpStatus501_IfCreatePersonIsNotOverridden(){
        Assert.assertEquals(501, createPerson(fakeDataProvider.getFakePerson()).getStatusCodeValue());
    }

    @Test
    public void should_defaultToHttpStatus501_IfGetPersonByIdIsNotOverridden(){
        Assert.assertEquals(501, getPersonById(123L).getStatusCodeValue());
    }

    @Test
    public void should_defaultToHttpStatus501_IfGetPeopleIsNotOverridden(){
        Assert.assertEquals(501, getPeople().getStatusCodeValue());
    }

    @Test
    public void should_defaultToHttpStatus501_IfUpdatePersonIsNotOverridden(){
        Assert.assertEquals(501, updatePerson(fakeDataProvider.getFakePerson()).getStatusCodeValue());
    }

    @Test
    public void should_defaultToHttpStatus501_IfDeletePersonIsNotOverridden(){
        Assert.assertEquals(501, deletePersonById(123L).getStatusCodeValue());
    }

}
