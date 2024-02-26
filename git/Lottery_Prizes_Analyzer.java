import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Programme Name:Lottery_Prizes_Analyzer.java 
 * Purpose:    to create a lottery ticket machine
 * 
 * @author Syed Saad Qadeer 
 * Date: 3 December.2023
 */
public class Lottery_Prizes_Analyzer {


//Method to split the commas and convert the tickets into array

	public static int[] getNextSeries(Scanner reader) {

		String line = reader.nextLine();

		String[] token = line.split(",");

		int[] tokenArray = new int[token.length];

		for (int i = 0; i < token.length; i++) {
			tokenArray[i] = Integer.parseInt(token[i].trim());
		}

		return tokenArray;

	}

	//Methods to count the matching numbers
	
	public static int countMatchingNumbers(int[] ticket_number1 , int[]wintoken) {

		int count = 0;

		

		for (int i = 0; i < ticket_number1.length; i++) {
			for (int j = 0; j < wintoken.length; j++) {
				if (ticket_number1[i] == wintoken[j]) {
					
				count++;
				break;
			}
		}
		}
		
		return count;

	}
	
	// Method to convert the array to string format
	public static String formatTicketNumbers(int[]ticket_number2) {
		
		
		
	
		
	 String arraytostring = Arrays.toString(ticket_number2).replaceAll("[\\[\\]]", "").replace(",", ", ");
	 
		
		return arraytostring;
	}
	

	

	public static void main(String[] args) {
		final double grand_Prize= 85.0;
		final double Second_Prize =7.0;
		final double third_Prize = 8.0;

		int lineCount=0;
			Scanner input = new Scanner(System.in);

			System.out.println("Lottery Prizes Analyzer\n");

			System.out.print("Enter the name of the lottery: ");
			String lotteryName = input.nextLine();

			System.out.print("Enter the amount of money in the prize pool: $");
			int prizePool = input.nextInt();
			System.out.print("Enter the path for the data file: ");
			input.nextLine();
			String fileName = input.nextLine();
			
			File fileContent = new File(fileName);
			try {
				Scanner reader = new Scanner(fileContent);
			lineCount++;
						  
                //output 
			System.out.println("\nLottery Prizes Report");
			System.out.println("-----------------------------\n");

			 
			System.out.printf("Lottery Name: %s\n", lotteryName);
			System.out.printf("Total prize pool: $%,3d\n", prizePool);
			System.out.printf("Number of tickets: %,3d\n",lineCount);
			

			System.out.print("Winning numbers: ");
			int[] numbers = Lottery_Prizes_Analyzer.getNextSeries(reader);
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + ", ");
			}
			System.out.println();
			System.out.println();
			
			 int rank2 = numbers.length -1;
			 int rank3 = numbers.length-2;
			
			 int innercount1 =0;
			 int innercount2 =0;
			 int innercount3 =0;
		
			 //create an empty ArrayList
			 ArrayList<String> secondPrize = new ArrayList<>();
			 ArrayList<String> thirdPrize = new ArrayList<>();
			 
			 int[] ticketnumbers;
			 String ticketNumber2="";
			 
			 
			 while (reader.hasNextLine()) { 
						   ticketnumbers = getNextSeries(reader);  
						  ticketNumber2 = formatTicketNumbers(ticketnumbers);
						  
						  int matchCount = countMatchingNumbers(ticketnumbers,numbers);
				  if(matchCount ==rank2) {
					  innercount2++;
					  //populating of array
						secondPrize.add(ticketNumber2);
					  }
					 
		      
				  
				  else  if (matchCount ==rank3) {
					  innercount3++;
					  thirdPrize.add(ticketNumber2);
				  } else if(matchCount ==6) {
					  innercount1++;
					  }
			
				
		 }
			 
			 //prize value
			 double prize_Value1 = (prizePool*grand_Prize)/100;
			 double prize_Value2 = (prizePool*Second_Prize)/100;
			 double prize_Value3 = (prizePool*third_Prize)/100;
			 
			 
			 //Prize per ticket
		     double prize_Per_Ticket1=prize_Value1/innercount1;
		     double prize_Per_Ticket2=prize_Value2/innercount2;
		     double prize_Per_Ticket3=prize_Value3/innercount3;
		     
		    
				    //FIRST PRIZE
			     System.out.println("Grand prize winners (all numbers match)...");	  
				System.out.printf("  Number of winners: %d",innercount1);
				System.out.printf("\n  %% of prize pool: %.1f",grand_Prize);
				System.out.printf("\n  Total prize Value: $%,3.2f",prize_Value1);
				System.out.printf("\n  Prize per ticket: $%,3.2f",prize_Per_Ticket1);
				
				System.out.println();
		        
					  //SECOND Prize
					  System.out.printf("\nSecond prize winners (%d numbers match)...\n",rank2);	  
						System.out.printf("  Number of winners: %d",innercount2);
						System.out.printf("\n  %% of prize pool: %.1f",Second_Prize);
						System.out.printf("\n  Total prize Value: $%,3.2f",prize_Value2);
						System.out.printf("\n  Prize per ticket: $%,3.2f",prize_Per_Ticket2);
						System.out.println("\n  Tickets Numbers: ");
						
							for(int i=0;i<secondPrize.size();i++) {
								System.out.println("  "+secondPrize.get(i));
							}
							
						
						 
						System.out.println();
				  // third prize
						 System.out.printf("\nThird prize winners (%d numbers match)...\n",rank3);	  
							System.out.printf("  Number of winners: %d",innercount3);
							System.out.printf("\n  %% of prize pool: %.1f",third_Prize);
							System.out.printf("\n  Total prize Value: $%.2f",prize_Value3);
							System.out.printf("\n  Prize per ticket: $%.2f",prize_Per_Ticket3);
							System.out.println("\n  Tickets Numbers: ");
							
							
								for(int i=0;i< thirdPrize.size();i++) {
								System.out.println("  "+thirdPrize.get(i));
							}
							
							 
				  System.out.println();
				  
						 
				  
		} catch (FileNotFoundException e) {
			 e.printStackTrace();
		}

			//CREATED BY SYED SAAD QADEER
			
	}// End main method
	
}
//End of class