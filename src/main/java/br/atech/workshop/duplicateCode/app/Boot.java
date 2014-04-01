/**
 * 
 */
package br.atech.workshop.duplicateCode.app;

import br.atech.workshop.duplicateCode.gui.Gui6b;

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
		new Gui6b(new App()).show();
	}
}
