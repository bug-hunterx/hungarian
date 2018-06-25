package com.epam.notareligion;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Attila_Horvath2 on 1/16/2016.
 */
public class Ch2Test {

    @Test
    public void firstTestCase() {
        assertEquals("7", Ch2.f("FJAFJKLDSKF7JKFDJ"));
        assertEquals("zxc", Ch2.f("ASDFDSASDFDSAzxcPOIUY"));
        assertEquals("qwER", Ch2.f("qwERfgHJ123456789"));
        assertEquals("zxc", Ch2.f("FGhjKL:\"';lkqwerzxcc"));
        assertEquals("234!", Ch2.f("ASDFASDFqwer432!"));
        assertEquals("9*(", Ch2.f("EUIyouiepIEjhadSDJ(*Y9y9"));
        assertEquals("123", Ch2.f("1233AERSdfqw"));
        assertEquals("ASDF", Ch2.f("ASDF11!*&+1"));
        assertEquals("}", Ch2.f("}*3%&2098@$2k234#@$M"));
        assertEquals("123", Ch2.f("wqfdSREA3321"));
        assertEquals("]", Ch2.f(":X:D:):DDDDDDDxDDDD:(;);];]`"));
    }
}