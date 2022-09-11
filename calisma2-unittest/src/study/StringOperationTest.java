package study;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringOperationTest {
	
	StringOperation testInstance=new StringOperation();
	
	@Test
	public void testFirstTwoCharacters_StringOne() {
	
		String s="mustafa ";
		String expect="mu";
		String actual=testInstance.firstTwoCharacters(s);
		assertEquals(expect,actual);
	}
	
	@Test
	public void testFirstTwoCharacters_Normal() { //Ustteki test kodlarinin tek satirda yazilmis halidir.
		
		assertEquals("ke",testInstance.firstTwoCharacters("kemal"));
	}
	
	@Test
	public void testCheckPalindrome_true() {
		assertTrue(testInstance.checkPalindrome("abba")); //Tek parametre alýr true dondurur.
	}
	
	@Test
	public void testCheckPalindrome_false() {
		assertFalse(testInstance.checkPalindrome("makara")); //Tek parametre alýr false dondurur.
	}
}