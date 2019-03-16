package com.smart.gym;

public class Soporte_Asistencias {

    private int id;
    private String name;


    public Soporte_Asistencias(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString(){
        return name;
    }





    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}

