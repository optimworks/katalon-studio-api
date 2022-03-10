<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description></description>
   <name>div_Welcome Sahil                          _8f9368</name>
   <tag></tag>
   <elementGuidId>987dd022-4aed-434b-9080-fc1920cce59c</elementGuidId>
   <selectorCollection>
      <entry>
         <key>CSS</key>
         <value>#branding</value>
      </entry>
      <entry>
         <key>XPATH</key>
         <value>//div[@id='branding']</value>
      </entry>
   </selectorCollection>
   <selectorMethod>XPATH</selectorMethod>
   <useRalativeImagePath>true</useRalativeImagePath>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>tag</name>
      <type>Main</type>
      <value>div</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>id</name>
      <type>Main</type>
      <value>branding</value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>text</name>
      <type>Main</type>
      <value>
                
                Welcome Sahil
                


    
        
        
    




    

        
        
            
                
                                    
                No new notifications
                
                                    
            
        
    

    
        
            
                
                                    
            

        

        
            


        

        
            

        
    




    
        
            

        
            
        

    



    
        
            Success!        
        
            Successfully Saved        
        
            Successfully Shared        
        
            Successfully Deleted        

    




    
        
            
        
    





    
        People who shared this post    
    
        
            
        

    





    
        People who like this post    
    
        
            
        

    




    var getAccessUrl = '/index.php/buzz/getLogedToBuzz';
    var loginpageURL = '/index.php/auth/login';

    // buzzCommon.js
    var viewLikedEmployees = '/index.php/buzz/viewLikedEmployees';
    var addBuzzCommentURL = '/index.php/buzz/addNewComment';
    var shareShareURL = '/index.php/buzz/shareAPost';
    var getLikedEmployeeListURL = '/index.php/buzz/getLikedEmployeeList';

    // buzzNew.js
    var shareLikeURL = '/index.php/buzz/likeOnShare';
    var commentLikeURL = '/index.php/buzz/likeOnComment';
    var getSharedEmployeeListURL = '/index.php/buzz/getSharedEmployeeList';

    // viewNotificationComponent.js
    var viewMoreShare = '/index.php/buzz/viewShare';
    var buzzURL = &quot;/index.php/buzz/viewBuzz&quot;;
    var ClearNotificationURL = &quot;/index.php/buzz/clearNotificationAjax&quot;;
    var ClickOnNotificationIconURL = &quot;/index.php/buzz/clickOnNotificationIconAjax&quot;;
    var lang_NoNewNotifications = 'No new notifications';
    var lang_NotificationClearFailed = 'Failed to clear notifications';

                

    
        
    

                                    
                        
                    
                                
                    var marketplaceURL = &quot;/index.php/marketPlace/ohrmAddons&quot;;
                    var SubscriberURL = &quot;/index.php/pim/subscriber&quot;;
                
                
                    
                        
    About

    
        
            ×
            About
        
        
            
                
                    
                        
                            Company Name: OrangeHRM
                        
                        
                            Version: Orangehrm OS 4.9
                        
                        
                            Active Employees: 64
                        
                        
                            Employees Terminated: 0
                        
                    
                
                
                        
    



    jQuery(document).ready(function() {
        
               
        jQuery('#aboutDisplayLink').click(function(event) {
            event.stopImmediatePropagation();
            jQuery('#messageToDisplayAbout').css(
                    'display', 'none');
            jQuery('#displayAbout').modal();
            jQuery('#help-menu.panelContainer').attr('style', 'display:block');
            
            var test = jQuery('.panelContainer');
            jQuery('#help-menu.panelContainer').css(
                    'display', 'block');
             
        });

        jQuery('#heartbeatSubmitBtn').click(function(event) {
            event.stopImmediatePropagation();
            jQuery(this).closest('form').ajaxSubmit(function() {
                jQuery('#messageToDisplayAbout').html('Saved');

                if (jQuery('#register_registration').is(':checked')) {
                    jQuery('#registration-section').css(
                            'display', 'none');
                }
                jQuery('#displayAbout').modal('hide');
                jQuery('#messageToDisplayAbout').css(
                        'display', 'block');
                jQuery('#welcome-menu').css('display','none');
            });
        });

        jQuery('#displayAbout').click(function(event) {
            event.stopImmediatePropagation();
        });
        
        jQuery('#heartbeatCancelBtn').click(function(event) {
            event.stopImmediatePropagation();
             jQuery('#welcome-menu').css('display','none');
                 jQuery('#displayAbout').modal('hide');
        });

    })



                        Support
                        Logout
                    
                
                                


    svg path,
    svg rect{
        fill: #FF6700;
    }
    .svgcl{
        position: relative;
        left: -35px;
        top: -31px;
    }
    


    var inputDatePattern = 'Y-m-d' ;
    var separatorString = 'to';
    $( document ).ready(function() {

        $(&quot;#loader-1&quot;).hide();
        empId = location.href[location.href.length-1];
        dates = $('#startDates').find(&quot;:selected&quot;).text().split(&quot; &quot;+separatorString+&quot; &quot;);
        startDate_timesheet = dates[0]+&quot; 00:00:00&quot;;
        endDate_timesheet   = dates[1]+&quot; 00:00:00&quot;;

        clientId  =     &quot;&quot;;
        clientSecret  = &quot;&quot;;
        clientUrl     = &quot;&quot;;
        successUrl  = &quot;&quot;;
        ajaxURL = &quot;/index.php/buzz/viewBuzz&quot;;
        var timeSheetStatus = $('#timesheet_status').find('h2').text();
        if(timeSheetStatus == 'Status: Approved'){

            $('.syncToggl').hide();
        } else {
            $('.syncToggl').show();
        }

    });

        
    function ajaxSyc() {
        $(&quot;#loader-1&quot;).show();

        $.ajax({
                type: &quot;POST&quot;,
                url: ajaxURL,
                data: {
                    'employee_Id':employeeId,
                    'startTime': startDate_timesheet,
                    'endTime': endDate_timesheet,
                    'timeFormat': inputDatePattern,
                    'timeZone': 'GMT'+formatTimeZone()
                },
                contentType: &quot;application/x-www-form-urlencoded&quot;,

                success: function (msg, status, jqXHR) {

                    $(&quot;#loader-1&quot;).hide();
                    msg = JSON.parse(msg);
                    msgCode = msg.statusCode;
                    if (msgCode != null) {
                        if (msgCode == 101) {
                            displayMessages('error',msg.description );
                        } else if (msgCode == 102) {

                            displayMessages('success', msg.description);
                            setTimeout(function () {
                                location.reload();
                            }, 2000);

                        }
                    } else {
                        showErrorMsg();
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(&quot;#loader-1&quot;).hide();
                    console.log(errorThrown);
                    showErrorMsg();
                }
            });
    }
    
    function startSyc() {
        $(&quot;#loader-1&quot;).show();

    $.ajax({

        type: &quot;POST&quot;,
        url: clientUrl,


        data: {
            'grant_type': 'client_credentials',
            'client_id': clientId,
            'client_secret': clientSecret
        },
        contentType: &quot;application/x-www-form-urlencoded&quot;,


        success: function (msg, status, jqXHR) {

            try {

                msg = $.parseJSON(jqXHR.responseText);

            } catch (err) {
                console.log(err);
                showErrorMsg();
            }

            $.ajax({
                type: &quot;POST&quot;,
                url: successUrl,
                beforeSend: function (xhr) {

                    xhr.setRequestHeader(&quot;Authorization&quot;, &quot;Bearer &quot; + msg.access_token);
                },

                data: {

                    'employee_Id':employeeId,
                    'startTime': startDate_timesheet,
                    'endTime': endDate_timesheet,
                    'timeFormat': inputDatePattern,
                    'timeZone': 'GMT'+formatTimeZone()
                },
                contentType: &quot;application/x-www-form-urlencoded&quot;,

                success: function (msg, status, jqXHR) {

                    $(&quot;#loader-1&quot;).hide();
                    msgCode = msg.statusCode;
                    if (msgCode != null) {
                        if (msgCode == 101) {
                            displayMessages('error',msg.description );
                        } else if (msgCode == 102) {

                            displayMessages('success', msg.description);
                            setTimeout(function () {
                                location.reload();
                            }, 2000);

                        }
                    } else {
                        showErrorMsg();
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(&quot;#loader-1&quot;).hide();
                    console.log(errorThrown);
                    showErrorMsg();
                }
            });

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $(&quot;#loader-1&quot;).hide();
            console.log(errorThrown);
            showErrorMsg();
        }


    });

    }

    function showErrorMsg(){
        displayMessages('error','Unable To Sync With Toggl' );
        setTimeout(function () {
            $('#msgDiv').remove();
        }, 3000);

    }




    
    
        
            
  
      
  
  
        
    

    
        
            ×
            Confirm Toggl Sync
        
        
            Any existing timesheet entry will be overwritten if record for same date is matched. Click ok to continue.
        
        
                            
                        
        
    






            </value>
   </webElementProperties>
   <webElementProperties>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath</name>
      <type>Main</type>
      <value>id(&quot;branding&quot;)</value>
   </webElementProperties>
   <webElementXpaths>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:attributes</name>
      <type>Main</type>
      <value>//div[@id='branding']</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:idRelative</name>
      <type>Main</type>
      <value>//div[@id='wrapper']/div</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:position</name>
      <type>Main</type>
      <value>//div/div</value>
   </webElementXpaths>
   <webElementXpaths>
      <isSelected>false</isSelected>
      <matchCondition>equals</matchCondition>
      <name>xpath:customAttributes</name>
      <type>Main</type>
      <value>//div[@id = 'branding' and (text() = concat(&quot;
                
                Welcome Sahil
                


    
        
        
    




    

        
        
            
                
                                    
                No new notifications
                
                                    
            
        
    

    
        
            
                
                                    
            

        

        
            


        

        
            

        
    




    
        
            

        
            
        

    



    
        
            Success!        
        
            Successfully Saved        
        
            Successfully Shared        
        
            Successfully Deleted        

    




    
        
            
        
    





    
        People who shared this post    
    
        
            
        

    





    
        People who like this post    
    
        
            
        

    




    var getAccessUrl = &quot; , &quot;'&quot; , &quot;/index.php/buzz/getLogedToBuzz&quot; , &quot;'&quot; , &quot;;
    var loginpageURL = &quot; , &quot;'&quot; , &quot;/index.php/auth/login&quot; , &quot;'&quot; , &quot;;

    // buzzCommon.js
    var viewLikedEmployees = &quot; , &quot;'&quot; , &quot;/index.php/buzz/viewLikedEmployees&quot; , &quot;'&quot; , &quot;;
    var addBuzzCommentURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/addNewComment&quot; , &quot;'&quot; , &quot;;
    var shareShareURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/shareAPost&quot; , &quot;'&quot; , &quot;;
    var getLikedEmployeeListURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/getLikedEmployeeList&quot; , &quot;'&quot; , &quot;;

    // buzzNew.js
    var shareLikeURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/likeOnShare&quot; , &quot;'&quot; , &quot;;
    var commentLikeURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/likeOnComment&quot; , &quot;'&quot; , &quot;;
    var getSharedEmployeeListURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/getSharedEmployeeList&quot; , &quot;'&quot; , &quot;;

    // viewNotificationComponent.js
    var viewMoreShare = &quot; , &quot;'&quot; , &quot;/index.php/buzz/viewShare&quot; , &quot;'&quot; , &quot;;
    var buzzURL = &quot;/index.php/buzz/viewBuzz&quot;;
    var ClearNotificationURL = &quot;/index.php/buzz/clearNotificationAjax&quot;;
    var ClickOnNotificationIconURL = &quot;/index.php/buzz/clickOnNotificationIconAjax&quot;;
    var lang_NoNewNotifications = &quot; , &quot;'&quot; , &quot;No new notifications&quot; , &quot;'&quot; , &quot;;
    var lang_NotificationClearFailed = &quot; , &quot;'&quot; , &quot;Failed to clear notifications&quot; , &quot;'&quot; , &quot;;

                

    
        
    

                                    
                        
                    
                                
                    var marketplaceURL = &quot;/index.php/marketPlace/ohrmAddons&quot;;
                    var SubscriberURL = &quot;/index.php/pim/subscriber&quot;;
                
                
                    
                        
    About

    
        
            ×
            About
        
        
            
                
                    
                        
                            Company Name: OrangeHRM
                        
                        
                            Version: Orangehrm OS 4.9
                        
                        
                            Active Employees: 64
                        
                        
                            Employees Terminated: 0
                        
                    
                
                
                        
    



    jQuery(document).ready(function() {
        
               
        jQuery(&quot; , &quot;'&quot; , &quot;#aboutDisplayLink&quot; , &quot;'&quot; , &quot;).click(function(event) {
            event.stopImmediatePropagation();
            jQuery(&quot; , &quot;'&quot; , &quot;#messageToDisplayAbout&quot; , &quot;'&quot; , &quot;).css(
                    &quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;none&quot; , &quot;'&quot; , &quot;);
            jQuery(&quot; , &quot;'&quot; , &quot;#displayAbout&quot; , &quot;'&quot; , &quot;).modal();
            jQuery(&quot; , &quot;'&quot; , &quot;#help-menu.panelContainer&quot; , &quot;'&quot; , &quot;).attr(&quot; , &quot;'&quot; , &quot;style&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;display:block&quot; , &quot;'&quot; , &quot;);
            
            var test = jQuery(&quot; , &quot;'&quot; , &quot;.panelContainer&quot; , &quot;'&quot; , &quot;);
            jQuery(&quot; , &quot;'&quot; , &quot;#help-menu.panelContainer&quot; , &quot;'&quot; , &quot;).css(
                    &quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;block&quot; , &quot;'&quot; , &quot;);
             
        });

        jQuery(&quot; , &quot;'&quot; , &quot;#heartbeatSubmitBtn&quot; , &quot;'&quot; , &quot;).click(function(event) {
            event.stopImmediatePropagation();
            jQuery(this).closest(&quot; , &quot;'&quot; , &quot;form&quot; , &quot;'&quot; , &quot;).ajaxSubmit(function() {
                jQuery(&quot; , &quot;'&quot; , &quot;#messageToDisplayAbout&quot; , &quot;'&quot; , &quot;).html(&quot; , &quot;'&quot; , &quot;Saved&quot; , &quot;'&quot; , &quot;);

                if (jQuery(&quot; , &quot;'&quot; , &quot;#register_registration&quot; , &quot;'&quot; , &quot;).is(&quot; , &quot;'&quot; , &quot;:checked&quot; , &quot;'&quot; , &quot;)) {
                    jQuery(&quot; , &quot;'&quot; , &quot;#registration-section&quot; , &quot;'&quot; , &quot;).css(
                            &quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;none&quot; , &quot;'&quot; , &quot;);
                }
                jQuery(&quot; , &quot;'&quot; , &quot;#displayAbout&quot; , &quot;'&quot; , &quot;).modal(&quot; , &quot;'&quot; , &quot;hide&quot; , &quot;'&quot; , &quot;);
                jQuery(&quot; , &quot;'&quot; , &quot;#messageToDisplayAbout&quot; , &quot;'&quot; , &quot;).css(
                        &quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;block&quot; , &quot;'&quot; , &quot;);
                jQuery(&quot; , &quot;'&quot; , &quot;#welcome-menu&quot; , &quot;'&quot; , &quot;).css(&quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;,&quot; , &quot;'&quot; , &quot;none&quot; , &quot;'&quot; , &quot;);
            });
        });

        jQuery(&quot; , &quot;'&quot; , &quot;#displayAbout&quot; , &quot;'&quot; , &quot;).click(function(event) {
            event.stopImmediatePropagation();
        });
        
        jQuery(&quot; , &quot;'&quot; , &quot;#heartbeatCancelBtn&quot; , &quot;'&quot; , &quot;).click(function(event) {
            event.stopImmediatePropagation();
             jQuery(&quot; , &quot;'&quot; , &quot;#welcome-menu&quot; , &quot;'&quot; , &quot;).css(&quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;,&quot; , &quot;'&quot; , &quot;none&quot; , &quot;'&quot; , &quot;);
                 jQuery(&quot; , &quot;'&quot; , &quot;#displayAbout&quot; , &quot;'&quot; , &quot;).modal(&quot; , &quot;'&quot; , &quot;hide&quot; , &quot;'&quot; , &quot;);
        });

    })



                        Support
                        Logout
                    
                
                                


    svg path,
    svg rect{
        fill: #FF6700;
    }
    .svgcl{
        position: relative;
        left: -35px;
        top: -31px;
    }
    


    var inputDatePattern = &quot; , &quot;'&quot; , &quot;Y-m-d&quot; , &quot;'&quot; , &quot; ;
    var separatorString = &quot; , &quot;'&quot; , &quot;to&quot; , &quot;'&quot; , &quot;;
    $( document ).ready(function() {

        $(&quot;#loader-1&quot;).hide();
        empId = location.href[location.href.length-1];
        dates = $(&quot; , &quot;'&quot; , &quot;#startDates&quot; , &quot;'&quot; , &quot;).find(&quot;:selected&quot;).text().split(&quot; &quot;+separatorString+&quot; &quot;);
        startDate_timesheet = dates[0]+&quot; 00:00:00&quot;;
        endDate_timesheet   = dates[1]+&quot; 00:00:00&quot;;

        clientId  =     &quot;&quot;;
        clientSecret  = &quot;&quot;;
        clientUrl     = &quot;&quot;;
        successUrl  = &quot;&quot;;
        ajaxURL = &quot;/index.php/buzz/viewBuzz&quot;;
        var timeSheetStatus = $(&quot; , &quot;'&quot; , &quot;#timesheet_status&quot; , &quot;'&quot; , &quot;).find(&quot; , &quot;'&quot; , &quot;h2&quot; , &quot;'&quot; , &quot;).text();
        if(timeSheetStatus == &quot; , &quot;'&quot; , &quot;Status: Approved&quot; , &quot;'&quot; , &quot;){

            $(&quot; , &quot;'&quot; , &quot;.syncToggl&quot; , &quot;'&quot; , &quot;).hide();
        } else {
            $(&quot; , &quot;'&quot; , &quot;.syncToggl&quot; , &quot;'&quot; , &quot;).show();
        }

    });

        
    function ajaxSyc() {
        $(&quot;#loader-1&quot;).show();

        $.ajax({
                type: &quot;POST&quot;,
                url: ajaxURL,
                data: {
                    &quot; , &quot;'&quot; , &quot;employee_Id&quot; , &quot;'&quot; , &quot;:employeeId,
                    &quot; , &quot;'&quot; , &quot;startTime&quot; , &quot;'&quot; , &quot;: startDate_timesheet,
                    &quot; , &quot;'&quot; , &quot;endTime&quot; , &quot;'&quot; , &quot;: endDate_timesheet,
                    &quot; , &quot;'&quot; , &quot;timeFormat&quot; , &quot;'&quot; , &quot;: inputDatePattern,
                    &quot; , &quot;'&quot; , &quot;timeZone&quot; , &quot;'&quot; , &quot;: &quot; , &quot;'&quot; , &quot;GMT&quot; , &quot;'&quot; , &quot;+formatTimeZone()
                },
                contentType: &quot;application/x-www-form-urlencoded&quot;,

                success: function (msg, status, jqXHR) {

                    $(&quot;#loader-1&quot;).hide();
                    msg = JSON.parse(msg);
                    msgCode = msg.statusCode;
                    if (msgCode != null) {
                        if (msgCode == 101) {
                            displayMessages(&quot; , &quot;'&quot; , &quot;error&quot; , &quot;'&quot; , &quot;,msg.description );
                        } else if (msgCode == 102) {

                            displayMessages(&quot; , &quot;'&quot; , &quot;success&quot; , &quot;'&quot; , &quot;, msg.description);
                            setTimeout(function () {
                                location.reload();
                            }, 2000);

                        }
                    } else {
                        showErrorMsg();
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(&quot;#loader-1&quot;).hide();
                    console.log(errorThrown);
                    showErrorMsg();
                }
            });
    }
    
    function startSyc() {
        $(&quot;#loader-1&quot;).show();

    $.ajax({

        type: &quot;POST&quot;,
        url: clientUrl,


        data: {
            &quot; , &quot;'&quot; , &quot;grant_type&quot; , &quot;'&quot; , &quot;: &quot; , &quot;'&quot; , &quot;client_credentials&quot; , &quot;'&quot; , &quot;,
            &quot; , &quot;'&quot; , &quot;client_id&quot; , &quot;'&quot; , &quot;: clientId,
            &quot; , &quot;'&quot; , &quot;client_secret&quot; , &quot;'&quot; , &quot;: clientSecret
        },
        contentType: &quot;application/x-www-form-urlencoded&quot;,


        success: function (msg, status, jqXHR) {

            try {

                msg = $.parseJSON(jqXHR.responseText);

            } catch (err) {
                console.log(err);
                showErrorMsg();
            }

            $.ajax({
                type: &quot;POST&quot;,
                url: successUrl,
                beforeSend: function (xhr) {

                    xhr.setRequestHeader(&quot;Authorization&quot;, &quot;Bearer &quot; + msg.access_token);
                },

                data: {

                    &quot; , &quot;'&quot; , &quot;employee_Id&quot; , &quot;'&quot; , &quot;:employeeId,
                    &quot; , &quot;'&quot; , &quot;startTime&quot; , &quot;'&quot; , &quot;: startDate_timesheet,
                    &quot; , &quot;'&quot; , &quot;endTime&quot; , &quot;'&quot; , &quot;: endDate_timesheet,
                    &quot; , &quot;'&quot; , &quot;timeFormat&quot; , &quot;'&quot; , &quot;: inputDatePattern,
                    &quot; , &quot;'&quot; , &quot;timeZone&quot; , &quot;'&quot; , &quot;: &quot; , &quot;'&quot; , &quot;GMT&quot; , &quot;'&quot; , &quot;+formatTimeZone()
                },
                contentType: &quot;application/x-www-form-urlencoded&quot;,

                success: function (msg, status, jqXHR) {

                    $(&quot;#loader-1&quot;).hide();
                    msgCode = msg.statusCode;
                    if (msgCode != null) {
                        if (msgCode == 101) {
                            displayMessages(&quot; , &quot;'&quot; , &quot;error&quot; , &quot;'&quot; , &quot;,msg.description );
                        } else if (msgCode == 102) {

                            displayMessages(&quot; , &quot;'&quot; , &quot;success&quot; , &quot;'&quot; , &quot;, msg.description);
                            setTimeout(function () {
                                location.reload();
                            }, 2000);

                        }
                    } else {
                        showErrorMsg();
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(&quot;#loader-1&quot;).hide();
                    console.log(errorThrown);
                    showErrorMsg();
                }
            });

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $(&quot;#loader-1&quot;).hide();
            console.log(errorThrown);
            showErrorMsg();
        }


    });

    }

    function showErrorMsg(){
        displayMessages(&quot; , &quot;'&quot; , &quot;error&quot; , &quot;'&quot; , &quot;,&quot; , &quot;'&quot; , &quot;Unable To Sync With Toggl&quot; , &quot;'&quot; , &quot; );
        setTimeout(function () {
            $(&quot; , &quot;'&quot; , &quot;#msgDiv&quot; , &quot;'&quot; , &quot;).remove();
        }, 3000);

    }




    
    
        
            
  
      
  
  
        
    

    
        
            ×
            Confirm Toggl Sync
        
        
            Any existing timesheet entry will be overwritten if record for same date is matched. Click ok to continue.
        
        
                            
                        
        
    






            &quot;) or . = concat(&quot;
                
                Welcome Sahil
                


    
        
        
    




    

        
        
            
                
                                    
                No new notifications
                
                                    
            
        
    

    
        
            
                
                                    
            

        

        
            


        

        
            

        
    




    
        
            

        
            
        

    



    
        
            Success!        
        
            Successfully Saved        
        
            Successfully Shared        
        
            Successfully Deleted        

    




    
        
            
        
    





    
        People who shared this post    
    
        
            
        

    





    
        People who like this post    
    
        
            
        

    




    var getAccessUrl = &quot; , &quot;'&quot; , &quot;/index.php/buzz/getLogedToBuzz&quot; , &quot;'&quot; , &quot;;
    var loginpageURL = &quot; , &quot;'&quot; , &quot;/index.php/auth/login&quot; , &quot;'&quot; , &quot;;

    // buzzCommon.js
    var viewLikedEmployees = &quot; , &quot;'&quot; , &quot;/index.php/buzz/viewLikedEmployees&quot; , &quot;'&quot; , &quot;;
    var addBuzzCommentURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/addNewComment&quot; , &quot;'&quot; , &quot;;
    var shareShareURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/shareAPost&quot; , &quot;'&quot; , &quot;;
    var getLikedEmployeeListURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/getLikedEmployeeList&quot; , &quot;'&quot; , &quot;;

    // buzzNew.js
    var shareLikeURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/likeOnShare&quot; , &quot;'&quot; , &quot;;
    var commentLikeURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/likeOnComment&quot; , &quot;'&quot; , &quot;;
    var getSharedEmployeeListURL = &quot; , &quot;'&quot; , &quot;/index.php/buzz/getSharedEmployeeList&quot; , &quot;'&quot; , &quot;;

    // viewNotificationComponent.js
    var viewMoreShare = &quot; , &quot;'&quot; , &quot;/index.php/buzz/viewShare&quot; , &quot;'&quot; , &quot;;
    var buzzURL = &quot;/index.php/buzz/viewBuzz&quot;;
    var ClearNotificationURL = &quot;/index.php/buzz/clearNotificationAjax&quot;;
    var ClickOnNotificationIconURL = &quot;/index.php/buzz/clickOnNotificationIconAjax&quot;;
    var lang_NoNewNotifications = &quot; , &quot;'&quot; , &quot;No new notifications&quot; , &quot;'&quot; , &quot;;
    var lang_NotificationClearFailed = &quot; , &quot;'&quot; , &quot;Failed to clear notifications&quot; , &quot;'&quot; , &quot;;

                

    
        
    

                                    
                        
                    
                                
                    var marketplaceURL = &quot;/index.php/marketPlace/ohrmAddons&quot;;
                    var SubscriberURL = &quot;/index.php/pim/subscriber&quot;;
                
                
                    
                        
    About

    
        
            ×
            About
        
        
            
                
                    
                        
                            Company Name: OrangeHRM
                        
                        
                            Version: Orangehrm OS 4.9
                        
                        
                            Active Employees: 64
                        
                        
                            Employees Terminated: 0
                        
                    
                
                
                        
    



    jQuery(document).ready(function() {
        
               
        jQuery(&quot; , &quot;'&quot; , &quot;#aboutDisplayLink&quot; , &quot;'&quot; , &quot;).click(function(event) {
            event.stopImmediatePropagation();
            jQuery(&quot; , &quot;'&quot; , &quot;#messageToDisplayAbout&quot; , &quot;'&quot; , &quot;).css(
                    &quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;none&quot; , &quot;'&quot; , &quot;);
            jQuery(&quot; , &quot;'&quot; , &quot;#displayAbout&quot; , &quot;'&quot; , &quot;).modal();
            jQuery(&quot; , &quot;'&quot; , &quot;#help-menu.panelContainer&quot; , &quot;'&quot; , &quot;).attr(&quot; , &quot;'&quot; , &quot;style&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;display:block&quot; , &quot;'&quot; , &quot;);
            
            var test = jQuery(&quot; , &quot;'&quot; , &quot;.panelContainer&quot; , &quot;'&quot; , &quot;);
            jQuery(&quot; , &quot;'&quot; , &quot;#help-menu.panelContainer&quot; , &quot;'&quot; , &quot;).css(
                    &quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;block&quot; , &quot;'&quot; , &quot;);
             
        });

        jQuery(&quot; , &quot;'&quot; , &quot;#heartbeatSubmitBtn&quot; , &quot;'&quot; , &quot;).click(function(event) {
            event.stopImmediatePropagation();
            jQuery(this).closest(&quot; , &quot;'&quot; , &quot;form&quot; , &quot;'&quot; , &quot;).ajaxSubmit(function() {
                jQuery(&quot; , &quot;'&quot; , &quot;#messageToDisplayAbout&quot; , &quot;'&quot; , &quot;).html(&quot; , &quot;'&quot; , &quot;Saved&quot; , &quot;'&quot; , &quot;);

                if (jQuery(&quot; , &quot;'&quot; , &quot;#register_registration&quot; , &quot;'&quot; , &quot;).is(&quot; , &quot;'&quot; , &quot;:checked&quot; , &quot;'&quot; , &quot;)) {
                    jQuery(&quot; , &quot;'&quot; , &quot;#registration-section&quot; , &quot;'&quot; , &quot;).css(
                            &quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;none&quot; , &quot;'&quot; , &quot;);
                }
                jQuery(&quot; , &quot;'&quot; , &quot;#displayAbout&quot; , &quot;'&quot; , &quot;).modal(&quot; , &quot;'&quot; , &quot;hide&quot; , &quot;'&quot; , &quot;);
                jQuery(&quot; , &quot;'&quot; , &quot;#messageToDisplayAbout&quot; , &quot;'&quot; , &quot;).css(
                        &quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;, &quot; , &quot;'&quot; , &quot;block&quot; , &quot;'&quot; , &quot;);
                jQuery(&quot; , &quot;'&quot; , &quot;#welcome-menu&quot; , &quot;'&quot; , &quot;).css(&quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;,&quot; , &quot;'&quot; , &quot;none&quot; , &quot;'&quot; , &quot;);
            });
        });

        jQuery(&quot; , &quot;'&quot; , &quot;#displayAbout&quot; , &quot;'&quot; , &quot;).click(function(event) {
            event.stopImmediatePropagation();
        });
        
        jQuery(&quot; , &quot;'&quot; , &quot;#heartbeatCancelBtn&quot; , &quot;'&quot; , &quot;).click(function(event) {
            event.stopImmediatePropagation();
             jQuery(&quot; , &quot;'&quot; , &quot;#welcome-menu&quot; , &quot;'&quot; , &quot;).css(&quot; , &quot;'&quot; , &quot;display&quot; , &quot;'&quot; , &quot;,&quot; , &quot;'&quot; , &quot;none&quot; , &quot;'&quot; , &quot;);
                 jQuery(&quot; , &quot;'&quot; , &quot;#displayAbout&quot; , &quot;'&quot; , &quot;).modal(&quot; , &quot;'&quot; , &quot;hide&quot; , &quot;'&quot; , &quot;);
        });

    })



                        Support
                        Logout
                    
                
                                


    svg path,
    svg rect{
        fill: #FF6700;
    }
    .svgcl{
        position: relative;
        left: -35px;
        top: -31px;
    }
    


    var inputDatePattern = &quot; , &quot;'&quot; , &quot;Y-m-d&quot; , &quot;'&quot; , &quot; ;
    var separatorString = &quot; , &quot;'&quot; , &quot;to&quot; , &quot;'&quot; , &quot;;
    $( document ).ready(function() {

        $(&quot;#loader-1&quot;).hide();
        empId = location.href[location.href.length-1];
        dates = $(&quot; , &quot;'&quot; , &quot;#startDates&quot; , &quot;'&quot; , &quot;).find(&quot;:selected&quot;).text().split(&quot; &quot;+separatorString+&quot; &quot;);
        startDate_timesheet = dates[0]+&quot; 00:00:00&quot;;
        endDate_timesheet   = dates[1]+&quot; 00:00:00&quot;;

        clientId  =     &quot;&quot;;
        clientSecret  = &quot;&quot;;
        clientUrl     = &quot;&quot;;
        successUrl  = &quot;&quot;;
        ajaxURL = &quot;/index.php/buzz/viewBuzz&quot;;
        var timeSheetStatus = $(&quot; , &quot;'&quot; , &quot;#timesheet_status&quot; , &quot;'&quot; , &quot;).find(&quot; , &quot;'&quot; , &quot;h2&quot; , &quot;'&quot; , &quot;).text();
        if(timeSheetStatus == &quot; , &quot;'&quot; , &quot;Status: Approved&quot; , &quot;'&quot; , &quot;){

            $(&quot; , &quot;'&quot; , &quot;.syncToggl&quot; , &quot;'&quot; , &quot;).hide();
        } else {
            $(&quot; , &quot;'&quot; , &quot;.syncToggl&quot; , &quot;'&quot; , &quot;).show();
        }

    });

        
    function ajaxSyc() {
        $(&quot;#loader-1&quot;).show();

        $.ajax({
                type: &quot;POST&quot;,
                url: ajaxURL,
                data: {
                    &quot; , &quot;'&quot; , &quot;employee_Id&quot; , &quot;'&quot; , &quot;:employeeId,
                    &quot; , &quot;'&quot; , &quot;startTime&quot; , &quot;'&quot; , &quot;: startDate_timesheet,
                    &quot; , &quot;'&quot; , &quot;endTime&quot; , &quot;'&quot; , &quot;: endDate_timesheet,
                    &quot; , &quot;'&quot; , &quot;timeFormat&quot; , &quot;'&quot; , &quot;: inputDatePattern,
                    &quot; , &quot;'&quot; , &quot;timeZone&quot; , &quot;'&quot; , &quot;: &quot; , &quot;'&quot; , &quot;GMT&quot; , &quot;'&quot; , &quot;+formatTimeZone()
                },
                contentType: &quot;application/x-www-form-urlencoded&quot;,

                success: function (msg, status, jqXHR) {

                    $(&quot;#loader-1&quot;).hide();
                    msg = JSON.parse(msg);
                    msgCode = msg.statusCode;
                    if (msgCode != null) {
                        if (msgCode == 101) {
                            displayMessages(&quot; , &quot;'&quot; , &quot;error&quot; , &quot;'&quot; , &quot;,msg.description );
                        } else if (msgCode == 102) {

                            displayMessages(&quot; , &quot;'&quot; , &quot;success&quot; , &quot;'&quot; , &quot;, msg.description);
                            setTimeout(function () {
                                location.reload();
                            }, 2000);

                        }
                    } else {
                        showErrorMsg();
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(&quot;#loader-1&quot;).hide();
                    console.log(errorThrown);
                    showErrorMsg();
                }
            });
    }
    
    function startSyc() {
        $(&quot;#loader-1&quot;).show();

    $.ajax({

        type: &quot;POST&quot;,
        url: clientUrl,


        data: {
            &quot; , &quot;'&quot; , &quot;grant_type&quot; , &quot;'&quot; , &quot;: &quot; , &quot;'&quot; , &quot;client_credentials&quot; , &quot;'&quot; , &quot;,
            &quot; , &quot;'&quot; , &quot;client_id&quot; , &quot;'&quot; , &quot;: clientId,
            &quot; , &quot;'&quot; , &quot;client_secret&quot; , &quot;'&quot; , &quot;: clientSecret
        },
        contentType: &quot;application/x-www-form-urlencoded&quot;,


        success: function (msg, status, jqXHR) {

            try {

                msg = $.parseJSON(jqXHR.responseText);

            } catch (err) {
                console.log(err);
                showErrorMsg();
            }

            $.ajax({
                type: &quot;POST&quot;,
                url: successUrl,
                beforeSend: function (xhr) {

                    xhr.setRequestHeader(&quot;Authorization&quot;, &quot;Bearer &quot; + msg.access_token);
                },

                data: {

                    &quot; , &quot;'&quot; , &quot;employee_Id&quot; , &quot;'&quot; , &quot;:employeeId,
                    &quot; , &quot;'&quot; , &quot;startTime&quot; , &quot;'&quot; , &quot;: startDate_timesheet,
                    &quot; , &quot;'&quot; , &quot;endTime&quot; , &quot;'&quot; , &quot;: endDate_timesheet,
                    &quot; , &quot;'&quot; , &quot;timeFormat&quot; , &quot;'&quot; , &quot;: inputDatePattern,
                    &quot; , &quot;'&quot; , &quot;timeZone&quot; , &quot;'&quot; , &quot;: &quot; , &quot;'&quot; , &quot;GMT&quot; , &quot;'&quot; , &quot;+formatTimeZone()
                },
                contentType: &quot;application/x-www-form-urlencoded&quot;,

                success: function (msg, status, jqXHR) {

                    $(&quot;#loader-1&quot;).hide();
                    msgCode = msg.statusCode;
                    if (msgCode != null) {
                        if (msgCode == 101) {
                            displayMessages(&quot; , &quot;'&quot; , &quot;error&quot; , &quot;'&quot; , &quot;,msg.description );
                        } else if (msgCode == 102) {

                            displayMessages(&quot; , &quot;'&quot; , &quot;success&quot; , &quot;'&quot; , &quot;, msg.description);
                            setTimeout(function () {
                                location.reload();
                            }, 2000);

                        }
                    } else {
                        showErrorMsg();
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $(&quot;#loader-1&quot;).hide();
                    console.log(errorThrown);
                    showErrorMsg();
                }
            });

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $(&quot;#loader-1&quot;).hide();
            console.log(errorThrown);
            showErrorMsg();
        }


    });

    }

    function showErrorMsg(){
        displayMessages(&quot; , &quot;'&quot; , &quot;error&quot; , &quot;'&quot; , &quot;,&quot; , &quot;'&quot; , &quot;Unable To Sync With Toggl&quot; , &quot;'&quot; , &quot; );
        setTimeout(function () {
            $(&quot; , &quot;'&quot; , &quot;#msgDiv&quot; , &quot;'&quot; , &quot;).remove();
        }, 3000);

    }




    
    
        
            
  
      
  
  
        
    

    
        
            ×
            Confirm Toggl Sync
        
        
            Any existing timesheet entry will be overwritten if record for same date is matched. Click ok to continue.
        
        
                            
                        
        
    






            &quot;))]</value>
   </webElementXpaths>
</WebElementEntity>
