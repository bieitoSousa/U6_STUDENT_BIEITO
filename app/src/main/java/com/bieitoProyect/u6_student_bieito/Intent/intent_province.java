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
                String prov = et_province.getText().toString();
                Intent u6_main = new Intent();
                if (prov.equals("")){
                    setResult(u6_student_bieito.RESULT_EMPTY, u6_main);
                    finish();
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString("province", prov);
                    u6_main.putExtras(bundle);
                    setResult(RESULT_OK, u6_main);
                    finish();
                }
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