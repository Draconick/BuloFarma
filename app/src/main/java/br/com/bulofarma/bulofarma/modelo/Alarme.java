package br.com.bulofarma.bulofarma.modelo;

/**
 * Created by Katrina on 29/05/2016.
 */
public class Alarme {
    private int idBula;
    private String medicamento;
    private int hora, minuto;
    private int estado;


    public Alarme(String medicamento, int hora, int minutos) {
        idBula = 0;
        this.medicamento = medicamento;
        this.hora = hora;
        this.minuto = minutos;
        estado = 1;
    }
    public Alarme(int idBula, String medicamento, int hora, int minutos,int estado) {
        this.idBula = idBula;
        this.medicamento = medicamento;
        this.hora = hora;
        this.minuto = minutos;
        this.estado = estado;
    }
    public int getIdBula() {
        return idBula;
    }

    public void setIdBula(int idBula) {
        this.idBula = idBula;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
