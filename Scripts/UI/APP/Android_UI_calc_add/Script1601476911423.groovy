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

Mobile.tap(findTestObject('mi_calc0/num_btn',[('index') : var_a]), 30)

Mobile.tap(findTestObject('mi_calc0/add_btn'), 30)

Mobile.tap(findTestObject('mi_calc0/num_btn',[('index') : var_b]), 30)

Mobile.tap(findTestObject('mi_calc0/equal_btn'), 30)

Mobile.verifyElementText(findTestObject('mi_calc0/result_show'), add_result)

Mobile.tap(findTestObject('mi_calc0/clear_btn'), 0)

Mobile.pressBack()

@com.kms.katalon.core.annotation.SetUp
def set(def param) {
    Mobile.startApplication('Calculator-10.1.20.apk', false)
}

@com.kms.katalon.core.annotation.TearDown
def tear(def param) {
    Mobile.closeApplication()
}

