package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/
//class Adapter + HashMap + String.format()

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeData myData = new IncomeData()
            {
                @Override
                public String getCountryCode()
                    {
                        return "CA";
                    }

                @Override
                public String getCompany()
                    {
                        return "JavaRush Ltd.";
                    }

                @Override
                public String getContactFirstName()
                    {
                        return "Ivan";
                    }

                @Override
                public String getContactLastName()
                    {
                        return "Ivanov";
                    }

                @Override
                public int getCountryPhoneCode()
                    {
                        return 38;
                    }

                @Override
                public int getPhoneNumber()
                    {
                        return 501234567;
                    }
            };

        Customer customer = new IncomeDataAdapter(myData);
        Contact contact = new IncomeDataAdapter(myData);

        System.out.println(customer.getCompanyName());
        System.out.println(customer.getCountryName());
        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data)
            {
                this.data = data;
            }

            //Contact functions.
        @Override
        public String getName()
            {
                return String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
            }

        @Override
        public String getPhoneNumber()
            {
                String phone = String.format("%010d",data.getPhoneNumber());
                return String.format("+%d(%s)%s-%s-%s", data.getCountryPhoneCode(), phone.substring(0, 3), phone.substring(3, 6),phone.substring(6, 8), phone.substring(8, 10));
            }

            //Customer functions.
        @Override
        public String getCompanyName()
            {
                return data.getCompany();
            }

        @Override
        public String getCountryName()
            {
                String country = null;
                
                for(Map.Entry<String, String> entry: countries.entrySet()){
                    if(data.getCountryCode().equals(entry.getKey())){
                        country = entry.getValue();
                    }
                }
                
                return country;
            }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}