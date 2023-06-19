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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ClockInOutSteps
{

    WebDriver driver;

    public ClockInOutSteps(Hooks hooks)
    {
        this.driver = hooks.getDriver();
    }

    @Given("User is on dashboard page")
    public void user_is_on_dashboard_page()
    {
        System.out.println("User is on dashboard page");
        WebElement PrivateDashboard = driver.findElement(By.partialLinkText("Private Dashboard")); //Redirect on Private dashboard
        PrivateDashboard.click();
    }

    @When("User clicks on Clock In button")
    public void userClicksOnClockInButton() throws InterruptedException, IOException {
        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot BeforeClockedInScreenshot = (TakesScreenshot) driver;
        Thread.sleep(1000); //Saving the screenshot in desired location
        File BeforeClockedIn = BeforeClockedInScreenshot.getScreenshotAs(OutputType.FILE);
        Thread.sleep(1000); //Path to the location to save screenshot
        FileHandler.copy(BeforeClockedIn, new File("/Users/addweb/IdeaProjects/ClockInOut/Screenshot/BeforeClockedIn.png"));
        Thread.sleep(1000);
        System.out.println("BeforeClockedIn Screenshot is captured");

        //Clock In
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[1]/div[2]/button")).click(); //Clock In button xpath
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button")).click(); //Clock In button xpath after selecting a type of work
        System.out.println("User Clock In Successfully");
        Thread.sleep(500);

        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot AfterClockedInScreenshot = (TakesScreenshot) driver;
        Thread.sleep(1000); //Saving the screenshot in desired location
        File AfterClockedInFile = AfterClockedInScreenshot.getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000); //Path to the location to save screenshot
        FileHandler.copy(AfterClockedInFile, new File("/Users/addweb/IdeaProjects/ClockInOut/ScreenShot/AfterClockedIn.png"));
        Thread.sleep(1000);
        System.out.println("AfterClockedIn Screenshot is captured");
        Thread.sleep(1000);
    }

    @Then("User Clocked In time and System time is display or not")
    public void userClockedInTimeAndSystemTimeIsDisplayOrNot()
    {
        System.out.println("Check User Clocked In time and System time is display or not");
    }

    @And("Clocked In time and System time is match")
    public String clockedInTimeAndSystemTimeIsMatch() throws InterruptedException, IOException
    {
        //Get the Employee name from the dashboard
        WebElement EmployeeName = driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div[1]/div/div[1]/div/div[1]/div[2]/h4"));
        String GetEmployeeName = EmployeeName.getText();

        //Click on HR Module
        Actions HRModule = new Actions(driver);
        Thread.sleep(1000);
        WebElement HRModuleLinkText = driver.findElement(By.linkText("HR"));
        HRModuleLinkText.click();
        System.out.println(HRModule);
        Thread.sleep(1000);

        // Screenshot of Clicked on HR module
        TakesScreenshot HRModuleScreenshot = (TakesScreenshot) driver;
        Thread.sleep(2000); //Saving the screenshot in desired location
        File HRModuleFile = HRModuleScreenshot.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000); //Path to the location to save screenshot
        FileHandler.copy(HRModuleFile, new File("/Users/addweb/IdeaProjects/ClockInOut/ScreenShot/AddedHRModule.png"));
        Thread.sleep(2000);
        System.out.println("Added HR module Screenshot is captured");

        //Clicked on Attendance module
        Actions AttendanceModule = new Actions(driver);
        Thread.sleep(1000);
        WebElement attendanceSubMenuLink = driver.findElement(By.linkText("Attendance"));
        AttendanceModule.moveToElement(attendanceSubMenuLink).click().perform();
        Thread.sleep(1000);

        // Screenshot of Clicked on Attendance module
        TakesScreenshot AttendanceModuleScreenshot = (TakesScreenshot) driver;
        Thread.sleep(2000); //Saving the screenshot in desired location
        File AttendanceModuleFile = AttendanceModuleScreenshot.getScreenshotAs(OutputType.FILE);
        Thread.sleep(2000); //Path to the location to save screenshot
        FileHandler.copy(AttendanceModuleFile, new File("/Users/addweb/IdeaProjects/ClockInOut/ScreenShot/AttendanceModule.png"));
        Thread.sleep(2000);
        System.out.println("Added Attendance module Screenshot is captured");

        //Search ------------------------------------------------------------------------
        WebDriverWait SearchBar = new WebDriverWait(driver, Duration.ofSeconds(100));
        SearchBar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/button")));
        driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/button")).click();
        Thread.sleep(2000); //----- Click on Employee

        WebElement AddEmployeeName = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/div/div[1]/input")); // Fetch an employee name from the dashboard
        AddEmployeeName.sendKeys(GetEmployeeName);

        WebDriverWait ClickEmployeeName = new WebDriverWait(driver, Duration.ofSeconds(100));
        ClickEmployeeName.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/div/div[2]/ul/li/a")));
        driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/div/div[2]/ul/li/a")).click();
        Thread.sleep(2000); //----- Click on Name of the Person

        //Get a System date
        DateFormat DateFormat = new SimpleDateFormat("d");
        Date DayOfMonth = new Date();
        String SystemDate = DateFormat.format(DayOfMonth);
        System.out.println("System date : " + SystemDate);

        //Find the date in attendance module and match with system date
        Actions MatchDaysInAttendance = new Actions(driver);
        WebElement AttendanceTable = driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div")); //xpath of attendance module
        MatchDaysInAttendance.moveToElement(AttendanceTable);
        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/thead/tr/th")); //xpath of attendance icon's row

        int Size = rows.size();
        System.out.println("Total Rows are : " + Size);
        for (int j = 1; j <= Size; j++) {
            WebElement MatchDate;
            MatchDate = driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/thead/tr/th[" + j + "]"));
            String ActualDate = MatchDate.getText();
            System.out.println(ActualDate);

            String ExpectedDate = (SystemDate);
            if (ActualDate.equals(ExpectedDate) == true)
            {
                driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/tbody/tr/td[" + j + "]")).click(); //After Matching the date click on view option
                Thread.sleep(1000);
                System.out.println("======date Matched======");
                Thread.sleep(5000);
                driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button")).click(); //Close the Attendance popup
                break;
            }
            else
            {
                System.out.println("Not Matched");
            }
        }
        WebElement DashboardMenu = driver.findElement(By.linkText("Dashboard"));
        DashboardMenu.click();
        System.out.println("User is on dashboard page");
        Thread.sleep(1000);
        WebElement PrivateDashboard = driver.findElement(By.partialLinkText("Private Dashboard")); //Redirect on Private dashboard
        PrivateDashboard.click();

        WebElement AddedEmployeeName = driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[2]/div[1]/div/div[1]/div/div[1]/div[2]/h4")); //Get a name
        String AddedGetEmployeeName = AddedEmployeeName.getText();

        WebElement TrimDashboardTime = driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[1]/div[2]/p/span")); //get dashboard time
        String DashboardText = TrimDashboardTime .getText();
        String TrimText = DashboardText.replace("Clock In at - ", ""); //trim dashboard time
        System.out.println("---------------- Clock In at Dashboard: " + TrimText );

        //Again move to HR module
        Thread.sleep(1000);
        WebElement HRMenu = driver.findElement(By.linkText("HR"));
        HRMenu.click();
        Thread.sleep(1000);
        System.out.println("User is on HR Module");

        //Again move to Attendance module
        Actions AttendanceSubMenu = new Actions(driver);
        Thread.sleep(1000);
        WebElement AttendancelinkText = driver.findElement(By.linkText("Attendance"));
        AttendanceSubMenu.moveToElement(AttendancelinkText).click().perform();
        Thread.sleep(1000);
        System.out.println("User is on Attendance Module");

        //Search ------------------------------------------------------------------------
        WebDriverWait EmployeeSearchBar= new WebDriverWait(driver, Duration.ofSeconds(100));
        EmployeeSearchBar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/button"))); //Employee Search bar
        driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/button")).click();
        Thread.sleep(2000); //----- Click on Employee

        WebElement AgainEmployeeName = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/div/div[1]/input")); // Fetch an employee name from the dashboard
        AgainEmployeeName.sendKeys(AddedGetEmployeeName);

        WebDriverWait FindEmployeeName = new WebDriverWait(driver, Duration.ofSeconds(100));
        FindEmployeeName.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/div/div[2]/ul/li/a")));
        driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/form/div/div[1]/div/div/div/div[2]/ul/li/a")).click();
        Thread.sleep(5000); //----- Click on Name of the Person

        //Get a system date
        DateFormat = new SimpleDateFormat("d");  //all the objects are reuse here
        DayOfMonth = new Date();
        SystemDate = DateFormat.format(DayOfMonth);
        System.out.println("System date : " + SystemDate);
        Thread.sleep(1000);

        //Again Find the date in attendance module and match with system date
        MatchDaysInAttendance = new Actions(driver);
        AttendanceTable = driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div"));
        MatchDaysInAttendance.moveToElement(AttendanceTable);
        rows = driver.findElements(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/thead/tr/th"));

            Size = rows.size();
            System.out.println("Total Rows are : " + Size);

                 for (int i = 1; i <= Size; i++)
                 {
                    WebElement TotalRows;
                    TotalRows = driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/thead/tr/th[" + i + "]"));
                    String GetActualDate = TotalRows.getText();
                    System.out.println(GetActualDate);

                    String GetExpectedDate = (SystemDate);
                    if (GetActualDate.equals(GetExpectedDate) == true)
                    {
                        driver.findElement(By.xpath("/html/body/div[1]/section/div[4]/div[2]/div/div[2]/div/div/table/tbody/tr/td[" + i + "]")).click();
                        Thread.sleep(1000);
                        System.out.println("======date Matched======");
                        Thread.sleep(5000);
                        break;
                    } else
                    {
                        System.out.println("Not Matched");
                    }
        }

        String ExpectedTime = TrimText;

        WebDriverWait AttendanceTimeTrim = new WebDriverWait(driver, Duration.ofSeconds(100));
        AttendanceTimeTrim.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div"))); // wait for Popup's clock In/Out xpath
        List<WebElement> RowsTime = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div")); //Popup's clock In/Out xpath
        int TimeSize = RowsTime.size();
        System.out.println("Total Rows are : " + TimeSize);
        Thread.sleep(500);

        for (int i = 1; i <= TimeSize; i++)
        {
            String PopUpTimes = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div[" + i + "]/ul/li[1]/p[2]")).getText(); //pop up clock In's common xpath
            String TrimmedTextAttendanceTime= PopUpTimes.replaceAll("\\s*(WFH|Late Half Day)\\s*", "").trim();  // Trim "WFH" and "Late Half Day" from the string
            System.out.println("---- ClockIn Time in Attendance Module is: " + TrimmedTextAttendanceTime);
            Thread.sleep(500);

            if (TrimmedTextAttendanceTime.equals(ExpectedTime) == true) {
                System.out.println("=============  Matched time =============");
                Thread.sleep(3000);
                driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button")).click(); //close popup
                break;
            }
            else
            {
                System.out.println("Not Matched");
            }
        }
        return TrimText;
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
        WebElement PrivateDashboardLink = driver.findElement(By.partialLinkText("Private Dashboard")); //Redirect on Private dashboard
        PrivateDashboardLink.click();
    }
    @When("User clicks on the Clocked out button")
    public void userClicksOnTheClockedOutButton() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/section/div[3]/div[1]/div[2]/button[1]")).click(); //Clock Out Button
        Thread.sleep(2000);
        System.out.println("User clicks on Clock Out button");
    }
    @Then("User successfully clock out")
    public void userSuccessfullyClockOut()
    {
        System.out.println("User Clocked out successfully");
    }
}

