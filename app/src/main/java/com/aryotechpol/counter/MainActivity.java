package com.aryotechpol.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String STATE_COUNT = "state_count"; // konstanta
    TextView tvCount;
    Button btnCount,btnReset;
    int count = 0; // tipe data primitif (cara 1)
    // Integer count = 0; // tipe data reference (cara 2)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // binding activity ke layout yang akan ditampilkan

        // binding component ke view
        tvCount = findViewById(R.id.tv_count);
        btnCount = findViewById(R.id.btn_count);
        btnReset = findViewById(R.id.btn_reset);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something here
                count++;
                if(count == 10){
                    tvCount.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimensionPixelSize(R.dimen.style_minimize));
                }
                tvCount.setText(String.valueOf(count)); // (cara 1)
                //tvCount.setText(count.toString()) //(cara 2)
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                tvCount.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimensionPixelSize(R.dimen.default_view));
                tvCount.setText(String.valueOf(count));
            }
        });

        if(savedInstanceState != null){ // cek apakah ada state yang tersimpan?
            count = savedInstanceState.getInt(STATE_COUNT);
            tvCount.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // save state

        outState.putInt(STATE_COUNT,count);
    }
}
