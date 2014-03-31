package br.atech.workshop.duplicateCode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.atech.workshop.duplicateCode.app.AppException;
import br.atech.workshop.duplicateCode.dry.ExceptionHandler;

/**
 * 
 * @author marcio
 * 
 */
public abstract class AbstractActionListener implements ActionListener {

	private AbstractGui controler;
	private ExceptionHandler exHandler;

	/**
	 * 
	 * @param controler
	 */
	public AbstractActionListener(AbstractGui controler) {
		this.controler = controler;
		this.exHandler = new ExceptionHandler(controler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
	 * ActionEvent)
	 */
	@Override
	public final void actionPerformed(ActionEvent event) {
		try {
			controler.reset();
			onAction();
		} catch (AppException e) {
			exHandler.handle(e);
		}
	}

	/**
	 * 
	 * @throws AppException
	 */
	protected abstract void onAction() throws AppException;
}