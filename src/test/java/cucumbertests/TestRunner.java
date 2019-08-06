package cucumbertests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\WorkSpace_Cucumber\\AAAA\\features\\requirement1.feature",glue="stepdefinitions",dryRun=false)
public class TestRunner {

}
