/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jumbo.cliente;

import org.openswing.swing.lookup.client.LookupServerDataLocator;

/**
 *
 * @author João Paulo
 */
public class LookupDataLocatorGenerico extends LookupServerDataLocator{

    public LookupDataLocatorGenerico(String nomeClasse) {
        setGridMethodName("importaDados");
        setValidationMethodName("validaDados");

        getLookupFrameParams().put("nomeClasse", nomeClasse);
        getLookupValidationParameters().put("nomeClasse", nomeClasse);

    }

}
