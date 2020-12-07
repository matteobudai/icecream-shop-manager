package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    private MenuItem item;
    private List<MenuItem> itemsOrdered;
    private User user;
    private LocalTime time;
    private Order ordine;

    @Before
    public void setup() {
        itemsOrdered = new ArrayList<MenuItem>();
        user = new User("teo99","Matteo","Budai",LocalDate.of(1999, 9, 23));
        time = LocalTime.of(14,00);
        item = new MenuItem(ItemType.Bevanda, "Fanta", 2.00);
        itemsOrdered.add(item);
        ordine = new Order(itemsOrdered, user, time, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreListaElementiVuotaTest() {
        itemsOrdered.clear();
        new Order(itemsOrdered, user, time, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreNomeUtenteNulloTest() {
        new Order(itemsOrdered, null, time, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreDataNullaTest() {
        new Order(itemsOrdered, user, null, 0);
    }

    @Test
    public void setPriceAndgetPriceTest() {
        ordine.setPrice(14);
        assertEquals(14,ordine.getPrice(),0.0);
    }

    @Test
    public void getUserTest(){
        assertEquals(ordine.getUser(), user);
    }

    @Test
    public void getOrarioOrdineTest(){
        assertEquals(ordine.getOrarioOrdine(), time);
    }

    @Test
    public void getListaElementiTest(){      
        assertEquals(ordine.getListaElementi(), itemsOrdered);
    }    
} 

