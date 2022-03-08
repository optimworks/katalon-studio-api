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
cardIdVar = []

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
for(int z = 0; z < 4;z++)
{
createListResponse = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[z], ('idBoard') : idBoardVar ]))
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
print('\n\t'+z.getClass()+'\n\t')
listIdVar.add(z,listIdVerify)

CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(nameofListVar[z],listNameVerify)

}
print('\n\t'+listIdVar+'\n\t')

//Card Creation
k = 0 
for(int j =3;j >=0;j--)
	{
	for(int i =k;i < k+1;i++)
	{
		createCardResponse = WS.sendRequest(findTestObject('Object Repository/Trello/Card/Create Card',
			[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[j], ('cardName') : cardNameVar[i]]))
		CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(createCardResponse,200)
		cardId = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createCardResponse, 'id')
        cardIdVar.add(i,cardId)
		print('\n\t'+cardIdVar+'\n\t')
		print('\n\t'+i+'\n\t')
		print('\n\t'+j+'\n\t')
	
	   cardResponseText = createCardResponse.getResponseText()
	   JsonSlurper js5 = new JsonSlurper()
	   cardparseResponse = js5.parseText(cardResponseText)
	
	   cardNameVerify= cardparseResponse.name
	   CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(cardNameVar[i],cardNameVerify)
	}
	k++
	}
	
//Add a sticker to Card
addStickerResponse = WS.sendRequest(findTestObject('Trello/Sticker/Add a Sticker on Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : cardIdVar[0] , ('imageName') : imageNameVar
							   , ('top') : topVar , ('left') : leftVar , ('zIndex') : zIndexVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addStickerResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addStickerResponse)
stickerResponseText = addStickerResponse.getResponseText()

JsonSlurper js9 = new JsonSlurper()
stickerparseResponse = js9.parseText(stickerResponseText)
	
stickerVerify= stickerparseResponse.image
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(imageNameVar,stickerVerify)

//Add due date to a card
addDueDateResponse = WS.sendRequest(findTestObject('Trello/Card/Add due date to a card',[('urlCard') : GlobalVariable.url_Card,('idCard') : cardIdVar[2] , ('dueDate') : dueDate]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addDueDateResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addDueDateResponse)

// Create a checklist
createChecklist = WS.sendRequest(findTestObject('Trello/Checklist on Card/Create Checklist on card', [('urlCard') : GlobalVariable.url_Card, ('idCard') : cardIdVar[2], ('checklistName') : checklistNameVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(createChecklist,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(createChecklist)
checklistResponseText = createChecklist.getResponseText()

JsonSlurper js6 = new JsonSlurper()
checklistparseResponse = js6.parseText(checklistResponseText)
	
checklistVerify= checklistparseResponse.name
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(checklistNameVar,checklistVerify)


//  Create a label in particular card
addLabelResponse = WS.sendRequest(findTestObject('Trello/Label on Card/Create a Label on Card',
	[('urlCard') : GlobalVariable.url_Card,('cardId') : cardIdVar[3],('labelColor') : labelColorVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addLabelResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addLabelResponse)
addLabel = addLabelResponse.getResponseText()
print('\n\t'+addLabel.getClass()+'\n\t')

JsonSlurper js4 = new JsonSlurper()
parseResponse = js4.parseText(addLabel)

addLabelVerify = parseResponse.color
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(labelColorVar,addLabelVerify)


// Watch a Card
watchResponse = WS.sendRequest(findTestObject('Trello/Card/Watch a card',
	[('idCard') : cardIdVar[1]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(watchResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(watchResponse)
watchCard = watchResponse.getResponseText()

JsonSlurper js5 = new JsonSlurper()
parseResponse = js5.parseText(watchCard)

watchCardVerify = parseResponse.id
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(cardIdVar[1],watchCardVerify)


// Add decription to a card
addDescription =  WS.sendRequest(findTestObject('Object Repository/Trello/Card/Add Description to a Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : cardIdVar[1]
	,('description') : addDesciptionToCard]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addDescription,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addDescription)
addDescriptionRespText = addDescription.getResponseText()

JsonSlurper js7 = new JsonSlurper()
parseResponse = js7.parseText(addDescriptionRespText)

descriptionCardVerify = parseResponse.desc
descriptionCardVerify1 = parseResponse.description
print('\n\t'+descriptionCardVerify1.getClass()+'\n\t')
print('\n\t'+descriptionCardVerify1+'\n\t')
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(addDesciptionToCard,descriptionCardVerify)

//Delete a particular card
deleteCard = WS.sendRequest(findTestObject('Object Repository/Trello/Card/Delete Card',[('urlCard') : GlobalVariable.url_Card,('idBoard') : idBoardVar, ('idCard') : cardIdVar[3]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(deleteCard,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(deleteCard)
deleteCardRespText = deleteCard.getResponseText()
	
JsonSlurper js10 = new JsonSlurper()
parseResponse = js10.parseText(deleteCardRespText)

deleteCardVerify = parseResponse.limits
print('\n\t'+deleteCardVerify+'\n\t')
print('\n\t'+deleteCardVerify.getClass()+'\n\t')
