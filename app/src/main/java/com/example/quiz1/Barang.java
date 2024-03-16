package com.example.quiz1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Barang implements Parcelable {
    private String nama;
    private String type;
    private String kodeBarang;
    private String jumlahBarang;
    private String namaBarang;
    private String hargaBarang;
    private String totalHarga;
    private String discHarga;
    private String discMember;
    private String totalBayar;

    public Barang() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getDiscHarga() {
        return discHarga;
    }

    public void setDiscHarga(String discHarga) {
        this.discHarga = discHarga;
    }

    public String getDiscMember() {
        return discMember;
    }

    public void setDiscMember(String discMember) {
        this.discMember = discMember;
    }

    public String getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(String totalBayar) {
        this.totalBayar = totalBayar;
    }

    protected Barang(Parcel in) {
        nama = in.readString();
        type = in.readString();
        kodeBarang = in.readString();
        jumlahBarang = in.readString();
        namaBarang = in.readString();
        hargaBarang = in.readString();
        totalHarga = in.readString();
        discHarga = in.readString();
        discMember = in.readString();
        totalBayar = in.readString();
    }

    public static final Creator<Barang> CREATOR = new Creator<Barang>() {
        @Override
        public Barang createFromParcel(Parcel in) {
            return new Barang(in);
        }

        @Override
        public Barang[] newArray(int size) {
            return new Barang[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(type);
        dest.writeString(kodeBarang);
        dest.writeString(jumlahBarang);
        dest.writeString(namaBarang);
        dest.writeString(hargaBarang);
        dest.writeString(totalHarga);
        dest.writeString(discHarga);
        dest.writeString(discMember);
        dest.writeString(totalBayar);
    }
}
