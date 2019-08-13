package com.example.calculadora_espol;

public class Promedio {
    private double porcentajePractico;
    private double porcentajeTeorico;
    private double notaPractica;
    private double primerParcial;
    private double segundoParcial;
    private double mejoramiento;



    public Promedio(double porcentajePractico, double porcentajeTeorico, double notaPractica, double primerParcial, double segundoParcial, double mejoramiento ){
        this.porcentajePractico=porcentajePractico;
        this.porcentajeTeorico=porcentajeTeorico;
        this.notaPractica=notaPractica;
        this.primerParcial=primerParcial;
        this.segundoParcial=segundoParcial;
        this.mejoramiento=mejoramiento;
    }


    public double obtenerPromedioFinal(){
        double promedioTeo= (this.primerParcial+this.segundoParcial+this.mejoramiento-Math.min(Math.min(this.primerParcial,this.segundoParcial),this.mejoramiento))/2;
        double ponderacionTeorica=(promedioTeo*porcentajeTeorico)/100;
        double ponderacionPractica= this.notaPractica*porcentajePractico/100;
        double promedioFinal=ponderacionPractica+ponderacionTeorica;
        return  promedioFinal;
    }

}

