import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Laszlo_Sisa
 */
public class domino_machineTest2 {

    @Test(dataProvider = "input")
    public void testF(String input, String expected) {
        String actual = domino_machine2.f(input);

        Assert.assertEquals(actual, expected);
    }


    @DataProvider(name = "input")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"///|\\\\\\", "///|\\\\\\"},
                {"| \\\\", "|__\\"},
                {"// |", "/__|"},
                {"|/ \\|/ \\|/ \\|/ \\|", "|__\\|__\\|__\\|__\\|"},
                {"/||||", "////__"},
                {"/| /|", "/__/__"},
                {"/||\\", "//\\\\"},
        };
               /* {"///|\\\\\\", "///|\\\\\\"},
                {"| \\\\", "|__\\"},
                {"// |", "/__|"},
                {"|/ \\|/ \\|/ \\|/ \\|", "|__\\|__\\|__\\|/__|"},
                {"/||||", "////__"},
                {"/| /|", "/__/__"},
                {"///", "//__"},
                {"\\\\\\", "__\\\\"},
                {"", ""},
                {"/", "__"},
                {"\\", "__"},
                {"/  |", "__ |"},
                {"/\\", "/\\"},
                {"/|__", "/|__"},
                {"/|/__", "///__"},
                {"/|\\", "/|\\"},
                {"__", "__"},
                {"////", "///__"},
                {"//||\\\\", "//||\\\\"}};*/
    }

}
