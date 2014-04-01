package br.atech.workshop.duplicateCode.dry;

import br.atech.workshop.duplicateCode.app.AppException;
import br.atech.workshop.duplicateCode.gui.GuiController;

/**
 * Tratamento de exceção de toda a aplicação.
 * 
 * @author marcio
 * 
 */
public class ExceptionHandler {

	public GuiController gui;

	/**
	 * 
	 * @param gui
	 */
	public ExceptionHandler(GuiController gui) {
		this.gui = gui;
	}

	/**
	 * 
	 * @param t
	 */
	public void handle(Throwable t) {
		t.printStackTrace();

		String msg = translate(t);

		gui.print(msg);
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	private String translate(Throwable t) {
		Throwable err = t;
		while (err.getCause() != null
				&& err.getClass().equals(RuntimeException.class)) {
			err = err.getCause();
		}

		if (err instanceof AppException) {
			return "Could not answer to your request.";
		}

		if (err instanceof RuntimeException) {
			return "System internal error. Notify sysadmin.";
		}

		return "System Error.";
	}
}