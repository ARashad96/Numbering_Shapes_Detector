package com.arashad96.androiddeveloperintermidatekit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Numbering_Shapes_Detector extends AppCompatActivity {
    Button github;
    Button info;
    EditText value;
    Button pressed;

    class Number{

        public boolean triangularno(){
            int T = Integer.valueOf(value.getText().toString());
            int n = (int)Math.sqrt(2*T);
            return n*(n+1) == 2*T;
        }
        public boolean squareno(){
            double d = Double.valueOf(value.getText().toString());
            double zz= Math.sqrt(d);
            Log.d("check","testwww  "+zz);
            Log.d("check","tdww  "+d);
            if(zz % 1 == 0){
                return true;
            }
            else {
                return false;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_numbering__shapes__detector);

        value=findViewById(R.id.value);
        pressed=findViewById(R.id.pressed);
        pressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Number x = new Number();

                //Log.d("check","test   "+value.getText().toString());
                if (value.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter value", Toast.LENGTH_LONG).show();
                }
                else if(x.triangularno() && x.squareno() && !value.getText().toString().equals("0")){
                    Toast.makeText(Numbering_Shapes_Detector.this, "Both", Toast.LENGTH_SHORT).show();
                }
                else if (x.triangularno() && !value.getText().toString().equals("0")){
                    Toast.makeText(Numbering_Shapes_Detector.this, "This number is Triangular", Toast.LENGTH_SHORT).show();
                }
                else if (x.squareno()){
                    Toast.makeText(Numbering_Shapes_Detector.this, "This number is Square", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Numbering_Shapes_Detector.this, "Neither", Toast.LENGTH_SHORT).show();
                }
            }
        });
        github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ARashad96/Numbering_Shapes_Detector"));
                startActivity(intent);
            }
        });
        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(Numbering_Shapes_Detector.this)
                        .setIcon(R.drawable.profile)
                        .setTitle("App info")
                        .setMessage("This app is performing a test on numbers to find if they are Triangular, Square, Both or Neither using buttons, toast, textview, edittext and linearlayout.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }
}