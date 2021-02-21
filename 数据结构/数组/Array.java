package 数据结构.数组;

public class Array {
    private int[] data;
    private int size;

    /**
     *
     * @param capacity
     */
    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }
    //获取数组中元素个数
    public int getSize(){
        return size;
    }
    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }
    //判断数组为空
    public boolean isEmpty(){
        return size==0;
    }
    public void addLast(int e){
        add(size,e);
    }
    private void addFirst(int e){
        add(0,e);
    }
    public void add(int index,int e){
        if(size  == data.length){
            throw new IllegalArgumentException("AddLast failed.Array is full .");
        }
        if(index<0||index > size){
            throw new IllegalArgumentException("AddLast failed.Array is full .");
        }
        for(int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
}
