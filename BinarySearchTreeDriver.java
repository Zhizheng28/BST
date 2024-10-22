import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTreeDriver {
    public static void main(String[] args) {
        try {
            File file = new File(args[0]);  //"args[1]"
            Scanner readFile = new Scanner(file);
            Scanner input = new Scanner(System.in);
            int num;
            String userInput;
            boolean quit = false;
            BinarySearchTree bst = new BinarySearchTree();
            
            while (readFile.hasNextInt()) {
                num = readFile.nextInt(); 
                ItemType key  = new ItemType(num);
                System.out.println(key.getValue());
                bst.insert(key);
            } // while
            System.out.print("TREE IN ORDER: ");
            bst.inOrder();

            // Print all Commands 
            System.out.println("\nCommands:");
            System.out.println("(i) - Insert Value");
            System.out.println("(d) - Delete Value");
            System.out.println("(p) - Print Tree");
            System.out.println("(r) - Retrieve Item");
            System.out.println("(l) - Count Leaf Nodes");
            System.out.println("(s) - Find Single Parents");
            System.out.println("(c) - Find Cousins");
            System.out.println("(q) - Quit program");

            while (quit != true) { // while user not quit run
                System.out.print("Enter a command: ");
                userInput = input.nextLine();
                //Take user Command and perform actions
                if (userInput.equals("i")) { // Insert value
                    System.out.print("In-Order: ");      
                    bst.inOrder();        
                    System.out.println();
                    System.out.print("Enter a number to insert: ");
                    int value = input.nextInt();
                    input.nextLine();
                    ItemType key  = new ItemType(value);
                    bst.insert(key);
                    System.out.print("In-Order: ");      
                    bst.inOrder();        
                    System.out.println();
               
                } else if(userInput.equals("d")) { // Delete value
                    System.out.print("Enter a number to delete: ");
                    int value = input.nextInt();
                    input.nextLine();
                    ItemType key  = new ItemType(value);
                    bst.delete(key);
                    System.out.print("In-Order: ");   
                    bst.inOrder();   
                    System.out.println(); 
                          
                } else if(userInput.equals("p")) { // Print Tree
                    System.out.print("In-Order: ");   
                    bst.inOrder();        
                    System.out.println();

                } else if(userInput.equals("r")) { // Retrieve Item
                    System.out.print("In-Order: ");
                    bst.inOrder();
                    System.out.println();

                    System.out.print("Enter a number to search: ");
                    int value = input.nextInt();
                    input.nextLine();
                    ItemType key  = new ItemType(value);
                    if (bst.retrieve(key) == true) {
                        System.out.println("Item is present in the tree");
                    } else {
                        System.out.println("Item is not present in the tree");
                    }

                } else if(userInput.equals("l")) { // Count Leaf Nodes
                    System.out.println("The number of leaf nodes are: " + bst.getNumLeafNodes());

                } else if(userInput.equals("s")) { // Find Single Parents
                    System.out.print("Single Parents: "); 
                    bst.getSingleParent(); 

                } else if(userInput.equals("c")) { // Find Cousins
                    System.out.print("In-Order: ");      
                    bst.inOrder();        
                    System.out.println();
                    System.out.print("Enter a number: ");  
                    int value = input.nextInt();
                    input.nextLine();
                    ItemType key  = new ItemType(value);
                    System.out.print(value + " Cousins: ");  
                    bst.getCousins(key);
                    System.out.println();

                } else if(userInput.equals("q")) { // quit/exit
                    System.out.println("Exiting the program...");
                    quit = true;
                } else { // Invalid command
                    System.out.println("Invalid command, try again!");
                } // if else 
            } // while
            
            readFile.close(); // close scanner
            input.close(); // close scanner
            System.exit(0);
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.toString());
        } // try/catch fnfe 
    } // main

} // BinarySearchTreeDriver
