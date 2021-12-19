package com.jumbo.servidor;

import javax.servlet.ServletContext;
import org.openswing.swing.server.ControllerCallbacks;

/**
 * <p>Title: Jumbo</p>
 * <p>Description: Classe específica da aplicação que contém
 * métodos de inicialização adicionais para a aplicação web.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 JUMBO.COM</p>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *

 * @author Jo�o Paulo
 * @version 1.0
 */
public class T2TiControllerCallbacks extends ControllerCallbacks {

    public T2TiControllerCallbacks() {
    }

    /**
     * Method called by the init method of Controller class, as last instruction.
     */
    @Override
    public void afterInit(ServletContext context) {
        createConnection(context);
    }

    /**
     * Cria a conexão e executa alguma lógica no banco de dados
     */
    private void createConnection(ServletContext context) {
        /*
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            try {
                //insere dados no banco
                session.getTransaction().commit();

            } catch (Exception ex1) {
                ex1.printStackTrace();
            } finally {
                try {
                    session.close();
                } catch (Exception ex2) {
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         */
    }
}
