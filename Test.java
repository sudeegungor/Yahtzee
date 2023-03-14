package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {

	
	//this function deletes same 4 numbers for Yahtzee point.
	public static int delete_same_numbers(SingleLinkedList sll)
	{
		int counter_value_1=0;
		int counter_value_2=0;
		int counter_value_3=0;
		int counter_value_4=0;
		int counter_value_5=0;
		int counter_value_6=0;
		int yahtzee_point=0;

		
		//these are number counters for each number.
		counter_value_1=sll.search(1);
		counter_value_2=sll.search(2);
		counter_value_3=sll.search(3);
		counter_value_4=sll.search(4);
		counter_value_5=sll.search(5);
		counter_value_6=sll.search(6);
		
		// if a number's counter is greater than 4 or equal to 4 this deletes 4 of them.
		// and adds 10 points.
		if(counter_value_1>=4)
		{
			for(int i=0;i<4;i++)
			{
				sll.remove(1);
				
			}
			yahtzee_point=yahtzee_point+10;
		}
		if(counter_value_2>=4)
		{
			for(int i=0;i<4;i++)
			{
				sll.remove(2);
			
			}
			yahtzee_point=yahtzee_point+10;
		}
		if(counter_value_3>=4)
		{
			for(int i=0;i<4;i++)
			{
				sll.remove(3);
			
			}
			yahtzee_point=yahtzee_point+10;
		}
		if(counter_value_4>=4)
		{
			for(int i=0;i<4;i++)
			{
				sll.remove(4);
				
			}
			yahtzee_point=yahtzee_point+10;
		}
		if(counter_value_5>=4)
		{
			for(int i=0;i<4;i++)
			{
				sll.remove(5);
			
			}
			yahtzee_point=yahtzee_point+10;
		}
		if(counter_value_6>=4)
		{
			for(int i=0;i<4;i++)
			{
				sll.remove(6);
				
			}
			yahtzee_point=yahtzee_point+10;
		}

		
	return yahtzee_point;
	}
	
	//this function deletes 6 consecutive numbers for Large Straight point.
	public static int delete_consecutive_numbers(SingleLinkedList sll)
	{
		int counter_value_1=0;
		int counter_value_2=0;
		int counter_value_3=0;
		int counter_value_4=0;
		int counter_value_5=0;
		int counter_value_6=0;
		int yahtzee_point=0;

		
		
		counter_value_1=sll.search(1);
		counter_value_2=sll.search(2);
		counter_value_3=sll.search(3);
		counter_value_4=sll.search(4);
		counter_value_5=sll.search(5);
		counter_value_6=sll.search(6);
		//if there's at least one of each number, it deletes one of each one.
		// and adds 30 points.
		if(counter_value_1>0&&counter_value_1<4&&counter_value_2>0&&counter_value_2<4&&
				counter_value_3>0&&counter_value_3<4&&counter_value_4>0&&counter_value_4<4&&
				counter_value_5>0&&counter_value_5<4&&counter_value_6>0&&counter_value_6<4)
		{
			sll.remove(1);
			sll.remove(2);
			sll.remove(3);
			sll.remove(4);
			sll.remove(5);
			sll.remove(6);
			yahtzee_point=yahtzee_point+30;
		}
		
	return yahtzee_point;
	}
	
/* this was supposed to be the player's class for high score table.
/*	public static class Person
	{

	private String name;
	private int score;
	public Person(String inputname, int score)
	{
	name = inputname;
	score = score;
	}
	public String getName()
	{
	return name;
	}
	public int getScore() {
	return score;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	}*/
	public static void main(String[] args) throws IOException {
		
		
		// TODO Auto-generated method stub
		SingleLinkedList First_Player = new SingleLinkedList();
		SingleLinkedList Second_Player= new SingleLinkedList();
		SingleLinkedList HighScore_Table_names= new SingleLinkedList();
		SingleLinkedList HighScore_Table_scores= new SingleLinkedList();
		int game_count=0;
		int score_1=0;
		int score_2=0;
		int final_score_1=0;
		int final_score_2=0;
		
		
		//the game turns for 10 times.
		while(game_count<10)
		{
			game_count++;
			for (int i = 0; i <3; i++)	
				{
				First_Player.add((int) (Math.random() * 6 + 1));
				}
			for (int i = 0; i <3; i++)	
			{
				Second_Player.add((int) (Math.random() * 6 + 1));
			}
			System.out.print("\n Turn:   "+(game_count));
			System.out.println("\n Player 1:         Score: "+score_1);
			First_Player.display();
			score_1=score_1+delete_same_numbers(First_Player);
			score_1=score_1+delete_consecutive_numbers(First_Player);
			System.out.println("\n Player 2:         Score: "+score_2);
			Second_Player.display();
			score_2=score_2+delete_same_numbers(Second_Player);
			score_2=score_2+delete_consecutive_numbers(Second_Player);
			if(game_count==9)
			{
				 final_score_1=score_1;
				 final_score_2=score_2;
			}
			

			
		}
		System.out.println("\n \n GAME OVER\n");
		System.out.println("Player 1's Score: "+final_score_1);
		System.out.println("Player 2's Score: "+final_score_2);
		if(final_score_1>final_score_2)
		    System.out.println("\n Winner is Player 1");
		else if(final_score_2>final_score_1)
			System.out.println("\n Winner is Player 2");
		else if(final_score_1==final_score_2)
			System.out.println("\n It's a tie.");
		
        FileReader fileReader1 = new FileReader("HighScoreTable.txt");
		String line1;
		String[] highscore_;

		BufferedReader br1 = new BufferedReader(fileReader1);

		
        try(FileWriter fw = new FileWriter("HighScoreTable.txt", true);
        	    BufferedWriter bw = new BufferedWriter(fw);
        	    PrintWriter out = new PrintWriter(bw))
        	{
        	
        	    out.println(" ");
        	    out.print(" ");
        	    out.print("1st_player ");
        	    out.print(final_score_1);
        	    out.println(" ");
        	    out.print(" ");
        	    out.print("2nd_player "+final_score_2);
        	    
        	   
        	} catch (IOException e) {
        	    //exception handling left as an exercise for the reader
        	}
        FileReader fileReader2 = new FileReader("HighScoreTable.txt");
		String line2;
		String[] highscore;

		BufferedReader br2 = new BufferedReader(fileReader2);
		
		try {
			while ((line2 = br2.readLine()) != null)
			{   
				
			    highscore=line2.split(" ");
				HighScore_Table_names.add(highscore[1]);
				HighScore_Table_scores.add(Integer.parseInt(highscore[2]));
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		br2.close();
		
	     try(FileWriter fw = new FileWriter("HighScoreTable.txt", false);
	        	    BufferedWriter bw = new BufferedWriter(fw);
	        	    PrintWriter out = new PrintWriter(bw))
	        	{
	          
	           out.print(HighScore_Table_scores.sort(HighScore_Table_names).print());
	   	
	        	    
	        	   
	        	} catch (IOException e) {
	        	    //exception handling left as an exercise for the reader
	        	}


	}

}
