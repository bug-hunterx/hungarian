package com.epam.notareligion;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Zoltan_Kornel_Torok on 1/15/2016.
 */
public class CH7Test {

    @Test
    public void shouldBePolite() {
        String building = "1:0|1:1\n" +
                "3:2|5:0\n" +
                "1:1|2:2\n";
        assertEquals(CH7.f(building, 6), "polite after 3 stops at 1 floor");
    }

    @Test
    public void shouldBeLonely() {
        String building = "2:1|3:2\n" +
                "1:0|1:1\n" +
                "3:2|5:0\n" +
                "1:1|2:2\n";
        assertEquals(CH7.f(building, 10), "lonely after 2 stops at 1 floor");
    }
}