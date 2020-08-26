package com.example.latihanbuat3layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    boolean keyTaken = false;
    public static int RESULT_CODE = 110;
    private int KUNCI;
    TextView desc;
    Button key;
    Button btnpertama;
    TextView kunci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        key = (Button) findViewById(R.id.key2);
        key.setOnClickListener(this);

        btnpertama = (Button) findViewById(R.id.btnpertama);
        btnpertama.setOnClickListener(this);

        desc = (TextView) findViewById(R.id.desc2);

        Bundle bundle = getIntent().getExtras();
        KUNCI = bundle.getInt("KUNCI");
        kunci = (TextView) findViewById(R.id.kunci);
        kunci.setText("Kunci Kamu : " + Integer.toString(KUNCI));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.key2:
                KUNCI += 1;
                key.setEnabled(false);
                desc.setText("*GRRRRRRRRRJHHHHHHH* Tanah nya bergetar, mungkin ruangan ini akan runtuh, mari kita kembali ke Lobby dungeon");
                kunci.setText("Kunci Kamu : " + Integer.toString(KUNCI));
                break;
            case R.id.btnpertama:
                Intent pertama = new Intent ();
                pertama.putExtra("extra_selected_value",KUNCI);
                setResult(RESULT_CODE,pertama);
                finish();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}