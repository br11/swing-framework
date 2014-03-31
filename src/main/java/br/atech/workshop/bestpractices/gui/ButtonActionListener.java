/**
 * 
 */
package br.atech.workshop.bestpractices.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import br.atech.workshop.bestpractices.util.ButtonActionUtil;

/**
 * @author spac2
 * 
 */
public class ButtonActionListener implements ActionListener {

	private ButtonActionUtil util;

	private ExceptionHandler exHandler;

	public ButtonActionListener(ButtonActionUtil util) {
		this(util, new ExceptionHandler(util.getControler()));
	}

	public ButtonActionListener(ButtonActionUtil util, ExceptionHandler exHandler) {
		this.util = util;
		this.exHandler = exHandler;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			util.getControler().reset();
			util.execute(event);
		} catch (InvocationTargetException e) {
			exHandler.handle(e.getCause());
		} catch (Exception e) {
			exHandler.handle(e);
		}
	}

}
