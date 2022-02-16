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
def boardNameVar = 'Create a Card Checkitem'
def nameofListVar = 'List'
def cardNameVar = 'My Card'
def getChecklistItemRespMsg = "complete"
def checklistNameVar = "Todo"
def nameCheckitemVar = 'Task-1'
//update checkitem vars
def updatedNameVar = 'Todo Task -1'
def updatedStateVar = 'complete'

//  Board Creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response1, boardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//  Create a List
response2 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar, ('idBoard') : idBoardVar ]))
WS.verifyResponseStatusCode(response2, 200, FailureHandling.CONTINUE_ON_FAILURE)
def listIdVar = WS.getElementPropertyValue(response2, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response2, nameofListVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//  Card Creation
response3 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar, ('cardName') : cardNameVar]))
WS.verifyResponseStatusCode(response3, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idCardVar = WS.getElementPropertyValue(response3, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response3, cardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

// Create a Checklist
response4 = WS.sendRequest(findTestObject('Trello/Checklist on Card/Create Checklist on card', [('urlCard') : GlobalVariable.url_Card, ('idCard') : idCardVar, ('checklistName') : checklistNameVar]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)
idChecklistVar = WS.getElementPropertyValue(response4, "id", FailureHandling.CONTINUE_ON_FAILURE)
data = response4.getResponseText()
print('\n\t'+data+'\n\t')
WS.containsString(response4, checklistNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)


// Create a Checkitem in Checklist
response5 = WS.sendRequest(findTestObject('Trello/Checkitems in a checklists on a card/Create Checkitem on Checklist', [('idChecklist') : idChecklistVar
	, ('nameCheckitem') : nameCheckitemVar]))
WS.verifyResponseStatusCode(response5, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idCheckitemVar = WS.getElementPropertyValue(response5, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response5, nameCheckitemVar, false, FailureHandling.CONTINUE_ON_FAILURE)


// Update the Checkitem
response6 = WS.sendRequest(findTestObject('Trello/Checkitems in a checklists on a card/Update a Checkitem on a Card', [('urlCard') : GlobalVariable.url_Card
	, ('idCard') : idCardVar, ('idCheckitem') : idCheckitemVar, ('updatedName') : updatedNameVar, ('updatedState') : updatedStateVar]))
WS.verifyResponseStatusCode(response6, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response6, updatedNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

// Delete a Checkitem
response7 = WS.sendRequest(findTestObject('Trello/Checkitems in a checklists on a card/Delete a Checkitem', [('urlCard') : GlobalVariable.url_Card
	, ('idCard') : idCardVar, ('idCheckitem') : idCheckitemVar]))
WS.verifyResponseStatusCode(response7, 200, FailureHandling.CONTINUE_ON_FAILURE)


