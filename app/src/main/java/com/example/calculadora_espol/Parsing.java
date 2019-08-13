package com.example.calculadora_espol;



import android.os.AsyncTask;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Parsing extends AsyncTask<String, Void, String> {

    String info_parsing = "";
    private TextView textViewMejoresAlumnos;

    public Parsing(TextView information){
        this.textViewMejoresAlumnos = textViewMejoresAlumnos;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Document doc = Jsoup.connect(params[0]).get();
            Element tables = doc.select("table").get(0);
            Elements filas = tables.select("tr");
            for (int index = 1; index < filas.size(); index = index + 2){
                Element fila = filas.get(index);
                Element datos = fila.select("td").get(0);
                Element dato_c = datos.select("p").get(0);
                Element dato_e = datos.select("p").get(2);
                Element dato_p = datos.select("p").get(3);
                info_parsing = info_parsing + "######" + dato_c.ownText() + "\n\n" + dato_e.ownText() + " Promedio:  " + dato_p.ownText() + "\n\n\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info_parsing;
    }

    @Override
    protected void onPostExecute(String resultado) {
        super.onPostExecute(resultado);
        textViewMejoresAlumnos.setText(resultado);
    }
}
