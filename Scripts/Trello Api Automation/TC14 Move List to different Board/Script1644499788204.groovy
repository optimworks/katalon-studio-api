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
def boardNameVar1 = 'Board from which list needed to be moved '
def nameofListVar = 'List that needs to be moved'
def boardNameVar2 = 'Board to which list needed to be moved'


//  Board1 Creation
response1 = WS.sendRequest(findTestObject('Trello/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar1]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardMovedFrom = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)
board_response = response1.getResponseText()
println("\n\t"+board_response+"\n\t")
WS.containsString(response1, boardNameVar1, false, FailureHandling.CONTINUE_ON_FAILURE)

//  Create a List1
response2 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar, ('idBoard') : idBoardMovedFrom ]))
WS.verifyResponseStatusCode(response2, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response2,nameofListVar, false, FailureHandling.CONTINUE_ON_FAILURE)
def listIdVar = WS.getElementPropertyValue(response2, "id", FailureHandling.CONTINUE_ON_FAILURE)

//  Board2 Creation
response4 = WS.sendRequest(findTestObject('Trello/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar2]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardMovedToVar = WS.getElementPropertyValue(response4, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response4, boardNameVar2, false, FailureHandling.CONTINUE_ON_FAILURE)

// Move List to a New Board
response5 = WS.sendRequest(findTestObject('Object Repository/Trello/Move List to Board',[('urlList') : GlobalVariable.url_List, ('idList') : listIdVar, ('idBoardMovedTo') : idBoardMovedToVar, ]))
WS.verifyResponseStatusCode(response5, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response5,nameofListVar, false, FailureHandling.CONTINUE_ON_FAILURE)



