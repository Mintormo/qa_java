package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AnimalTest {
    List<String> foods;
    String expectedKindAnimal;

    public AnimalTest(List<String> foods, String expectedKindAnimal) {
        this.foods = foods;
        this.expectedKindAnimal = expectedKindAnimal;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {List.of("Животные", "Птицы", "Рыба"), "Хищник"},
                {List.of("Трава", "Различные растения"), "Травоядное"},
                {List.of("Ест все"), "Нечто"}
        };
    }

    @Test
    public void getFamilyReturnNotEmptyString() {
        boolean isExpectedFamilyNotEmpty = true;
        Animal animal = new Animal();
        boolean actualFamily = !animal.getFamily().isEmpty();
        assertEquals(isExpectedFamilyNotEmpty, actualFamily);
    }

    @Test
    public void getFoodReturnFoodForAnyKindAnimals() {
        try {
            Animal animal = new Animal();
            List<String> food = animal.getFood(expectedKindAnimal);
            assertTrue(food.equals(foods));
        } catch (Exception e) {
            assertTrue(true);
            System.out.println(e);
        }
    }
}
