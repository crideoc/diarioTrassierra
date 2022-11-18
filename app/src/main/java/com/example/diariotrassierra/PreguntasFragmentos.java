package com.example.diariotrassierra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PreguntasFragmentos extends AppCompatActivity {

    ArrayList<Fragment>frag_preguntas;
    private int contador;
    TextView respuestas;
    View contenedor;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_fragmentos);

        respuestas=findViewById(R.id.txtRespuesta);
        contenedor=findViewById(R.id.contenedor);
        btnSiguiente=findViewById(R.id.btnSiguienteFragmento);

        respuestas.setVisibility(View.INVISIBLE);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuestas.append(R.string.pregunta+(contador+1)+": "+frag_preguntas.get(contador).getRespuesta()+"\n");
                if(++contador<frag_preguntas.size()){
                    cargaFragmento(contador);
                }if(contador==frag_preguntas.size()-1){
                    btnSiguiente.setText(R.string.ver_respuestas);
                }else if(contador==frag_preguntas.size()){
                    respuestas.setVisibility(View.VISIBLE);
                    contenedor.setVisibility(View.INVISIBLE);
                    btnSiguiente.setText(R.string.finalizar);
                }else if(contador>frag_preguntas.size()){
                    finishAffinity();
                }
            }
        });
    }
    private void cargaFragmento(int cuenta){
        FragmentTransaction transaction;
        transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor,frag_preguntas.get(cuenta));
        transaction.commit();
    }

    private void init(){
        frag_preguntas=new ArrayList<>();
        frag_preguntas.add(Frag_Pregunta.newInstance(
                R.string.pregunta1,

        ));
    }
}