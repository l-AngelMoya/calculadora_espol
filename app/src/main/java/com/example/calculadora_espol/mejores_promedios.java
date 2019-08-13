package com.example.calculadora_espol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class mejores_promedios extends AppCompatActivity {

    private TextView textViewMejoresAlumnos;
    final String URL = "https://www.fiec.espol.edu.ec/es/lista-excelencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejores_promedios);

        textViewMejoresAlumnos = (TextView) findViewById(R.id.textViewMejoresAlumnos);
        new Parsing(textViewMejoresAlumnos).execute(URL);
    }

}
