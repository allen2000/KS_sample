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
import mypackage.PRequestOject as PRequestObject

re_dic = [('statusResult') : '', ('respBodyResult') : '']

PRequestObject req = new PRequestObject(base_url + path, req_body)
ResponseObject resp = req.buildPostApiRequest2()
status_code = status_code.toInteger()

(re_dic['statusResult']) = (GetResponseObject.getStatusCode(resp) == status_code)
(re_dic['respBodyResult']) = (GetResponseObject.getResponseBodyContent(resp) == resp_body)

if (re_dic['statusResult'] & re_dic['respBodyResult']) {
	println('+++++Pass+++++')

	WebUI.callTestCase(findTestCase('Common/write_excel'), [('sheetname') : 'post', ('inx') : index.toInteger(), ('cellNO') : 9, ('rr') : 'Pass'],
		FailureHandling.STOP_ON_FAILURE)
} else {
	WebUI.callTestCase(findTestCase('Common/write_excel'), [('sheetname') : 'post', ('inx') : index.toInteger(), ('cellNO') : 9, ('rr') : 'Fail'],
		FailureHandling.STOP_ON_FAILURE)
	println('-----False-----')
	println path+"---"+GetResponseObject.getResponseBodyContent(resp)
}

assert re_dic['statusResult']&re_dic['respBodyResult']==true