package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person;
        String key;
        //List<String> keyList = new ArrayList<>();

        //тут цикл по чтению ключей, пункт 1
        while (true){
           key = reader.readLine();
            switch (key){
                case "user":
                    person = new Person.User();
                    doWork(person);
                    continue;
                case "loser":
                    person = new Person.Loser();
                    doWork(person);
                    continue;
                case "coder":
                    person = new Person.Coder();
                    doWork(person);
                    continue;
                case "proger":
                    person = new Person.Proger();
                    doWork(person);
                    continue;
                default:
                    break;
            }
            break;
        }


            //создаем объект, пункт 2

           // doWork(person); //вызываем doWork


    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
       /* switch (person.getClass().getSimpleName()){
            case "User":
                ((Person.User) person).live();
                break;
            case "Loser":
                ((Person.Loser) person).doNothing();
                break;
            case "Coder":
                ((Person.Coder) person).writeCode();
                break;
            case "Proger":
                ((Person.Proger) person).enjoy();
                break;
            default:
                break;
        }*/
        // пункт 3

    }
}
