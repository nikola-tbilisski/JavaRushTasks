package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

  /*  @Override
    public synchronized int compareTo(Beach o)
        {
            int res, cof1, cof2;
            res = this.name.compareTo(o.name);
            if (res == 0) return 0;

            cof1 = (this.quality + (int) this.distance);
            cof2 = (o.quality + (int) o.distance);
            return Integer.compare(cof1, cof2);
        }*/
    @Override
    public synchronized int compareTo(Beach obj) {
        int distanceParam = (int) (distance - obj.getDistance());
        int qualityParam = quality - obj.getQuality();
        return 10000 * name.compareTo(obj.getName()) + 100 * distanceParam + qualityParam;
    }

    public static void main(String[] args) {
        Beach malibu = new Beach ("Malibu", 19,10);
        Beach sochi = new Beach("Sochi", 10,15);
        System.out.println(malibu.compareTo(sochi));

    }
}
