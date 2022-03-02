package com.javarush.task.task21.task2113;

public class Horse
	{
		private String name;
		private double speed;
		private double distance;

		public Horse(String name, double speed, double distance){
			this.name = name;
			this.speed = speed;
			this.distance = distance;
		}

		public void move(){
			distance += speed * Math.random();
		}

		public void print(){
			//int dotsNumber = (int) distance;
			//String dot = ".";
			System.out.println(new String(new char[(int)distance]).replace("\0", ".") + getName()); //"\uD83D\uDC0E"

			/*for(int i = 0; i < dotsNumber; i++){
				System.out.print(".");
			}
			System.out.println(getName());*/
		}

		public String getName() { return name; }

		public double getSpeed() {
				return speed;
			}

		public double getDistance() {
				return distance;
			}

		public void setName(String name) {
				this.name = name;
			}

		public void setSpeed(double speed) {
				this.speed = speed;
			}

		public void setDistance(double distance) { this.distance = distance; }
	}
