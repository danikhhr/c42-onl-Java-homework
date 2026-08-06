package homeworkNumber16;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(wordMultiple(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println(pairs(new String[]{"man", "moon", "good", "night"}));
        System.out.println(isBalanced("([{{[(())]}}])"));
    }

    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String string : strings) {
            if (map.containsKey(string)) map.put(string, true);
            else map.put(string, false);
        }
        return map;
    }

    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String string : strings) {
            map.put(String.valueOf(string.charAt(0)), String.valueOf(string.charAt(string.length() - 1)));
        }
        return map;
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty() || stack.pop() != map.get(c) ) return false;
            }
        }
        return stack.isEmpty();
    }
}
