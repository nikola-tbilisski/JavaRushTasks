package com.javarush.task.task14.task1408;

public class RussianHen extends Hen
	{
		public int getCountOfEggsPerMonth(){
			return 90;
		}

		@Override
		public String getDescription(){
			String str = super.getDescription() + " Моя страна - Russia." + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

			return str;
		}
	}
