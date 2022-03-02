package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
//@XmlType(name = "shop")
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    @Override
    public String toString() {
        return "Shop{" + "\n"+
                "goods=" + goods + "\n"+
                ", count=" + count + "\n"+
                ", profit=" + profit + "\n" +
                ", secretData=" + Arrays.toString(secretData) +
                '}' +"\n";
    }

    public static class Goods {
        //@XmlElementWrapper(name = "names", nillable = true)
        @XmlElement
        public List<String> names = new LinkedList<>();

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names +
                    '}';
        }
    }
}
