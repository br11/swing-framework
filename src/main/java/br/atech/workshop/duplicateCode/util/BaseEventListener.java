/**
 * 
 */
package br.atech.workshop.duplicateCode.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.atech.workshop.duplicateCode.gui.ExceptionHandler;
import br.atech.workshop.duplicateCode.gui.GuiControler;

/**
 * @author marcio
 * 
 */
public class BaseEventListener<T extends GuiControler> implements
		ActionListener, DocumentListener {

	private EventUtil<T> util;
	private ExceptionHandler exHandler;

	/**
	 * 
	 * @param controler
	 * @param exHandler
	 */
	public BaseEventListener(T controler, ExceptionHandler exHandler) {
		try {
			this.util = new EventUtil<T>(controler, this);
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
	 * @param event
	 * @throws Exception
	 */
	public void onChange(DocumentEvent event) throws Exception {
		util.execute(event);
	}

	/**
	 * 
	 * @param exception
	 * @param event
	 */
	public void onException(Throwable exception, Object event) {
		exHandler.handle(exception);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.
	 * DocumentEvent)
	 */
	@Override
	public void insertUpdate(DocumentEvent event) {
		changedUpdate(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.
	 * DocumentEvent)
	 */
	@Override
	public void removeUpdate(DocumentEvent event) {
		changedUpdate(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.
	 * DocumentEvent)
	 */
	@Override
	public void changedUpdate(DocumentEvent event) {
		try {
			onChange(event);
		} catch (InvocationTargetException e) {
			onException(e.getCause(), event);
		} catch (Exception e) {
			onException(e, event);
		}
	}
}