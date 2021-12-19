/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jumbo.cliente;

import java.util.ArrayList;
import java.util.Map;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.send.java.GridParams;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;
import org.openswing.swing.util.client.ClientUtils;

/**
 *
 * @author João Paulo
 */
public class CadastroClienteController extends GridController implements GridDataLocator{

    private CadastroCliente grid;

    public CadastroClienteController() {
        grid = new CadastroCliente(this);
        MDIFrame.add(grid);
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        return ClientUtils.getData("clienteLoadAction", new GridParams(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, otherGridParams));
    }

    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        return ClientUtils.getData("clienteInsertAction", newValueObjects);
    }

    @Override
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        return ClientUtils.getData("clienteInsertAction", persistentObjects);
    }

    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        return ClientUtils.getData("clienteInsertAction", persistentObjects);
    }

}
