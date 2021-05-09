package com.bieitoProyect.u6_student_bieito.Dialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.bieitoProyect.u6_student_bieito.R;

import java.util.Objects;

/**
 *
 */
public class Dlg_Fragments extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        builder.setTitle(R.string.title_dialog)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setItems(R.array.dialog_array, (dialog, pos) -> {
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
                });
        return builder.create();
    }

    private void launchCalculatorIntent() {
        Intent intent = new Intent();
        intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
        startActivity(intent);
    }

    private void launchEmailIntent() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("application/octet-stream");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.email_subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, R.string.email_message);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bieito.sousa.1991@gmail.com"});
        startActivity(emailIntent);

    }
}