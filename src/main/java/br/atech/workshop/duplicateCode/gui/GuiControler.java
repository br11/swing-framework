package br.atech.workshop.duplicateCode.gui;

/**
 * 
 * @author marcio
 * 
 */
public interface GuiControler {

	/**
	 * 
	 */
	public abstract void show();

	/**
	 * 
	 */
	public abstract void hide();

	/**
	 * 
	 * @param err
	 */
	public abstract void error(String err);

}