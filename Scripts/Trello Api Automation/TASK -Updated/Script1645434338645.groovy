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

//board creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : nameBoardVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response1,200)
idBoardVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response1, 'id')
board_response = CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(response1)
BoardNameVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response1, 'name')
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(BoardNameVar,nameBoardVar)
print('\n\t'+idBoardVar+'\n\t')

//idBoardVar = '621329ee6b8c051850ed9495'
//listIdVar = ['621329f001642d7baeac2436', '621329f1db71ef032411d317', '621329f258549c7b9c443c99', '621329f30559f6159d2a96a5']
//cardIdVar = []
listIdVar = []
cardIdVar = []

//  List Creation
for(int i =0;i < 4;i++)
{
response2 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[i], ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response2,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response2, 'id')
listIdVar.add(i,id)
print('\n\t'+id+'\n\t')
}
print('\n\t'+listIdVar+'\n\t')


//  Cards Creation
for(int i =0;i < 6;i++)
{
response3 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[3], ('cardName') : cardNameVar[i]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response3,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response3, 'id')
cardIdVar.add(i,id)
print('\n\t'+id+'\n\t')
}
print('\n\t'+cardIdVar+'\n\t')


// Move Card first 2 cards to Respected list
k = 0
for(int j = 2; j>=0; j--)
{
  for(int i = k;i<k+2;i++)
  {
  response12 = WS.sendRequest(findTestObject('Move Cards to Respected List', [('urlList') : GlobalVariable.url_List,('idCard') : cardIdVar[i]
	  , ('idList') : listIdVar[j]]))
   CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response12,200)
   print('\n\t'+i+'\n\t')
  }
  k+=2
}


