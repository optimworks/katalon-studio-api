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

//  login
//response = WS.sendRequest(findTestObject('Trello/login', [('url') : GlobalVariable.trello_url, ('email') : emailVar, ('password') : passwordVar]))
//WS.verifyResponseStatusCode(response, 200, FailureHandling.CONTINUE_ON_FAILURE)// is there any way to print the costum error message
//login_response = response.getResponseText()
//println(login_response)

//  board creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)
board_response = response1.getResponseText()
println("\n\t"+board_response+"\n\t")
WS.containsString(response1,boardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

//Get Board
response2 = WS.sendRequest(findTestObject('Trello/Board/Get Board', [('urlBoard') : GlobalVariable.url_Board, ('idBoard') : idBoardVar, ('key') : GlobalVariable.key
	, ('token') : GlobalVariable.token]))
WS.getResponseStatusCode(response2, FailureHandling.CONTINUE_ON_FAILURE)
board_response = response2.getResponseText()
println("\n\t"+board_response+"\n\t")
boardName = WS.getElementPropertyValue(response2, 'name', FailureHandling.CONTINUE_ON_FAILURE)
idBoard = WS.getElementPropertyValue(response2, 'id', FailureHandling.CONTINUE_ON_FAILURE)
WS.verifyMatch(boardName, 'API_Automation', false)
//WS.verifyEqual(idBoard, '620c9e6dba1fb343abf87921', FailureHandling.CONTINUE_ON_FAILURE)
WS.containsString(response2,idBoard, false, FailureHandling.CONTINUE_ON_FAILURE)
WS.verifyMatch(GlobalVariable.key, '87a4904ed7d712ca1bc346ae43515', false, FailureHandling.CONTINUE_ON_FAILURE)


////  logout
//response4 = WS.sendRequest(findTestObject('Trello/logout'))
//WS.verifyResponseStatusCode(response4, 200, FailureHandling.CONTINUE_ON_FAILURE)
//logout_response = response4.getResponseText()
//println(logout_response)
//






