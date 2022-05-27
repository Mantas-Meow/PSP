package validation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmailValidator {

	private String allowedSpecialSymbols = "~!@#$%^&*_+=-`'./{}";
	private List<String> tldList;
	
	public boolean hasAtSign(String string) {
		if (string.indexOf("@") == -1) return false;
		return true;
	}

	public boolean hasInvalidCharacters(String string) {
	    if (string.contains("..")) return true;
		
		
		for(int i=0; i < string.length(); i++) {
			char c = string.charAt(i);
			if(!Character.isLetterOrDigit(c) && allowedSpecialSymbols.indexOf(c) == -1) return true;
		}
		
		String[] split = string.split("@");
		int lenght = split[0].length();
		if (split[0].charAt(0) == '.' && split[0].charAt(lenght - 1) == '.') return true;
		
		return false;
	}

	public boolean hasCorrectDomainAndTDL(String string) {
		if (!hasAtSign(string)) return false;
		
		String[] split = string.split("@");
		if(hasInvalidCharacters(split[1])) return false;
		
		int lastDotIndex = split[1].lastIndexOf('.');
		if (lastDotIndex == -1) return false;
		
		String tld = split[1].substring(lastDotIndex + 1);
		
		try {
			String file = "resources/tld-list.csv";
			tldList = new ArrayList<>();
			String s;
			BufferedReader r = new BufferedReader(new FileReader(file));
		while((s=r.readLine()) != null)
		{
			tldList.add(s);
		}
		r.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
		
		if (tldList.contains(tld)) return true;
		return false;
	}
 
}
