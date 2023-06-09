package Steps;

import Steps.Hooks;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static Steps.Hooks.emailAddress;

public class TimelogSteps {

    WebDriver driver;

    public TimelogSteps(Hooks hooks)
    {
        this.driver = hooks.getDriver();
    }

    @Given("User is on dashboard page")
    public void user_is_on_dashboard_page()
    {
        System.out.println("User is on dashboard page");
        WebElement privateDashboardLink = driver.findElement(By.partialLinkText("Private Dashboard")); //Redirect on Private dashboard
        privateDashboardLink.click();
    }

    @When("User clicks on Clock In button")
    public void userClicksOnClockInButton() throws InterruptedException, IOException {
        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot ClockedIn = (TakesScreenshot) driver;
        Thread.sleep(1000);
        //Saving the screenshot in desired location
        File BeforeClockedIn = ClockedIn.getScreenshotAs(OutputType.FILE);
        Thread.sleep(1000);
        //Path to the location to save screenshot
        FileHandler.copy(BeforeClockedIn, new File("/Users/addweb/IdeaProjects/ClockInOut/SS/BeforeClockedIn.png"));
        Thread.sleep(1000);
        System.out.println("BeforeClockedIn Screenshot is captured");

        //Clock In
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button")).click();
        System.out.println("User Clock In Successfully");
        Thread.sleep(500);

        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot AfterClockedIn = (TakesScreenshot) driver;
        Thread.sleep(1000);
        //Saving the screenshot in desired location
        File AfterClockedInFile = AfterClockedIn.getScreenshotAs(OutputType.FILE);
        Thread.sleep(1000);
        //Path to the location to save screenshot
        FileHandler.copy(AfterClockedInFile, new File("/Users/addweb/IdeaProjects/ClockInOut/SS/AfterClockedIn.png"));
        Thread.sleep(1000);
        System.out.println("AfterClockedIn Screenshot is captured");
        Thread.sleep(1000);
    }

    @Then("User Clocked In time and System time is display or not")
    public void userClockedInTimeAndSystemTimeIsDisplayOrNot() throws InterruptedException
    {
        System.out.println("Check User Clocked In time and System time is display or not");
    }

    @And("Clocked In time and System time is match")
    public String clockedInTimeAndSystemTimeIsMatch() throws InterruptedException, IOException {
        //Click on HR Module
        Actions HRModule = new Actions(driver);
        Thread.sleep(1000);
        WebElement hrModuleLink = driver.findElement(By.linkText("HR"));
        hrModuleLink.click();
        System.out.println(HRModule);
        Thread.sleep(1000);

        // Screenshot of Clicked on HR module
        TakesScreenshot AddedHRModule = (TakesScreenshot) driver;
        Thread.sleep(2000); //Saving the screenshot in desired location
        File AddedHRModuleSS = AddedHRModule.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000); //Path to the location to save screenshot
        FileHandler.copy(AddedHRModuleSS, new File("/Users/addweb/IdeaProjects/ClockInOut/SS/AddedHRModule.png"));
        Thread.sleep(2000);
        System.out.println("Added HR module Screenshot is captured");

        //Clicked on Attendance module
        Actions Attendance = new Actions(driver);
        Thread.sleep(1000);
        WebElement attendanceSubMenuLink = driver.findElement(By.linkText("Attendance"));
        Attendance.moveToElement(attendanceSubMenuLink).click().perform();
        Thread.sleep(1000);

        // Screenshot of Clicked on Attendance module
        TakesScreenshot AttendanceModule = (TakesScreenshot) driver;
        Thread.sleep(2000); //Saving the screenshot in desired location
        File AttendanceModuleSS = AttendanceModule.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000); //Path to the location to save screenshot
        FileHandler.copy(AttendanceModuleSS, new File("/Users/addweb/IdeaProjects/ClockInOut/SS/AttendanceModule.png"));
        Thread.sleep(2000);
        System.out.println("Added Attendance module Screenshot is captured");

        //Search a particular employee

        // Get a System date
        DateFormat dateFormat = new SimpleDateFormat("d");
        Date systemDate = new Date();
        String dayOfMonth = dateFormat.format(systemDate);
        System.out.println("Day of the month: " + dayOfMonth);

        //Find the date in attendance module and match with system date
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div")); //xpath of attendance module
        action.moveToElement(element);
        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/thead/tr/th")); //xpath of attendance icon's row

        int Size = rows.size();
        System.out.println("Total Rows are : " + Size);
        for (int j = 1; j <= Size; j++) {
            WebElement DayCount;
            DayCount = driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/thead/tr/th[" + j + "]"));
            String actual_name = DayCount.getText();
            System.out.println(actual_name);

            String expectedDayOfMonth = (dayOfMonth);
            if (actual_name.equals(expectedDayOfMonth) == true)
            {
                driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/tbody/tr/td[" + j + "]")).click();
                Thread.sleep(1000);
                System.out.println("date Matched");
                Thread.sleep(5000);
                driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button")).click(); //close popup
                break;
            } else
            {
                System.out.println("Not Matched");
            }
        }
        WebElement dashboardMenu = driver.findElement(By.linkText("Dashboard"));
        dashboardMenu.click();
        System.out.println("User is on dashboard page");
        Thread.sleep(1000);
        WebElement privateDashboardLink = driver.findElement(By.partialLinkText("Private Dashboard")); //Redirect on Private dashboard
        privateDashboardLink.click();

        WebElement Trim = driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[1]/div[2]/p/span")); //get dashboard time
        String text = Trim.getText();
        String trimmedText = text.replace("Clock In at - ", ""); //trim dashboard time
        System.out.println("---------------- Clock In at Dashboard: " + trimmedText );

        //Again move to HR module
        Thread.sleep(1000);
        WebElement HRModuleLink = driver.findElement(By.linkText("HR"));
        HRModuleLink.click();
        Thread.sleep(1000);
        System.out.println("User is on HR Module");

        //Again move to Attendance module
        Actions actions_Attendance = new Actions(driver);
        Thread.sleep(1000);
        WebElement attendanceSubMenuLink1 = driver.findElement(By.linkText("Attendance"));
        actions_Attendance.moveToElement(attendanceSubMenuLink1).click().perform();
        Thread.sleep(1000);
        System.out.println("User is on Attendance Module");

        //Get a system date
        Thread.sleep(1000);
        DateFormat SystemDateFormat = new SimpleDateFormat("d");
        Date systemDate1 = new Date();
        String SystemDayOfMonth = SystemDateFormat.format(systemDate1);
        System.out.println("Day of the month: " + SystemDayOfMonth);

        //Again Find the date in attendance module and match with system date
        Actions actionMatch = new Actions(driver);
        WebElement elementMatch = driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div")); //xpath of attendance module
        actionMatch.moveToElement(elementMatch);
        List<WebElement> rowsMatch = driver.findElements(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/thead/tr/th")); //xpath of attendence row

        int NewSize = rowsMatch.size();
        System.out.println("Total Rows are : " + NewSize);

        for (int i = 1; i <= NewSize; i++) {
            WebElement TotalRows;
            TotalRows = driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/thead/tr/th[" + i + "]"));
            String actual_name = TotalRows.getText();
            System.out.println(actual_name);

            String expectedDayOfMonth = (dayOfMonth);
            if (actual_name.equals(expectedDayOfMonth) == true) {
                driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/tbody/tr/td[" + i + "]")).click();
                Thread.sleep(1000);
                System.out.println("date Matched");
                Thread.sleep(5000);
                break;
            } else {
                System.out.println("Not Matched");
            }
        }

        String expectedTime = trimmedText;

        WebDriverWait waitTrim = new WebDriverWait(driver, Duration.ofSeconds(100));
        waitTrim.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div"))); // wait for Popup's clock In/Out xpath
        List<WebElement> rowsTime = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div")); //Popup's clock In/Out xpath
        int SizeTime = rowsTime.size();
        System.out.println("Total Rows are : " + SizeTime);
        Thread.sleep(500);

        for (int i = 1; i <= SizeTime; i++)
        {
            String times = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div[" + i + "]/ul/li[1]/p[2]")).getText(); //pop up clock In's common xpath
            String trimmedTextAttendance= times.replaceAll("\\s*(WFH|Late Half Day)\\s*", "").trim();  // Trim "WFH" and "Late Half Day" from the string
            System.out.println("---  ClockIn Time in Attendance Module is: " + trimmedTextAttendance);
            Thread.sleep(500);

            if (trimmedTextAttendance.equals(expectedTime) == true) {
                System.out.println("=========  Matched time  =========");
                Thread.sleep(3000);
                driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button")).click(); //close popup
                break;
            }
            else
            {
                System.out.println("Not Matched");
            }
        }
        return dayOfMonth;
    }
    @Given("User is on the Attendance page")
    public void userIsOnTheAttendancePage()
    {
        System.out.println("User is on the Attendance page");
    }
    @And("User is going on the Dashboard page")
    public void userIsGoingOnTheDashboardPage()
    {
        System.out.println("User is going on the Dashboard page");
        driver.findElement(By.xpath("/html/body/aside/div[2]/div[2]/ul/li[1]/a")).click(); //Dashboard
        System.out.println("User is on dashboard page");
        WebElement privateDashboardLink = driver.findElement(By.partialLinkText("Private Dashboard")); //Redirect on Private dashboard
        privateDashboardLink.click();
    }
    @When("User clicks on the Clocked out button")
    public void userClicksOnTheClockedOutButton() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[1]/div[2]/button[1]")).click();
        Thread.sleep(2000);
        System.out.println("User clicks on Clock Out button");
    }
    @Then("User successfully clock out")
    public void userSuccessfullyClockOut()
    {
        System.out.println("User Clocked out successfully");
    }
}

