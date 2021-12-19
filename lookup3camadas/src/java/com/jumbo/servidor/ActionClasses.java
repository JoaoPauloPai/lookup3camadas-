package com.jumbo.servidor;

import org.openswing.swing.server.ActionsCollection;
import org.openswing.swing.server.Action;

public class ActionClasses extends ActionsCollection {

    public ActionClasses() {
        Action a = null;

        a = new UserLoginAction(); put(a.getRequestName(), a);
        a = new ClienteLoadAction(); put(a.getRequestName(), a);
        a = new ClienteInsertAction(); put(a.getRequestName(), a);
        a = new ClienteUpdateAction(); put(a.getRequestName(), a);
        a = new ClienteDeleteAction(); put(a.getRequestName(), a);
        a = new ImportaSituacaoClienteAction(); put(a.getRequestName(), a);
        a = new ValidaSituacaoClienteAction(); put(a.getRequestName(), a);
        a = new ImportaCepAction(); put(a.getRequestName(), a);
        a = new ValidaCepAction(); put(a.getRequestName(), a);
        a = new ImportaDadosAction(); put(a.getRequestName(), a);
        a = new ValidaDadosAction(); put(a.getRequestName(), a);
    }
}
