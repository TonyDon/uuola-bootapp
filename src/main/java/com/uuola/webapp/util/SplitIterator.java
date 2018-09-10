

package com.uuola.webapp.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * <pre>
 * 带有泛型参数的List&lt;E&gt;批次遍历器
 * @author tangxiaodong
 * 创建日期: 2014年9月30日
 * </pre>
 */
public class SplitIterator<E> implements Iterator<List<E>> {

    /**
     * 将每次获取批次集合的大小
     */
    private int batchSize;
    
    /**
     * 引用原始集合List
     */
    private List<E> srcList;
    
    
    private int index = 0;
    
    private int size = 0;
    
    /**
     * 返回子结果List
     */
    private List<E> result;

    public SplitIterator(List<E> srcList, int batchSize) {
        if (0 >= batchSize) {
            throw new RuntimeException(
                    "Please do not be set less than or equal to '0' for GenericBatchIterator's batchSize !");
        }
        this.batchSize = batchSize;
        this.srcList = srcList;
        this.size = null == srcList ? 0 : srcList.size();
        result = new ArrayList<E>(batchSize);
    }

    /**
     * 是否可以获取到下一个批次集合
     */
    @Override
    public boolean hasNext() {
        return index < size;
    }

    /**
     * 得到下一个批次集合
     */
    @Override
    public List<E> next() {
        result.clear();
        for (int i = 0; i < batchSize && index < size; i++) {
            result.add(srcList.get(index++));
        }
        return result;
    }

    /**
     * 暂不支持移除子集合方法
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 带有泛型参数的List集合批次遍历器，非线程安全，next()一旦调用，上次的引用对应结果将清空<br/>
     * 构建一个分批迭代器
     * @param srcList
     * @param batchSize
     * @return 分批迭代器
     */
    public static <E> Iterator<List<E>> make(List<E> srcList, int batchSize) {
        return new SplitIterator<E>(srcList, batchSize);
    }
}
