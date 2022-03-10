<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Create Checkitem on Checklist</name>
   <tag></tag>
   <elementGuidId>7ab567f4-53d8-4720-b8cf-4e71a4512ec4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <katalonVersion>8.2.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://api.trello.com/1/checklists/${idChecklist}/checkItems?name=${nameCheckitem}&amp;key=${key}&amp;token=${token}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>9cacb036-2694-4a4c-8639-f8debe9c3863</id>
      <masked>false</masked>
      <name>idChecklist</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>57bba343-fd0d-405b-bccd-5e85a02c0225</id>
      <masked>false</masked>
      <name>nameCheckitem</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.key</defaultValue>
      <description></description>
      <id>1f4a1588-4de2-4cf4-a612-0d74eaa6f6b1</id>
      <masked>false</masked>
      <name>key</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.token</defaultValue>
      <description></description>
      <id>a9d8301f-cc01-412d-9ebf-6155c43e8e24</id>
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
