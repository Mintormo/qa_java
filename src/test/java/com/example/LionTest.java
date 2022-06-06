package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensReturnOne() {
        int expectedKittens = 1;

        Mockito.when(feline.getKittens()).thenReturn(1);
        try {
            Lion lion = new Lion(feline, "Самец");
            int actualKittens = lion.getKittens();
            assertEquals(actualKittens, expectedKittens);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void doesHaveManeTrue() {
        boolean expectedMane = true;

        try {
            Lion lion = new Lion(feline, "Самец");
            boolean actualMane = lion.doesHaveMane();
            assertEquals(actualMane, expectedMane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void doesHaveManeFalse() {
        boolean expectedMane = false;

        try {
            Lion lion = new Lion(feline, "Самка");
            boolean actualMane = lion.doesHaveMane();
            assertEquals(actualMane, expectedMane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void LionUnknownSex() {
        try {
            Lion lion = new Lion(feline, "Нечто");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void getFoodReturnPredatorFoods() {
        try {
            List<String> expectedPredatorFood = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.getFood(Mockito.anyString()))
                    .thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Lion lion = new Lion(feline, "Самец");
            List<String> actualFoods = lion.getFood();
            assertTrue(expectedPredatorFood.equals(actualFoods));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
