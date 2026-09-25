package QLKhachSan.QLKhachSan.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DichVu")
public class DichVu {

    @Id
    @Column(name = "MaDV", length = 20)
    private String maDV;

    @Column(name = "TenDV", nullable = false, length = 120)
    private String tenDV;

    @Column(name = "DonGia", nullable = false)
    private BigDecimal donGia;

    @Column(name = "DonViTinh", length = 50)
    private String donViTinh;

    public DichVu() {
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
}