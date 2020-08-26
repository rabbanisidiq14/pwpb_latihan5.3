package com.example.latihanbuat3layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    private int KUNCI;
    Button lubang;
    Button pintu;
    Button lobby;
    TextView kunci;
    TextView desc;
    TextView hadiah;
    public static int RESULT_CODE = 120;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = getIntent().getExtras();
        KUNCI = bundle.getInt("KUNCI");

        lubang = (Button) findViewById(R.id.lubang);
        lubang.setOnClickListener(this);

        pintu = (Button) findViewById(R.id.pintu);
        pintu.setOnClickListener(this);

        kunci = (TextView) findViewById(R.id.kunci2);
        kunci.setText("Kunci Kamu : " + Integer.toString(KUNCI));

        desc = (TextView) findViewById(R.id.desc3);

        hadiah = (TextView) findViewById(R.id.hadiah);

        lobby = (Button)findViewById(R.id.lobby);
        lobby.setOnClickListener(this);

        if(KUNCI != 0){
            desc.setText("Yesss, ternyata disini juga ada pintu aneh tersebut, ayo buka pintu nya cepat!");
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.lubang && KUNCI != 0){

            pintu.setEnabled(true);
            pintu.setText("ruang harta");
            KUNCI = 0;
            kunci.setText("Kunci Kamu : " + Integer.toString(KUNCI));
        }
        else if(view.getId() == R.id.pintu){
            hadiah.setVisibility(View.VISIBLE);
            pintu.setEnabled(false);
            lubang.setEnabled(false);
            lobby.setEnabled(false);
        }
        else if(view.getId() == R.id.lobby){
            Intent pertama = new Intent ();
            pertama.putExtra("balik_ke_lobby",KUNCI);
            setResult(RESULT_CODE,pertama);
            finish();
        }
    }
}