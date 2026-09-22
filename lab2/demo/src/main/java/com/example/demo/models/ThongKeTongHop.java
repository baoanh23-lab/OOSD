package com.example.demo.models;

import java.math.BigDecimal;

public class ThongKeTongHop {

    private int luotSachMuon;
    private int sachQuaHan;
    private int sachMat;
    private int sachHuHong;
    private BigDecimal tongPhiPhat;

    public int getLuotSachMuon() {
        return luotSachMuon;
    }

    public void setLuotSachMuon(int luotSachMuon) {
        this.luotSachMuon = luotSachMuon;
    }

    public int getSachQuaHan() {
        return sachQuaHan;
    }

    public void setSachQuaHan(int sachQuaHan) {
        this.sachQuaHan = sachQuaHan;
    }

    public int getSachMat() {
        return sachMat;
    }

    public void setSachMat(int sachMat) {
        this.sachMat = sachMat;
    }

    public int getSachHuHong() {
        return sachHuHong;
    }

    public void setSachHuHong(int sachHuHong) {
        this.sachHuHong = sachHuHong;
    }

    public BigDecimal getTongPhiPhat() {
        return tongPhiPhat;
    }

    public void setTongPhiPhat(BigDecimal tongPhiPhat) {
        this.tongPhiPhat = tongPhiPhat;
    }
}