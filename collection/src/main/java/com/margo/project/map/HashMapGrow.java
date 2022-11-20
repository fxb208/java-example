package com.margo.project.map;

import java.util.HashMap;

public class HashMapGrow {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "东方不败");
        map.put(2, "东方不败");
        map.put(3, "东方不败");
        map.put(4, "东方不败");
        map.put(5, "东方不败");
        map.put(6, "东方不败");
        map.put(7, "东方不败");
        map.put(8, "东方不败");
        map.put(9, "东方不败");
        map.put(10, "东方不败");
        map.put(11, "东方不败");
        map.put(12, "东方不败");
        map.put(13, "东方不败");  //扩容
    }
}
