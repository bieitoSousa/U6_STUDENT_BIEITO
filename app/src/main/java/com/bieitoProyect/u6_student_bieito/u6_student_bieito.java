package com.bieitoProyect.u6_student_bieito;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.bieitoProyect.u6_student_bieito.Dialog.Dlg_Fragments;
import com.bieitoProyect.u6_student_bieito.Intent.intent_province;

public class u6_student_bieito extends AppCompatActivity {

    public final static String PROVINCE = "province";
    public static String valueProvince = "";
    private final int COD_PETITION = 33;
    public final static int RESULT_EMPTY = 3;


    private void EventManagement() {
        buttonPCE();
        buttonShowProvince();
    }


    @SuppressLint("QueryPermissionsNeeded")
    private void buttonPCE() {
        Button button_pce = findViewById(R.id.button_pce_id);
        button_pce.setOnClickListener(v -> {
            Intent intentProvince = new Intent(getApplicationContext(), intent_province.class);
            if (intentProvince.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intentProvince, COD_PETITION);
            }
        });
        button_pce.setOnLongClickListener(v -> {
            DialogFragment dialogFragment = new Dlg_Fragments();
            String stringDialogTag = getString(R.string.diaologTag);
            dialogFragment.show(getSupportFragmentManager(), stringDialogTag);
            return true;
        });
    }

    private void buttonShowProvince() {

        Button button_showProvince = findViewById(R.id.button_province_id);
        button_showProvince.setOnClickListener(v -> {
            if (valueProvince.equals("")) {
                Toast.makeText(getApplicationContext(), R.string.emptyProvince, Toast.LENGTH_LONG).show();
            } else {
                String stringShowProvince = getString(R.string.showProvince) + " ";
                Toast.makeText(getApplicationContext(), stringShowProvince + valueProvince, Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_PETITION) {
            if (resultCode == RESULT_OK) {
                System.out.println(data);
                if (data.hasExtra(u6_student_bieito.PROVINCE)) {
                    valueProvince = data.getExtras().getString(u6_student_bieito.PROVINCE);
                    String stringShowProvince = getString(R.string.showProvince) + " ";
                    Toast.makeText(getApplicationContext(), stringShowProvince + valueProvince, Toast.LENGTH_LONG).show();
                }
            } else if (resultCode == RESULT_EMPTY) {
                Toast.makeText(this, R.string.emptyProvince, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.backActivity, Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void finish() {
        super.finish();
        Toast.makeText(this, R.string.mainActivityFinish, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u6_student_bieito);
        EventManagement();
    }


}