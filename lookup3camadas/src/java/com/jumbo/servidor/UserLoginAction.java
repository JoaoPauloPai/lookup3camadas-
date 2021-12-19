package com.jumbo.servidor;

import org.openswing.swing.server.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.openswing.swing.message.receive.java.*;

public class UserLoginAction extends LoginAction {

    public UserLoginAction() {
    }
    /**
     * Login operation.
     */
    public final Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        try {
            //String username = ((String[]) inputPar)[0];
            //String password = ((String[]) inputPar)[1];

            String languageId = null;
            //if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {

                languageId = "PT_BR";
                TextResponse tr = new TextResponse(languageId);
                SessionIdGenerator gen = (SessionIdGenerator) context.getAttribute(Controller.SESSION_ID_GENERATOR);
                tr.setSessionId(gen.getSessionId(request, response, userSession, context));

                Hashtable userSessions = (Hashtable) context.getAttribute(Controller.USER_SESSIONS);
                HashSet authenticatedIds = (HashSet) context.getAttribute(Controller.SESSION_IDS);
                if (userSessionPars != null) {
                    userSessions.remove(userSessionPars.getSessionId());
                    authenticatedIds.remove(userSessionPars.getSessionId());
                }
                userSessionPars = new UserSessionParameters();
                userSessionPars.setSessionId(tr.getSessionId());
                userSessionPars.setUsername("");
                userSessions.put(tr.getSessionId(), userSessionPars);
                userSessionPars.setLanguageId(languageId);

                authenticatedIds.add(tr.getSessionId());

                return tr;
            //} else {
                //return new ErrorResponse("Usuário inválido.");
            //}
        } catch (Exception ex1) {
            ex1.printStackTrace();
            return new ErrorResponse(ex1.getMessage());
        }
    }
}
