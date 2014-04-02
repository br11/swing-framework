/**
 * 
 */
package br.atech.workshop.duplicateCode.app;

import br.atech.workshop.duplicateCode.gui.Gui1;

/**
 * 
 * 
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
		new Gui1(new App()).show();
	}
}
