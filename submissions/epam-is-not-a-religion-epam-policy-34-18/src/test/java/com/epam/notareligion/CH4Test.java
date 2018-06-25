package com.epam.notareligion;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Zoltan_Kornel_Torok on 1/15/2016.
 */
public class CH4Test {

    @Test
    public void xShouldWin() {
        assertEquals(CH4.f("352476"), "X");
        assertEquals(CH4.f("3124679"), "X");
    }

    @Test
    public void OShouldWin() {
        assertEquals(CH4.f("4268379"), "O");
        assertEquals(CH4.f("523764918"), "O");
    }

    @Test
    public void NobodyShouldWin() {
        assertEquals(CH4.f("631854792"), "?");
    }
}