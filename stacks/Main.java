package stacks;

import java.util.Stack;

public class Main {
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
        return chr == '[' || chr == '(';
    }

    private static boolean isSameKind(char chr1, char chr2) {
        return (chr1 == '[' && chr2 == ']') || (chr2 == '[' && chr1 == ']') || (chr1 == '(' && chr2 == ')') || (chr2 == '(' && chr1 == ')');
    }

    private static boolean isCloseChar(char chr) {
        return chr == ']' || chr == ')';
    }

}
