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
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import mypackage.GetResponseObject as GetResponseObject
import mypackage.GRequestObject as GRequestObject

re_dic = [('statusResult') : '', ('respBodyResult') : '']
GRequestObject req = new GRequestObject(base_url + path)
ResponseObject resp = req.buildgetApiRequest1()
println(GetResponseObject.getResponseBodyContent(resp))

status_code = status_code.toInteger()

(re_dic['statusResult']) = (GetResponseObject.getStatusCode(resp) == status_code)
(re_dic['respBodyResult']) = (GetResponseObject.getResponseBodyContent(resp) == resp_body)

if (re_dic['statusResult'] & re_dic['respBodyResult']) {
	println('+++++Pass+++++')

	WebUI.callTestCase(findTestCase('Common/write_excel'), [('sheetname') : 'API_Get', ('inx') : index.toInteger(), ('cellNO') : 7, ('rr') : 'Pass'],
		FailureHandling.STOP_ON_FAILURE)
} else {
	WebUI.callTestCase(findTestCase('Common/write_excel'), [('sheetname') : 'API_Get', ('inx') : index.toInteger(), ('cellNO') : 7, ('rr') : 'Fail'],
		FailureHandling.STOP_ON_FAILURE)
	println('-----False-----')
}
assert re_dic['statusResult']&re_dic['respBodyResult']==true