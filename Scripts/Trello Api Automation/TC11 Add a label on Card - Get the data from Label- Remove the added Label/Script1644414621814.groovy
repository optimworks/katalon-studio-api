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

//  Variable
// https://trello.com/c/ttpGPBw5/4-test-create-1
// red's idLabel = 61e7bae48166f387531fe62f
def labelColorVar = "yellow"
def deleteParticularLabelRespMsg = '{"_value":null}'
def boardNameVar = 'Add Label to a Card '
def nameofListVar = 'List1'
def cardNameVar = 'My card'


//  Board Creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)
board_response = response1.getResponseText()
println("\n\t"+board_response+"\n\t")


//  Create a List
response2 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar, ('idBoard') : idBoardVar ]))
WS.verifyResponseStatusCode(response2, 200, FailureHandling.CONTINUE_ON_FAILURE)
//WS.containsString(response2,createListRespMsg, false, FailureHandling.CONTINUE_ON_FAILURE)
def listIdVar = WS.getElementPropertyValue(response2, "id", FailureHandling.CONTINUE_ON_FAILURE)


//  Card Creation
response3 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar, ('cardName') : cardNameVar]))
WS.verifyResponseStatusCode(response3, 200, FailureHandling.CONTINUE_ON_FAILURE)
card_response = response3.getResponseText()
println("\n\t"+card_response+"\n\t")
def cardIdVar = WS.getElementPropertyValue(response3, "id", FailureHandling.CONTINUE_ON_FAILURE)


//  Create a label in particular card
response4 = WS.sendRequest(findTestObject('Trello/Label on Card/Create a Label on Card', [('urlCard') : GlobalVariable.url_Card,('cardId') : cardIdVar,('labelColor') : labelColorVar]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response4, labelColorVar, false, FailureHandling.CONTINUE_ON_FAILURE)
def labelIdVar = WS.getElementPropertyValue(response4, "id", FailureHandling.CONTINUE_ON_FAILURE)


// Get the data from label
response5 = WS.sendRequest(findTestObject('Trello/Label on Card/Get a data from Label on Card', [('urlCard') : GlobalVariable.url_Card,('cardId') : cardIdVar,('labelId') : labelIdVar]))
WS.verifyResponseStatusCode(response5, 200, FailureHandling.CONTINUE_ON_FAILURE)

//  Delete a particular label
response6 = WS.sendRequest(findTestObject('Trello/Label on Card/Delete a Label on Card', [('urlCard') : GlobalVariable.url_Card,('labelId') : labelIdVar,('cardId') : cardIdVar, ('labelColor') : labelColorVar]))
WS.verifyResponseStatusCode(response6, 200, FailureHandling.CONTINUE_ON_FAILURE)
//WS.containsString(response6,deleteParticularLabelRespMsg, false, FailureHandling.CONTINUE_ON_FAILURE)

