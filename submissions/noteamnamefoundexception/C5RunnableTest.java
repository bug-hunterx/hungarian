import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by adam_csordas on 1/15/2016.
 */
public class C5RunnableTest {

    @Test
    public void test1() {
        String result = C5Runnable.f("///|\\\\\\");

        assertEquals("///|\\\\\\", result);
    }

    @Test
    public void test2() {
        String result = C5Runnable.f("| \\\\");         /*  | \\  */

        assertEquals("|__\\", result);                  /*   |__\   */
    }


    @Test
    public void test3() {
        String result = C5Runnable.f("// |");

        assertEquals("/__|", result);
    }

    @Test
    public void test4() {
        String result = C5Runnable.f("|/ \\|/ \\|/ \\|/ \\|");

        assertEquals("|__\\|__\\|__\\|__\\|", result);
    }

    @Test
    public void test5() {
        String result = C5Runnable.f("/||||");

        assertEquals("////__", result);
    }

    @Test
    public void test6() {
        String result = C5Runnable.f("/| /|");

        assertEquals("/__/__", result);
    }

    @Test
    public void test7() {
        String result = C5Runnable.f("\\/");

        assertEquals("____", result);
    }

    @Test
    public void test8() {
        String result = C5Runnable.f("/");

        assertEquals("__", result);
    }

    @Test
    public void test9() {
        String result = C5Runnable.f("|\\");

        assertEquals("__\\", result);
    }

    @Test
    public void test10() {
        String result = C5Runnable.f("/|\\");

        assertEquals("/|\\", result);
    }

    @Test
    public void test11() {
        String result = C5Runnable.f("/||\\");     /*   /||\   */

        assertEquals("//\\\\", result);         /*  //\\          */
    }

    @Test
    public void test12() {
        String result = C5Runnable.f("/|\\   /||\\");

        assertEquals("/|\\   //\\\\", result);
    }

    @Test
    public void test13() {
        String result = C5Runnable.f("/||||\\");

        assertEquals("///\\\\\\", result);
    }

    @Test
    public void test14() {
        String result = C5Runnable.f("/||||\\ /||||\\");

        assertEquals("///\\\\\\ ///\\\\\\", result);
    }

    @Test
    public void test15() {
        String result = C5Runnable.f("/|||\\");

        assertEquals("//|\\\\", result);
    }

    @Test
    public void test16() {
        String result = C5Runnable.f("/|| | ||\\");

        assertEquals("//__|__\\\\", result);
    }

    @Test
    public void test17() {
        String result = C5Runnable.f("/||    /\\    | ||\\");

        assertEquals("//__   /\\    |__\\\\", result);
    }

}
