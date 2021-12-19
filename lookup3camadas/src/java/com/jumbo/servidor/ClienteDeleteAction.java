/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jumbo.servidor;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;

/**
 *
 * @author João Paulo
 */
public class ClienteDeleteAction implements Action {

    public ClienteDeleteAction() {
    }

    public String getRequestName() {
        return "clienteDeleteAction";
    }

    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;
        List persistentObjects = (ArrayList) inputPar;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            for (int i = 0; i < persistentObjects.size(); i++){
                session.delete(persistentObjects.get(i));
            }

            session.getTransaction().commit();

            return new VOListResponse(persistentObjects, false, persistentObjects.size());
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }
}
