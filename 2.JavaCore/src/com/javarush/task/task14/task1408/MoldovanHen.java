package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen
	{
		public int getCountOfEggsPerMonth(){
			return 80;
		}

		@Override
		public String getDescription(){
			String str = super.getDescription() + " Моя страна - Moldova." + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";

			return str;
		}
	}
