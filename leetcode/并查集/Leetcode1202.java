package leetcode.并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }
        UnionFind uf = new UnionFind(s.length());
        for (int i = 0; i < pairs.size(); i++) {
            int a = pairs.get(i).get(0);
            int b = pairs.get(i).get(1);
            uf.union(a,b);
        }
        Map<Integer, PriorityQueue<Character>> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmpChar = s.charAt(i);
            int tmp = uf.find(i);
            if(m.containsKey(tmp)){
                m.get(tmp).offer(tmpChar);
            }else{
                PriorityQueue<Character> pq = new PriorityQueue<>();
                pq.offer(tmpChar);
                m.put(tmp,pq);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            sb.append(m.get(root).poll());
        }
        return sb.toString();
    }
    static class UnionFind{
        private int[] parent;
        private int[] rank;
        public UnionFind(int size){
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x){
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x,int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot==yRoot){
                return;
            }
            if(rank[xRoot]==rank[yRoot]){
                parent[xRoot] = yRoot;
                rank[yRoot] = rank[yRoot]+1;
            }else if(rank[xRoot]<rank[yRoot]){
                parent[xRoot] = yRoot;
            }else{
                parent[yRoot] = xRoot;
            }
        }
    }
}
