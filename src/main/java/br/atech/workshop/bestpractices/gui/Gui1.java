package br.atech.workshop.bestpractices.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.atech.workshop.bestpractices.app.App;
import br.atech.workshop.bestpractices.app.AppException;

/**
 * 
 * @author marcio
 * 
 */
public class Gui1 extends AbstractGui {

	final JLabel namelbl;
	final JTextField namefield;
	final JLabel resultlbl;
	final JTextField resultfield;

	final JButton btn1;
	final JButton btn2;
	final JButton btn3;

	private final App app;

	public Gui1(App app) {
		this.app = app;

		namelbl = addContent(new JLabel("Name:"));
		namefield = addContent(new JTextField());
		resultlbl = addContent(new JLabel("Result:"));
		resultfield = addContent(new JTextField());
		resultfield.setEditable(false);

		btn1 = addAction(new JButton("Button 1"));
		btn2 = addAction(new JButton("Button 2"));
		btn3 = addAction(new JButton("Button 3"));

		addBtn1Listeners();
		addBtn2Listeners();
		addBtn3Listeners();
	}

	protected void addBtn1Listeners() {
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					reset();
					resultfield.setText(app.feature1(namefield.getText()));
				} catch (AppException e) {
					e.printStackTrace();
					error("System Error");
				}
			}
		});
	}

	protected void addBtn2Listeners() {
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					resultfield.setText("");
					reset();
					resultfield.setText(app.feature2(namefield.getText()));
				} catch (AppException e) {
					e.printStackTrace();
					error("System Error");
				}
			}
		});
	}

	protected void addBtn3Listeners() {
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					resultfield.setText("");
					reset();
					resultfield.setText(app.feature3(namefield.getText()));
				} catch (AppException e) {
					e.printStackTrace();
					error("System Error");
				}
			}
		});
	}
}