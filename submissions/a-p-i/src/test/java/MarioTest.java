import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Peter_Szanto on 1/16/2016.
 */
public class MarioTest {

    @Test
    public void testF() throws Exception {

//        Mario.f("piranha Princess piranha"); //WIN
//        Mario.f("1Up koopa goomba piranha Bowser"); //WIN
//        Mario.f("Star Mushroom  piranha goomba piranha goomba Princess"); //WIN
//        Mario.f(" piranha piranha piranha piranha"); //GAME O
//        Mario.f("piranha piranha Star goomba goomba Princess"); //WIN
//        Mario.f("10 40 koopa goomba 20 30 piranha piranha"); //GAME OVER
        Mario.f("10 40 koopa goomba 20 30 piranha piranha"); //GAME OVER
        Mario.f("10 40 koopa goomba 20 30 piranha "); //GAME OVER

    }
}