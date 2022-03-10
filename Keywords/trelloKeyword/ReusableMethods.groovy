package trelloKeyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.commons.lang.RandomStringUtils
import java.util.Random;

import internal.GlobalVariable

public class ReusableMethods {

	@Keyword
	def concatenationWithSting(text,value){
		WS.concatenate([text, value] as String[], FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def getElementPropertyValue(resp,value) {
		WS.getElementPropertyValue(resp, value, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def printResponseText(resp) {
		def printResponse = resp.getResponseText()
		println("\n\t"+printResponse+"\n\t")
	}
	@Keyword
	def verifyStatusCode(resp,statusCode) {
		WS.verifyResponseStatusCode(resp, statusCode, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyMatch(text,text1) {
		WS.verifyMatch(text,text1, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyNotMatch(text,text1) {
		WS.verifyMatch(text,text1, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def getRandomSetofCharacter(int length){
		String alphabet = RandomStringUtils.randomAlphabetic(length).toLowerCase()
		return alphabet
	}
	
	@Keyword
	def verifyEqual(text,text1){
		WS.verifyEqual(text, text1, FailureHandling.STOP_ON_FAILURE)
		
	}
	
}

