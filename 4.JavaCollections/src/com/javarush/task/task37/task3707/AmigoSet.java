package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private final static long serialVersionUID = 1L;
    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>(Math.max(16, (int) (Math.ceil(collection.size()) / .75f) + 1));
        addAll(collection);
    }

    public boolean add(E e) {
        return this.map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> set = (AmigoSet<E>) super.clone();
            set.map = (HashMap<E, Object>) map.clone();
            return set;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(HashMapReflectionHelper.<Integer>callHiddenMethod(map, "capacity"));
        oos.writeFloat(HashMapReflectionHelper.<Float>callHiddenMethod(map, "loadFactor"));
        oos.writeInt(map.size());

        for (E e : map.keySet())
            oos.writeObject(e);
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        int mapSize = ois.readInt();

        for (int i = 0; i < mapSize; i++) {
            E e = (E) ois.readObject();
            map.put(e, PRESENT);
        }

    }
}
