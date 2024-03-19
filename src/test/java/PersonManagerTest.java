import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonManagerTest {

    private PersonManager personManager;

    @BeforeEach
    void setUp() {
        personManager = new PersonManager();
    }


    @Test
    void createPerson() {
        Person person = personManager.createPerson("Natalie", "Schöfecker");
        assertEquals("Natalie", person.getName());
        assertEquals("Schöfecker", person.getLastname());
        //assertNotNull(person);

    }

    @Test
    void testCreatePerson() {
        Person person = personManager.createPerson("Natalie", "Schöfecker", LocalDate.parse("16/08/1996", PersonManager.birthdayFormatter), Gender.FEMALE);
        assertEquals("Natalie", person.getName());
        assertEquals("Schöfecker", person.getLastname());
        assertEquals(LocalDate.parse("16/08/1996", PersonManager.birthdayFormatter), person.getBirthday());
        assertEquals(Gender.FEMALE, person.getGender());
    }

    @Test
    void testCreateAddress() {
        Address address = new Address("Hasnerstraße", 29, 4020, "Linz");
        assertEquals("Hasnerstraße", address.getStreet());
        assertEquals(29, address.getNumber());
        assertEquals(4020, address.getPlz());
        assertEquals("Linz", address.getPlace());
    }

    @Test
    void removePerson() {
        Person person = personManager.createPerson("Natalie", "Schöfecker");
        personManager.removePerson(person.getName());
        assertThrows(NullPointerException.class, () -> personManager.searchPerson("Natalie"));
    }

    @Test
    void listPerson() {
        personManager.createPerson("Natalie", "Schöfecker", LocalDate.parse("16/08/1996",PersonManager.birthdayFormatter),Gender.FEMALE, new Address("Hasnerstraße",29, 4020, "Linz"));
        personManager.createPerson("Matthias", "Schöfecker", LocalDate.parse("05/12/2020",PersonManager.birthdayFormatter),Gender.MALE,new Address("Sesamenstraße", 1, 9020, "Insbruck"));
        assertDoesNotThrow(() -> personManager.printPersonList());
    }

    @Test
    void testSearchExistingPerson() {
        Person person = personManager.createPerson("Natalie", "Schöfecker");
        assertEquals(person, personManager.searchPerson("Natalie"));
    }


    @Test
    void testSearchPersonNotFound() {
        assertThrows(NullPointerException.class, () -> {
            personManager.searchPerson("Nonexistent Person");
        });
    }

}