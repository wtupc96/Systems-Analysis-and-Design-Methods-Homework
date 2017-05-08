package com.ouyang.peter.rbac;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wtupc96 on 2017/5/8.
 */
public class ListStudentDialog extends DialogFragment {
    private static String[] allList = null;

    public ListStudentDialog(){

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("List all students.")
                .setItems(allList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                }).show();

    }

    public ListStudentDialog(String[] allList){
        this.allList = allList;
    }
}
