/**
 * 
 */
package br.atech.workshop.duplicateCode.app;

/**
 * Camada de aplicação.
 * 
 * @author marcio
 * 
 */
public class App {

	/**
	 * 
	 * @param name
	 * @return
	 * @throws AppException
	 */
	public String feature1(String name) throws AppException {
		takeTime();
		return String.format("Good morning %s", name);
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws AppException
	 */
	public String feature2(String name) throws AppException {
		takeTime();
		return String.format("Good afternoon %s", name);
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws AppException
	 */
	public String feature3(String name) throws AppException {
		takeTime();

		if (Math.random() > 0.7) {
			throw new AppException("error");
		} else if (Math.random() > 0.5) {
			throw new RuntimeException();
		}

		return String.format("Good night %s", name);
	}

	private void takeTime() {
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
