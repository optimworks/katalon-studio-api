<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Delete a Sticker on Card</name>
   <tag></tag>
   <elementGuidId>26d42a93-d368-4162-97d9-b7d0598af174</elementGuidId>
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
   <restRequestMethod>DELETE</restRequestMethod>
   <restUrl>${urlCard}/${idCard}/stickers/${idSticker}?key=87a4904ed7d712ca1bc346ae43515631&amp;token=22145b645f529838e731eb82a289d8283e1a75aac36464b960dce222c6f80758</restUrl>
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
      <id>b504e032-558c-4df5-ad18-6a8418140ee1</id>
      <masked>false</masked>
      <name>urlCard</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>65d0b1c5-e6e5-455a-aa10-5e26cd65f2bc</id>
      <masked>false</masked>
      <name>idCard</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>07d847ec-b4cf-4167-8812-98800dc32232</id>
      <masked>false</masked>
      <name>idSticker</name>
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
