<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>listUsers</name>
   <tag></tag>
   <elementGuidId>8c82361c-0686-4b98-abf8-1be078ecc684</elementGuidId>
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
   <restUrl>https://reqres.in/api/users?page=2</restUrl>
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


WS.verifyElementPropertyValue(response, 'page', 2)
WS.verifyElementPropertyValue(response, 'per_page', 6)
WS.verifyElementPropertyValue(response, 'total', 12)
WS.verifyElementPropertyValue(response, 'total_pages', 2)
WS.verifyElementPropertyValue(response, 'data', '')
WS.verifyElementPropertyValue(response, 'data[0].id', 7)
WS.verifyElementPropertyValue(response, 'data[0].email', &quot;michael.lawson@reqres.in&quot;)
WS.verifyElementPropertyValue(response, 'data[0].first_name', &quot;Michael&quot;)
WS.verifyElementPropertyValue(response, 'data[0].last_name', &quot;Lawson&quot;)
//WS.verifyElementPropertyValue(response, 'data[0].avatar', &quot;https://reqres.in/img/faces/7-image.jpg&quot;)
WS.verifyElementPropertyValue(response, 'data[1].id', 8)
WS.verifyElementPropertyValue(response, 'data[1].email', &quot;lindsay.ferguson@reqres.in&quot;)
WS.verifyElementPropertyValue(response, 'data[1].first_name', &quot;Lindsay&quot;)
WS.verifyElementPropertyValue(response, 'data[1].last_name', &quot;Ferguson&quot;)
WS.verifyElementPropertyValue(response, 'data[1].avatar', &quot;https://reqres.in/img/faces/8-image.jpg&quot;)
WS.verifyElementPropertyValue(response, 'data[2].id', 9)
WS.verifyElementPropertyValue(response, 'data[2].email', &quot;tobias.funke@reqres.in&quot;)
WS.verifyElementPropertyValue(response, 'data[2].first_name', &quot;Tobias&quot;)
WS.verifyElementPropertyValue(response, 'data[2].last_name', &quot;Funke&quot;)
WS.verifyElementPropertyValue(response, 'data[2].avatar', &quot;https://reqres.in/img/faces/9-image.jpg&quot;)
WS.verifyElementPropertyValue(response, 'data[3].id', 10)
WS.verifyElementPropertyValue(response, 'data[3].email', &quot;byron.fields@reqres.in&quot;)
WS.verifyElementPropertyValue(response, 'data[3].first_name', &quot;Byron&quot;)
WS.verifyElementPropertyValue(response, 'data[3].first_name', &quot;Byron&quot;)
WS.verifyElementPropertyValue(response, 'data[3].last_name', &quot;Fields&quot;)
WS.verifyElementPropertyValue(response, 'data[3].avatar', &quot;https://reqres.in/img/faces/10-image.jpg&quot;)
WS.verifyElementPropertyValue(response, 'data[4].id', 11)
WS.verifyElementPropertyValue(response, 'data[4].email', &quot;george.edwards@reqres.in&quot;)
WS.verifyElementPropertyValue(response, 'data[4].first_name', &quot;George&quot;)
WS.verifyElementPropertyValue(response, 'data[4].last_name', &quot;Edwards&quot;)
WS.verifyElementPropertyValue(response, 'data[4].avatar', &quot;https://reqres.in/img/faces/11-image.jpg&quot;)
WS.verifyElementPropertyValue(response, 'data[5].id', 12)
WS.verifyElementPropertyValue(response, 'data[5].email', &quot;rachel.howell@reqres.in&quot;)
WS.verifyElementPropertyValue(response, 'data[5].first_name', &quot;Rachel&quot;)
WS.verifyElementPropertyValue(response, 'data[5].last_name', &quot;Howell&quot;)
WS.verifyElementPropertyValue(response, 'data[5].avatar', &quot;https://reqres.in/img/faces/12-image.jpg&quot;)
WS.verifyElementPropertyValue(response, 'support.url', &quot;https://reqres.in/#support-heading&quot;)
WS.verifyElementPropertyValue(response, 'support.text', &quot;To keep ReqRes free, contributions towards server costs are appreciated!&quot;)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
