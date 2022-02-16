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

//vars
def boardNameVar = 'Update details of board'
def updatedBoardNameVar = 'Board Name Updated'
def m = 'I have updated the details of this board'
def permissionLevelVar = 'public'
def backgroundColorVar = 'red'


//  Board Creation
response = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
WS.verifyResponseStatusCode(response, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response, boardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)


// Update Board Creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Update Board',[('urlBoard') : GlobalVariable.url_Board,('updatedBoardName') : updatedBoardNameVar,
	('idBoard') : idBoardVar,('description') : boardDescription,('permission') : permissionLevelVar,('backgroundColor') : backgroundColorVar ]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
boardResponse = response1.getResponseText()
println("\n\t"+boardResponse+"\n\t")
WS.containsString(response1, boardDescription, false, FailureHandling.CONTINUE_ON_FAILURE)