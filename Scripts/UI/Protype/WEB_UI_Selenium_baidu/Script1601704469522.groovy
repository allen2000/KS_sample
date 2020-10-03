import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.PageLoadStrategy as PageLoadStrategy
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

System.setProperty('webdriver.chrome.driver', '.\\Tools\\chromedriver.exe')
ChromeOptions options = new ChromeOptions()
options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.NORMAL)
options.addArguments('--test-type --ignore-certificate-errors')
options.addArguments('--use-fake-ui-for-media-stream')
DesiredCapabilities capabilities = new DesiredCapabilities()
capabilities.setCapability(ChromeOptions.CAPABILITY, options)
options.merge(capabilities)
ChromeDriver driver = new ChromeDriver(options)
driver.get("https://www.baidu.com/")
//driver.manage().window().maximize()
driver.findElementById('kw').sendKeys('allen')
sleep(1000)
driver.findElementById('su').click()
sleep(2000)
println driver.getTitle()
assert "allen_百度搜索"==driver.getTitle()
driver.close()