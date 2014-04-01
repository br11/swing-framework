/**
 * 
 */
package br.atech.workshop.duplicateCode.dry;

import java.awt.Cursor;
import java.awt.event.ActionEvent;

import br.atech.workshop.duplicateCode.gui.AbstractGui;

/**
 * Implementa a paronização do comportamento de tela.
 * 
 * @author marcio
 * 
 * @param <T>
 */
public class ExtendedEventListener<T extends AbstractGui> extends
		StandardEventListener<T> {

	/**
	 * 
	 * @param controler
	 * @param exHandler
	 */
	public ExtendedEventListener(T controler, ExceptionHandler exHandler) {
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
		try {
			getControler().getFrame().setCursor(
					Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			Thread.sleep(700); // 
			super.onAction(event);
		} finally {
			getControler().getFrame().setCursor(
					Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	}
}
