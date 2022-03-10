<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Delete a Label on Card</name>
   <tag></tag>
   <elementGuidId>dccb1d51-dab2-4d6b-a499-2c2e10a74d80</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <katalonVersion>8.2.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>DELETE</restRequestMethod>
   <restUrl>${urlCard}/${cardId}/idLabels/${labelId}?key=87a4904ed7d712ca1bc346ae43515631&amp;token=22145b645f529838e731eb82a289d8283e1a75aac36464b960dce222c6f80758&amp;name=${labelColor}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.url_Card</defaultValue>
      <description></description>
      <id>e8146d1d-ab7e-4314-8566-3cd4d8156cdf</id>
      <masked>false</masked>
      <name>urlCard</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>31a6d564-fec6-4a53-bab9-1fcf7ff0e205</id>
      <masked>false</masked>
      <name>labelId</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>205137b9-d003-464a-bc4d-2c6f115b031f</id>
      <masked>false</masked>
      <name>labelColor</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>35405af6-b1a7-445b-9493-b6da98a1602e</id>
      <masked>false</masked>
      <name>cardId</name>
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
