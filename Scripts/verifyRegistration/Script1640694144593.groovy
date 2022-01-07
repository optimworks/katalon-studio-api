import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable


println(userName)

println(password)

 response1 = WS.sendRequest(findTestObject('Object Repository/registration', [('userName') :userName, ('password') : password]))
 
 
//String data = response1.getResponseText()

println(response1.getClass())
assertThat(response1.getStatusCode()).isEqualTo(200)

assertThat(response1.getResponseText()).contains(userName)

WS.verifyElementPropertyValue(response1, 'email', userName)

WS.verifyElementPropertyValue(response1, 'password', password)
//def slurper = new groovy.json.JsonSlurper()
//def entry = slurper.parseText('{"result":[{"id":"167687","dapadmin":"false","status":"in progress","lastupdated":"2017-04-21 14:34:30.0","started":"2017-04-21 14:34:28.0","user":"sys","log":"Running a Stop action\n\nRunning command \n"}]}')
//def lastupdated = entry.result.lastupdated
//def status = entry.result.status
//def id = entry.result.id

//HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
 //onse.getResponseText()
//String data1 = data.toString();
//println(data1)
//String  data1 = JSON.stringify(response1);
//println(data1)
//String listString = "";
//
//for (String s : data1)
//{
//	listString = s ;
//}
//

//System.out.println(listString);
//String[] data = response.toString();
//String data1 = ''.join(response)
//println(data1)
//def jsonSlurper = new groovy.json.JsonSlurper()

//def jsonRespo= jsonSlurper.parseText(response.getResponseText())
//String list1 = response

//println(response1)




//RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

//ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()





