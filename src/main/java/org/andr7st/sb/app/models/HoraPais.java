package org.andr7st.sb.app.models;


public class HoraPais {
	
    private String nombrePais;
    private String horaPais;

    public HoraPais() {
    }

    public HoraPais(String nombrePais, String horaPais) {
        this.nombrePais = nombrePais;
        this.horaPais = horaPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getHoraPais() {
        return horaPais;
    }

    public void setHoraPais(String horaPais) {
        this.horaPais = horaPais;
    }
}
