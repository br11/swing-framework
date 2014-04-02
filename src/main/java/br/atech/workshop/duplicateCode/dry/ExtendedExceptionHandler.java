package br.atech.workshop.duplicateCode.dry;

import br.atech.workshop.duplicateCode.gui.Gui;

/**
 * Tratamento de exceção de toda a aplicação.
 * 
 * @author marcio
 * 
 */
public class ExtendedExceptionHandler extends ExceptionHandler {
	/**
	 * 
	 * @param gui
	 */
	public ExtendedExceptionHandler(Gui gui) {
		super(gui);
	}

	/**
	 * 
	 * @param t
	 */
	public void handle(Throwable t) {
		if (t instanceof AbortSignal) {
			return;
		}

		super.handle(t);
	}
}