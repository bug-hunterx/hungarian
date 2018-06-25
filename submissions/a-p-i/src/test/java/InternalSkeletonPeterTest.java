import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Peter_Szanto on 1/15/2016.
 */
public class InternalSkeletonPeterTest {

//    @Test
//    public void testSelectNotInRow() throws Exception {
//
//        assertEquals(new InternalSkeletonPeter().charsNotInRow("qwertz"), new String[] {"qwertz", "z"});
//
//    }
//
//    @Test
//    public void testSelectNotInRow2() throws Exception {
//
//        assertEquals(new InternalSkeletonPeter().charsNotInRow("qWertZ"), new String[] {"qWertZ", "Z"});
//
//    }
//
//    @Test
//    public void testSelectShortest() throws Exception {
//
////        assertEquals(new InternalSkeletonPeter().b( new String[] {"asd", "as"}), "as");
//
//    }


    @DataProvider(name = "f")
    Object[][] dataProviderF() {
        return new Object[][] {
//                {"FJAFJKLDSKF7JKFDJ", "7"},
//                {"ASDFDSASDFDSAzxcPOIUY", "zxc"},
                {"FGhjKL:\"';lkqwerzxcc", "zxc"},


//                {"EUIyouiepIEjhadSDJ(*Y9y9", "9*("},
//                {"ASDFASDFqwer432!", "234!"},
//                {"1233AERSdfqw", "123"},
//                {"ASDF11!*&+1", "ASDF"},
//                {"}*3%&2098@$2k234#@$M", "}"},
//                {"wqfdSREA3321", "123"},
//                {":X:D:):DDDDDDDxDDDD:(;);];]", "]"},
//                {"qwERfgHJ123456789", "qwER"},
//                {"qweAa", "aA"},
//                {"rtysA", "sA"}
        };
    }

    @Test(dataProvider = "f")
    public void testF(String input, String expected) throws Exception {

        InternalSkeletonPeter m = new InternalSkeletonPeter();
        assertEquals(m.sortToKeyboardOrder(m.selectShortest(m.charsNotInRow(input))), expected);

    }
}