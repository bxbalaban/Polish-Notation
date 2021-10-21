/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polish_otomata_30;

import java.util.Scanner;
import java.util.Stack;

/**
 *

 */
public class Polish_otomata_30 {


     
	static double evaluatePrefix(String exprsn) 
	{ 
            String [] str=new String[exprsn.length()+1];
            str=exprsn.split("\\s+");
            
		Stack<Double> Stack = new Stack<Double>(); 

		for (int j = str.length-1; j >= 0; j--) { //adding string in the given string len
//                    System.out.println(Double.valueOf(Integer.valueOf(str[j]))+" ");


//                      * + 10 2 + 4 1
			if(str[j].chars().allMatch(Character::isDigit))   {//add if number
//                            System.out.println(str[j]+" ");
                            Double num=Double.valueOf(str[j]);
                            Stack.push(num);
                        }   
                        
                        else{
                                try {
                                    if (Stack.empty()) {
                                        throw new Exception(" stack is empty give valid input");
                                    }
                                double o1 = Stack.peek(); 
				Stack.pop(); 
				double o2 = Stack.peek(); 
				Stack.pop();  
				switch (str[j]) { 
				case "+": 
                                    
					Stack.push(o1 + o2); 
					break; 
				case "-": 
					Stack.push(o1 - o2); 
					break; 
				case "*": 
					Stack.push(o1 * o2); 
					break; 
				case "/": 
					Stack.push(o1 / o2); 
					break; 
				} 
                            } catch (Exception e) {
//                                    System.out.println(e);
                                        System.out.println();
                                        System.out.println("!!! PREFIX FORMAT IS WRONG  !!!");
                                        System.out.println();
                                        System.out.println(e.getMessage());
                            }
				
			} 
		} 

		return Stack.peek(); 
	} 

	/* Driver program to test above function */
	public static void main(String[] args) 
	{ 
		String exprsn ;
                System.out.println("--------------------RESULTS IN PREFIX NOTATION-------------------------");
                Scanner scanner=new Scanner(System.in);
                System.out.print("Enter prefix with space in between");
                exprsn=scanner.nextLine();                
		System.out.println("results="+evaluatePrefix(exprsn)); 
	} 
        
        
    
} 


