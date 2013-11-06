import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class VendingMachine
{
	int motor;
	int[] columns;
	int[][] shelf;
	int currCol;
	int timestamp;

	public int motorUse(String[] prices, String[] purchases)
	{
		motor = 0;
		columns = null;
		shelf = new int[prices.length][];
		currCol = 0;
		timestamp = 0;
		
		for (int i = 0; i < prices.length; ++i) {
			String[] row = prices[i].split(" ");
			shelf[i] = new int[row.length];
			if (columns == null) {
				columns = new int[row.length];
			}
			for (int j = 0; j < row.length; ++j) {
				shelf[i][j] = Integer.parseInt(row[j]);
				columns[j] += shelf[i][j];
			}
		}
		rotateTo(mostExpensive());
		
		for (int i = 0; i < purchases.length; ++i) {
			Scanner in = new Scanner(purchases[i]);
			in.useDelimiter("[,:]");
			int row = in.nextInt();
			int col = in.nextInt();
			int time = in.nextInt();
			if (shelf[row][col] == 0) {
				return -1;
			}
			if (timestamp + 5 <= time) {
				rotateTo(mostExpensive());
			}
			rotateTo(col);
			columns[col] -= shelf[row][col];
			shelf[row][col] = 0;
			timestamp = time;
		}
		rotateTo(mostExpensive());
		return motor;
	}
	
	private int mostExpensive() {
		int max = 0;
		for (int i = 0; i < columns.length; ++i) {
			if (columns[i] > columns[max]) {
				max = i;
			}
		}
		return max;
	}
	
	private void rotateTo(int col) {
		int dis = Math.abs(col - currCol);
		int movement = Math.min(dis, columns.length - dis);
		motor += movement;
		currCol = col;
	}
		
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new VendingMachine().motorUse(new String[]{"100 100 100"}, new String[]{"0,0:0", "0,2:5", "0,1:10"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new VendingMachine().motorUse(new String[]{"100 200 300 400 500 600"}, new String[]{"0,2:0", "0,3:5", "0,1:10", "0,4:15"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 17;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new VendingMachine().motorUse(new String[]{"100 200 300 400 500 600"}, new String[]{"0,2:0", "0,3:4", "0,1:8", "0,4:12"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 11;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new VendingMachine().motorUse(new String[]{"100 100 100"}, new String[]{"0,0:10", "0,0:11"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new VendingMachine().motorUse(new String[]{"100 200 300", "600 500 400"}, new String[]{"0,0:0", "1,1:10", "1,2:20", "0,1:21", "1,0:22", "0,2:35"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
