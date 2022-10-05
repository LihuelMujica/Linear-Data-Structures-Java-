package stacks;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "abcd";

        System.out.println(stringReverser(str));
    }
    public static String stringReverser(String string) {
        if ( string == null ) throw new IllegalArgumentException();

        Stack<Character> reversedStack = new Stack<>();

        for (char character : string.toCharArray()) {
            reversedStack.push(character);
        }

        StringBuilder reversed = new StringBuilder();
        while (!reversedStack.isEmpty()) {
            reversed.append(reversedStack.pop());
        }

        return reversed.toString();
    }
}
