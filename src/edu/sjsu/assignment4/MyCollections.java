package edu.sjsu.assignment4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyCollections {

    public static void main(String[] args) {
        //downsize() test
        LinkedList<String> employees = new LinkedList<>(Arrays.asList("Tom", "Bob", "Cathy", "Alice", "Trudy", "Harry", "Denny"));
        System.out.println(employees);
        downsize(employees, 3);
        System.out.println(employees);
        //isBalanced() test
        System.out.println(isBalanced("System.out.println(list.get(0))"));  //true
        System.out.println(isBalanced("[](3*5)^2"));    //true
        System.out.println(isBalanced("[(2+3]*5)^2"));  //false
        System.out.println(isBalanced("System.out.println(list.get(0)"));   //false
        System.out.println(isBalanced("[(3*5)]^2]"));   //false
    }

    public static void printFiles(Queue<File> files) {
        while (!files.isEmpty()) {
            try (Scanner in = new Scanner(files.poll())) {
                while (in.hasNextLine()) {
                    System.out.println(in.nextLine());
                }
                System.out.println("***");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
    }

    public static void downsize(LinkedList<String> employees, int n) {
        ListIterator<String> iterator = employees.listIterator();
        int index = 1;
        while (iterator.hasNext()) {
            iterator.next();
            if (index % n == 0) {
                iterator.remove();
            }
            index++;
        }
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == '[') {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (expression.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return (stack.isEmpty());
    }
}
