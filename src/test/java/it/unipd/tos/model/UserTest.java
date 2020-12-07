package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

public class UserTest {

    private User Matteo = new User("teo99","Matteo","Budai",LocalDate.of(1999, 9, 23));

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreNicknameNulloTest() {
        new User(null,"Matteo","Budai",LocalDate.of(1999, 9, 23));
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreNomeNulloTest() {
        new User("teo99",null,"Budai",LocalDate.of(1999, 9, 23));
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreCognomeNulloTest() {
        new User("teo99","Matteo",null,LocalDate.of(1999, 9, 23));
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreDataNullaTest() {
        new User("teo99","Matteo","Budai",null);
    }

    @Test
    public void getNameTest() {
        assertEquals(Matteo.getName(), "Matteo");
    }

    @Test
    public void getNicknameTest(){
        assertEquals(Matteo.getNickname(), "teo99");
    }

    @Test
    public void getSurnameTest() {
        assertEquals(Matteo.getSurname(), "Budai");
    }

    @Test
    public void getAgeTest() {
        assertEquals(Matteo.getAge(), 21);  
    }
} 
