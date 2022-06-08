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
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void getSoundReturnMeow() {
        String expectedSound = "Мяу";

        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void getFoodReturnFoodsForPredator() {
        try {
            List<String> expectedPredatorFood = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(feline.eatMeat())
                    .thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Cat cat = new Cat(feline);
            List<String> foods = cat.getFood();
            assertTrue(foods.equals(expectedPredatorFood));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
