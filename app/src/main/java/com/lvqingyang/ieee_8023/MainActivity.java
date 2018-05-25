package com.lvqingyang.ieee_8023;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private android.widget.EditText etdata;
    private android.widget.Button btnclear;
    private android.widget.Button btnencap;
    private android.widget.TextView tvframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvframe = (TextView) findViewById(R.id.tv_frame);
        this.btnencap = (Button) findViewById(R.id.btn_encap);
        this.btnclear = (Button) findViewById(R.id.btn_clear);
        this.etdata = (EditText) findViewById(R.id.et_data);

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etdata.setText("");
                tvframe.setText("");
            }
        });

        btnencap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=etdata.getText().toString();
                if (!data.isEmpty()) {
                    showFrame(data);
                }
            }
        });

    }

    private void showFrame(String data) {
        Frame frame=new Frame(data);
        CRC32.calculate(frame);
        tvframe.setText(frame.toString());
    }
}
