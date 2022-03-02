package com.javarush.task.task27.task2712;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int orderInterval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int orderInterval) {
        this.tablets = tablets;
        this.orderInterval = orderInterval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int randomTabletIndex = ThreadLocalRandom.current().nextInt(tablets.size());
                Tablet randTablet = tablets.get(randomTabletIndex);
                randTablet.createTestOrder();
                Thread.sleep(orderInterval);
            }
        } catch (InterruptedException e) {
        }
    }
}
