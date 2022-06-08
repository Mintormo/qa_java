package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FelineTest {
    @Test
    public void eatMeatReturnPredatorFood() {
        List<String> predatorFood = List.of("Животные", "Птицы", "Рыба");
        try {
            Feline feline = new Feline();
            List<String> foods = feline.eatMeat();
            assertTrue(foods.equals(predatorFood));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void getFamilyReturnFeline() {
        String expectedFamily = "Кошачьи";

        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnOne() {
        int expectedKittens = 1;

        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getKittensReturnMoreThanOne() {
        int expectedKittens = 5;

        Feline feline = new Feline();
        int actualKittens = feline.getKittens(5);
        assertEquals(expectedKittens, actualKittens);
    }
}
