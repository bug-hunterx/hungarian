import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewEmptyTestNGTest {
    
    public NewEmptyTestNGTest() {
    }

    @DataProvider(name = "dataProvider")
     public Object[][] dataProvider() {
         return new Object[][]{
             {"///|\\\\\\", "///|\\\\\\"},
         };
     };
    
     @Test(dataProvider = "dataProvider")
     public void hello(String input, String expected) {
         
     }
}
