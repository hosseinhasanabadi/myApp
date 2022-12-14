package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        public  static final String EXTTERA_KEY_FULLNAME="fullname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveinfirmashenbtn = findViewById(R.id.btn_main_savinf);
        saveinfirmashenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"user on click information ",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox = findViewById(R.id.checkBox_main_android);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {

                if (ischecked){
                    Toast.makeText(MainActivity.this,"android is checked",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"android is not checked",Toast.LENGTH_SHORT).show();
                }
            }

        });
        RadioGroup radioGroup = findViewById(R.id.RadioGorup_main);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId){
                case  R.id.radioButton_main_tehran:
                    Toast.makeText(MainActivity.this,"tehran Radiobtn is chekt",Toast.LENGTH_SHORT).show();
                    break;
                case  R.id.radioButton_main_alborz:
                    Toast.makeText(MainActivity.this,"alborz Radiobtn is chekt",Toast.LENGTH_SHORT).show();
                    break;
                case  R.id.radioButton_main_gilan:
                    Toast.makeText(MainActivity.this,"gilan Radiobtn is chekt",Toast.LENGTH_SHORT).show();
                    break;

            }
            }
        });
        Button editporofilbtn = findViewById(R.id.btn_main_editporofil);
        editporofilbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EditePorofilActivity.class);
                TextView fullnametv = findViewById(R.id.tv_main_fullname);
                intent.putExtra(EXTTERA_KEY_FULLNAME,fullnametv.getText());
            startActivityForResult(intent,1001);

            }
        });
        Button viewwebsitebtn = findViewById(R.id.btn_main_viewwebsite);
viewwebsitebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://7learn.ac"));
    startActivity(intent);
    }
});
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onActivityResult(int requestcode,int resultCode ,@Nullable Intent data) {

        if (resultCode == 1001 && resultCode == Activity.RESULT_OK && data != null) {
            String fullname = data.getStringExtra(EXTTERA_KEY_FULLNAME);
            TextView textView = findViewById(R.id.tv_main_fullname);
            textView.setText(fullname);
        }
        //new lin
    }

}