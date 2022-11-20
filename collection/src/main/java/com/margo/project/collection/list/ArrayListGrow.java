package com.margo.project.collection.list;

import java.util.ArrayList;

/**
 * ArrayList
 */
public class ArrayListGrow {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);  // grow,   Object[] elementData   length = 10
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11); // grow,   Object[] elementData   length = 10 + 10>>1 = 15

        arrayList.remove(12);
    }
}
