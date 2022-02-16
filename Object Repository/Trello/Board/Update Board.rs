<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Update Board</name>
   <tag></tag>
   <elementGuidId>c6503144-0c3f-458c-b44f-00e38c374814</elementGuidId>
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
   <restUrl>${urlBoard}/${idBoard}?key=${key}&amp;token=${token}&amp;name=${updatedBoardName}&amp;desc=${description}&amp;prefs/permissionLevel=${permission}&amp;prefs/background=${backgroundColor}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.url_Board</defaultValue>
      <description></description>
      <id>0aa9e52f-0dab-4524-9869-ed98ea60abf3</id>
      <masked>false</masked>
      <name>urlBoard</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>71c83f4f-223d-4882-b895-47dc667ec66d</id>
      <masked>false</masked>
      <name>idBoard</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f0ff8773-618c-4de8-8ac5-3bf580266f8e</id>
      <masked>false</masked>
      <name>updatedBoardName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>5f333a6a-a15e-463c-9657-51b634f1fb3e</id>
      <masked>false</masked>
      <name>description</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3c33adc9-4ab8-4a9d-a3a8-30b70955f96b</id>
      <masked>false</masked>
      <name>permission</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>314d0501-d5fc-4326-9fa3-a6a50469a2ce</id>
      <masked>false</masked>
      <name>backgroundColor</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.key</defaultValue>
      <description></description>
      <id>bc6a7871-f0fd-4a14-933e-d39fe9027634</id>
      <masked>false</masked>
      <name>key</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.token</defaultValue>
      <description></description>
      <id>5881b4d0-9490-4f32-89d1-f2b13eebdf92</id>
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
