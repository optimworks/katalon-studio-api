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
def boardNameVar = 'Create a Card Checklist'
def nameofListVar = 'List'
def cardNameVar = 'My Card'
def getChecklistItemRespMsg = "complete"
def checklistNameVar = "Todo"

//  board creation
response1 = WS.sendRequest(findTestObject('Trello/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response1, boardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//  Create a List
response2 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar, ('idBoard') : idBoardVar ]))
WS.verifyResponseStatusCode(response2, 200, FailureHandling.CONTINUE_ON_FAILURE)
def listIdVar = WS.getElementPropertyValue(response2, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response2, nameofListVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//  card creation
response3 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar, ('cardName') : cardNameVar]))
WS.verifyResponseStatusCode(response3, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idCardVar = WS.getElementPropertyValue(response3, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response3, cardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

// create a checklist
response4 = WS.sendRequest(findTestObject('Trello/Checklist on Card/Create Checklist on card', [('urlCard') : GlobalVariable.url_Card, ('idCard') : idCardVar, ('checklistName') : checklistNameVar]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)
idChecklistVar = WS.getElementPropertyValue(response4, "id", FailureHandling.CONTINUE_ON_FAILURE)

// Get a checklist item
response5 = WS.sendRequest(findTestObject('Trello/Checklist on Card/Get Checklist Item', [('urlCard') : GlobalVariable.url_Card, ('idCard') : idCardVar]))
WS.verifyResponseStatusCode(response5, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response5, checklistNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

// Delete a checklist on a card
response6 = WS.sendRequest(findTestObject('Trello/Checklist on Card/Delete a Checklist on a Card', [('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar, ('idChecklist') : idChecklistVar ]))
WS.verifyResponseStatusCode(response6, 200, FailureHandling.CONTINUE_ON_FAILURE)

