package com.ouyang.peter.rbac;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wtupc96 on 2017/5/8.
 */
public class ListTeacherDialog extends DialogFragment {
    private static String[] allList = null;

    public ListTeacherDialog(){

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("List all teachers.")
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

    public ListTeacherDialog(String[] allList){
        this.allList = allList;
    }
}
