
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String



def static "sample.Common.createNewUser"(
    	int age	
     , 	String username	
     , 	String password	
     , 	String gender	
     , 	int expectedStatus	) {
    (new sample.Common()).createNewUser(
        	age
         , 	username
         , 	password
         , 	gender
         , 	expectedStatus)
}


def static "sample.Common.findUserById"(
    	int id	
     , 	int age	
     , 	String username	
     , 	String password	
     , 	String gender	
     , 	int expectedStatus	) {
    (new sample.Common()).findUserById(
        	id
         , 	age
         , 	username
         , 	password
         , 	gender
         , 	expectedStatus)
}


def static "trelloKeyword.ReusableMethods.concatenationWithSting"(
    	Object text	
     , 	Object value	) {
    (new trelloKeyword.ReusableMethods()).concatenationWithSting(
        	text
         , 	value)
}


def static "trelloKeyword.ReusableMethods.getElementPropertyValue"(
    	Object resp	
     , 	Object value	) {
    (new trelloKeyword.ReusableMethods()).getElementPropertyValue(
        	resp
         , 	value)
}


def static "trelloKeyword.ReusableMethods.printResponseText"(
    	Object resp	) {
    (new trelloKeyword.ReusableMethods()).printResponseText(
        	resp)
}


def static "trelloKeyword.ReusableMethods.verifyStatusCode"(
    	Object resp	
     , 	Object statusCode	) {
    (new trelloKeyword.ReusableMethods()).verifyStatusCode(
        	resp
         , 	statusCode)
}


def static "trelloKeyword.ReusableMethods.verifyMatch"(
    	Object resp	
     , 	Object text	) {
    (new trelloKeyword.ReusableMethods()).verifyMatch(
        	resp
         , 	text)
}


def static "trelloKeyword.ReusableMethods.verifyNotMatch"(
    	Object resp	
     , 	Object text	) {
    (new trelloKeyword.ReusableMethods()).verifyNotMatch(
        	resp
         , 	text)
}


def static "trelloKeyword.ReusableMethods.getRandomSetofCharacter"(
    	int length	) {
    (new trelloKeyword.ReusableMethods()).getRandomSetofCharacter(
        	length)
}


def static "trelloKeyword.ReusableMethods.listCreation"(
    	Object idBoardVar	) {
    (new trelloKeyword.ReusableMethods()).listCreation(
        	idBoardVar)
}
