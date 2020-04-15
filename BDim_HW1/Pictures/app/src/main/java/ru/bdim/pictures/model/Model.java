package ru.bdim.pictures.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private int arrayId;
    private List<Integer> frequencyList;

    public Model(int arrayId){
        this.arrayId = arrayId;
        frequencyList = new ArrayList<>();
    }

    public void initArray(int count) {
        for (int i = 0; i< count; i++){
            frequencyList.add(0);
        }
    }
    public int increase(int position) {
        frequencyList.set(position, frequencyList.get(position) + 1);
        return frequencyList.get(position);
    }
    public int getArrayId() {
        return arrayId;
    }
}