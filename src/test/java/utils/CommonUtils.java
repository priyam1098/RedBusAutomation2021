package utils;

import org.testng.SkipException;

import com.redbus.tests.BaseTest;

public class CommonUtils extends BaseTest {

    // function toCheckExecutionRequired
    public static void toCheckExecutionRequired(String executionRequired) {
        
        // if execution required field is no
        if(executionRequired.equals("no")) {
            throw new SkipException("Skipping this exception");
        }
        
        // if execution required field is empty
        else if(executionRequired.equals("")) {

            throw new SkipException("Skipping this exception");
        }
    }
}