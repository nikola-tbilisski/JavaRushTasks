package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        //Tablet tablet = new Tablet(5);
        List<Tablet> tabletsList = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            Tablet tablet = new Tablet(i);
            tablet.setQueue(ORDER_QUEUE);
            tabletsList.add(tablet);
        }

        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(ORDER_QUEUE);
        Cook cook2 = new Cook("Albert");
        cook2.setQueue(ORDER_QUEUE);

//        StatisticManager.getInstance().register(cook1);
//        StatisticManager.getInstance().register(cook2);

//        for(Tablet tablet : tabletsList){
//            tablet.addObserver(orderManager);
//        }

        Thread cookThr1 = new Thread(cook1);
        Thread cookThr2 = new Thread(cook2);
        cookThr1.start();
        cookThr2.start();
        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletsList, ORDER_CREATING_INTERVAL));
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        Waiter waiter = new Waiter();
//        cook1.addObserver(waiter);
//        cook2.addObserver(waiter);
//        tablet.addObserver(cook);
//        cook1.addObserver(waiter);

//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();
//        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
