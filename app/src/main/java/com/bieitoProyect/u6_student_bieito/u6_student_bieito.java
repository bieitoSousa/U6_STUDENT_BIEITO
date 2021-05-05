package com.bieitoProyect.u6_student_bieito;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.bieitoProyect.u6_student_bieito.Dialog.Dlg_Fragments;
import com.bieitoProyect.u6_student_bieito.Intent.intent_province;

public class u6_student_bieito extends AppCompatActivity implements View.OnClickListener{

    public final String ACCION_VISUALIZAR = "ACCION_VISUALIZAR";
    public final static String PROVINCE = "province";
    private final int COD_PETICION = 33;
    private Dlg_Fragments dialogoFragmento;


    private void xestionarEventos() {
        intentProvinceEvent();
        calculadoraEvent();
        emailEvent();
        longClickDialogEvent();
        dialogEvent();
        dialogFrgmentEvent();
    }


    private void intentProvinceEvent(){
        Button button_pce = findViewById(R.id.button_pce_id);
        button_pce.setOnClickListener(new View.OnClickListener() {
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
        button_pce.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialogFrament();
                return true;
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

    private void longClickDialogEvent(){
        //Botón para lanzar a calculadora do S.O.
        Button btnCalculadora = findViewById(R.id.btnCalculadora);
        btnCalculadora.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder venta;
                venta = new AlertDialog.Builder(u6_student_bieito.this);
                venta.setIcon(android.R.drawable.ic_dialog_alert);
                venta.setTitle(R.string.title_dialog);
                venta.setItems(R.array.dialog_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int posicion) {
                        // O usuario selecciona unha das opcións do listado
                        String[] opcions = getResources().getStringArray(R.array.dialog_array);
                        Toast.makeText(getApplicationContext(), "Seleccionaches: '" + opcions[posicion] + "'", Toast.LENGTH_LONG).show();
                    }
                });
                venta.create();
                return true;
            }
    });
    }

    private void dialogFrament(){
        DialogFragment dialogoFragmento = new Dlg_Fragments();
        dialogoFragmento.show( getSupportFragmentManager(), "EXEMPLO DE DIALOGO!!!!");
    }
    private void dialogEvent(){
        Button btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder venta;
                venta = new AlertDialog.Builder(u6_student_bieito.this);
                venta.setIcon(android.R.drawable.ic_dialog_alert);
                venta.setTitle(R.string.title_dialog);
                venta.setItems(R.array.dialog_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int posicion) {
                        // O usuario selecciona unha das opcións do listado
                        String[] opcions = getResources().getStringArray(R.array.dialog_array);
                        Toast.makeText(getApplicationContext(), "Seleccionaches: '" + opcions[posicion] + "'", Toast.LENGTH_LONG).show();
                    }
                });
                venta.create();
            }
        });
    }

    private void dialogFrgmentEvent(){
        Button btnDialogFragment = findViewById(R.id.btnDialogFragment);
        btnDialogFragment.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialogFrament();
                return true;
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

    @Override
    public void onClick(View v) {

    }
}