package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Long> profitMap = statisticManager.getProfitMap();
        ArrayList<String> list = new ArrayList(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            double amount = 1.0 * profitMap.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Map<String, Integer>> cookWorkloadingMap = statisticManager.getCookWorkloadingMap();
        ArrayList<String> list = new ArrayList(cookWorkloadingMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            Map<String, Integer> cookMap = cookWorkloadingMap.get(key);
            System.out.println(key);

            ArrayList<String> cookNames = new ArrayList(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                System.out.println(cookName + " - " + ((cookMap.get(cookName) + 59) / 60) + " min");
            }

            System.out.println();
        }
    }


    public void printActiveVideoSet() {
        List<Advertisement> activeVideoSet = StatisticAdvertisementManager.getInstance().getActiveInactiveVideoSet(true);
        activeVideoSet.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        for(Advertisement adv : activeVideoSet){
            System.out.println(adv.getName() + " - " + adv.getHits());
        }

    }

    public void printArchivedVideoSet() {
        List<Advertisement> inactiveVideoSet = StatisticAdvertisementManager.getInstance().getActiveInactiveVideoSet(false);
        inactiveVideoSet.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        for(Advertisement adv : inactiveVideoSet){
            System.out.println(adv.getName());
        }
    }
}
