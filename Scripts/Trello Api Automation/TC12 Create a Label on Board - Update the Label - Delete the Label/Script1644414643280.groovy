@import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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

//  Vars
//show menu->more->labels

def labelColorVar = "yellow"
def deleteParticularLabelRespMsg = '{"_value":null}'
def boardNameVar = 'Create a Label on a Board '
def labelNameVar = 'This is label'
def updatedNameVar = 'Updated name label'

//  Board creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response1, boardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)

//  Create a label on Board
response2 = WS.sendRequest(findTestObject('Trello/Label on Board/Create a Label on Board', [('urlBoard') : GlobalVariable.url_Board
	, ('idBoard') : idBoardVar, ('name') : labelNameVar, ('color') : labelColorVar]))
WS.verifyResponseStatusCode(response2, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response2, labelColorVar, false, FailureHandling.CONTINUE_ON_FAILURE)
def labelIdVar = WS.getElementPropertyValue(response2, "id", FailureHandling.CONTINUE_ON_FAILURE)


//  Update the created label on Board
response3 = WS.sendRequest(findTestObject('Trello/Label on Board/Update the Created Label on a Board', [('idLabel') : labelIdVar, ('updatedName') : updatedNameVar]))
WS.verifyResponseStatusCode(response3, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response3, updatedNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//  Delete a created label on Board
response4 = WS.sendRequest(findTestObject('Trello/Label on Board/Delete the Created Label', [('idLabel') : labelIdVar]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)

