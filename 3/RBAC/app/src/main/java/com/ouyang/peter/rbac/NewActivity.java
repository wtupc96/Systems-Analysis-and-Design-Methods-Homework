package com.ouyang.peter.rbac;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wtupc96 on 2017/5/8.
 */
public class NewActivity extends AppCompatActivity {

    private static final int[] adminPermission = {0, 0, 1, 1, 1};
    private static final int[] teacherPermission = {0, 1, 0, 1, 0};
    private static final int[] studentPermission = {1, 0, 0, 0, 0};
    private static List<String> username = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);

        username = LoginActivity.getUsernamePassword();

        Button[] buttons = {(Button) findViewById(R.id.Imastudent),
                (Button) findViewById(R.id.Imateacher),
                (Button) findViewById(R.id.Imanadmin),
                (Button) findViewById(R.id.Listallstudents),
                (Button) findViewById(R.id.Listallteachers)};

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new StudentDialog().show(getFragmentManager(), "");
            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TeacherDialog().show(getFragmentManager(), "");
            }
        });

        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AdminDialog().show(getFragmentManager(), "");
            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> studentList = new ArrayList<String>();
                for (String name : username) {
                    String[] pieces = name.split(":");
                    if (pieces[1].equals("student")) {
                        studentList.add(pieces[0]);
                    }
                }
                String[] studentStr = new String[studentList.size()];
                for (int i = 0; i < studentStr.length; ++i) {
                    studentStr[i] = studentList.get(i);
                }
                ListStudentDialog listStudentDialog = new ListStudentDialog(studentStr);
                listStudentDialog.show(getFragmentManager(), "");
            }
        });

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> studentList = new ArrayList<String>();
                for (String name : username) {
                    String[] pieces = name.split(":");
                    if (pieces[1].equals("teacher")) {
                        studentList.add(pieces[0]);
                    }
                }
                String[] teacherStr = new String[studentList.size()];
                for (int i = 0; i < teacherStr.length; ++i) {
                    teacherStr[i] = studentList.get(i);
                }
                ListTeacherDialog listTeacherDialog = new ListTeacherDialog(teacherStr);
                listTeacherDialog.show(getFragmentManager(), "");
            }
        });
        String role = getIntent().getStringExtra("role");
        int[] permission = null;
        switch (role) {
            case "admin":
                permission = adminPermission;
                break;
            case "teacher":
                permission = teacherPermission;
                break;
            case "student":
                permission = studentPermission;
                break;
        }

        for (int i = 0; i < permission.length; ++i) {
            if (permission[i] == 0) {
                buttons[i].setVisibility(View.GONE);
            }
        }
    }
}
