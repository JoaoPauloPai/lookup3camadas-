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
 * @author Jo?o Paulo
 */
public class ValidaSituacaoClienteAction implements Action{

    public Response executeCommand(Object inputPar, UserSessionParameters userSessionPars, HttpServletRequest request, HttpServletResponse response, HttpSession userSession, ServletContext context) {
        Session session = null;

        String code = ((LookupValidationParams) inputPar).getCode();

        String baseSQL = "select SITUACAO_CLIENTE from com.jumbo.java.SituacaoClienteVO as SITUACAO_CLIENTE where SITUACAO_CLIENTE.id = " + code;

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
                    com.t2ti.java.SituacaoClienteVO.class,
                    baseSQL,
                    new Object[0],
                    new Type[0],
                    "SITUACAO_CLIENTE",
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
        return "validaSituacaoCliente";
    }

}
