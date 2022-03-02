package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {
    public enum HumanFactoryType {
        MALE, FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType hft){
        AbstractFactory af = null;

        if(hft.equals(HumanFactoryType.MALE)) af = new MaleFactory();
        else if(hft.equals(HumanFactoryType.FEMALE)) af = new FemaleFactory();

        return af;
    }
}
