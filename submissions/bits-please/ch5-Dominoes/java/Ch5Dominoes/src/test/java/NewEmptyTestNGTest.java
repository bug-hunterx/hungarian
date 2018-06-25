
import hackathon.ch5dominoes.NewMain;
import java.util.Random;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewEmptyTestNGTest {

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
            {"///|\\\\\\", "///|\\\\\\"},
            {"/|\\", "/|\\"},
            {"__\\", "__\\"},
            {"/__", "/__"},
            {"__\\\\", "__\\\\"},
            {"//__", "//__"},
            {"//|\\\\", "//|\\\\"},
            {"//__|__\\\\", "//__|__\\\\"},
            {"/ \\", "__\\"},
            {"///|\\\\\\", "///|\\\\\\"},
            {"| \\\\", "|__\\"},
            {"// |", "/__|"},
            {"|/ \\|/ \\|/ \\|/ \\|", "|__\\|__\\|__\\|__\\|"},
            {"/||||", "////__"},
            {"/| /|", "/__/__"},
            //my test cases:
            {"/", "__"},
            {"\\", "__"},
            {"__  \\", "__ __"},
            {"__     \\", "__    __"},
            {"__/     \\", "____   __"},
            {" __/     \\", "____   __"},
            {"///|\\\\\\   ", "///|\\\\\\"},
            {"/ \\", "__\\"},
            {"//| |\\", "//__\\\\"},
            {"/| |\\/| |\\/| |\\", "/__\\\\/__\\\\/__\\\\"},
            {"/||\\", "//\\\\"},
            {"|||||||||\\", "__\\\\\\\\\\\\\\\\\\"},
            //testcases with htomi
            {"__|\\", "__\\\\"},
            {"/|__", "//__"},
            {" |\\", "__\\"},
            {"/| ", "/__"},
            {"/||", "//__"},
            {"||\\", "__\\\\"},
            {"/ ", "__"},
            {" \\", "__"},
            {"", ""},
            {"/|", "/__"},
            {"|\\", "__\\"},
            {"///|\\\\\\", "///|\\\\\\"},
            {"| \\\\", "|__\\"},
            {"// |", "/__|"},
            {"|/ \\|/ \\|/ \\|/ \\|", "|__\\|__\\|__\\|__\\|"},
            {"/||||", "////__"},
            {"/| /|", "/__/__"},
            {"__\\\\  //__  //|\\\\ //__|__\\\\", "__\\\\  //__  //|\\\\ //__|__\\\\"},
            {"/ ||\\", "__\\\\\\"},
            {"/|| \\", "///__"},
            //1
            {" ", ""},
            {"|", "|"},
            {"/", "__"},
            {"__", "__"},
            {"\\", "__"},
            //2
            {"  ", ""},
            {"| ", "|"},
            {"/ ", "__"},
            {"__ ", "__"},
            {"\\ ", "__"},
            {" |", "|"},
            {"||", "||"},
            {"/|", "/__"},
            {"__|", "__|"},
            {"\\|", "__|"},
            {" /", "__"},
            {"|/", "|__"},
            {"//", "/__"},
            {"__/", "____"},
            {"\\/", "____"},
            {" __", "__"},
            {"|__", "|__"},
            {"/__", "/__"},
            {"____", "____"},
            {"\\__", "____"},
            {" \\", "__"},
            {"|\\", "__\\"},
            {"/\\", "/\\"},
            {"__\\", "__\\"},
            {"\\\\", "__\\"},
            {"/|\\//____\\| \\\\||/|", "/|\\//____\\|__\\||/__"},
            {" //__ /   __\\ ____\\\\|\\/__ __|/| ____|//\\\\______///|__/\\/__\\__/__|/\\\\ |//|__|/|\\__",
                "//__ __  __\\ ____\\\\\\\\/__ __|/______|//\\\\______////__/\\/__\\__/__|/\\\\ |///__|/|\\__"},
        
            {"/ \\__", "__\\__"},
            
            {"/||||| ||||\\", "//////__\\\\\\\\"}, //error
            {"/|||| ||||\\", "////__\\\\\\\\\\"},
            {"", ""},
            {"", ""},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void hello(String input, String expected) {
        assertEquals(NewMain.f2(input), expected, "Input: [" + input + "]");
    }

    @Test
    public void hello2() {

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            String randomChar = getrandomChar("__", "/", "|", "\\", " ");
            b.append(randomChar);
        }
        System.out.println(b.toString());
    }
    private static final Random r = new Random(System.currentTimeMillis());

    private String getrandomChar(String... arr) {
        return arr[r.nextInt(arr.length)];
    }

    @Test
    public void hello3() {
        String[] signs = new String[]{"__", "/", "|", "\\", " "};

        int counter = 0;
        
        System.out.println("Strings for you!");
        System.out.println();
        for (String sign1 : signs) {
            for (String sign2 : signs) {
                for (String sign3 : signs) {
                    String sign = sign1 + sign2 + sign3;
                    if (sign.contains("\\") || sign.contains("/")) {
                        System.out.println("<" + sign + "> == <" + NewMain.f(sign) + ">");
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
