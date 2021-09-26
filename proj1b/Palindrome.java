
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {

        if (word == null) {
            return null;
        }
        Deque<Character> result = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }

        return result;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> words = wordToDeque(word);
        if (words.size() == 1 || words.size() == 0) {
            return true;
        }

        while (words.size() > 1) {
            Character first, last;
            first = words.removeFirst();
            last = words.removeLast();
            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int size = word.length();
        for (int i = 0; i < size / 2; i++) {
            if(!cc.equalChars(word.charAt(i), word.charAt(size - 1 - i))) {
                return false;
            }
        }

        return true;
    }
}
