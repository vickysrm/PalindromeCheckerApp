public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC13: Palindrome Algorithm Performance Comparison =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize once
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Stack Strategy Timing
        long startStack = System.nanoTime();
        boolean stackResult = stackCheck(normalized);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;

        // Deque Strategy Timing
        long startDeque = System.nanoTime();
        boolean dequeResult = dequeCheck(normalized);
        long endDeque = System.nanoTime();
        long dequeTime = endDeque - startDeque;

        // Two-Pointer Strategy Timing
        long startTwoPointer = System.nanoTime();
        boolean twoPointerResult = twoPointerCheck(normalized);
        long endTwoPointer = System.nanoTime();
        long twoPointerTime = endTwoPointer - startTwoPointer;

        // Display Results
        System.out.println("\n===== Results =====");
        System.out.println("Stack Method Result: " + stackResult +
                " | Time: " + stackTime + " ns");

        System.out.println("Deque Method Result: " + dequeResult +
                " | Time: " + dequeTime + " ns");

        System.out.println("Two-Pointer Method Result: " + twoPointerResult +
                " | Time: " + twoPointerTime + " ns");

        System.out.println("SEE YOU SOON!");

        scanner.close();
    }

    // Stack-Based Method
    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque-Based Method
    public static boolean dequeCheck(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    // Two-Pointer Optimized Method
    public static boolean twoPointerCheck(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}