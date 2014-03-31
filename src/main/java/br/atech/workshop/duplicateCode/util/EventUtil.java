package br.atech.workshop.duplicateCode.util;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

import br.atech.workshop.duplicateCode.gui.GuiControler;

/**
 * 
 * @author marcio
 * 
 * @param <T>
 */
public class EventUtil<T extends GuiControler> {

	private Map<Object, Method> methods = new HashMap<Object, Method>();

	private final T controler;

	private BaseEventListener<T> actionListener;

	/**
	 * 
	 * @param controler
	 * @param actionListener
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public EventUtil(T controler, BaseEventListener<T> actionListener)
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
				if (JComponent.class.isAssignableFrom(field.getType())) {
					field.setAccessible(true);
					JComponent component = (JComponent) field.get(controler);

					if (component instanceof JButton) {
						if (findEventMethod(type, component, field.getName()
								+ "OnClick", ActionEvent.class)) {
							((JButton) component)
									.addActionListener(actionListener);
						}
					} else if (component instanceof JTextField) {
						if (findEventMethod(type,
								((JTextField) component).getDocument(),
								field.getName() + "OnChange",
								DocumentEvent.class)) {
							((JTextField) component).getDocument()
									.addDocumentListener(actionListener);
						}
					}
				}
			}
			type = type.getSuperclass();
		}
	}

	private boolean findEventMethod(Class<?> type, Object source,
			String command, Class<?> eventType) throws NoSuchMethodException {
		try {
			System.out.println(String.format("[%s] // [%s]", type.getName(), command));
			Method method = type.getDeclaredMethod(command, eventType);
			method.setAccessible(true);
			methods.put(source, method);
			return true;
		} catch (NoSuchMethodException e) {
			return false;
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
		return execute((JComponent) e.getSource(), e);
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
	public Object execute(DocumentEvent e) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		return execute(e.getDocument(), e);
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
	private Object execute(Object source, Object e)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		if (methods.containsKey(source)) {
			return methods.get(source).invoke(getControler(), e);
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