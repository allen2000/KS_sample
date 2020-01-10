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

WebUI.setText(findTestObject('Object Repository/Page_/input__wd'), SearchString)

WebUI.click(findTestObject('Object Repository/Page_/input__su'))

WebUI.delay(2)

tt = WebUI.getWindowTitle()

assert tt == (SearchString + '_百度搜索')

@com.kms.katalon.core.annotation.SetUp
def set_up() {
    WebUI.openBrowser('')

    WebUI.navigateToUrl('https://www.baidu.com/')

    WebUI.callTestCase(findTestCase('common/init _result2excel'), [('inx') : inx, ('rr') : ' ', ('cellNO') : '3', ('sheetInx') : '0'], 
        FailureHandling.STOP_ON_FAILURE)
}

@com.kms.katalon.core.annotation.TearDown
def Tear_Down() {
    WebUI.callTestCase(findTestCase('common/write_result2excel'), [('inx') : inx, ('rr') : SearchString + '_百度搜索', ('cellNO') : '3'
            , ('sheetInx') : '0'], FailureHandling.STOP_ON_FAILURE)

    WebUI.closeBrowser()
}

