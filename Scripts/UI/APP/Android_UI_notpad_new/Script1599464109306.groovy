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

Mobile.startApplication('com.example.android.notepad.apk', false)

'new'
Mobile.tap(findTestObject('notepad/android.widget.ImageView0'), 0)

Mobile.setText(findTestObject('notepad/android.widget.EditText0'), 'allen', 0)

'save'
Mobile.tap(findTestObject('notepad/android.widget.TextView0 - '), 0)

'judgement'
tt = Mobile.getAttribute(findTestObject('notepad/android.widget.TextView0 -  (2)'), 'text', 0)

assert tt == 'allen'

'options'
Mobile.tap(findTestObject('notepad/android.widget.ImageButton0'), 0)

'All delete'
Mobile.tap(findTestObject('notepad/android.widget.TextView0 -  (1)'), 0)

'confirm'
Mobile.tap(findTestObject('notepad/android.widget.Button0 - '), 0)

Mobile.closeApplication()

