package com.loginService.dwr;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.ScriptSessions;
import org.directwebremoting.WebContextFactory;

public class SocialMessagingService {
    String userId="";
    
    private final static String SCRIPT_SESSION_ATTR = "SCRIPT_SESSION_ATTR";
    
    public void socialMessage(String response) {
        userId=response;
       
        ScriptSessionFilter attributeFilter = new AttributeScriptSessionFilter(SCRIPT_SESSION_ATTR);
        Browser.withAllSessionsFiltered(attributeFilter, new Runnable()
        {
                public void run()
                {
                    try{
                        System.out.println("-->");
                        ScriptSessions.addFunctionCall("reverseAjax", userId); 
                    }catch(Exception e){
                        
                    }
                }
        });
    }
    
    public void addAttributeToScriptSession() {
        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        scriptSession.setAttribute(SCRIPT_SESSION_ATTR, true);
    }
    protected class AttributeScriptSessionFilter implements ScriptSessionFilter
    {
        public AttributeScriptSessionFilter(String attributeName)
        {
            this.attributeName = attributeName;
        }

        /* (non-Javadoc)
         * @see org.directwebremoting.ScriptSessionFilter#match(org.directwebremoting.ScriptSession)
         */
        
        private final String attributeName;

        public boolean match(ScriptSession session)
        {
            Object check = session.getAttribute(attributeName);
            return (check != null && check.equals(Boolean.TRUE));
        }

    }

}
