package com.smart.gym;

public class Soporte_Pagos {

    private int id;
    private String fecha;
    private String pago;


    public Soporte_Pagos(int id, String fecha, String pago){
        super();
        this.id = id;
        this.fecha = fecha;
        this.pago = pago;
    }


    @Override
    public String toString(){
        return fecha;
    }






    public int getId(){
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPago() {
        return pago;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

}

