package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager(){

    }

    public List<Advertisement> getActiveInactiveVideoSet(boolean isActive){
        List<Advertisement> res = new ArrayList<>();

        for(Advertisement adv : storage.list()){
            if(!isActive ^ adv.isActive()){
                res.add(adv);
            }
        }
        return res;
    }
}
