package com.bieitoProyect.u6_student_bieito.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bieitoProyect.u6_student_bieito.*;

public class intent_province extends AppCompatActivity {

    private void xestionarEventoss(){
        findViewById(R.id.btnCloused).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_province = (EditText) findViewById(R.id.etProvinceName);
                Intent u6_main = new Intent();
                u6_main.putExtra(u6_student_bieito.PROVINCE, et_province.getText().toString());
                setResult(RESULT_OK, u6_main);
                finish();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_province);
        xestionarEventoss();
    }
}