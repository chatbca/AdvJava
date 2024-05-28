package a4;

import java.util.Scanner;

public class four {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        StringBuilder output1 = new StringBuilder();
        StringBuilder output2 = new StringBuilder();

        for (String word : words) {
            if (word.length() % 2 == 0) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i += 2) {
                    char temp = chars[i];
                    chars[i] = chars[i + 1];
                    chars[i + 1] = temp;
                }
                output1.append(String.valueOf(chars)).append(" ");
            }

            StringBuilder tempOutput2 = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                tempOutput2.append(Character.isUpperCase(ch)
                        ? Character.toLowerCase(ch) : Character.toUpperCase(ch));
            }
            output2.append(tempOutput2).append(" ");
        }

        System.out.println(output1.toString().trim());
        System.out.println(output2.toString().trim());
    }
}
