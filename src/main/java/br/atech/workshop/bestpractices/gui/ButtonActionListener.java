/**
 * 
 */
package br.atech.workshop.bestpractices.gui;

import java.awt.event.ActionEvent;

import br.atech.workshop.bestpractices.util.BaseActionListener;

/**
 * 
 * @author marcio
 * 
 * @param <T>
 */
public class ButtonActionListener<T extends AbstractGui> extends
		BaseActionListener<T> {

	/**
	 * 
	 * @param controler
	 * @param exHandler
	 */
	public ButtonActionListener(T controler, ExceptionHandler exHandler) {
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
