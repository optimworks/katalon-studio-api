import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.nio.file.WatchService

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

response = WS.sendRequest(findTestObject('singleResources'))

WS.verifyElementPropertyValue(response, 'data.id', 2)

WS.verifyElementPropertyValue(response, 'data.name', "fuchsia rose")

WS.verifyElementPropertyValue(response, 'data.year', 2001)

WS.verifyElementPropertyValue(response, 'data.color', "#C74375")

WS.verifyElementPropertyValue(response, 'data.pantone_value', "17-2031")

WS.verifyElementPropertyValue(response, 'support.text', "To keep ReqRes free, contributions towards server costs are appreciated!")

assert WS.sendRequestAndVerify(null, FailureHandling.STOP_ON_FAILURE)==true;"m "
WS.verifyElementsCount(null, null, 0)
WS.verifyElementText(response, 'data.year', 2001)
WS.verifyEqual(findWindowsObject, findTestCase)
WS.v