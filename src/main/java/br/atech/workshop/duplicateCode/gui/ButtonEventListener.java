/**
 * 
 */
package br.atech.workshop.duplicateCode.gui;

import java.awt.event.ActionEvent;

import br.atech.workshop.duplicateCode.util.BaseEventListener;

/**
 * 
 * @author marcio
 * 
 * @param <T>
 */
public class ButtonEventListener<T extends AbstractGui> extends
		BaseEventListener<T> {
 
	/**
	 * 
	 * @param controler
	 * @param exHandler
	 */
	public ButtonEventListener(T controler, ExceptionHandler exHandler) {
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
