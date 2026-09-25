package QLKhachSan.QLKhachSan.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChiTietPhieuSuDungDV")
public class ChiTietPhieuSuDungDV {

    @EmbeddedId
    private ChiTietPhieuSuDungDVId id;

    @Column(name = "SoLuong", nullable = false)
    private int soLuong;

    @Column(name = "DonGia", nullable = false)
    private BigDecimal donGia;

    public ChiTietPhieuSuDungDV() {
    }

    public ChiTietPhieuSuDungDVId getId() {
        return id;
    }

    public void setId(ChiTietPhieuSuDungDVId id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }
}