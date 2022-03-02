package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети calculate net address with ip & subnet mask (ArrayList BigInteger String.join() substring())
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAdr = new byte[ip.length];
       for(int i = 0; i < ip.length; i++){
           netAdr[i] = (byte) (ip[i] & mask[i]);
       }

        return netAdr;
    }

    public static void print(byte[] bytes) {
        List<String> resList = new ArrayList<>();
        String strIP = new BigInteger(1,bytes).toString(2);
        int index = 0, blockSize = 8;

        while (index < strIP.length()) {
            resList.add(strIP.substring(index, Math.min(index + blockSize, strIP.length())));
            index += blockSize;
        }
        System.out.println(String.join(" ", resList));
    }
}
