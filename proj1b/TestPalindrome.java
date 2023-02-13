import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("asdasdasdasdasdcdscdasc");
        String actual = "";
        for (int i = 0; i < "asdasdasdasdasdcdscdasc".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("asdasdasdasdasdcdscdasc", actual);
    }
    
    @Test
    public void testIsPalindrome()  {
    	assertTrue(palindrome.isPalindrome(""));
    	assertTrue(palindrome.isPalindrome("a"));
    	assertTrue(palindrome.isPalindrome("asdsa"));
    	assertFalse(palindrome.isPalindrome("ac"));
    	assertFalse(palindrome.isPalindrome("asdfdsc"));
    }
    
    @Test
    public void testOffByOnePalindrome()  {
    	 CharacterComparator cc = new OffByOne();
    	 assertTrue(palindrome.isPalindrome("%amb&", cc));
    	 assertFalse(palindrome.isPalindrome("asdvfvdsa", cc));
    }
    //Uncomment this class once you've created your Palindrome class.
}
