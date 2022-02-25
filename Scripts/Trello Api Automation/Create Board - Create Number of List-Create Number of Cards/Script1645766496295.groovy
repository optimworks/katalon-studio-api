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

listIdVar = []

//Board creation
createBoardResponse = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : nameBoardVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(createBoardResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(createBoardResponse)

idBoardVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createBoardResponse, 'id')
board_response = CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(createBoardResponse)
BoardNameVerify = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createBoardResponse, 'name')
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(BoardNameVerify,BoardNameVerify)
print('\n\t'+idBoardVar+'\n\t')

//  Create a List
for(int i = 0; i < 4;i++)
{
createListResponse = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[i], ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(createListResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(createListResponse)
def list = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createListResponse, 'id')

listResponseText = createListResponse.getResponseText()
JsonSlurper js1 = new JsonSlurper()
listparseResponse = js1.parseText(listResponseText)

print('\n\t'+listparseResponse.getClass()+'\n\t')

listNameVerify= listparseResponse.name
listIdVerify= listparseResponse.id

print('\n\t'+listIdVerify.getClass()+'\n\t')
print('\n\t'+i.getClass()+'\n\t')
listIdVar.add(i,listIdVerify)

//print('\n\t'+listIdVerify+'\n\t')

//CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(nameofListVar,listNameVerify)
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(listIdVar,listIdVerify)
}
print('\n\t'+listIdVar+'\n\t')

//Card Creation

for(int i =0;i < 5;i++)
	{
	for(int j =3;j > 0;j--)
	createCardResponse = WS.sendRequest(findTestObject('Object Repository/Trello/Card/Create Card',
		[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[j], ('cardName') : cardNameVar[i]]))
	CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(createCardResponse,200)
	//cardName = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createCardResponse, 'name')
	//CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(cardName,cardNameVar[i])
	cardIdVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createCardResponse, 'id')
	cardIdVar.add(i,id)
	print('\n\t'+id+'\n\t')
	
	cardResponseText = createCardResponse.getResponseText()
	JsonSlurper js5 = new JsonSlurper()
	cardparseResponse = js5.parseText(cardResponseText)
	
	cardNameVerify= cardparseResponse.name
	CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(cardNameVar,cardNameVerify)
	}