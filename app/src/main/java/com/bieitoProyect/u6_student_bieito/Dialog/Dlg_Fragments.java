package com.bieitoProyect.u6_student_bieito.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bieitoProyect.u6_student_bieito.R;

/**

 */
public class Dlg_Fragments extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.title_dialog)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setItems(R.array.dialog_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int pos) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (pos) {
                            case 0 : calculadoraEvent();
                                break;

                            case 1 : calculadoraEvent();
                                break;
                            default:
                                break;
                        }
                    }
                });
        return builder.create();
    }
    private void calculadoraEvent(){

                Intent intent = new Intent();
                intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
                startActivity(intent);
            }
}