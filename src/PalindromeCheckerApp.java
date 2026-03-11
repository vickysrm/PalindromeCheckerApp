public class PalindromeCheckerApp{

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC8: Linked List Based Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input
        input = input.toLowerCase().replaceAll("\\s+", "");

        if (input.length() == 0) {
            System.out.println("Result: The given string is a Palindrome.");
            return;
        }

        // Step 1: Convert string to linked list
        Node head = null;
        Node tail = null;

        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Find middle using Fast & Slow pointers
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half (in-place)
        Node secondHalf = reverseList(slow);

        // Step 4: Compare first half and reversed second half
        Node firstHalf = head;
        Node tempSecondHalf = secondHalf;

        boolean isPalindrome = true;

        while (tempSecondHalf != null) {
            if (firstHalf.data != tempSecondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecondHalf = tempSecondHalf.next;
        }

        // Output result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }

    // Method to reverse linked list
    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}