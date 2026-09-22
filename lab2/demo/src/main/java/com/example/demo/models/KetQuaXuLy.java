package com.example.demo.models;

public class KetQuaXuLy {

    private boolean thanhCong;
    private String thongBao;

    private KetQuaXuLy(boolean thanhCong, String thongBao) {
        this.thanhCong = thanhCong;
        this.thongBao = thongBao;
    }

    public boolean isThanhCong() {
        return thanhCong;
    }

    public String getThongBao() {
        return thongBao;
    }

    public static KetQuaXuLy ok(String thongBao) {
        return new KetQuaXuLy(true, thongBao);
    }

    public static KetQuaXuLy loi(String thongBao) {
        return new KetQuaXuLy(false, thongBao);
    }
}