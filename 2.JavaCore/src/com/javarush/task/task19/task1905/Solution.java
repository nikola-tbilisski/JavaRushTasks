package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/
//Class Adapter + HashMap + Regular Expression + replaceAll() + split()

public class Solution {
    public static Map<String, String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Contact contact = new Contact()
            {
                @Override
                public String getName()
                    {
                        return "Goncalo, Boris";
                    }

                @Override
                public String getPhoneNumber()
                    {
                        return "+38(050)123-45-67";
                    }
            };

        Customer customer = new Customer()
            {
                @Override
                public String getCompanyName()
                    {
                        return "Kvanto& comp.";
                    }

                @Override
                public String getCountryName()
                    {
                        return "Russia";
                    }
            };

        RowItem rowItem = new DataAdapter(customer, contact);
        System.out.println(rowItem.getContactFirstName());
        System.out.println(rowItem.getContactLastName());
        System.out.println(rowItem.getDialString());
        System.out.println(rowItem.getCountryCode());
        System.out.println(rowItem.getCompany());


    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }


        @Override
        public String getCountryCode()
            {
                String countryCode = null;

                for(Map.Entry<String, String> entry: countries.entrySet()){
                    if(customer.getCountryName().equals(entry.getValue())){
                        countryCode = entry.getKey();
                    }
                }

                return countryCode;
            }

        @Override
        public String getCompany()
            {
                return customer.getCompanyName();
            }

        @Override
        public String getContactFirstName()
            {
                return contact.getName().split(",\\s")[1];
            }

        @Override
        public String getContactLastName()
            {
                return contact.getName().split(",\\s")[0];
            }

        @Override
        public String getDialString()
            {
                return "callto://+" + contact.getPhoneNumber().replaceAll("\\D", "");
            }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}