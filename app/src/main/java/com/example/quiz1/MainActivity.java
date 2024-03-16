package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nama, code, jumlah;
    RadioButton gold, silver, reguler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.nama);
        gold = findViewById(R.id.goldButton);
        silver = findViewById(R.id.silverButton);
        reguler = findViewById(R.id.regulerButton);
        code = findViewById(R.id.kodeBarang);
        jumlah = findViewById(R.id.jumlahBarang);
        Button buy = findViewById(R.id.beliButton);

        buy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.beliButton) {
            EditText code = findViewById(R.id.kodeBarang);
            String kodeBarang = code.getText().toString().trim();
            Barang barang = null;
            if (kodeBarang.equalsIgnoreCase("LV3")) {
                double jumlahh = Double.parseDouble(jumlah.getText().toString());
                double hargaSatuan = 6666666;
                double total = jumlahh * hargaSatuan;
                double jumlahBayar = total;
                double diskonHarga = 0;
                double diskonMembership = 0;

                if (total >= 10000000) {
                    diskonHarga = 100000;
                }

                if (gold.isChecked()) {
                    diskonMembership = 0.1;
                } else if (silver.isChecked()) {
                    diskonMembership = 0.05;
                } else if (reguler.isChecked()) {
                    diskonMembership = 0.02;
                }

                jumlahBayar -= diskonHarga;
                jumlahBayar -= (total * diskonMembership);

                barang = new Barang();
                barang.setNama(nama.getText().toString());
                barang.setNamaBarang("Lenovo V14 gen 3");
                barang.setKodeBarang("LV3");
                barang.setHargaBarang("6.666.666");
                barang.setTotalHarga(String.valueOf(total));
                barang.setDiscHarga(String.valueOf(diskonHarga));
                barang.setDiscMember(String.valueOf(total * diskonMembership));
                barang.setTotalBayar(String.valueOf(jumlahBayar));

                String member = "";
                if (gold.isChecked()) {
                    member = "Gold";
                } else if (silver.isChecked()) {
                    member = "Silver";
                } else if (reguler.isChecked()) {
                    member = "Biasa";
                }
                barang.setType(member);
            } else if (kodeBarang.equalsIgnoreCase("OAS")) {
                double jumlahh = Double.parseDouble(jumlah.getText().toString());
                double hargaSatuan = 1989123;
                double total = jumlahh * hargaSatuan;
                double jumlahBayar = total;
                double diskonHarga = 0;
                double diskonMembership = 0;

                if (total >= 10000000) {
                    diskonHarga = 100000;
                }

                if (gold.isChecked()) {
                    diskonMembership = 0.1;
                } else if (silver.isChecked()) {
                    diskonMembership = 0.05;
                } else if (reguler.isChecked()) {
                    diskonMembership = 0.02;
                }

                jumlahBayar -= diskonHarga;
                jumlahBayar -= (total * diskonMembership);

                barang = new Barang();
                barang.setNama(nama.getText().toString());
                barang.setNamaBarang("Oppo A5s");
                barang.setKodeBarang("OAS");
                barang.setHargaBarang("1.989.123");
                barang.setTotalHarga(String.valueOf(total));
                barang.setDiscHarga(String.valueOf(diskonHarga));
                barang.setDiscMember(String.valueOf(total * diskonMembership));
                barang.setTotalBayar(String.valueOf(jumlahBayar));

                String member = "";
                if (gold.isChecked()) {
                    member = "Gold";
                } else if (silver.isChecked()) {
                    member = "Silver";
                } else if (reguler.isChecked()) {
                    member = "Biasa";
                }
                barang.setType(member);
            } else if (kodeBarang.equalsIgnoreCase("O17")) {
                double jumlahh = Double.parseDouble(jumlah.getText().toString());
                double hargaSatuan = 2500999;
                double total = jumlahh * hargaSatuan;
                double jumlahBayar = total;
                double diskonHarga = 0;
                double diskonMembership = 0;

                if (total >= 10000000) {
                    diskonHarga = 100000;
                }

                if (gold.isChecked()) {
                    diskonMembership = 0.1;
                } else if (silver.isChecked()) {
                    diskonMembership = 0.05;
                } else if (reguler.isChecked()) {
                    diskonMembership = 0.02;
                }

                jumlahBayar -= diskonHarga;
                jumlahBayar -= (total * diskonMembership);

                barang = new Barang();
                barang.setNama(nama.getText().toString());
                barang.setNamaBarang("Oppo A17");
                barang.setKodeBarang("O17");
                barang.setHargaBarang("2.500.999");
                barang.setTotalHarga(String.valueOf(total));
                barang.setDiscHarga(String.valueOf(diskonHarga));
                barang.setDiscMember(String.valueOf(total * diskonMembership));
                barang.setTotalBayar(String.valueOf(jumlahBayar));

                String member = "";
                if (gold.isChecked()) {
                    member = "Gold";
                } else if (silver.isChecked()) {
                    member = "Silver";
                } else if (reguler.isChecked()) {
                    member = "Biasa";
                }
                barang.setType(member);
            }

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(ResultActivity.keyObject, barang);
            startActivity(intent);
        }
    }
}
