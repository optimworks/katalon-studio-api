<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Update a Checkitem on a Card</name>
   <tag></tag>
   <elementGuidId>0b5f6feb-71eb-4be9-addf-dc61d6adbf1f</elementGuidId>
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
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>${urlCard}/${idCard}/checkItem/${idCheckitem}?key=${key}&amp;token=${token}&amp;name=${updatedName}&amp;state=${updatedState}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.url_Card</defaultValue>
      <description></description>
      <id>d8bb3214-7486-4361-bc82-65ab9fe24b45</id>
      <masked>false</masked>
      <name>urlCard</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>cc01bb73-596a-4c58-a056-a7f05c97c086</id>
      <masked>false</masked>
      <name>idCard</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>6e6dde2c-e7b0-40a8-85c4-68880d040aba</id>
      <masked>false</masked>
      <name>idCheckitem</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>340d9d03-d873-4c7e-9f01-6c5a275e812e</id>
      <masked>false</masked>
      <name>updatedName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3f88d18e-792c-433e-8d96-c9f1ba8618c4</id>
      <masked>false</masked>
      <name>updatedState</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.key</defaultValue>
      <description></description>
      <id>aea7658b-23aa-4c9e-8be6-d8065395d8e2</id>
      <masked>false</masked>
      <name>key</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.token</defaultValue>
      <description></description>
      <id>db558577-eefc-4453-9c10-714880f3746a</id>
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
