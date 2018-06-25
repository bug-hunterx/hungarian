package com.epam.notareligion;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by me on 1/15/2016.
 */
public class CH5Test {

    @Test
    public void fuckIt1() {
        assertEquals(Ch5.f("///|\\\\\\"), "///|\\\\\\");
    }

    @Test
    public void fuckIt2() {
        assertEquals(Ch5.f("| \\\\"), "|__\\");
    }

    @Test
    public void fuckIt3() {
        assertEquals(Ch5.f("// |"), "/__|");
    }

    @Test
    public void fuckIt4() {
        assertEquals(Ch5.f("|/ \\|/ \\|/ \\|/ \\|"), "|__\\|__\\|__\\|__\\|");

    }

    @Test
    public void fuckIt5() {
        assertEquals(Ch5.f("/||||"), "////__");

    }

    @Test
    public void fuckIt6() {
        assertEquals(Ch5.f("/| /|"), "/__/__");
    }
}