package com.pineapple.pab_m2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etInputNama;
    TextInputEditText etOutputNama;
    TextInputEditText etOutputStatus;
    TextInputEditText etOutputGolongan;
    TextInputEditText etOutputGaji;
    RadioGroup rgGolongan;
    RadioButton rbGolongan1;
    RadioButton rbGolongan2;
    CheckBox cbStatus;
    Button btnHitung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHitung = findViewById(R.id.btn_hitung);
        btnHitung.setOnClickListener(this::onClick);

    }

    private void onClick(View v) {
        etInputNama = findViewById(R.id.tv_nama_user);
        etOutputNama = findViewById(R.id.tv_nama_userr);
        etOutputStatus = findViewById(R.id.tv_hasil_status);
        etOutputGolongan = findViewById(R.id.tv_hasil_golongan);
        etOutputGaji = findViewById(R.id.tv_hasil_gaji);
        String status;
        int tunjangan;
        int gaji;
        String golongan;
        String nama = String.valueOf(etInputNama.getText());
        if (!nama.equals("")) {
            cbStatus = findViewById(R.id.cb_menikah);
            if (cbStatus.isChecked()) {
                tunjangan = 500000;
                status = "Menikah";
            } else {
                tunjangan = 0;
                status = "Tidak Menikah";
            }
            rgGolongan = findViewById(R.id.rg_golongan);
            rbGolongan1 = findViewById(R.id.rb_golongan_1);
            rbGolongan2 = findViewById(R.id.rb_golongan_2);
            if (rgGolongan.getCheckedRadioButtonId() == rbGolongan1.getId()) {
                golongan = "Golongan 1";
                gaji = 1000000;
            } else {
                golongan = "Golongan 2";
                gaji = 2000000;
            }
            etOutputNama.setText(nama);
            etOutputStatus.setText(status);
            etOutputGolongan.setText(golongan);
            etOutputGaji.setText(String.valueOf((gaji + tunjangan)));
        } else {
            etOutputNama.setText("");
            etOutputStatus.setText("");
            etOutputGolongan.setText("");
            etOutputGaji.setText("");
            Context context = getApplicationContext();
            CharSequence text = "Nama Lengkap (User) Tidak Boleh Kosong.";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}