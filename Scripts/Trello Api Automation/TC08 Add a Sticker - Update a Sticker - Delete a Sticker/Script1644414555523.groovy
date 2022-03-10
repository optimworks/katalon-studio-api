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
def boardNameVar = 'Add Sticker to a Card'
def nameofListVar = 'List of Sticker'
def cardNameVar = 'taco sticker' 
//Add a sticker to card
def imageNameVar = 'taco-confused'
def topVar = 10
def leftVar = 20
def zIndexVar =3
//Update sticker  on a card 
//def imageNameUpdateVar = 'taco-love'
def topUpdateVar = 70
def leftUpdateVar = 40
def zIndexUpdateVar =3

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

//Add a sticker to Card
response4 = WS.sendRequest(findTestObject('Trello/Sticker/Add a Sticker on Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar , ('imageName') : imageNameVar
	                       , ('top') : topVar , ('left') : leftVar , ('zIndex') : zIndexVar]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idStickerVar = WS.getElementPropertyValue(response4, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response4, imageNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//Update a sticker to Card
response5 = WS.sendRequest(findTestObject('Trello/Sticker/Update a Sticker on Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar , ('idSticker') : idStickerVar
	                       , ('topUpdate') : topUpdateVar , ('leftUpdate') : leftUpdateVar , ('zIndexUpdate') : zIndexUpdateVar]))
WS.verifyResponseStatusCode(response5, 200, FailureHandling.CONTINUE_ON_FAILURE)

//Delete a sticker
response6 = WS.sendRequest(findTestObject('Trello/Sticker/Delete a Sticker on Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar , ('idSticker') : idStickerVar]))
WS.verifyResponseStatusCode(response6, 200, FailureHandling.CONTINUE_ON_FAILURE)

