package ru.bdim.gluetextmoxy.model;

public class Model {
    private String text;

    public Model(){
        text = "";
    }

    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
}