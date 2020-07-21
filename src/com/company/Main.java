package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string){
        Stack<Character> characterStack = new Stack<>();
        boolean isPalindrome = false;

        String merge = string.replaceAll("\\p{P}", "");        //found this and tried it out
        merge = merge.replaceAll("\\s", "");
        merge = merge.toLowerCase();

        for (int i = 0; i < merge.length()/2; i++){    //adds the first half to the stack
            characterStack.add(merge.charAt(i));
        }
        for (int i = merge.length()%2 == 0 ? merge.length()/2 : merge.length()/2 + 1; i < merge.length(); i++){   //starts at the latter half
            char top = characterStack.pop();
            if (top == merge.charAt(i))isPalindrome = true;
            else {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}
