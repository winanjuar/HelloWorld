package com.sugengwin.multimatics.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnHitung;
    private EditText edtPanjang, edtLebar;
    private TextView tvHasil;
    private double luas = 0;
    private String KEY_HASIL = "hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHitung = (Button) findViewById(R.id.btn_hitung);
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

                if (TextUtils.isEmpty(panjang) || TextUtils.isEmpty(lebar)) {
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    luas = Double.parseDouble(panjang) * Double.parseDouble(lebar);
                    tvHasil.setText("Luasnya : " + luas);
                }
            }
        });
        edtPanjang = (EditText) findViewById(R.id.edt_panjang);
        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        tvHasil = (TextView) findViewById(R.id.tv_hasil);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(KEY_HASIL, luas);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        luas = savedInstanceState.getDouble(KEY_HASIL);
        tvHasil.setText("Luasnya : " + luas);
    }
}
