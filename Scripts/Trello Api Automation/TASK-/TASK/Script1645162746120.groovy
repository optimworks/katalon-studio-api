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
cardNameVar = ['Api Setup','Login','Board Creation','List Creation','Card Creation','Logout']
listIdVar = []
cardIdVar = []

//  Create a List 1
response2 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[0], ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response2,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response2, 'id')
print('\n\t'+id+'\n\t')
getId(0,response2)

//  Create a List 2
response3 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[1], ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response3,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response3, 'id')
print('\n\t'+id+'\n\t')
getId(1,response3)

//  Create a List 3
response4 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[2], ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response4,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response4, 'id')
print('\n\t'+id+'\n\t')
getId(2,response4)

//  Create a List 4
response5 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[3], ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response5,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response5, 'id')
print('\n\t'+id+'\n\t')
getId(3,response5)

def getId(int index,resp) {
listIdVar[index] = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(resp, 'id')
return listIdVar
}
print('\n\t'+listIdVar+'\n\t')

def getcardId(int index,resp) {
	cardIdVar[index] = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(resp, 'id')
	return cardIdVar
	}
	print('\n\t'+cardIdVar+'\n\t')


//  Cards 1
response6 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[3], ('cardName') : cardNameVar[0]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response6,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response6, 'id')
print('\n\t'+id+'\n\t')
getcardId(0,response6)

//  Cards 2
response7 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[3], ('cardName') : cardNameVar[1]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response7,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response7, 'id')
print('\n\t'+id+'\n\t')
getcardId(1,response7)

//  Cards 3
response8 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[3], ('cardName') : cardNameVar[2]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response8,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response8, 'id')
print('\n\t'+id+'\n\t')
getcardId(2,response8)

//  Cards 4
response9 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[3], ('cardName') : cardNameVar[3]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response9,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response9, 'id')
print('\n\t'+id+'\n\t')
getcardId(3,response9)

//  Cards 5
response10 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[3], ('cardName') : cardNameVar[4]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response10,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response10, 'id')
print('\n\t'+id+'\n\t')
getcardId(4,response10)

//  Cards 6
response11 = WS.sendRequest(findTestObject('Trello/Create card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[3], ('cardName') : cardNameVar[5]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response11,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response11, 'id')
print('\n\t'+id+'\n\t')
getcardId(5,response11)


// Move Card first set of 2 cards to Respected list
//for(int j = 2; j>=0; j--)
for(int i =0;i<2;i++)
response12 = WS.sendRequest(findTestObject('Trello/Card/Move Cards to Respected List', [('urlList') : GlobalVariable.url_List,('idCard') : cardIdVar[i]
	, ('idList') : listIdVar[2]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response12,200)


// Move Card second set of  2 cards to Respected list
//for(int j = 2; j>=0; j--)
for(int i =2;i<4;i++)
response13 = WS.sendRequest(findTestObject('Trello/Card/Move Cards to Respected List', [('urlList') : GlobalVariable.url_List,('idCard') : cardIdVar[i]
	, ('idList') : listIdVar[1]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response13,200)

// Move Card 3rd set 2 of cards to Respected list
//for(int j = 2; j>=0; j--)
for(int i =4;i<6;i++)
response14 = WS.sendRequest(findTestObject('Trello/Card/Move Cards to Respected List', [('urlList') : GlobalVariable.url_List,('idCard') : cardIdVar[i]
	, ('idList') : listIdVar[0]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response14,200)

