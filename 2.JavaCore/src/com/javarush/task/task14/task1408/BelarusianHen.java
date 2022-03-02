package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen
	{
		public int getCountOfEggsPerMonth(){
			return 120;
		}

		@Override
		public String getDescription(){
			String str = super.getDescription() + " Моя страна - Belarus." + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

			return str;
		}
	}
