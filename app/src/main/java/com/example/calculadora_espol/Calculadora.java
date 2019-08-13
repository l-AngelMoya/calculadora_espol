package com.example.calculadora_espol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {
    private EditText editTextPorcentajeTeorico;
    private EditText editTextPrimerParcial;
    private EditText editTextSegundoParcial;
    private EditText editTextMejoramiento;
    private EditText editTextPorcentajePractico;
    private EditText editTextPractica;
    private TextView textViewEstado;
    private TextView textViewPromedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        editTextPorcentajeTeorico = (EditText) findViewById(R.id.editTextPorcentajeTeorico);
        editTextPrimerParcial = (EditText) findViewById(R.id.editTextPrimerParcial);
        editTextSegundoParcial = (EditText) findViewById(R.id.editTextSegundoParcial);
        editTextMejoramiento = (EditText) findViewById(R.id.editTextMejoramiento);
        editTextPorcentajePractico = (EditText) findViewById(R.id.editTextPorcentajePractico);
        editTextPractica = (EditText) findViewById(R.id.editTextPractica);
        textViewEstado = (TextView) findViewById(R.id.textViewEstado);
        textViewPromedio = (TextView) findViewById(R.id.textViewPromedio);
    }

    public void llenarPorcentajePractica(View v){
        double porcentajeTeorico = Double.parseDouble(editTextPorcentajeTeorico.getText().toString());
        double porcentajePracticaTemp =100-porcentajeTeorico;
        editTextPorcentajePractico.setText(String.valueOf(porcentajePracticaTemp));
    }

    public void calcularPromedio(View v){
        double porcentajeTeorico = Double.parseDouble(editTextPorcentajeTeorico.getText().toString());
        double primerParcial = Double.parseDouble(editTextPrimerParcial.getText().toString());
        double segundoParcial = Double.parseDouble(editTextSegundoParcial.getText().toString());
        double mejoramiento = Double.parseDouble(editTextMejoramiento.getText().toString());
        double porcentajePractico = Double.parseDouble(editTextPorcentajePractico.getText().toString());
        double notaPractica = Double.parseDouble(editTextPractica.getText().toString());

        //public Promedio(double porcentajePractico, double porcentajeTeorico, double notaPractica, double primerParcial, double segundoParcial, double mejoramiento ){
        Promedio pr = new Promedio(porcentajePractico,porcentajeTeorico,notaPractica,primerParcial,segundoParcial, mejoramiento);
        double promedioFinal = pr.obtenerPromedioFinal();

        textViewPromedio.setText(String.valueOf(promedioFinal));

        if (promedioFinal >= 60) {
            textViewEstado.setText("APROBASTE");
        } else {
            textViewEstado.setText("REPROBASTE");
        }
    }
}
