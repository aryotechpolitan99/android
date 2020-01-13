package com.aryotechpol.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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
                tvCount.setText(String.valueOf(count)); // (cara 1)
                //tvCount.setText(count.toString()) //(cara 2)
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                tvCount.setText(String.valueOf(count));
            }
        });

    }
}
