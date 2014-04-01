package br.atech.workshop.duplicateCode.dry;

import javax.swing.JOptionPane;


/**
 * Tela com comportamento mais especializado.
 * 
 * @author marcio
 * 
 */
public class ExtendedGui extends ExtensibleGui {

	/**
	 * 
	 */
	public ExtendedGui() {
		setActionListener(new ExtendedEventListener<>(this,
				new ExtendedExceptionHandler(this)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.duplicateCode.dry.ExtensibleGui#afterHide()
	 */
	@Override
	protected void afterHide() {
		super.afterHide();
		JOptionPane.showMessageDialog(null, "Good bye!");
	}
}