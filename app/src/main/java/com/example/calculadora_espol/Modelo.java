package com.example.calculadora_espol;

public class Modelo {


    private String carrera;
    private String estudiante;

    public Modelo(String carrera, String estudiante) {
        this.carrera = carrera;
        this.estudiante = estudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getEstudiante() {
        return estudiante;
    }
}
