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
import groovy.json.JsonSlurper


////board creation
//response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : nameBoardVar]))
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response1,200)
//idBoardVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response1, 'id')
//board_response = CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(response1)
//BoardNameVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response1, 'name')
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(BoardNameVar,nameBoardVar)
//print('\n\t'+idBoardVar+'\n\t')

listIdVar = ['6214752774eb6c5c59335115', '621475280b2d784e301c18c6','62147529f1c38a5f60ad0fea', '6214752a76bc65067e0f551d']
cardIdVar = []

////  List Creation
//for(int i =0;i < 4;i++)
//{
//response2 = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[i], ('idBoard') : idBoardVar ]))
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response2,200)
//listName = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response2, 'name')
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(listName,nameofListVar[i])
//id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response2, 'id')
//listIdVar.add(i,id)
//print('\n\t'+id+'\n\t')
//}
//print('\n\t'+listIdVar+'\n\t')
//
//
////  Cards Creation
//for(int i =0;i < 6;i++)
//{
//response3 = WS.sendRequest(findTestObject('Object Repository/Trello/Card/Create Card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[3], ('cardName') : cardNameVar[i]]))
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response3,200)
//cardName = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response3, 'name')
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(cardName,cardNameVar[i])
//id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response3, 'id')
//cardIdVar.add(i,id)
//print('\n\t'+id+'\n\t')
//}
//print('\n\t'+cardIdVar+'\n\t')
//
//
//// Move Cards into different set of lists
//k = 0
//for(int j = 2; j>=0; j--)
//{
//  for(int i = k;i<k+2;i++)
//  {
//  response4 = WS.sendRequest(findTestObject('Move Cards to Respected List', [('urlList') : GlobalVariable.url_List,('idCard') : cardIdVar[i]
//	  , ('idList') : listIdVar[j]]))
//   CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response4,200)
//   movedName = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response3, 'name')
//   //CustomKeywords.'trelloKeyword.ReusableMethods.verifyNotMatch'(movedName,nameofListVar[3])
//  }
//  k+=2
//}

//  Apply assertion  wheather cards are moved into  respected list
listOfCards = WS.sendRequest(findTestObject('Trello/Card/Get Cards in a particular List',[('urlList') : GlobalVariable.url_List, ('idList') : listIdVar[0]]))
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(listOfCards)
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(listOfCards,200)
res=listOfCards.getResponseText()
print('\n Response DATA - '+listOfCards)
print('\n Response DATA - '+listOfCards.getResponseText())
print('\n Response DATA TYPE - '+res.getClass())
JsonSlurper js = new JsonSlurper()
parseResponse = js.parseText(res)

print('\n Response DATA TYPE - '+parseResponse.getClass())
r=parseResponse.get(0)
r2=parseResponse.get(1)

print("First Card- "+parseResponse[0].name.getClass())
print("First Card- "+parseResponse[0].name)

k = 0
for(int j = 2; j>=0; j--)
{
  for(int i = k;i<k+2;i++)
  {
listOfCards = WS.sendRequest(findTestObject('Trello/Card/Get Cards in a particular List',[('urlList') : GlobalVariable.url_List, ('idList') : listIdVar[j]]))
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(listOfCards)
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(listOfCards,200)
res=listOfCards.getResponseText()
print('\n Response DATA - '+listOfCards)
print('\n Response DATA - '+listOfCards.getResponseText())
print('\n Response DATA TYPE - '+res.getClass())
for(int p=0;p<2;p++)
{
getName = parseResponse[p].name
if(getName == cardNameVar[k])
{
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(getName,cardNameVar[k])
}
else
{
	continue
}
}

  }
  k+=2
}





