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


 response = WS.sendRequest(findTestObject('delayedResponse'))

println(response.getClass())

WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

WS.verifyElementPropertyValue(response, 'page', 1)

WS.verifyElementPropertyValue(response, 'per_page', 6)

WS.verifyElementPropertyValue(response, 'total', 12)

WS.verifyElementPropertyValue(response, 'total_pages', 2)

WS.verifyElementPropertyValue(response, 'data[0].id', 1)

WS.verifyElementPropertyValue(response, 'data[0].email', "george.bluth@reqres.in")

WS.verifyElementPropertyValue(response, 'data[0].first_name', "George")

WS.verifyElementPropertyValue(response, 'data[0].last_name', "Bluth")

WS.verifyElementPropertyValue(response, 'data[0].avatar', "https://reqres.in/img/faces/1-image.jpg")

WS.verifyElementPropertyValue(response, 'data[1].id', 2)

WS.verifyElementPropertyValue(response, 'data[1].email', "janet.weaver@reqres.in")

WS.verifyElementPropertyValue(response, 'data[1].first_name', "Janet")

WS.verifyElementPropertyValue(response, 'data[1].last_name', "Weaver")

WS.verifyElementPropertyValue(response, 'data[1].avatar', "https://reqres.in/img/faces/2-image.jpg")

WS.verifyElementPropertyValue(response, 'data[2].id', 3)

WS.verifyElementPropertyValue(response, 'data[2].email', "emma.wong@reqres.in")

WS.verifyElementPropertyValue(response, 'data[2].first_name', "Emma")

WS.verifyElementPropertyValue(response, 'data[2].last_name', "Wong")

WS.verifyElementPropertyValue(response, 'data[2].avatar', "https://reqres.in/img/faces/3-image.jpg")

WS.verifyElementPropertyValue(response, 'data[3].id', 4)

WS.verifyElementPropertyValue(response, 'data[3].email', "eve.holt@reqres.in")

WS.verifyElementPropertyValue(response, 'data[3].first_name', "Eve")

WS.verifyElementPropertyValue(response, 'data[3].last_name', "Holt")

WS.verifyElementPropertyValue(response, 'data[3].avatar', "https://reqres.in/img/faces/4-image.jpg")

WS.verifyElementPropertyValue(response, 'data[4].id', 5)

WS.verifyElementPropertyValue(response, 'data[4].email', "charles.morris@reqres.in")

WS.verifyElementPropertyValue(response, 'data[4].first_name', "Charles")
