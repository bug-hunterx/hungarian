import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by adam_csordas on 1/16/2016.
 */
public class C9RunnableTest {
    @Test
    public void testWin() {
        assertEquals("WIN", C9Runnable.f("piranha Princess piranha"));
    }

    @Test
    public void testNoEnd() {
        assertEquals("???", C9Runnable.f("piranha"));
    }

    @Test
    public void testDie() {
        assertEquals("GAME OVER", C9Runnable.f("piranha koopa goomba"));
    }

    @Test
    public void testSuper() {
        assertEquals("WIN", C9Runnable.f("Mushroom piranha koopa goomba Princess"));
    }

    @Test
    public void testCoins() {
        assertEquals("WIN", C9Runnable.f("20 80 piranha koopa goomba Princess"));
    }

    @Test
    public void testCoins2() {
        assertEquals("WIN", C9Runnable.f("10 80 piranha piranha 130 koopa goomba Princess"));
    }
    @Test
    public void testStar() {
        assertEquals("WIN", C9Runnable.f("Star piranha koopa goomba goomba Princess"));
    }

    @Test
    public void test1Up() {
        assertEquals("WIN", C9Runnable.f("1Up piranha koopa  goomba Princess"));
    }
    @Test
    public void test2() {
        assertEquals("WIN", C9Runnable.f("1Up koopa goomba piranha Bowser"));
    }

    @Test
    public void test3() {
        assertEquals("WIN", C9Runnable.f("Star Mushroom  piranha goomba piranha goomba Princess"));
    }

    @Test
    public void test4() {
        assertEquals("GAME OVER", C9Runnable.f(" piranha piranha piranha piranha"));
    }

    @Test
    public void test5() {
        assertEquals("WIN", C9Runnable.f("piranha piranha Star goomba goomba Princess"));
    }

    @Test
    public void test6() {
        assertEquals("GAME OVER", C9Runnable.f("10 40 koopa goomba 20 30 piranha piranha"));
    }

}
