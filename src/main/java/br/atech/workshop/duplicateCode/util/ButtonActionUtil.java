package br.atech.workshop.duplicateCode.util;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import br.atech.workshop.duplicateCode.gui.GuiControler;

/**
 * 
 * @author marcio
 * 
 * @param <T>
 */
public class ButtonActionUtil<T extends GuiControler> {

	private Map<String, Method> methods = new HashMap<String, Method>();

	private final T controler;

	private BaseActionListener<T> actionListener;

	/**
	 * 
	 * @param controler
	 * @param actionListener
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public ButtonActionUtil(T controler,
			BaseActionListener<T> actionListener)
			throws NoSuchMethodException, SecurityException,
			IllegalArgumentException, IllegalAccessException {

		this.controler = controler;
		this.actionListener = actionListener;

		init();
	}

	/**
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
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

	/**
	 * 
	 * @param e
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public Object execute(ActionEvent e) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		return execute(e.getActionCommand(), e);
	}

	/**
	 * 
	 * @param command
	 * @param e
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public Object execute(String command, ActionEvent e)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		if (methods.containsKey(command)) {
			return methods.get(command).invoke(getControler(), e);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public T getControler() {
		return controler;
	}

}
