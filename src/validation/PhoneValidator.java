package validation;

import java.util.HashMap;
import java.util.Map;

public class PhoneValidator {
	
	private Map<String, Integer> countryPrefix = new HashMap<>();
	
	public PhoneValidator() {
		countryPrefix.put("+49", 9);
		countryPrefix.put("+370", 8);
	}

	public boolean hasOnlyNumbers(String string) {
		for (int i=0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean beginsWithEight(String string) {
		if (string.charAt(0) == 56) return true;
		return false;
	}

	public boolean belongsToSelectedCountry(String string) {
		for (Map.Entry<String, Integer> entry 
				: countryPrefix.entrySet()) {
            if(string.startsWith(entry.getKey()) && string.length() == entry.getValue() + entry.getKey().length()) return true;
        }
        return false;
	}

}
