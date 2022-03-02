package com.javarush.task.task30.task3001;

import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        Number result;
        try {
            String numDigit = number.getDigit();
            if (numDigit.contains(".") || numDigit.contains("-")) throw new Exception();
            else {
//                BigInteger integer = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
//
//                String s1 = integer.toString(expectedNumberSystem.getNumberSystemIntValue());
//                result = new Number(number.getNumberSystem(), s1);
                result = new Number(expectedNumberSystem,
                        new BigInteger(numDigit,
                                number.getNumberSystem().getNumberSystemIntValue()).toString(expectedNumberSystem.getNumberSystemIntValue()));
            }
        } catch (Exception e) {
            throw new NumberFormatException();
        }

        return result;

//            Number res = null;
//
//            switch (number.getNumberSystem().getNumberSystemIntValue()) {
//                case 10:
//                    if(number.getNumberSystem().equals(expectedNumberSystem)) {
//                        res = new Number(expectedNumberSystem, number.getDigit());
//                    }
//                    else if(Integer.parseInt(number.getDigit()) >= 0) {
//                        if (expectedNumberSystem.getNumberSystemIntValue() == 2) {
//                            res = new Number(number.getNumberSystem(),
//                                    new BigInteger(number.getDigit()).toString(2));
//                        }
//
//                    } else throw new NumberFormatException();
//                    break;
//
//                case 16:
//                    if(number.getNumberSystem().equals(expectedNumberSystem)) {
//                        res = new Number(expectedNumberSystem, number.getDigit());
//                    }
//                    else if(!number.getDigit().contains(".") || !number.getDigit().contains("-")){
//                        if (expectedNumberSystem.getNumberSystemIntValue() == 8) {
//                            res = new Number(number.getNumberSystem(),
//                                    new BigInteger(number.getDigit(), 16).toString(8));
//                        }
//                    } else throw new NumberFormatException();
//                    break;
//            }
//
//        //напишите тут ваш код
//        return res;
    }
}
