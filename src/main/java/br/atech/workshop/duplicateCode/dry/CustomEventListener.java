/**
 * 
 */
package br.atech.workshop.duplicateCode.dry;

import java.awt.event.ActionEvent;

import br.atech.workshop.duplicateCode.gui.AbstractGui;

/**
 * 
 * @author marcio
 * 
 * @param <T>
 */
public class CustomEventListener<T extends AbstractGui> extends
		BaseEventListener<T> {
 
	/**
	 * 
	 * @param controler
	 * @param exHandler
	 */
	public CustomEventListener(T controler, ExceptionHandler exHandler) {
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
	public void onAction(ActionEvent event) throws Exception{
		getControler().reset();
		super.onAction(event);
	}
}
