package br.atech.workshop.bestpractices.util;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import br.atech.workshop.bestpractices.gui.ButtonActionListener;
import br.atech.workshop.bestpractices.gui.iGui;

public class ButtonActionUtil {

	/**
	 * 
	 * @param controler
	 * @return
	 * @throws RuntimeException
	 *             caused by NoSuchMethodException, SecurityException,
	 *             IllegalArgumentException or IllegalAccessException.
	 * 
	 */
	public static ButtonActionUtil instrument(iGui controler)
			throws RuntimeException {
		try {
			return new ButtonActionUtil(controler);
		} catch (NoSuchMethodException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private Map<String, Method> methods = new HashMap<String, Method>();

	private final iGui controler;

	private ButtonActionListener actionListener;

	private ButtonActionUtil(iGui controler) throws NoSuchMethodException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		this.controler = controler;
		this.actionListener = new ButtonActionListener(this);

		init();
	}

	void init() throws NoSuchMethodException, SecurityException,
			IllegalArgumentException, IllegalAccessException {

		Class<?> type = getControler().getClass();
		while (type != null && !type.equals(Object.class)) {
			for (Field field : type.getDeclaredFields()) {
				if (JButton.class.isAssignableFrom(field.getType())) {
					String command = field.getName() + "Action";
					try {
						Method method = type.getDeclaredMethod(command,
								ActionEvent.class);
						method.setAccessible(true);
						methods.put(command, method);

						field.setAccessible(true);
						((JButton) field.get(controler))
								.setActionCommand(command);
						((JButton) field.get(controler))
								.addActionListener(actionListener);

					} catch (NoSuchMethodException e) {

					}
				}
			}
			type = type.getSuperclass();
		}
	}

	public Object execute(ActionEvent e) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		return execute(e.getActionCommand(), e);
	}

	public Object execute(String command, ActionEvent e)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		if (methods.containsKey(command)) {
			return methods.get(command).invoke(getControler(), e);
		} else {
			return null;
		}
	}

	public iGui getControler() {
		return controler;
	}

}
