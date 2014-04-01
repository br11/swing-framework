/**
 * 
 */
package br.atech.workshop.duplicateCode.app;

import br.atech.workshop.duplicateCode.gui.Gui6;

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
		new Gui6(new App()).show(); 
	}
}
