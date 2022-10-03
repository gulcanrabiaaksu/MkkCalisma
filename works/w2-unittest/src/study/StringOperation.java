package study;

public class StringOperation {
	public String firstTwoCharacters(String inputString) {
		if(inputString.length()<=2) {
			return inputString;
		}
		else {
			String twoChar=inputString.substring(0,2);
			return twoChar;
		}
	}
	public boolean checkPalindrome(String inputString) {
		
		int num1=0;
		int num2=inputString.length()-1;
		
		while (num2>num1) {
			
			if(inputString.charAt(num1)!= inputString.charAt(num2)) {
		
				return false;
				
			}
			else {
				
				num1++;
				num2--;
			}
		}
		return true;
	}
}
