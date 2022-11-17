package com.example.diariotrassierra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActitivyDatos extends AppCompatActivity {

    Spinner spCiudades;
    EditText txtEdad;
    RadioButton rdnHombre;
    RadioButton rdnMujer;
    RadioButton rdnOtro;
    Button btnSiguiente;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actitivy_datos);

        spCiudades=findViewById(R.id.spCiudades);
        txtEdad=findViewById(R.id.txtEdad);
        rdnHombre=findViewById(R.id.rdnHombre);
        rdnMujer=findViewById(R.id.rdnMujer);
        rdnOtro=findViewById(R.id.rdnOtro);
        btnSiguiente=findViewById(R.id.btnSiguiente);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.lista, android.R.layout.simple_list_item_1);
        spCiudades.setAdapter(adapter);



        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;

                String datos[]=new String[3];

                datos[0]=txtEdad.getText().toString();
                datos[2]=spCiudades.getSelectedItem().toString();

                datos[1]=EleccionRadioGroup();
                if(datos[1]==""){
                    toast=Toast.makeText(ActitivyDatos.this,"Escoge un genero",Toast.LENGTH_LONG);
                    toast.show();
                }else if(datos[0].length()==0){
                    toast=Toast.makeText(ActitivyDatos.this,"La edad debe de estar rellena",Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    Intent intent=new Intent(ActitivyDatos.this,ActivityConfirmacion.class);
                    intent.putExtra("datos",datos);
                    //recibe
                    //ArrayList<String> datos = (ArrayList<String>) getIntent().getSerializableExtra("datos");

                }

            }

            private String EleccionRadioGroup() {
                String elegido;

                if(rdnHombre.isChecked()){
                    elegido="Hombre";
                }else if(rdnMujer.isChecked()){
                    elegido="Mujer";
                }else if(rdnOtro.isChecked()){
                    elegido="Otro";
                }else{
                    elegido="";
                }


                return elegido;
            }
        });

    }
}