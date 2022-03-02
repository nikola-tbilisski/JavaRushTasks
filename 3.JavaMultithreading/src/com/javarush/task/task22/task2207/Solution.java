package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        List<String> wList = new ArrayList<>();
        String line;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));){
            while (fileReader.ready()){
                wList.addAll(Arrays.asList(fileReader.readLine().split("\\s+")));
            }
        } catch (IOException e){
                e.printStackTrace();
        }
        //System.out.println(wList);

        for(int i = 0; i < wList.size(); i++){
            for(int j = i + 1; j < wList.size(); j++){
                StringBuilder sb = new StringBuilder(wList.get(j));
                if(!wList.get(i).isEmpty() && wList.get(i).equals(sb.reverse().toString())){
                    Pair tmpPair = new Pair();
                    tmpPair.first = wList.get(i);
                    tmpPair.second = wList.get(j);
                    result.add(tmpPair);
                    wList.set(i, "");
                    wList.set(j, "");
                    break;
                }
            }
        }
        for(Pair p: result){
            System.out.println(p);
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
