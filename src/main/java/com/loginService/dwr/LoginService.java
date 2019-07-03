package com.loginService.dwr;

import org.directwebremoting.Browser;
import org.directwebremoting.ui.dwr.Util;


public class LoginService {
    String chatId="";
    public void login(String response) {
        chatId=response;
        Browser.withAllSessions(new Runnable()
        {
                public void run()
                {
                    try{
                        Util.removeClassName(chatId+"off", "show");
                        Util.addClassName(chatId+"off", " hide");
                        Util.removeClassName(chatId+"on", "hide");
                        Util.addClassName(chatId+"on", " show");
                    }catch(Exception e){
                        
                    }
                }
        });
    }
    
    public void logout(String response) {
        chatId=response;
        Browser.withAllSessions(new Runnable()
        {
                public void run()
                {
                    try{
                        Util.removeClassName(chatId+"off", "hide");
                        Util.addClassName(chatId+"off", " show");
                        Util.removeClassName(chatId+"on", "show");
                        Util.addClassName(chatId+"on", " hide");
                        
                    }catch(Exception e){
                        
                    }
                }
        });
    }

   
}