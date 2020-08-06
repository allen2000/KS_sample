package mypackage

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent

public class PRequestOject {
	/**
	 * Restful POST requests
	 * @return
	 */
	def url
	def reqbody
	def PRequestOject(url,reqbody){
		this.url=url
		this.reqbody=reqbody
	}
	String endpoint = url
	String requestMethod = "POST"

	TestObjectProperty header2 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")
	ArrayList defaultHeaders = Arrays.asList(header2)

	String body = reqbody

	public ResponseObject buildPostApiRequest2() {
		RequestObject ro = new RequestObject("objectId")
		ro.setRestUrl(endpoint)
		ro.setHttpHeaderProperties(defaultHeaders)
		ro.setRestRequestMethod("POST")
		ro.setBodyContent(new HttpTextBodyContent(body))
		ResponseObject respObj = WS.sendRequest(ro)
		return respObj
	}
}