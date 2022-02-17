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


//  Board Creation
response = WS.sendRequest(findTestObject('Trello/Board/Board Creation', [('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar ]))
WS.verifyResponseStatusCode(response, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response, "id", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response,boardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//  Create a List
response1 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar, ('idBoard') : idBoardVar]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response1,nameofListVar, false, FailureHandling.CONTINUE_ON_FAILURE)
def listIdVar = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)

//  Get the data from list
response2 = WS.sendRequest(findTestObject('Trello/List/Get data from list',[('urlList') : GlobalVariable.url_List, ('ListId') : listIdVar ]))
WS.verifyResponseStatusCode(response2, 200, FailureHandling.CONTINUE_ON_FAILURE)
getData = response2.getResponseText()
print('\n\t'+getData+'\n\t' )
def getListDataRespMsg = WS.getElementPropertyValue(response2, "name", FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response2,getListDataRespMsg , false, FailureHandling.CONTINUE_ON_FAILURE)

 //Update the List
response3 = WS.sendRequest(findTestObject('Trello/List/Update List',[('updateName') : updateNameVar, ('urlList') : GlobalVariable.url_List, ('ListId') : listIdVar ]))
WS.verifyResponseStatusCode(response3, 200, FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response3,updateNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

// Archive the List
response4 = WS.sendRequest(findTestObject('Trello/List/Archive a list',[('urlList') : GlobalVariable.url_List, ('ListId') : listIdVar ]))
WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)


