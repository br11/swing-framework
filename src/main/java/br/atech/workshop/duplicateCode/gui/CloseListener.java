package br.atech.workshop.duplicateCode.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 
 * @author spac2
 *
 */
public class CloseListener implements WindowListener {

	/**
	 * 
	 */
	private final AbstractGui controller;

	/**
	 * @param abstractGui
	 */
	public CloseListener(AbstractGui controller) {
		this.controller = controller;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		controller.hide();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}
}