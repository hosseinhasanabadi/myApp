package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditePorofilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_porofil);
        String fullname = getIntent().getStringExtra(MainActivity.EXTTERA_KEY_FULLNAME);

        EditText editText = findViewById(R.id.et_EditProfil);
        editText.setText("fullname");
        Button donbtn= findViewById(R.id.btn_editporofil_done);
        donbtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTTERA_KEY_FULLNAME,fullname);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}