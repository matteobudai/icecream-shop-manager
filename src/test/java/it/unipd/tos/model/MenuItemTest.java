package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MenuItemTest {

    private MenuItem Budino;
    private MenuItem Bevanda;
    private MenuItem Gelato;

    @Before
    public void setup() {
        Budino = new MenuItem( ItemType.Budino, "Pinguino",3.00);
        Bevanda = new MenuItem(ItemType.Bevanda, "Fanta", 2.00);
        Gelato = new MenuItem( ItemType.Gelato, "Coppa Nafta", 4.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreTipologiaElementoNulloTest() {
        new MenuItem(null, "Fanta", 3.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttoreNomeElementoNulloTest() {
        new MenuItem(ItemType.Budino, null, 3.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void costruttorePrezzoElementoNegativoTest() {
        new MenuItem(ItemType.Bevanda, "Fanta", -3.00);
    }

    @Test
    public void getNameTest() {
        assertEquals("Pinguino", Budino.getName());
        assertEquals("Fanta", Bevanda.getName());
        assertEquals("Coppa Nafta", Gelato.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(3.00, Budino.getPrice(), 0.0);
        assertEquals(2.00, Bevanda.getPrice(), 0.0);
        assertEquals(4.00, Gelato.getPrice(), 0.0);
    }

    @Test
    public void getTypeTest() {
        assertEquals(ItemType.Budino, Budino.getType());
        assertEquals(ItemType.Bevanda, Bevanda.getType());
        assertEquals(ItemType.Gelato, Gelato.getType());
    }
}
