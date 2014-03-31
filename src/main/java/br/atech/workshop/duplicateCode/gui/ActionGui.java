package br.atech.workshop.duplicateCode.gui;

/**
 * 
 * @author marcio
 * 
 */
public abstract class ActionGui extends AbstractGui {

	private ButtonEventListener<ActionGui> actionListener;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#show()
	 */
	@Override
	public void show() {
		if (actionListener == null) { 
			actionListener = new ButtonEventListener<>(this,  new ExceptionHandler(this));
		}
		
		super.show();
	}

}