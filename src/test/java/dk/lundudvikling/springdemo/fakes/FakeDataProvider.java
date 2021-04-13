package dk.lundudvikling.springdemo.fakes;


import dk.lundudvikling.springdemo.people.models.Person;

import java.util.ArrayList;
import java.util.List;

public class FakeDataProvider {
    public List<Person> getFakePeople(){
        List<Person> fakePeople = new ArrayList<>();
        fakePeople.add(getFakePerson());
        return fakePeople;
    }

    public Person getFakePerson(){
        Person fakePerson = new Person();
        fakePerson.setFirstName("Test");
        fakePerson.setLastName("Testesen");
        fakePerson.setAge(28);
        return fakePerson;
    }
}
