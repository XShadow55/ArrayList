package com.example.MethodArrayList.servis.impl;

import com.example.MethodArrayList.exeption.*;
import com.example.MethodArrayList.servis.StringList;

import java.util.Arrays;

public class StringListImp implements StringList {
    private Integer size = 0;
    private String[] list = new String[10];



    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        list[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) throws ListFullException {
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
    public String set(int index, String item)throws IndexIsOutOfArray {
        if (index > size) {
            throw new IndexIsOutOfArray();
        }

        list[index] = item;
        return item;

    }

    @Override
    public String remove(String item) throws ObjectNotFound {
        validateItem(item);
        if (!contains(item)){
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
    public String remove(int index) throws  ObjectNotFound {
        validateIndex(index);
        String item = list[index];
        if (index != size){
            System.arraycopy(list,index+1,list,index,size-index);
            return item;
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i  = 0;i <size;i++){
            String string = list[i];
            if(string.equals(item)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i  = size-1;i >=0;i--){
            String string = list[i];
            if(string.equals(item)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public String get(int index) throws IndexIsOutOfArray{
        if (index > size){
            throw new IndexIsOutOfArray();
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        return Arrays.copyOf(list,size);
    }
    private void validateItem(String item){
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
}
