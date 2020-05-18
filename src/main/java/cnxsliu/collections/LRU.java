package cnxsliu.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/17 15:40
 * @strategy 使用链表 + HashMap 来实现 LRU
 * 当需要插入新的数据项的时候，如果新数据项在链表中存在（一般称为命中），则把该节点移到链表头部，
 * 如果不存在，则新建一个节点，放到链表头部，若缓存满了，则把链表最后一个节点删除即可。
 * 在访问数据的时候，如果数据项在链表中存在，则把该节点移到链表头部，否则返回-1。
 * 这样一来在链表尾部的节点就是最近最久未访问的数据项。
 */
public class LRU<K, V> {
    private static final float HASH_LOAD_FACTORY = 0.75f;
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int) Math.ceil(cacheSize / HASH_LOAD_FACTORY) + 1;
        map = new LinkedHashMap<K, V>(capacity, HASH_LOAD_FACTORY, true) {
            private static final long serialVersionUID = 1;
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > cacheSize;
            }
        };
    }
    
    public synchronized V get(K key) {
        return map.get(key);
    }
    
    public synchronized void put (K key, V value) {
        map.put(key, value);
    }
    
    public synchronized void clear () {
        map.clear();
    }
    
    public  synchronized int usedSize() {
        return map.size();
    }
    
    public void print () {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getValue() + "--");
        }
        System.out.println();
    }
}
