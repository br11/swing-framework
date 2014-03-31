package br.atech.workshop.duplicateCode.dry;

import javax.swing.event.DocumentEvent;

import br.atech.workshop.duplicateCode.app.AppException;
import br.atech.workshop.duplicateCode.gui.AbstractGui;

/**
 * 
 * @author marcio
 * 
 */
public abstract class ActionGui extends AbstractGui {

	private CustomEventListener<ActionGui> actionListener;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#show()
	 */
	@Override
	public void show() {
		instrument();
		super.show();
	}

	/**
	 * 
	 */
	protected void instrument() {
		if (actionListener == null) {
			actionListener = new CustomEventListener<>(this,
					new ExceptionHandler(this));
		}
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