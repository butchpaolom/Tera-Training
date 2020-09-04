public class Palindrome
{
    public static boolean isPalindrome(String word){
        StringBuilder tempWord = new StringBuilder(word);
        String reversedWord = tempWord.reverse().toString();
        return reversedWord.equals(word);
    }
}
