package br.atech.workshop.duplicateCode.gui;

import javax.swing.JFrame;

/**
 * Processa os eventos da GUI.
 * 
 * @author marcio
 * 
 */
public interface GuiController {

	/**
	 * Exibir / Abrir a tela
	 */
	public abstract void show();

	/**
	 * Ocultar / Fechar a tela
	 */
	public abstract void hide();

	/**
	 * Exibir mensagem
	 * 
	 * @param err
	 */
	public abstract void print(String err);

	/**
	 * 
	 * @return
	 */
	public JFrame getFrame();

}