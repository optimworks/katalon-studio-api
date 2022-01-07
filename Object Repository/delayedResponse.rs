<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>delayedResponse</name>
   <tag></tag>
   <elementGuidId>349d45ee-e5bf-46d5-a674-be2fed55b50f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <katalonVersion>8.2.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://reqres.in/api/users?delay=3</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>
import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()


WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

WS.verifyElementPropertyValue(response, 'page', 1)

WS.verifyElementPropertyValue(response, 'per_page', 6)

WS.verifyElementPropertyValue(response, 'total', 12)

WS.verifyElementPropertyValue(response, 'total_pages', 2)

WS.verifyElementPropertyValue(response, 'data[0].id', 1)

WS.verifyElementPropertyValue(response, 'data[0].email', &quot;george.bluth@reqres.in&quot;)

WS.verifyElementPropertyValue(response, 'data[0].first_name', &quot;George&quot;)

WS.verifyElementPropertyValue(response, 'data[0].last_name', &quot;Bluth&quot;)

WS.verifyElementPropertyValue(response, 'data[0].avatar', &quot;https://reqres.in/img/faces/1-image.jpg&quot;)

WS.verifyElementPropertyValue(response, 'data[1].id', 2)

WS.verifyElementPropertyValue(response, 'data[1].email', &quot;janet.weaver@reqres.in&quot;)

WS.verifyElementPropertyValue(response, 'data[1].first_name', &quot;Janet&quot;)

WS.verifyElementPropertyValue(response, 'data[1].last_name', &quot;Weaver&quot;)

WS.verifyElementPropertyValue(response, 'data[1].avatar', &quot;https://reqres.in/img/faces/2-image.jpg&quot;)

WS.verifyElementPropertyValue(response, 'data[2].id', 3)

WS.verifyElementPropertyValue(response, 'data[2].email', &quot;emma.wong@reqres.in&quot;)

WS.verifyElementPropertyValue(response, 'data[2].first_name', &quot;Emma&quot;)

WS.verifyElementPropertyValue(response, 'data[2].last_name', &quot;Wong&quot;)

WS.verifyElementPropertyValue(response, 'data[2].avatar', &quot;https://reqres.in/img/faces/3-image.jpg&quot;)

WS.verifyElementPropertyValue(response, 'data[3].id', 4)

WS.verifyElementPropertyValue(response, 'data[3].email', &quot;eve.holt@reqres.in&quot;)

WS.verifyElementPropertyValue(response, 'data[3].first_name', &quot;Eve&quot;)

WS.verifyElementPropertyValue(response, 'data[3].last_name', &quot;Holt&quot;)

WS.verifyElementPropertyValue(response, 'data[3].avatar', &quot;https://reqres.in/img/faces/4-image.jpg&quot;)

WS.verifyElementPropertyValue(response, 'data[4].id', 5)

WS.verifyElementPropertyValue(response, 'data[4].email', &quot;charles.morris@reqres.in&quot;)

WS.verifyElementPropertyValue(response, 'data[4].first_name', &quot;Charles&quot;)

WS.verifyElementPropertyValue(response, 'data[4].last_name', &quot;Morris&quot;)

WS.verifyElementPropertyValue(response, 'data[4].avatar', &quot;https://reqres.in/img/faces/5-image.jpg&quot;)

WS.verifyElementPropertyValue(response, 'data[5].id', 6)

WS.verifyElementPropertyValue(response, 'data[5].email', &quot;tracey.ramos@reqres.in&quot;)

WS.verifyElementPropertyValue(response, 'data[5].first_name', &quot;Tracey&quot;)

WS.verifyElementPropertyValue(response, 'data[5].last_name', &quot;Ramos&quot;)

WS.verifyElementPropertyValue(response, 'data[5].avatar', &quot;https://reqres.in/img/faces/6-image.jpg&quot;)
//WS.verifyElementPropertyValue(response, 'support', '')
//WS.verifyElementPropertyValue(response, 'support.url', &quot;https://reqres.in/#support-heading&quot;)
//WS.verifyElementPropertyValue(response, 'support.url', &quot;https://reqres.in/#support-heading&quot;)
WS.verifyElementPropertyValue(response, 'support.text', &quot;To keep ReqRes free, contributions towards server costs are appreciated!&quot;)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
