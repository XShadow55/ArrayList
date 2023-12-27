package com.example.MethodArrayList;

import java.util.Stack;

public class StringListImp implements StringList{
    private Integer size = 10;
    private Stack<String > list = new Stack<>();
    private Stack<String > list1 = new Stack<>();



    @Override
    public String add(String item) {
        list.push(item);
        return item;
    }

    @Override
    public String add(int index, String item) throws ListFullException {
        int in = list.size();
        if (list.empty()){
            list.push(item);
        }
        else {
            while (index < in) {
                list1.push(list.peek());
                in -= 1;
                if (in == index) {
                    list.push(item);
                }
            }
            while (!list1.empty()) {
                list.push(list1.peek());
            }
            if (list.size() > size) {
                throw new ListFullException();
            }
        }

        return item;
    }

    @Override
    public String set(int index, String item)throws IndexIsOutOfArray {
        int in = list.size();
        if (index > size) {
            throw new IndexIsOutOfArray();
        }
        while (index < in){

            if (in == index){
                list.pop();
                list.push(item);
                break;
            }

            list1.push(list.peek());

            in -=1;
        }
        while (!list1.empty()) {
            list.push(list1.peek());
        }
        return item;
    }

    @Override
    public String remove(String item) throws ObjectNotFound {

        while (!list.empty()){

            if (list.peek().equals(item)){
                list.pop();
                break;
            }

            list1.push(list.peek());


        }
        if (list.empty()){
            throw new ObjectNotFound();
        }
        while (!list1.empty()) {
            list.push(list1.peek());
        }
        return item;
    }

    @Override
    public String remove(int index) throws  ObjectNotFound {
        int in = list.size();
        String item = null;
        if (list.empty() || index > in){
            throw new ObjectNotFound();
        }
        else {
            while (index < in) {

                if (in == index) {
                    item = list.peek();
                    list.pop();
                }
                list1.push(list.peek());
                in -= 1;
            }
            while (!list1.empty()) {
                list.push(list1.peek());
            }

        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        boolean search = false;
        while (!list.empty()){

            if (list.peek().equals(item)){
                search = true;
                break;
            }

            list1.push(list.peek());


        }

        while (!list1.empty()) {
            list.push(list1.peek());
        }
        return search;
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        while (!list.empty()){

            if (list.peek().equals(item)){
                index = list.size()-1;
                break;
            }

            list1.push(list.peek());


        }
        while (!list1.empty()) {
            list.push(list1.peek());
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        while (!list.empty()){

            if (list.peek().equals(item)){
                index = list.size()-1;
                break;
            }

            list1.push(list.peek());


        }
        while (!list1.empty()) {
            list.push(list1.peek());
        }
        return index;
    }

    @Override
    public String get(int index) {
        String item = null;
        int in = list.size();
        if (index > size) {
            throw new IndexIsOutOfArray();
        }
        while (index < in){

            if (in == index){
                item = list.peek();
                break;
            }

            list1.push(list.peek());

            in -=1;
        }
        while (!list1.empty()) {
            list.push(list1.peek());
        }
        return item;

    }

    @Override
    public boolean equals(StringList otherList) {
        return list.equals(otherList);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        if (list.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        list.clear();

    }

    @Override
    public String[] toArray() {
        return list.toArray(new String[0]);
    }
}
