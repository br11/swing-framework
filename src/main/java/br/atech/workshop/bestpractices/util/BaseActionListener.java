/**
 * 
 */
package br.atech.workshop.bestpractices.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import br.atech.workshop.bestpractices.gui.ExceptionHandler;
import br.atech.workshop.bestpractices.gui.GuiControler;

/**
 * @author marcio
 * 
 */
public class BaseActionListener<T extends GuiControler> implements
		ActionListener {

	private ButtonActionUtil<T> util;
	private ExceptionHandler exHandler;

	/**
	 * 
	 * @param controler
	 * @param exHandler
	 */
	public BaseActionListener(T controler, ExceptionHandler exHandler) {
		try {
			this.util = new ButtonActionUtil<T>(controler, this);
			this.exHandler = exHandler;
		} catch (NoSuchMethodException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @return
	 */
	public T getControler() {
		return util.getControler();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			onAction(event);
		} catch (InvocationTargetException e) {
			onException(e.getCause(), event);
		} catch (Exception e) {
			onException(e, event);
		}
	}

	/**
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void onAction(ActionEvent event) throws Exception {
		util.execute(event);
	}

	/**
	 * 
	 * @param exception
	 * @param event
	 */
	public void onException(Throwable exception, ActionEvent event) {
		exHandler.handle(exception);
	}
}
