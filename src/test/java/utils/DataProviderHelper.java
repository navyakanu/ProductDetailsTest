package utils;

import org.testng.annotations.DataProvider;

public class DataProviderHelper {

        @DataProvider(name = "ProductName")
        public static Object[][] dataProviderMethod()
        {
            return new Object[][] { { "Galaxy M30s"  }, { "POWER BANK" } };
        }
}

