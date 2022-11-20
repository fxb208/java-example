package com.margo.project.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://www.cnblogs.com/black-fact/p/10958180.html
 * https://www.cnblogs.com/wyq178/p/9976815.html
 *   场景 :1,redis缓存淘汰策略     2,内存置换策略
 * @author fxb208
 *
 * @param <K>
 * @param <V>
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K,V>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义缓存的容量
    private int capacity;
    //带参数的构造器
    public LRULinkedHashMap(int capacity){
        //如果accessOrder为true的话，则会把访问过的元素放在链表后面，放置顺序是访问的顺序
    	//(LinkedHashMap里面的get方法，当accessOrder为true，会走afterNodeAccess方法将节点移到最后)
        //如果accessOrder为flase的话，则按插入顺序来遍历
        super(16,0.75f,true);
        //传入指定的缓存最大容量
        this.capacity=capacity;
    }
    //实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return size()>capacity;
    }
}
