package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Leetcode1207 {
    //用哈希表存入每个数出现的次数
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> m = new HashMap<>();   //创建哈希表
        for (int i = 0; i < arr.length; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1); //如果哈希表内存在这个数，
                                                                // 就使这个数的value加1
                                                                //不存在这个数，就存入这个数，并默认为0+1
        }
        System.out.println(m.size());
        return m.size() == new HashSet<>(m.values()).size();//用set把重复的数去掉，如果最后set大小等于map大小
                                                            //说明每个数字出现的次数都是独一无二的
    }
}
