<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>plus</name>
   <tag></tag>
   <elementGuidId>2e24f175-1652-4238-ab41-85b301072d3c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;Envelope xmlns=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot;>
    &lt;Body>
        &lt;Add xmlns=&quot;http://tempuri.org/&quot;>
            &lt;intA>${a}&lt;/intA>
            &lt;intB>${b}&lt;/intB>
        &lt;/Add>
    &lt;/Body>
&lt;/Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>Add</soapServiceFunction>
   <variables>
      <defaultValue>findTestData('CALC').getValue(1, 1)</defaultValue>
      <description></description>
      <id>0b5b6f40-ee00-4580-aaae-a7a491c780a3</id>
      <masked>false</masked>
      <name>a</name>
   </variables>
   <variables>
      <defaultValue>findTestData('CALC').getValue(2, 1)</defaultValue>
      <description></description>
      <id>981822b9-4284-4533-adb1-0b305f3f5883</id>
      <masked>false</masked>
      <name>b</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyElementText(response, 'AddResponse.AddResult', '4')</verificationScript>
   <wsdlAddress>http://www.dneonline.com/calculator.asmx?wsdl</wsdlAddress>
</WebServiceRequestEntity>
