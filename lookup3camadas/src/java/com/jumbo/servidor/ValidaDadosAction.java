/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jumbo.servidor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.message.send.java.LookupValidationParams;
import org.openswing.swing.server.Action;
import org.openswing.swing.server.UserSessionParameters;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author João Paulo
 */
public class ValidaDadosAction implements Action{

    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;

        LookupValidationParams validationPars = (LookupValidationParams) inputPar;
        
        String code = validationPars.getCode();

        String nomeClasse = (String) validationPars.getLookupValidationParameters().get("nomeClasse");

        String baseSQL = "select REGISTRO from " + nomeClasse + " as REGISTRO where REGISTRO.id = " + code;

        try {
            GridParams pars = new GridParams();
            session = HibernateUtil.getSessionFactory().openSession();
            Response res = HibernateUtils.getBlockFromQuery(
                    pars.getAction(),
                    pars.getStartPos(),
                    50, // block size...
                    pars.getFilteredColumns(),
                    pars.getCurrentSortedColumns(),
                    pars.getCurrentSortedVersusColumns(),
                    Class.forName(nomeClasse),
                    baseSQL,
                    new Object[0],
                    new Type[0],
                    "REGISTRO",
                    HibernateUtil.getSessionFactory(),
                    session);
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
            try {
                session.close();
            } catch (Exception ex1) {
            }
        }
    }

    public String getRequestName() {
        return "validaDados";
    }

}
