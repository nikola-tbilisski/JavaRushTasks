package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    List<Entry<String>> elementList = new LinkedList<>();

    private int elementListSize = 0;

    public CustomTree() {
        this.root = new Entry<>("0");
        root.parent = this.root;
        elementList.add(root.parent);
    }

    @Override
    public int size() {
        return elementList.size() - 1;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        return super.set(index, element);
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> entry = new Entry<>(elementName);

        for (Entry<String> currentEntry : elementList) {
            if (currentEntry.isAvailableToAddChildren()) {
                if (currentEntry.availableToAddLeftChildren) {
                    currentEntry.leftChild = entry;
                    //childList.add(currentEntry.leftChild);
                    currentEntry.availableToAddLeftChildren = false;
                    entry.parent = currentEntry;
                    elementList.add(entry);
                    elementListSize++;
                    return true;
                } else if (currentEntry.availableToAddRightChildren) {
                    currentEntry.rightChild = entry;
                    //childList.add(currentEntry.rightChild);
                    currentEntry.availableToAddRightChildren = false;
                    entry.parent = currentEntry;
                    elementList.add(entry);
                    elementListSize++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object elementToRemove) {
        if(!(elementToRemove instanceof String)){
            throw new UnsupportedOperationException();
        }
        Entry<String> removeElement = getElementByName(elementToRemove.toString());
        Entry<String> parentOfRemElement = removeElement.parent;

        if(!removeElement.availableToAddLeftChildren){
            remove(removeElement.leftChild.elementName);
        }
        if(!removeElement.availableToAddRightChildren){
            remove(removeElement.rightChild.elementName);
        }

        if(removeElement.rightChild == null && removeElement.leftChild == null){
            if(parentOfRemElement.leftChild == removeElement){
                parentOfRemElement.leftChild = null;
                parentOfRemElement.availableToAddLeftChildren = true;
            } else {
                parentOfRemElement.rightChild = null;
                parentOfRemElement.availableToAddRightChildren = true;
            }
            elementList.remove(removeElement);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }

    public String getParent(String elName) {
        String parent = null;

        for (Entry<String> stringEntry : elementList) {
            if (stringEntry.elementName.equals(elName)) {
                parent = stringEntry.parent.elementName;
            }
        }

        return parent;
    }

    public Entry<String> getElementByName(String name){
        for(Entry<String> el : elementList){
            if(el.elementName.equals(name)) return el;
        }
        return null;
    }

    public List<String> getChildren(String elName){
        List<String> childList = new LinkedList<>();
        String childLeft;
        String childRight;

        for(Entry<String> entry : elementList){
            if(entry.elementName.equals(elName)){
                childLeft = entry.leftChild.elementName;
                childRight = entry.rightChild.elementName;
                childList.add(childLeft);
                childList.add(childRight);
            }
        }
        return childList;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String str) {
            this.elementName = str;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren | availableToAddRightChildren);
        }
    }
}
