public class PalindromeCheckerApp{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC10: Case-Insensitive & Space-Ignored Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Step 1: Normalize the string
        // Convert to lowercase and remove spaces using regex
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Step 2: Apply palindrome logic using two-pointer technique
        boolean isPalindrome = true;
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Step 3: Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}}