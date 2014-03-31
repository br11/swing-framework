package br.atech.workshop.bestpractices.gui;

/**
 * 
 * @author marcio
 * 
 */
public abstract class ActionGui extends AbstractGui {

	private ButtonActionListener<ActionGui> actionListener;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#show()
	 */
	@Override
	public void show() {
		if (actionListener == null) { 
			actionListener = new ButtonActionListener<>(this,  new ExceptionHandler(this));
		}
		
		super.show();
	}

}