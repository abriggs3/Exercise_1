package edu.matc.entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class UserTest {
    User user;
    @Before
    public void setUp(){
        user = new User("Test", "user", "6", getLocalDate("08-01-2000"));
    }

    @Test
    public void returnUserAge() throws Exception {
        int age = user.returnUserAge();
        assertEquals("Age calculation failed", 17, age);
    }

    private LocalDate getLocalDate(String inputDate) {
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(inputDate, DATE_FORMAT);
    }

}