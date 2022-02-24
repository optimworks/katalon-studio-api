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


//Board creation
response1 = WS.sendRequest(findTestObject('Trello/Board/Board Creation',[('urlBoard') : GlobalVariable.url_Board,('boardName') : nameBoardVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(response1,200)
idBoardVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response1, 'id')
board_response = CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(response1)
BoardNameVerify = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(response1, 'name')
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(BoardNameVerify,BoardNameVerify)
print('\n\t'+idBoardVar+'\n\t')


//idBoardVar = '62177ae6f0954c1be1eaba23'
//idCardVar = '62177ae95041a9474577a404'
//listIdVar = '62177ae8d52cfe7004bf0d97' 
//idAttachmentVar = '62177aeb456720475cf76b60'


//  Create a List
createListResponse = WS.sendRequest(findTestObject('Trello/List/Create a new list',[('urlList') : GlobalVariable.url_List, ('nameofList') : nameofListVar, ('idBoard') : idBoardVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(createListResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(createListResponse)
def listIdVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createListResponse, 'id')
print('\n\t'+listIdVar+'\n\t')
print('\n\t'+createListResponse.getClass()+'\n\t')

listResponseText = createListResponse.getResponseText()
JsonSlurper js1 = new JsonSlurper()
listparseResponse = js1.parseText(listResponseText)

print('\n\t'+listparseResponse.getClass()+'\n\t')

listNameVerify= listparseResponse.name
listIdVerify= listparseResponse.id
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(nameofListVar,listNameVerify)
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(listIdVar,listIdVerify)


//  Card Creation
createCardResponse = WS.sendRequest(findTestObject('Object Repository/Trello/Card/Create Card',[('urlCard') : GlobalVariable.url_Card,('listId') : listIdVar, ('cardName') : cardNameVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(createCardResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(createCardResponse)

cardNameVerify = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createCardResponse, 'name')
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(cardNameVar,cardNameVerify)
print('\n\t'+cardNameVar.getClass()+'\n\t')
idCardVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(createCardResponse, 'id')
print('\n\t'+idCardVar+'\n\t')


// Add attachment
addAttachmentResponse = WS.sendRequest(findTestObject('Trello/Attachment/Add an attachment to a Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar, ('urlAttachment') :  urlAttachmentVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addAttachmentResponse,200)
// Extracting a particular value from a response
def idAttachmentVar = CustomKeywords.'trelloKeyword.ReusableMethods.getElementPropertyValue'(addAttachmentResponse, 'id')
print('\n\t'+idAttachmentVar+'\n\t')

// Get attachment
getAttachmentResponse = WS.sendRequest(findTestObject('Trello/Attachment/Get an attachment',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar, ('idAttachment') : idAttachmentVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(getAttachmentResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(getAttachmentResponse)
getAttachment = getAttachmentResponse.getResponseText()
print('\n\t'+getAttachment.getClass()+'\n\t')

JsonSlurper js = new JsonSlurper()
parseResponse = js.parseText(getAttachment)

print('\n\t'+parseResponse.getClass()+'\n\t')
getAttachedUrlVerify = parseResponse.url
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(urlAttachmentVar,getAttachedUrlVerify)

// Update the Created attachment
updateAttachmentResponse = WS.sendRequest(findTestObject('Object Repository/Trello/Attachment/Update the Created Attachments',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar, ('idAttachment') : idAttachmentVar, ('updateUrlAttachment') :  updateUrlAttachmentVar ]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(updateAttachmentResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(updateAttachmentResponse)
updateAttachment = updateAttachmentResponse.getResponseText()
print('\n\t'+updateAttachment.getClass()+'\n\t')

JsonSlurper js2 = new JsonSlurper()
parseResponse = js2.parseText(updateAttachment)

print('\n\t'+parseResponse.getClass()+'\n\t')
updateAttachedUrlVerify = parseResponse.name
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(updateUrlAttachmentVar,updateAttachedUrlVerify)

// Add a Comment to a Card
addCommentResponse = WS.sendRequest(findTestObject('Trello/Comment on Card/Add a comment to a Card',[('urlCard') : GlobalVariable.url_Card,('idCard') : idCardVar, ('comment') : commentVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addCommentResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addCommentResponse)
addComment = addCommentResponse.getResponseText()
print('\n\t'+addComment.getClass()+'\n\t')

JsonSlurper js3 = new JsonSlurper()
parseResponse = js3.parseText(addComment)

print('\n\t'+parseResponse.getClass()+'\n\t')
addCommentVerify = parseResponse.data.text
CustomKeywords.'trelloKeyword.ReusableMethods.verifyMatch'(commentVar,addCommentVerify)


//  Create a label in particular card
addLabelResponse = WS.sendRequest(findTestObject('Trello/Label on Card/Create a Label on Card', 
	[('urlCard') : GlobalVariable.url_Card,('cardId') : idCardVar,('labelColor') : labelColorVar]))
CustomKeywords.'trelloKeyword.ReusableMethods.verifyStatusCode'(addLabelResponse,200)
CustomKeywords.'trelloKeyword.ReusableMethods.printResponseText'(addLabelResponse)
addLabel = addLabelResponse.getResponseText()
print('\n\t'+addLabel.getClass()+'\n\t')

JsonSlurper js4 = new JsonSlurper()
parseResponse = js4.parseText(addLabel)

addLabelVerify = parseResponse.color
CustomKeywords.'trelloKeyword.ReusableMethods.verifyEqual'(labelColorVar,addLabelVerify)

//// Delete attachment
//response6 = WS.sendRequest(findTestObject('Trello/Attachment/Delete an Attachement',[('urlCard') : GlobalVariable.url_Card, ('idAttachment') : idAttachmentVar,('idCard') : idCardVar ]))
//WS.verifyResponseStatusCode(response6, 200, FailureHandling.CONTINUE_ON_FAILURE)

