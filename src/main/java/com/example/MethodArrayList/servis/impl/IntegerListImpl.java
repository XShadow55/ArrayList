package com.example.MethodArrayList.servis.impl;

import com.example.MethodArrayList.exeption.*;
import com.example.MethodArrayList.servis.IntegerList;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer size = 0;
    private final Integer[] getList = new Integer[10];
    private Integer[] list = sortInsertion(getList);



    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        list[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) throws ListFullException {
        validateItem(item);
        validateSize();
        validateIndex(index);
        if (index==size){
            list[size++] = item;
            return item;
        }

        System.arraycopy(list,index,list,index+1,size-index);
        list[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item)throws IndexIsOutOfArray {
        if (index > size) {
            throw new IndexIsOutOfArray();
        }

        list[index] = item;
        return item;

    }

    @Override
    public Integer remove(Integer item) throws ObjectNotFound {
        validateItem(item);
        if (!contains(list,item)){
            throw new ObjectNotFound();
        }
        int index = indexOf(item);
        if (index != size){
            System.arraycopy(list,index+1,list,index,size-index);
            return item;
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) throws  ObjectNotFound {
        validateIndex(index);
        Integer item = list[index];
        if (index != size){
            System.arraycopy(list,index+1,list,index,size-index);
            return item;
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer[] arr,Integer element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i  = 0;i <size;i++){
            Integer string = list[i];
            if(string.equals(item)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i  = size-1;i >=0;i--){
            Integer string = list[i];
            if(string.equals(item)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public Integer get(int index) throws IndexIsOutOfArray{
        if (index > size){
            throw new IndexIsOutOfArray();
        }
        return list[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(list,size);
    }
    private void validateItem(Integer item){
        if(item == null){
            throw new ObjectIsNull();
        }
    }
    private void validateSize(){
        if(size == list.length){
            throw new ListFullException();
        }
    }
    private void validateIndex(int index){
        if(index > list.length || index<0){
            throw new InvalidIndexException();
        }
    }
    public static Integer[] sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }
}
