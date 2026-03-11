public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a string: ");
        String original = scanner.nextLine();

        String reversed = "";

        // Push characters into stack
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        // Pop characters from stack to build reversed string
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        // Compare original and reversed strings
        if (original.equals(reversed)) {
            System.out.println("The string \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}