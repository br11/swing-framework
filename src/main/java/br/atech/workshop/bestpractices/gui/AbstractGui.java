package br.atech.workshop.bestpractices.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author marcio
 * 
 */
public abstract class AbstractGui implements iGui {

	protected final JFrame guiFrame;

	protected final JPanel messagePanel;
	protected final JLabel messagelbl;
	protected final JPanel contentPanel;
	protected final JPanel actionPanel;

	public AbstractGui() {
		guiFrame = new JFrame();
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Example GUI");
		guiFrame.setSize(350, 150);
		guiFrame.setLocationRelativeTo(null);

		messagePanel = new JPanel();
		messagePanel.setVisible(false);
		messagelbl = new JLabel();
		messagePanel.add(messagelbl);

		contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(3, 2));

		actionPanel = new JPanel();

		guiFrame.add(messagePanel, BorderLayout.NORTH);
		guiFrame.add(contentPanel, BorderLayout.CENTER);
		guiFrame.add(actionPanel, BorderLayout.SOUTH);

	}

	public <T extends JComponent> T addAction(T component) {
		actionPanel.add(component);
		return component;
	}

	public <T extends JComponent> T addContent(T component) {
		contentPanel.add(component);
		return component;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#error(java.lang.String)
	 */
	@Override
	public void error(String err) {
		messagePanel.setVisible(true);
		messagelbl.setText(err);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#hide()
	 */
	@Override
	public void hide() {
		guiFrame.setVisible(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#reset()
	 */
	@Override
	public void reset() {
		messagePanel.setVisible(false);
		messagelbl.setText("");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#show()
	 */
	@Override
	public void show() {
		guiFrame.setVisible(true);
	}

}