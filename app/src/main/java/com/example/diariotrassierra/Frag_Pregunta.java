package com.example.diariotrassierra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_Pregunta extends Fragment {

    TextView pregunta;
    RadioGroup rg;
    private RadioButton rb1, rb2, rb3, rb4;
    private String p, r1, r2, r3, r4;

    public Frag_Pregunta() {

    }

    public static Frag_Pregunta newInstance(String preg, String resp1, String resp2, String resp3, String resp4) {
        Frag_Pregunta fragment = new Frag_Pregunta();
        Bundle args = new Bundle();
        args.putString("pregunta", preg);
        args.putString("respuesta1", resp1);
        args.putString("respuesta2", resp2);
        args.putString("respuesta3", resp3);
        args.putString("respuesta4", resp4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            p = getArguments().getString("pregunta");
            r1 = getArguments().getString("respuesta1");
            r2 = getArguments().getString("respuesta2");
            r3 = getArguments().getString("respuesta3");
            r4 = getArguments().getString("respuesta4");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pregunta, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Bindeamos el textView, radiogroup y los radioButton buscando dentro del fragmento
        pregunta = view.findViewById(R.id.tvPregunta);
        pregunta.setText(p);

        rg = view.findViewById(R.id.rg_respuestas);

        rb1 = view.findViewById(R.id.rb1);
        rb2 = view.findViewById(R.id.rb2);
        rb3 = view.findViewById(R.id.rb3);
        rb4 = view.findViewById(R.id.rb4);

        rb1.setText(r1);
        rb2.setText(r2);
        rb3.setText(r3);
        rb4.setText(r4);
    }

    @SuppressLint("NonConstantResourceId")
    public String getRespuesta(){
        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb1:
                return r1;
            case R.id.rb2:
                return r2;
            case R.id.rb3:
                return r3;
            case R.id.rb4:
                return r4;
            default:
                return "No hay respuesta";
        }
    }

}
