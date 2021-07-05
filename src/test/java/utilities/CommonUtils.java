package utilities;

import org.testng.SkipException;

import com.redbus.tests.BaseTest;

public class CommonUtils extends BaseTest {

	// function toCheckExecutionRequired
	public static void toCheckExecutionRequired(String executionRequired) {

		// Execution required field is no then if will execute
		if (executionRequired.equals("no")) {
			throw new SkipException("Skipping this exception");
		}
		// Execution required field is empty than skip
		else if (executionRequired.equals("")) {

			throw new SkipException("Skipping this exception");
		}
	}
}