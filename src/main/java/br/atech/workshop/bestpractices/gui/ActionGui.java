package br.atech.workshop.bestpractices.gui;

import br.atech.workshop.bestpractices.util.ButtonActionUtil;

/**
 * 
 * @author marcio
 * 
 */
public abstract class ActionGui extends AbstractGui {
 
	private ButtonActionUtil util;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.atech.workshop.bestpractices.gui.iGui#show()
	 */
	@Override
	public void show() {
		if (util == null) {
			util = ButtonActionUtil.instrument(this);
		}

		super.show();
	}

}