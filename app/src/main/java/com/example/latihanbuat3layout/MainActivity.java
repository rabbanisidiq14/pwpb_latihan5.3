package com.example.latihanbuat3layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int KUNCI = 0;
    Button btnkedua;
    Button btnketiga;
    TextView kunci;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnkedua = (Button) findViewById(R.id.btnkedua1);
        btnkedua.setOnClickListener(this);

        btnketiga = (Button) findViewById(R.id.btnketiga1);
        btnketiga.setOnClickListener(this);

        kunci = (TextView) findViewById(R.id.kunci1);

        desc = (TextView) findViewById(R.id.desc);

        Bundle bundle = getIntent().getExtras();
        kunci.setText("Kunci Kamu : " + Integer.toString(KUNCI));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnkedua1:
                Intent kedua = new Intent(MainActivity.this, MainActivity2.class);
                kedua.putExtra("KUNCI",KUNCI);
                startActivityForResult(kedua,100);
                break;
            case R.id.btnketiga1:
                Intent ketiga = new Intent(MainActivity.this, MainActivity3.class);
                ketiga.putExtra("KUNCI",KUNCI);
                startActivityForResult(ketiga, 130);
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            if(resultCode == MainActivity2.RESULT_CODE){
                int value = data.getIntExtra("extra_selected_value",0);
                KUNCI = value;
                kunci.setText("Kunci Kamu : " + Integer.toString(value));
                if(KUNCI == 1){
                    btnkedua.setEnabled(false);
                    desc.setText("Kita tidak dapat masuk lagi ke jalan kiri, untung saja kamu selamat tadi \nehh tapi bukan berarti aku mencemaskanmu atau gimana ya!!");
                }
            }
        }
        if(requestCode == 130){
            if(resultCode == MainActivity3.RESULT_CODE){
                int value = data.getIntExtra("balik_ke_lobby",0);
                KUNCI = value;
                kunci.setText("Kunci Kamu : " + Integer.toString(value));
                if(KUNCI == 1){
                    btnkedua.setEnabled(false);
                    desc.setText("Kamu tidak dapat masuk lagi ke jalan kiri, untung saja kamu selamat tadi \nehh tapi bukan berarti aku mencemaskanmu atau gimana ya!!");
                }
            }
        }
    }
}