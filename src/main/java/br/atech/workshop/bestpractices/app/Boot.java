/**
 * 
 */
package br.atech.workshop.bestpractices.app;

import br.atech.workshop.bestpractices.gui.Gui2;

/**
 * @author marcio
 * 
 */
public class Boot {

	/**
	 * 
	 * @param args
	 * @throws AppException
	 */
	public static void main(String[] args) throws AppException {
		new Gui2(new App()).show();
	}
}
