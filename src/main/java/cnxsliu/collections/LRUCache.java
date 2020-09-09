package cnxsliu.collections;

/**
 * @author cnxsliu
 * @date 2020/8/30 18:33
 */
public interface LRUCache<E, T> {

    /**
     * 获取元素
     * @param key key
     * @return T
     */
    T get(E key);

    /**
     * 添加元素
     * @param key key
     * @param value value
     */
    void put(E key, T value);
}
