import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Initialize Linked List, Stack, Queue
        LinkedList linkedlist = new LinkedList();
        Stack stack = new Stack();
        Queue queue = new Queue();
        
        //Initialize scanner to scan through magicitems.txt file
        Scanner input = new Scanner(new File("src/magicitems.txt"));
        
        final int arrSize = 666;
    
        //Initialize array to hold the magicitems
        String[] magicitemsList = new String[arrSize];
        //Add each item in magicitems to the array
        for(int i = 0; input.hasNextLine(); i++) {
            magicitemsList[i] = input.nextLine();
        }//end for i

        //Print out the array to check
        //System.out.println(magicitemsList);
        
        //For loop to go through each magicitem in the array
        for(int x = 0; x < magicitemsList.length; x++) {
            String stackPop = "";
            String queueDeq = "";
            String reverse = "";
            String original="";
            boolean palindrome = false;
    
            String item = magicitemsList[x];
            item = item.replaceAll(" ", "");
            item = item.replaceAll("'","");
            item = item.toUpperCase();
            //System.out.println(item);

            //For loop to go through each magicitem character in the string
            for(int j = 0; j < item.length(); j++) {
                if(!item.equals("")) {
                    Character chr = item.charAt(j);
                    //Add item's characters to stack and queue
                    stack.push(chr.toString());
                    queue.enqueue(chr.toString());
                }//end if
            }//end for j
    
            //For loop to go through each magicitem character in the string
            for(int y = 0; y < item.length(); y++) {
                if(!item.equals("")) {
                    //Remove each item's character from stack and queue
                    stackPop = stack.pop().item;
                    queueDeq = queue.dequeue().item;
                    reverse= reverse + stackPop;
                    original = original + queueDeq;
                    
                    //System.out.print(original + " " + reverse + " ");
                    /*if(stackPop.equals(queueDeq)) {
                        palindrome = true;
                    }else {
                        palindrome = false;
                    }*/ //end if
                    
                }//end if
            }//end for i
            //System.out.println(original + " " + reverse);
            
            if(original.equals(reverse)) {
                palindrome = true;
            }else {
                palindrome = false;
            }
            
            if (palindrome == true) {
                System.out.println("The magic item: " + original + " is a palindrome.");
            }//end if
        }//end for x
    }//end main
}//end Main Class
