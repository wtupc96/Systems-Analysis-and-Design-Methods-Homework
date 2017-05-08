package com.ouyang.peter.rbac;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by wtupc96 on 2017/5/8.
 */
public class AdminDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("I'm the GOD.")
                .setMessage("Am I the GOD?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Awesome!", Toast.LENGTH_SHORT).show();
                    }
                })
               .show();
    }
}
