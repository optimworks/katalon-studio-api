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
boardNameVar = "Update Pref1"

//  board creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : boardNameVar]))
WS.verifyResponseStatusCode(response1, 200, FailureHandling.CONTINUE_ON_FAILURE)
def idBoardVar = WS.getElementPropertyValue(response1, "id", FailureHandling.CONTINUE_ON_FAILURE)
board_response = response1.getResponseText()
println("\n\t"+board_response+"\n\t")
WS.containsString(response1,boardNameVar, false, FailureHandling.CONTINUE_ON_FAILURE)

// Update emailPosition Pref
response2 = WS.sendRequest(findTestObject('Trello/Update Pref/Update emailPosition Pref', [('idBoard') : idBoardVar]))
WS.verifyResponseStatusCode(response2, 200, FailureHandling.CONTINUE_ON_FAILURE)

// Update showSidebar Pref on a Board
response3 = WS.sendRequest(findTestObject('Object Repository/Trello/Update Pref/Update showSidebar Pref on a Board', [('idBoard') : idBoardVar]))
WS.verifyResponseStatusCode(response3, 200, FailureHandling.CONTINUE_ON_FAILURE)