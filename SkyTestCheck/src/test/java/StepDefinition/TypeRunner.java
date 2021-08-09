/*
 * This is the TypeRunner script to execute the entire Project.
 * 
 * The project flows as TypeRunner -> SkyScenarios.feature -> PageNavigator.java -> other POM file
 * 
 * The files included are
 *  1. TypeRunner - class file. This file initiates the run. It also enables to store test results in target folder
 *  2. SkyScenarios.feature - BDD Cucumber feature file. This has all scenarios. 
 *    There were 2features given as part of test, for easiness, both are added in same feature file
 *  3. PageNavigator - class file. This is the Step Definition file, translates and maps the scenarios in
 *     BDD File to java functions. This enables Navigation between various pages
 *  4. HomePage - class file. POM for Home Page. Contains all web elements and its associated methods
 *  5. DealsPage - class file. POM for Deals Page. Contains all web elements and its associated methods
 *  6. SignInPage - class file. POM for Sign In Page. Contains all web elements and its associated methods
 *  7. SearchPage - class file. POM for Search Page. Contains all web elements and its associated methods
 *  
 *  OtherSupport file
 *  1. pom.xml - configured with all dependencies 
 *  
 *  Outcome
 *  1. /target - contains all reports in HTML, JSON format
 *     Kindly note the report for tag3 (Sign In) would not be available in the sample enclosed.
 *     As, due to multiple trial runs, Sky.com has added additional checks from my IP to authenticate my login
 *     So have commented from my execution. But when run fresh they would be validated and report generated
 */

package StepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue= {"StepDefinition"},
monochrome=true,
plugin = {"pretty","html:target/HtmlReports/report.html",
		"json:target/JsonReports/report.json",
		"junit:target/JunitReports/report.xml"}
)
public class TypeRunner {

}
