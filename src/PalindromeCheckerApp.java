class PalindromeCheckerApp{

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {

        // Normalize input (ignore case and spaces)
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare stack pop with original string
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Main application class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC11: Object-Oriented Palindrome Service =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create object of service class
        PalindromeChecker checker = new PalindromeChecker();

        // Call encapsulated method
        boolean result = checker.checkPalindrome(input);

        // Display result
        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}