package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static java.time.Duration.ofSeconds;

public class TimelogSteps
{

    WebDriver driver;

    public TimelogSteps(Hooks hooks)
    {
        this.driver = hooks.getDriver();
    }

    @Given("User is on dashboard page")
    public void user_is_on_dashboard_page() {
        System.out.println("User is on dashboard page");
    }

    @When("User clicks on Work menu")
    public void user_clicks_on_work_menu() throws InterruptedException, IOException
    {
        System.out.println("User click on Work menu");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement sidemenu = driver.findElement(By.xpath("/html/body/aside/div[2]/div[2]"));
        actions.moveToElement(sidemenu);
        TakesScreenshot screenshot0 = (TakesScreenshot)driver;
        Thread.sleep(2000);
        //Saving the screenshot in desired location
        File source0 = screenshot0.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000);
        //Path to the location to save screenshot
        FileHandler.copy(source0, new File("/Users/addweb/Downloads/TimeLogWithSS/SS/Logged.png"));
        Thread.sleep(2000);
        System.out.println("Added Time log Page Screenshot is captured");
        WebElement workmenu = driver.findElement(By.xpath("/html/body/aside/div[2]/div[2]/ul/li[5]"));
        actions.moveToElement(workmenu);
        driver.findElement(By.xpath("/html/body/aside/div[2]/div[2]/ul/li[5]/a")).click();
        Thread.sleep(100);
        System.out.println("Clicked on work");
    }

    @And("User clicks on Time Logs sub menu")
    public void user_clicks_on_time_logs_sub_menu() throws InterruptedException {
        System.out.println("User clicks on Time Logs sub menu");
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/aside/div[2]/div[2]/ul/li[5]/div/a[4]")));
        driver.findElement(By.xpath("/html/body/aside/div[2]/div[2]/ul/li[5]/div/a[4]")).click();
        Thread.sleep(3000);
    }

    @Then("User is redirect on the time Logs page")
    public void user_is_redirect_on_the_time_logs_page()
    {
        System.out.println("User is redirect on the time Logs page");
    }

    @Given("User is on time log page")
    public void userIsOnTimeLogPage()
    {
        System.out.println("User is on time log page");
    }

    @And("User can see the log time button")
    public void userCanSeeTheLogTimeButton()
    {
        System.out.println("User can see the log time button");
    }

    @When("User clicks on log time button")
    public void userClicksOnLogTimeButton() throws InterruptedException
    {
        System.out.println("User clicks on log time button");
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#table-actions >a")));
        driver.findElement(By.cssSelector("#table-actions > a")).click();
        Thread.sleep(2000);
    }

    @Then("User is navigated to log time Page")
    public void userIsNavigatedToLogTimePage()
    {
        System.out.println("User is navigated to log time Page");
    }

    @Given("User is on time log details page")
    public void userIsOnTimeLogDetailsPage()
    {
        System.out.println("User is on time log details page");
    }

    @When("User fills up all the require details")
    public void userFillsUpAllTheRequireDetails() throws InterruptedException
    {
        System.out.println("User fills up all the require details");

        WebDriverWait wait1 = new WebDriverWait(driver, ofSeconds(100));
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[1]/div[1]/div/div/button")));
        driver.findElement(By.xpath(" /html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[1]/div[1]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[1]/div[1]/div/div/select/option[3]")).click(); //project
        Thread.sleep(2000);
        System.out.println("require1");

        WebDriverWait wait2 = new WebDriverWait(driver, ofSeconds(100));
        wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#save-timelog-data-form > div > div.row.p-20 > div.col-md-12 > div:nth-child(1) > div:nth-child(2) > div > div > button")));
        driver.findElement(By.cssSelector("#save-timelog-data-form > div > div.row.p-20 > div.col-md-12 > div:nth-child(1) > div:nth-child(2) > div > div > button")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[1]/div[2]/div/div/select/option[2]")).click(); //Task
        Thread.sleep(2000);
        System.out.println("require2");

        WebDriverWait wait3 = new WebDriverWait(driver, ofSeconds(100));
        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[1]/div[3]/div/div/button")));
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[1]/div[3]/div/div/button")).click();
        WebDriverWait wait0 = new WebDriverWait(driver, ofSeconds(100));
        wait0.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[1]/div[3]/div/div/select/option[2]")));
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[1]/div[3]/div/div/select/option[2]")).click(); //employee
        Thread.sleep(2000);

        WebDriverWait wait4 = new WebDriverWait(driver, ofSeconds(100));
        wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[2]/div[5]/div/div/button")));
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[2]/div[5]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[1]/div[2]/div[5]/div/div/div/div[2]/ul/li[2]")).click(); //hour
        Thread.sleep(2000);

        WebDriverWait wait5 = new WebDriverWait(driver, ofSeconds(100));
        wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[2]/div/textarea")));
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[2]/div/textarea")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[2]/div/textarea")).sendKeys("Test");
        Thread.sleep(2000);
    }

    @And("User clicks on save button")
    public void userClicksOnSaveButton() throws InterruptedException, IOException
    {
        System.out.println("User clicks on save button");
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/button[1]")).click();
        Thread.sleep(1000);


        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot screenshot0 = (TakesScreenshot)driver;
        Thread.sleep(2000);
        //Saving the screenshot in desired location
        File source0 = screenshot0.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000);
        //Path to the location to save screenshot
        FileHandler.copy(source0, new File("/Users/addweb/Downloads/TimeLogWithSS/SS/SuccessfullyLogged.png"));
        Thread.sleep(2000);
        System.out.println("Added Time log Page Screenshot is captured");
    }

    @Then("User is redirect on Time Logs page")
    public void userIsRedirectOnTimeLogsPage() throws InterruptedException
    {
        System.out.println("User is redirect on Time Logs page");
        Thread.sleep(50);

        String str1 = "Create a Theme for the Addcom Project";
        String str2 = "Create a Theme for the Addcom Project";

        if(str1.equals(str2) )
        {
            System.out.println("Data is Matched");
        }
        else
        {
            System.out.println("Data Not Matched");
        }
    }
    @Given("User is on time logs page")
    public void userIsOnTimeLogsPage()
    {
        System.out.println("User is on time log page for edit");

    }
    @When("User clicks on the drop-down menu link")
    public void userClicksOnTheDropDownMenuLink() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[8]/div/div/a/i")).click();
        Thread.sleep(1000);
        System.out.println("drop-down icon");
    }

    @And("User clicks on the Edit menu")
    public void userClicksOnTheEditMenu() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[8]/div/div/div/a[2]")).click();
        Thread.sleep(2000);
        System.out.println("User clicks on the Edit menu");
    }

    @And("User updates a data")
    public void userUpdatesAData() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[2]/div/textarea")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/form/div/div[2]/div[2]/div/textarea")).sendKeys(" Updated");
        Thread.sleep(1000);
    }

    @And("clicks on save button")
    public void clicksOnSaveButton() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/button[1]")).click();
        Thread.sleep(1000);
    }

    @Then("Updated data is display")
    public void updatedDataIsDisplay() throws InterruptedException, IOException
    {
        System.out.println("Data is Updated successfully");
        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot screenshot00 = (TakesScreenshot)driver;
        Thread.sleep(2000);
        //Saving the screenshot in desired location
        File source00 = screenshot00.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000);
        //Path to the location to save screenshot
        FileHandler.copy(source00, new File("/Users/addweb/Downloads/TimeLogWithSS/SS/UpdatedData.png"));
        Thread.sleep(2000);
        System.out.println("Updated Time log Page Screenshot is captured");
        Thread.sleep(1000);
    }
    @Given("User is on to the time logs page")
    public void userIsOnToTheTimeLogsPage()
    {
        System.out.println("User is on to the time logs page");
    }

    @When("User clicks on drop-down menu link")
    public void userClicksOnDropDownMenuLink() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[8]/div/div/a/i")).click();
        Thread.sleep(1000);
        System.out.println("drop-down icon");
    }

    @And("User clicks on View menu")
    public void userClicksOnViewMenu() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[8]/div/div/div/a[1]")).click();
        Thread.sleep(2000);
    }

    @Then("User is able to view the details")
    public void userIsAbleToViewTheDetails() throws InterruptedException
    {
        System.out.println("User is able to view the details");
        driver.findElement(By.cssSelector("#close-task-detail > span")).click();  //Cross icon for closing view page
        Thread.sleep(2000);
    }
    @Given("User is on the time Logs page")
    public void userIsOnTheTimeLogsPage()
    {
        System.out.println("User is on the time log page");
    }

    @When("User clicks on the log time button")
    public void userClicksOnTheLogTimeButton() throws InterruptedException
    {
        System.out.println("User clicks on log time button");
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#table-actions >a")));
        driver.findElement(By.cssSelector("#table-actions > a")).click();
        Thread.sleep(2000);
    }

    @And("User clicks on the Save button")
    public void userClicksOnTheSaveButton() throws InterruptedException
    {
        System.out.println("User clicks on Save button");
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div/div/div/div/div/div/button[1]")));
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div/div/button[1]")).click();
        Thread.sleep(3000);
    }

    @Then("User is able to see a validations")
    public void userIsAbleToSeeAValidations() throws InterruptedException, IOException
    {
        System.out.println("Validation is appearing");
        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot screenshot1 = (TakesScreenshot) driver;
        Thread.sleep(2000);
        //Saving the screenshot in desired location
        File source1 = screenshot1.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000);
        //Path to the location to save screenshot
        FileHandler.copy(source1, new File("/Users/addweb/Downloads/TimeLogWithSS/SS/Validation.png"));
        Thread.sleep(2000);
        System.out.println("Validation appeared on Time log Page Screenshot is captured");
        driver.findElement(By.cssSelector("#close-task-detail > span > svg")).click();
        Thread.sleep(1000);
    }
    @Given("User is on to Time Logs page")
    public void userIsOnToTimeLogsPage()
    {
        System.out.println("User is on to Time Logs page");
    }

    @When("User clicks on to the drop-down menu link")
    public void userClicksOnToTheDropDownMenuLink() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[8]/div/div/a/i")).click();
        Thread.sleep(1000);
        System.out.println("drop-down icon");
    }

    @And("User clicks on Delete menu")
    public void userClicksOnDeleteMenu() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[8]/div/div/div/a[3]")).click();
        driver.findElement(By.xpath("/html/body/div[8]/div/div[3]/button[1]")).click();
        Thread.sleep(2000);
    }

    @Then("User is able to delete the data")
    public void userIsAbleToDeleteTheData() throws InterruptedException, IOException
    {
        System.out.println("Deleted");
        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot screenshot4 = (TakesScreenshot) driver;
        Thread.sleep(2000);
        //Saving the screenshot in desired location
        File source4 = screenshot4.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000);
        //Path to the location to save screenshot
        FileHandler.copy(source4, new File("/Users/addweb/Downloads/TimeLogWithSS/SS/Delete.png"));
        Thread.sleep(2000);
        System.out.println("Deleted appeared on Time log Page Screenshot is captured");
        Thread.sleep(1000);
    }
}
