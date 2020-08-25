package practise;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name="Input Data")
    public Object[] getDataforEditField()
    {
        Object[][] obj=new Object[][]
                {
                        {"hello"}, {"goodbye"}

                };

        return obj;
    }
}
