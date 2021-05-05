package com.bieitoProyect.u6_student_bieito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bieitoProyect.u6_student_bieito.Intent.intent_province;

public class u6_student_bieito extends AppCompatActivity {

    public final String ACCION_VISUALIZAR = "ACCION_VISUALIZAR";
    public final static String PROVINCE = "province";
    private final int COD_PETICION = 33;


    private void xestionarEventos() {
        intentProvinceEvent();
        calculadoraEvent();
        emailEvent();
    }


    private void intentProvinceEvent(){
        findViewById(R.id.button_pce_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intentProvince = new Intent();
                Intent intentProvince = new Intent(getApplicationContext(), intent_province.class);
                //intentProvince.setAction(ACCION_VISUALIZAR);
                if (intentProvince.resolveActivity(getPackageManager()) != null) { // Comprobamos sempre nas chamadas implicitas se existe algunha activity que poida atender a miña petición
                    // startActivity(intentProvince);
                    startActivityForResult(intentProvince, COD_PETICION);
                }
            }
        });
    }
    private void calculadoraEvent(){
        //Botón para lanzar a calculadora do S.O.
        Button btnCalculadora = findViewById(R.id.btnCalculadora);
        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
                startActivity(intent);
            }
        });
    }

    private void emailEvent(){
        //Botón para lanzar a email do S.O.
        Button btnEmail= findViewById(R.id.btnEmail);
        // Reemplazamos el email por algun otro real
        String[] to = { "email1@ejemplo.com", "otroEmail@ejemplo.com" };
        String[] cc = { "otroEmail@ejemplo.com" };
        String asunto =  "Hola";
        String mensaje = "Esto es un email enviado desde una app de Android";
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
                emailIntent.putExtra(Intent.EXTRA_CC, cc);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
                emailIntent.setType("message/rfc822");
                //intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
                //startActivity(intent);
                startActivity(Intent.createChooser(emailIntent, "Email "));
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_PETICION) {
            if (resultCode == RESULT_OK) {
                if (data.hasExtra(u6_student_bieito.PROVINCE)) {
                    Toast.makeText(this, "\nAtua provincia é: " + data.getExtras().getString(PROVINCE), Toast.LENGTH_SHORT).show();
                }

            } else
                Toast.makeText(this, "Saíches da actividade secundaria sen premer o botón Pechar", Toast.LENGTH_SHORT).show();
        }

    }

    public void finish() {
        super.finish();
        Toast.makeText(this, "Mataches a actividade principal", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u6_student_bieito);
        xestionarEventos();



    }
}