package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    public static final String keyObject = "KEY_OBJECT";
    private TextView welcomee, typeMember, codeBarang, namaBarang, hargaBarang, totalHarga, diskonHarga, diskonMember, jumlahBayar;
    private Button shareButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        DecimalFormat formatter = new DecimalFormat("#,###.##");

        welcomee = findViewById(R.id.welcome);
        typeMember = findViewById(R.id.type);
        codeBarang = findViewById(R.id.tvKode);
        namaBarang = findViewById(R.id.tvNama);
        hargaBarang = findViewById(R.id.tvHarga);
        totalHarga = findViewById(R.id.tvTotal);
        diskonHarga = findViewById(R.id.tvDiskonHarga);
        diskonMember = findViewById(R.id.tvDiskonMember);
        jumlahBayar = findViewById(R.id.tvJumlah);
        shareButton = findViewById(R.id.shareBtn);

        Barang barang;
        if (Build.VERSION.SDK_INT > 33){
            barang = getIntent().getParcelableExtra(keyObject, Barang.class);
        }else {
            barang = getIntent().getParcelableExtra(keyObject);
        }

        welcomee.setText(getString(R.string.str_welcome) + barang.getNama());
        typeMember.setText(getString(R.string.result_type) + barang.getType());
        codeBarang.setText(getString(R.string.result_code) + barang.getKodeBarang());
        namaBarang.setText(getString(R.string.result_name) + barang.getNamaBarang());
        hargaBarang.setText(getString(R.string.result_price) + barang.getHargaBarang());
        totalHarga.setText(getString(R.string.result_totalPrice) + formatter.format(Double.parseDouble(barang.getTotalHarga())));
        diskonHarga.setText(getString(R.string.result_disc) + barang.getDiscHarga());
        diskonMember.setText(getString(R.string.result_member) + barang.getDiscMember());
        jumlahBayar.setText(getString(R.string.result_payment) + formatter.format(Double.parseDouble(barang.getTotalBayar())));

        shareButton.setOnClickListener(click -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareMessage = "Nama : " + barang.getNama() +
                    "\nTipe Member: " + barang.getType() +
                    "\nKode Barang: " + barang.getKodeBarang() +
                    "\nNama Barang: " + barang.getNamaBarang() +
                    "\nHarga Barang: " + barang.getHargaBarang() +
                    "\nTotal Harga: " + formatter.format(Double.parseDouble(barang.getTotalHarga())) +
                    "\nDiskon Harga: " + formatter.format(Double.parseDouble(barang.getDiscHarga())) +
                    "\nDiskon Member: " + formatter.format(Double.parseDouble(barang.getDiscMember())) +
                    "\nJumlah Bayar: " + formatter.format(Double.parseDouble(barang.getTotalBayar()));
            intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(intent, "Bagikan melalui"));
        });
    }
}