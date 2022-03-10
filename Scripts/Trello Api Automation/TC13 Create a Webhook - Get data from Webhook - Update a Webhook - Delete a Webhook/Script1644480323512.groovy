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
def boardNameVar = "Trello Board Creation "
def nameofListVar = 'My List'
def cardNameVar = 'My card'
def descriptionVar = 'Introduction to Webhook'

//  board creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)
board_response = response1.getResponseText()
println("\n\t"+board_response+"\n\t")
WS.containsString(response1,boardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//Create a Webhook
response4 = WS.sendRequest(findTestObject('Trello/Webhook/Create a webhook',[('idBoard') : idBoardVar]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idWebhookVar = WS.getElementPropertyValue(response4, "id", FailureHandling.CONTINUE_ON_FAILURE)

//  Create a List
response2 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar, ('idBoard') : idBoardVar ]))
WS.verifyResponseStatusCode(response2, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response2,nameofListVar, false, FailureHandling.CONTINUE_ON_FAILURE)
def listIdVar = WS.getElementPropertyValue(response2, "id", FailureHandling.CONTINUE_ON_FAILURE)

//  Card Creation
response3 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar, ('cardName') : cardNameVar]))
WS.verifyResponseStatusCode(response3, 200, FailureHandling.CONTINUE_ON_FAILURE)
idCardVar = WS.getElementPropertyValue(response3,"id", FailureHandling.CONTINUE_ON_FAILURE)
card_response = response3.getResponseText()
println("\n\t"+card_response+"\n\t")
WS.containsString(response3,cardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

// Get data from Webhook
response5 = WS.sendRequest(findTestObject('Object Repository/Trello/Webhook/Get data from Webhook',[('idWebhook') : idWebhookVar]))
WS.verifyResponseStatusCode(response5, 200, FailureHandling.CONTINUE_ON_FAILURE)


// Update a Webhook
response6 = WS.sendRequest(findTestObject('Object Repository/Trello/Webhook/Update a Webhook',[('idWebhook') : idWebhookVar, ('description') : descriptionVar]))
WS.verifyResponseStatusCode(response6, 200, FailureHandling.CONTINUE_ON_FAILURE)

// Delete a webhook
response7 = WS.sendRequest(findTestObject('Object Repository/Trello/Webhook/Delete a Webhook',[('idWebhook') : idWebhookVar]))
WS.verifyResponseStatusCode(response7, 200, FailureHandling.CONTINUE_ON_FAILURE)

