package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen
	{
		public int getCountOfEggsPerMonth(){
			return 100;
		}

		@Override
		public String getDescription(){
			String str = super.getDescription() + " Моя страна - Ukraine." + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

			return str;
		}
	}
