package com.bieitoProyect.u6_student_bieito.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.bieitoProyect.u6_student_bieito.R;

/**
 *
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
                            case 0:
                                launchCalculatorIntent();
                                break;
                            case 1:
                                launchEmailIntent();
                                break;
                            default:
                                break;
                        }
                    }
                });
        return builder.create();
    }

    private void launchCalculatorIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
        startActivity(intent);
    }

    private void launchEmailIntent() {
        Intent intent1 = new Intent(Intent.ACTION_SEND);
        intent1.setType("application/octet-stream");
        intent1.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent1.putExtra(Intent.EXTRA_TEXT, "Texto do email");
        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"android@cursoandroid.es"});
        startActivity(intent1);

    }
}