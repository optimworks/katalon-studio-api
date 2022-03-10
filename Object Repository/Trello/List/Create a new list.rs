<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Create a new list</name>
   <tag></tag>
   <elementGuidId>05782c69-49bb-4d0e-838f-64e76ae5daba</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${urlList}?name=${nameofList}&amp;idBoard=${idBoard}&amp;key=${key}&amp;token=${token}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.url_List</defaultValue>
      <description></description>
      <id>67a9d87a-a7f4-4289-85b0-b62045443f39</id>
      <masked>false</masked>
      <name>urlList</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>117212e9-7e53-4397-8d85-19e751f69d2c</id>
      <masked>false</masked>
      <name>nameofList</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>be238d27-cc7a-4fe2-849a-9358224883a5</id>
      <masked>false</masked>
      <name>idBoard</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.key</defaultValue>
      <description></description>
      <id>35d02258-d1bd-45fd-a3ea-a2a517122f6f</id>
      <masked>false</masked>
      <name>key</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.token</defaultValue>
      <description></description>
      <id>228ad9fb-3ad4-4d6b-889f-2902141ad1db</id>
      <masked>false</masked>
      <name>token</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
