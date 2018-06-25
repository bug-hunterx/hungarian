import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class internal_skeleton_test {

    @Test(dataProvider = "input")
    public void testF(String input, String expected) {
        internal_skeleton underTest = new internal_skeleton();

        String actual = underTest.f(input);

        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "input")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"FJAFJKLDSKF7JKFDJ", "7"},
                {"ASDFDSASDFDSAzxcPOIUY", "zxc"},
                {"qwERfgHJ123456789", "qwER"},
                {"FGhjKL:\"';lkqwerzxcc", "zxc"},
                {"ASDFASDFqwer432!", "234!"},
                {"EUIyouiepIEjhadSDJ(*Y9y9", "9*("},
                {"1233AERSdfqw", "123"},
                {"ASDF11!*&+1`", "ASDF"},
                {"}*3%&2098@$2k234#@$M", "}"},
                {"wqfdSREA3321", "123"},
                {":X:D:):DDDDDDDxDDDD:(;);];]", "]"},

                {"wqREfgHJ123456789", "qwER"}};
    }
}
