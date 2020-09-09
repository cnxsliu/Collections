package cnxsliu.collections;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 直接利用 LinkedHashMap 的 removeEldestEntry 来实现
 * @author cnxsliu
 * @date 2020/8/30 18:32
 */
public class LRUCacheImpl<E, T> implements LRUCache<E, T>{

    private LinkedHashMap<E, T> linkedHashMap = null;

    public LRUCacheImpl(int capacity) {
        linkedHashMap = new LinkedHashMap<E, T>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Entry<E, T> oldest) {
                return size() > capacity;
            }
        };
    }

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public T get(E key) {
        lock.readLock().lock();
        T value = linkedHashMap.get(key);
        lock.readLock().unlock();;
        return value;
    }

    @Override
    public void put(E key, T value) {
        lock.writeLock().lock();
        linkedHashMap.put(key, value);
        lock.writeLock().unlock();
    }
}
