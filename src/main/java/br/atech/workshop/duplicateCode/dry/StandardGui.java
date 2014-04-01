package br.atech.workshop.duplicateCode.dry;

import javax.swing.event.DocumentEvent;

import br.atech.workshop.duplicateCode.app.AppException;
import br.atech.workshop.duplicateCode.gui.AbstractGui;

/**
 * Implementa o comportamento que é padrão nas telas.
 * 
 * @author marcio
 * 
 */
public abstract class StandardGui extends AbstractGui {

	private StandardEventListener<StandardGui> actionListener = new StandardEventListener<>(
			this, new ExceptionHandler(this));

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#show()
	 */
	@Override
	public void show() {
		actionListener.activate();
		super.show();
	}

	/**
	 * 
	 * @param event
	 * @throws AppException
	 */
	protected void anyOnChange(DocumentEvent event) throws AppException {
		reset();
	}

}