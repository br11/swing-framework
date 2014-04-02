package br.atech.workshop.duplicateCode.dry;

/**
 * Tela com comportamento mais especializado. Programação do tipo
 * "Crianças, não tentem fazer isso em casa".
 * 
 * @author marcio
 * 
 */
public class SimpleGui extends ExtendedGui {

	/**
	 * 
	 */
	public SimpleGui() {
		setActionListener(new ExtendedEventListener<>(this,
				new ExtendedExceptionHandler(this)));
	}

	/**
	 * 
	 */
	protected void abort() {
		throw new AbortSignal();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.duplicateCode.dry.ExtensibleGui#beforeHide()
	 */
	@Override
	protected void beforeHide() {
		if (!confirm("Do you really want to exit?")) {
			abort();
		}

		super.beforeHide();
	}
}