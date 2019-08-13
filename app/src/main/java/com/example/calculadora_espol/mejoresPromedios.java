package com.example.calculadora_espol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.calculadora_espol.Modelo;
import com.example.calculadora_espol.Parsing;


public class mejoresPromedios extends AppCompatActivity{

    private TextView headlineTextView;
    private TextView articleTextView;
    private TextView errorMessageTextView;
    private EditText cajaTexto;
    private Button boton;
    private Button botonl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejores_promedios);

       /* headlineTextView = (TextView) findViewById(R.id.headline);
        articleTextView = (TextView) findViewById(R.id.article);
        cajaTexto = (EditText) findViewById(R.id.editText);
        boton = (Button) findViewById(R.id.scrapear);
        botonl = (Button) findViewById(R.id.limpiar);*/
        //Execute AsyncTask for Parsing HTML


        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ejecutar(cajaTexto.getText().toString());
            }
        });
        botonl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                headlineTextView.setText("");
                articleTextView.setText("La página a scrapear debe poseer en su html la etiqueta meta property=og:title y property=og:description, por ejemplo https://www.harvard.edu o http://web.mit.edu");
                cajaTexto.setText("http://");
                Toast.makeText(getApplicationContext(),"Ha pulsado limpiar",Toast.LENGTH_SHORT).show();
            }
        });



    }
    public void ejecutar(String url){
        Toast.makeText(getApplicationContext(),"Estás intentando scrapear el url: "+url,Toast.LENGTH_SHORT).show();
       // new Parsing(this).execute(url);
    }

    public void onParsingDone(Modelo articleModel) {

        if(articleModel!=null){
            //headlineTextView.setText(articleModel.getHeadline());
            //articleTextView.setText(asrticleModel.getArticle());
        }
        else
            headlineTextView.setText("Esto es un título por defecto");
        Toast.makeText(getApplicationContext(),"No se ha podido scrapear, revise sus etiquetas",Toast.LENGTH_SHORT).show();
    }

}
