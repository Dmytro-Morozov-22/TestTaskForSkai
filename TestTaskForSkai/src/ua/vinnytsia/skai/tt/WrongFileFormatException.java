package ua.vinnytsia.skai.tt;

@SuppressWarnings("serial")
public class WrongFileFormatException extends Exception {

	@Override
	public String toString() {
		String message = "MVP cannot be calculated because the set of files contains the wrong format. All files must be only in CSV format. ";
		return message;
	}

}
