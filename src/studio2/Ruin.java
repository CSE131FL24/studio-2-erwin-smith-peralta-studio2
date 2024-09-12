package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("Start Amount: ");
		double startAmount = in.nextDouble();
		System.out.println("Win Chance: ");
		double winChance = in.nextDouble();
		System.out.println("Win Limit: ");
		double winLimit = in.nextDouble();
		System.out.println("Total Simulations: ");
		int totalSimulations = in.nextInt();
		int ruins = 0;
		
		// simulated gambling
		for (int i = 1; i <= totalSimulations; i++) {
			int games = 0;
			double amount = startAmount;
			// simulated day
			while (amount > 0 && amount < winLimit) {
				double odds = Math.random();
				if(odds <= winChance) {
					amount++;
				}
				else {
					amount--;
				}
				games++;
			}
			// 
			if (amount == 0) {
				System.out.println("Simulation " + i + ": Games: " + games + " Ruin");
				ruins++;	
			}
			else {
				System.out.println("Simulation " + i + ": Games: " + games + " Success");
			}	
		}
		
		
		// calculated gambling
		double expectedRuinrate = 0.0;
		double a = (1-winChance)/winChance;
		if( winChance == 0.5) {
			expectedRuinrate = 1 - (startAmount/winLimit);
		}
		else {
			expectedRuinrate = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		
		// expected and simulated results
		System.out.println("Losses: " + ruins + " Simulations: " + totalSimulations);
		System.out.println("Ruin rate from simulation: " + ((double)ruins / totalSimulations) + " Expected ruin rate: " + expectedRuinrate);
	}

}
