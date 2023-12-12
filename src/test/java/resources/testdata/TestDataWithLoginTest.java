package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestDataWithLoginTest {

    @DataProvider(name = "credentials")
    public Object[][] getCredential() {
        Object[][] data = new Object[][]{
                {" ", " ", "Required"},
                {"test123@gmail.com", " ", "Required"},
                {" ", "test123", "Required"},
                {"test123@gmail.com", "test123", "Invalid credentials"}
        };
        return data;
    }
}
