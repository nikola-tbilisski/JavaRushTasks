package com.javarush.task.task21.task2113;

//game horse run

import java.util.ArrayList;
import java.util.List;

public class Hippodrome
	{
		public static Hippodrome game;

		public Hippodrome(List<Horse> horse){
			this.horses = horse;
		}

		private List<Horse> horses;

		public List<Horse> getHorses(){
			return horses;
		}

		public void run() throws InterruptedException {
			for(int i = 0; i < 100; i++){
				move();
				print();
				Thread.sleep(200);
			}
		}

		public void move(){
			for(Horse horse : horses){
				horse.move();
			}	
		}

		public void print(){
			for(Horse horse : horses){
				horse.print();
			}

			for(int i = 0; i < 10; i++){
				System.out.println();
			}
		}

		public Horse getWinner(){
			double max = 0.0;
			Horse winnerHorse = null;

			for(Horse horse : horses){
				if(horse.getDistance() > max){
					max = horse.getDistance();
					winnerHorse = horse;
				}
			}
			return winnerHorse;
		}

		public void printWinner(){
			System.out.println("Winner is " + getWinner().getName() + "!");
		}

		public static void main(String[] args) throws InterruptedException
			{
				List<Horse> horses = new ArrayList<>();

				Horse h1 = new Horse("Penelopa",3,0);
				Horse h2 = new Horse("Diablo",3,0);
				Horse h3 = new Horse("Mephisto",3,0);

				horses.add(h1);
				horses.add(h2);
				horses.add(h3);

				//Hippodrome hippodrome = new Hippodrome(horses);
				game = new Hippodrome(horses);

				game.run();
				game.printWinner();
			}
	}
