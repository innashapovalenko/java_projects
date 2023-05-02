class Palindrome
{

    public static boolean isPalindrome(String s)
    {   
        int l = s.length();
        return isPalindromehelper(s, l, 0, false);
    }

    public static boolean isPalindromehelper(String s, int l, int i, boolean result){
        if (i == l){
            return result;
        }
        else if (s.charAt(i) == (s.charAt(l-i-1))){
            result = true;
            i += 1;
            return isPalindromehelper(s, l, i, result);
        }
        else {
            result = false;
            return result;
        }
        
    }

    public static void main(String [] args)
    {
    String s = args[0].toLowerCase();
    boolean res = isPalindrome(s); 
    if (res){
        System.out.println(s + " is a palindrome");
    }
    else
        System.out.println(s + " is not a palindrome");
    }

    //time complexity O(n)
    //because at one time we are checking two elements of the string
    //So in total we would have n/2 steps -> O(n) time complexity
}
