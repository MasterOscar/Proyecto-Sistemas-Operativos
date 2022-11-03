package com.example.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText txtNumeros;

    private  TextView txt1;
    private ImageButton imgAlerta;
    private ImageButton imgInfo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgInfo = (ImageButton) findViewById(R.id.imgInfo);
        imgAlerta = (ImageButton) findViewById(R.id.imgAlerta);
        imgAlerta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("¿Desea Salir de la Aplicacion?")
                        .setCancelable(false).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Salida");
                titulo.show();

            }
        });
        imgInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AlertDialog.Builder info = new AlertDialog.Builder(MainActivity.this);
                info.setMessage("Ingrese numeros separados de una coma luego presione el boton para ver el algoritmo").
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog Titulo = info.create();
                Titulo.setTitle("Como Usar");
                Titulo.show();
            }
        });


        txtNumeros = findViewById(R.id.txtNumeros);
        txt1 = findViewById(R.id.txt1);

    }

    public void Ordenar(View view){
        String[] ListaNumeros = txtNumeros.getText().toString().split(",");
        Integer[] numeros = new Integer[ListaNumeros.length];

        for(int i=0; i<ListaNumeros.length; i++){
            numeros[i] = Integer.parseInt(ListaNumeros[i]);
        }
        OrdenamientoBurbuja(numeros,numeros.length); //al azar

        txt1.setText(Arrays.toString(numeros));




    }

    private void OrdenamientoBurbuja(Integer[] numeros, int length){
            if(length<2){
                return;
            }
            for (int i = 0;i<length-1;i++){
                if(numeros[i]>numeros[i+1]){
                    //Se realiza el intercambio
                    Integer temp = numeros[i];
                    numeros[i] = numeros[i+1];
                    numeros[i+1] = temp;
                }
            }
            OrdenamientoBurbuja(numeros,length-1);
    }



    }
