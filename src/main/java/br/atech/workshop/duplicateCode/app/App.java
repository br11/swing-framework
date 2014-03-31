/**
 * 
 */
package br.atech.workshop.duplicateCode.app;


/**
 * @author marcio
 * 
 */
public class App {

	public String feature1(String name) throws AppException {
		return String.format("Good morning %s", name);
	}

	public String feature2(String name) throws AppException {
		return String.format("Good afternoon %s", name);
	}

	public String feature3(String name) throws AppException {
		if (Math.random() > 0.6) {
			throw new AppException("error");
		}
		return String.format("Good night %s", name);
	}

}
