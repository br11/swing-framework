package br.atech.workshop.bestpractices.gui;

import br.atech.workshop.bestpractices.app.AppException;

/**
 * 
 * @author marcio
 * 
 */
public class ExceptionHandler {

	public GuiControler gui;

	/**
	 * 
	 * @param gui
	 */
	public ExceptionHandler(GuiControler gui) {
		this.gui = gui;
	}

	/**
	 * 
	 * @param t
	 */
	public void handle(Throwable t) {
		t.printStackTrace();

		String msg = translate(t);

		gui.error(msg);
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
			return "System internal error. Notify sysadmin";
		}

		return "System Error.";
	}
}