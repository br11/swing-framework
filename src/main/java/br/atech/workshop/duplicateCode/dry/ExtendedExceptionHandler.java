package br.atech.workshop.duplicateCode.dry;

import br.atech.workshop.duplicateCode.gui.GuiController;

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
	public ExtendedExceptionHandler(GuiController gui) {
		super(gui);
	}

	/**
	 * 
	 * @param t
	 */
	public void handle(Throwable t) {
		if (t instanceof BreakSignal) {
			return;
		}

		super.handle(t);
	}
}