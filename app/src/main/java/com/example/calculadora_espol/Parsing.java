package com.example.calculadora_espol;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.example.calculadora_espol.Modelo;

import java.io.IOException;


public class Parsing extends AsyncTask<String, Void, Modelo> {


    @Override
    protected Modelo doInBackground(String... params) {

        String url = params[0];
        Modelo articleModel = null;

        String headline;
        String article = "";

        Document pageDocument;
        Elements elements;
        Elements articleElements;
        String desc;
        String titulo;

        try {
            pageDocument = Jsoup.connect(url).get();
            elements = pageDocument.select("meta[property=og:description]");
            desc = elements.attr("content");
            elements = pageDocument.select("meta[property=og:title]");
            titulo = elements.attr("content");

            articleModel = new Modelo(titulo, desc);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return articleModel;
    }


}
