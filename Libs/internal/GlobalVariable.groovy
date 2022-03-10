package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object stg_url
     
    /**
     * <p></p>
     */
    public static Object stgSonnenspieleAuthToken
     
    /**
     * <p></p>
     */
    public static Object email_sonnenspiele
     
    /**
     * <p></p>
     */
    public static Object password_sonnenspiele
     
    /**
     * <p></p>
     */
    public static Object email_fail
     
    /**
     * <p></p>
     */
    public static Object password_fail
     
    /**
     * <p></p>
     */
    public static Object trello_url
     
    /**
     * <p></p>
     */
    public static Object url_Card
     
    /**
     * <p></p>
     */
    public static Object url_List
     
    /**
     * <p></p>
     */
    public static Object url_Board
     
    /**
     * <p></p>
     */
    public static Object key
     
    /**
     * <p></p>
     */
    public static Object token
     
    /**
     * <p></p>
     */
    public static Object nameofListVar
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            stg_url = selectedVariables['stg_url']
            stgSonnenspieleAuthToken = selectedVariables['stgSonnenspieleAuthToken']
            email_sonnenspiele = selectedVariables['email_sonnenspiele']
            password_sonnenspiele = selectedVariables['password_sonnenspiele']
            email_fail = selectedVariables['email_fail']
            password_fail = selectedVariables['password_fail']
            trello_url = selectedVariables['trello_url']
            url_Card = selectedVariables['url_Card']
            url_List = selectedVariables['url_List']
            url_Board = selectedVariables['url_Board']
            key = selectedVariables['key']
            token = selectedVariables['token']
            nameofListVar = selectedVariables['nameofListVar']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
