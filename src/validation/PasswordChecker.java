package validation;

public class PasswordChecker {
	
	private String specialSymbols = "~!@#$%^&*()_+=-`[];',./{}:\"<>?"; 

	public boolean isAtLeastX(String string, int i) {
		if (string.length() < i) return false;
		return true;
	}

	public boolean hasUppercaseSymbols(String string) {
		for (int i=0; i < string.length(); i++) {
			if (string.charAt(i) >= 65 && string.charAt(i) <= 90) {
				return true;
			}
		}
		return false;
	}

	public boolean hasSpecialSymbols(String string) {
		for (int i=0; i < string.length(); i++) {
			if (specialSymbols.lastIndexOf(string.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

}
