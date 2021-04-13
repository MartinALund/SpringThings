package dk.lundudvikling.springthings.people.repositories;

import dk.lundudvikling.springthings.people.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> getPersonById(long id);
    @Transactional
    void deletePersonById(long id);

    Person getPersonByFirstName(String firstName);

    @Query("SELECT person FROM people person WHERE person.id < 3")
    List<Person> getPeopleWhereIdIsLessThanThree();

    @Query("SELECT person FROM people person WHERE person.lastName LIKE %?1%")
    //Ordered query, first param will be injected into LIKE
    List<Person> getPeopleByCustomLastNameQuery(@Param("lastName") String lastName);

    //LIKE Query --> Injectes med "%like%"; wildcard
    List<Person> getPersonByFirstNameLike(String likeString);

    List<Person> findByFirstNameStartingWithIgnoreCase(String startingLetter);

    List<Person> findPeopleByFirstNameContainingIgnoreCase(String input);

    Page<Person> findByFirstName(String firstName, Pageable pageable);

}
