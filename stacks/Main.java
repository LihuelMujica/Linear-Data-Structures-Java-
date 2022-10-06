package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    private static final List<Character> openChars = Arrays.asList('(', '<', '{', '[');
    private static final List<Character> closeChars = Arrays.asList(')', '}', '<', ']');

    public static void main(String[] args) {
        String str = "(a[bcd)])";

        System.out.println(isBalanced(str));
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

    public static boolean isBalanced(String str) {
        Stack<Character> characterStack = new Stack<>();
        for (char chr : str.toCharArray()) {
            if (isOpenChar(chr)) characterStack.push(chr);
            if (isCloseChar(chr) && !isSameKind(characterStack.pop(), chr)) return false;
        }

        return characterStack.isEmpty();
    }


    private static boolean isOpenChar(char chr) {
        return openChars.contains(chr);
    }

    private static boolean isSameKind(char chr1, char chr2) {
        int index1 = openChars.indexOf(chr1);
        int index2 = closeChars.indexOf(chr2);
        return index1 == index2;
    }

    private static boolean isCloseChar(char chr) {
        return closeChars.contains(chr);
    }

}
