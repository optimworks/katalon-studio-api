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

nameBoardVar = nameBoard + CustomKeywords.'trelloKeyword.ReusableMethods.getRandomSetofCharacter'(5)
nameofListVar = nameList + CustomKeywords.'trelloKeyword.ReusableMethods.getRandomSetofCharacter'(5)

//  board creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : nameBoardVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response1,200)
idBoardVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response1, 'id')
board_response = CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(response1)
BoardNameVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response1, 'name')

//Get Board
response2 = WS.sendRequest(findTestObject('Trello/Board/Get Board', [('urlBoard') : GlobalVariable.url_Board, ('idBoard') : idBoardVar, ('key') : GlobalVariable.key
	, ('token') : GlobalVariable.token]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response2,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(response2)

boardName = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response2, 'name')
idBoard = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response2, 'id')
 
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(BoardNameVar,nameBoardVar)
WS.containsString(response2,idBoard, false, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(GlobalVariable.key,'87a4904ed7d712ca1bc346ae43515')
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(GlobalVariable.token,'22145b645f529838e731eb82a289d8283e1a75aac36464b960dce222c6f80758')
CustomKeywords.'trelloKeyword.ReusableMethods.concatenationWithSting'('Katalon ',nameBoardVar)

//  Create a List
response3 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar, ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response3,200)
def listIdVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response3, 'id')

//  Delete board
response4 = WS.sendRequest(findTestObject('Trello/Board/Board Deletion', [('urlBoard') : GlobalVariable.url_Board, ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response4,200)


