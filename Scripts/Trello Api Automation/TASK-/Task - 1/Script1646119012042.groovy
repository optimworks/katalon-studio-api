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


cardIdVar = []
listIdVar = []

//Board reation
boardCreationResponse = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : nameBoardVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(boardCreationResponse,200)
idBoardVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(boardCreationResponse, 'id')
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(boardCreationResponse)
boardResponseText = boardCreationResponse.getResponseText()
print('\n\t'+boardResponseText.getClass()+'\n\t')

JsonSlurper js = new JsonSlurper()
parseResponse = js.parseText(boardResponseText)

boardCreationVerify = parseResponse.name
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(nameBoardVar,boardCreationVerify)


//  List Creation
for(int i =0;i < 4;i++)
{
createListResponse = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar[i], ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(createListResponse,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createListResponse, 'id')
listIdVar.add(i,id)

listResponseText = createListResponse.getResponseText()
JsonSlurper js1 = new JsonSlurper()
listparseResponse = js1.parseText(listResponseText)

print('\n\t'+listparseResponse.getClass()+'\n\t')
listNameVerify= listparseResponse.name
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(nameofListVar[i],listNameVerify)
}
print('\n\t'+listIdVar+'\n\t')


//  Cards Creation
k=0
for(int j = 3; j>=0; j--)
{
for(int i =k;i < k+1;i++)
{
cardCreationResponse = WS.sendRequest(findTestObject('Object Repository/Trello/Card/Create Card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[j], ('cardName') : cardNameVar[i]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(cardCreationResponse,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(cardCreationResponse, 'id')
cardIdVar.add(i,id)
print('\n\t'+cardIdVar+'\n\t')

cardResponseText = cardCreationResponse.getResponseText()
JsonSlurper js2 = new JsonSlurper()
cardparseResponse = js2.parseText(cardResponseText)

cardNameVerify= cardparseResponse.name
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(cardNameVar[i],cardNameVerify)
}
k++
}


//  Create a label in particular card
for(int i =0;i < 4;i++)
{
addLabelResponse = WS.sendRequest(findTestObject('Trello/Label on Card/Create a Label on Card',
	[('urlCard') : GlobalVariable.url_Card,('cardId') : cardIdVar[i],('labelColor') : labelColorVar[i]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addLabelResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addLabelResponse)

addLabel = addLabelResponse.getResponseText()
print('\n\t'+addLabel.getClass()+'\n\t')

JsonSlurper js3 = new JsonSlurper()
parseResponse = js3.parseText(addLabel)

addLabelVerify = parseResponse.color
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(labelColorVar[i],addLabelVerify)
}

//2nd set of Cards
//  Cards Creation
k=4
for(int j = 3; j>=0; j--)
{
for(int i =k;i < k+1;i++)
{
cardCreationResponse = WS.sendRequest(findTestObject('Object Repository/Trello/Card/Create Card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar[j], ('cardName') : cardNameVar[i]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(cardCreationResponse,200)
id = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(cardCreationResponse, 'id')
cardIdVar.add(i,id)
print('\n\t'+cardIdVar+'\n\t')

cardResponseText = cardCreationResponse.getResponseText()
JsonSlurper js4 = new JsonSlurper()
cardparseResponse = js4.parseText(cardResponseText)

cardNameVerify= cardparseResponse.name
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(cardNameVar[i],cardNameVerify)
}
k++
}

//  2nd set of labels
//  Create a label in particular card
k=4
for(int j = 0; j<4; j++)
{
for(int i =k;i < k+1;i++)
{
addLabelResponse = WS.sendRequest(findTestObject('Trello/Label on Card/Create a Label on Card',
	[('urlCard') : GlobalVariable.url_Card,('cardId') : cardIdVar[k],('labelColor') : labelColorVar[j]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addLabelResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addLabelResponse)
addLabelRespText = addLabelResponse.getResponseText()
print('\n\t'+addLabel.getClass()+'\n\t')

JsonSlurper js5 = new JsonSlurper()
parseResponse = js5.parseText(addLabelRespText)

addLabelVerify = parseResponse.color

CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(labelColorVar[j],addLabelVerify)
}
k++
}


// Watch a Card
for(i=0;i<8;i++)
{
watchResponse = WS.sendRequest(findTestObject('Trello/Card/Watch a card',
	[('idCard') : cardIdVar[i]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(watchResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(watchResponse)
watchCard = watchResponse.getResponseText()
}


// Add decription to a card
for(i=0;i<4;i++)
{
addDescription =  WS.sendRequest(findTestObject('Object Repository/Trello/Card/Add Description to a Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : cardIdVar[i]
	,('description') : addDesciptionToCard[i]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addDescription,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addDescription)
addDescriptionRespText = addDescription.getResponseText()

JsonSlurper js6 = new JsonSlurper()
parseResponse = js6.parseText(addDescriptionRespText)

descriptionCardVerify = parseResponse.desc
descriptionCardVerify1 = parseResponse.description
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(addDesciptionToCard[i],descriptionCardVerify)
}

// Add attachment
k=0
for(i=4;i<8;i++)
{
for(int j =k;j < k+1;j++)
{
addAttachmentResponse = WS.sendRequest(findTestObject('Trello/Attachment/Add an attachment to a Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : cardIdVar[i], ('urlAttachment') :  urlAttachmentVar[j]]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addAttachmentResponse,200)
addAttachmentRespText = addAttachmentResponse.getResponseText()

JsonSlurper js9 = new JsonSlurper()
parseResponse = js9.parseText(addAttachmentRespText)

addAttachmentVerify = parseResponse.url
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(urlAttachmentVar[j],addAttachmentVerify)
}
k++
}

// Add board background
addBoardBackgroundResponse = WS.sendRequest(findTestObject('Object Repository/Trello/Board/Board Background',[('idBoard') : idBoardVar,('url') : urlBackground]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addBoardBackgroundResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addBoardBackgroundResponse)
addBoardBackgroundRespText = addBoardBackgroundResponse.getResponseText()

JsonSlurper js8 = new JsonSlurper()
parseResponse = js8.parseText(addBoardBackgroundRespText)

addBoardBackgroundVerify = parseResponse.backgroundImage
//CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(urlBackground,addBoardBackgroundVerify)


