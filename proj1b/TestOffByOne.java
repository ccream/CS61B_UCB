import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.*/
    static CharacterComparator offByOne = new OffByOne();

    
    // Your tests go here.
    @Test
    public void testEqualChars()  {
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('6', '8'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertTrue(offByOne.equalChars('6', '5'));
    }
    
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
}
