package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestDataWithUserTest {

    @DataProvider(name = "details")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"Admin","Admin", "Paul Collings", "Enable"},
                {"Cassidy.Hope", "ESS", "Cassidy Hope", "Enable"},
                {"Nina.Patel", "ESS", "Nina Patel", "Enable"},
                {"Odis.Adalwin", "Admin", "Odis Adalwin","Enable"}
        };
       return data;
    }
}
