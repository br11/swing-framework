/**
 * 
 */
package br.atech.workshop.duplicateCode.dry;

import java.awt.event.ActionEvent;

import br.atech.workshop.duplicateCode.gui.AbstractGui;

/**
 * Implementa a paronização do comportamento de tela.
 * 
 * @author marcio
 * 
 * @param <T>
 */
public class StandardEventListener<T extends AbstractGui> extends
		GenericEventListener<T> {

	/**
	 * 
	 * @param controler
	 * @param exHandler
	 */
	public StandardEventListener(T controler, ExceptionHandler exHandler) {
		super(controler, exHandler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.atech.workshop.bestpractices.util.AbstractActionListener#onAction(
	 * java.awt.event.ActionEvent)
	 */
	@Override
	public void onAction(ActionEvent event) throws Exception {
		getControler().reset();
		super.onAction(event);
	}
}
