package Project1B;

public class Palindrome {
	public Deque<Character> wordToDeque(String word) {
		Deque<Character> result = new LinkedListDeque<Character>();
		for(int i = word.length()-1; i >= 0; i--)  {
			result.addFirst(word.charAt(i));
		}		
		return result;
	}
	
	public boolean isPalindrome(String word)  {
		OffByOne test = new OffByOne();
		Deque<Character> temp = wordToDeque(word);
		while(!temp.isEmpty() || temp.size() != 1)  {
			char nextF = temp.removeFirst();
			char nextB = temp.removeLast();
			if(!test.equalChars(nextF, nextB))  {
				return false;
			}
		}
		return true;
	}
}
