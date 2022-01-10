package ua.vinnytsia.skai.tt;

@SuppressWarnings("serial")
public class NotUniqueNicknameException extends Exception {

	@Override
	public String toString() {
		String message = "Please ensure that each file contains players with a unique nickname";
		return message;
	}

}
