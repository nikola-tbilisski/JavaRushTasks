package com.javarush.task.task32.task3211;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(byteArrayOutputStream.toByteArray());

        byte[] digest = md.digest();
        //System.out.println(Arrays.toString(digest));

//        StringBuilder hexStr = new StringBuilder();
//
//        for (byte b : digest) {
//            hexStr.append(Integer.toHexString(0xFF & b));
//        }
        byte[] md5Hash = DatatypeConverter.parseHexBinary(md5);

        //System.out.println(hexStr);

        return Arrays.equals(digest, md5Hash);
    }
}
