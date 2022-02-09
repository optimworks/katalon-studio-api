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
def boardNameVar = 'Add Comment on a Card'
def nameofListVar = 'List'
def cardNameVar = 'Comment'
def commentVar = 'This is the comment added to this card'
def commentUpdateVar = 'This is the updated comment added to this card'

//  Board Creation
response1 = WS.sendRequest(findTestObject('Trello/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
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

// Add a Comment to a Card
response4 = WS.sendRequest(findTestObject('Trello/Comment on Card/Add a comment to a Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar, ('comment') : commentVar]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response4, commentVar, false, FailureHandling.CONTINUE_ON_FAILURE)
Data = response4.getResponseText()
print('\n\t'+ Data +'\n\t')
def idActionVar = WS.getElementPropertyValue(response4, "id", FailureHandling.CONTINUE_ON_FAILURE)

// Update a Comment on a Card
response5 = WS.sendRequest(findTestObject('Trello/Comment on Card/Update a comment on a card',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar, ('commentUpdate') : commentUpdateVar
	         ,('idAction') : idActionVar]))
WS.verifyResponseStatusCode(response5, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response5, commentUpdateVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//Delete a Comment on a Card
response6 = WS.sendRequest(findTestObject('Trello/Comment on Card/Delete a comment on a card',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar,('idAction') : idActionVar]))
WS.verifyResponseStatusCode(response6, 200, FailureHandling.CONTINUE_ON_FAILURE)

