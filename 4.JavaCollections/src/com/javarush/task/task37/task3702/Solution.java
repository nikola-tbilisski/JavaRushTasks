package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class Solution {
    public static void main(String[] args) {
        //Abstract Factory implementation.
        AbstractFactory factory = FactoryProducer.getFactory(FactoryProducer.HumanFactoryType.FEMALE);
        useFactory(factory);

        factory = FactoryProducer.getFactory(FactoryProducer.HumanFactoryType.MALE);
        useFactory(factory);

        //Factory Method implementation
//        MaleFactory maleFactory = new MaleFactory();
//        System.out.println(maleFactory.getPerson(99));
//        System.out.println(maleFactory.getPerson(4));
//        System.out.println(maleFactory.getPerson(15)+"\n");
//
//        FemaleFactory femaleFactory = new FemaleFactory();
//        System.out.println(femaleFactory.getPerson(99));
//        System.out.println(femaleFactory.getPerson(4));
//        System.out.println(femaleFactory.getPerson(15));

    }

    public static void useFactory(AbstractFactory factory) {
        System.out.println(factory.getPerson(99));
        System.out.println(factory.getPerson(4));
        System.out.println(factory.getPerson(15)+"\n");
    }

}
