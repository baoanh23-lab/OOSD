package QLKhachSan.QLKhachSan.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "chi_tiet_phieu_den_bu")
public class ChiTietPhieuDenBu {

    @EmbeddedId
    private ChiTietPhieuDenBuId id;

    @Column(name = "muc_do_thiet_hai", nullable = false)
    private String mucDoThietHai;

    @Column(name = "so_tien", nullable = false, precision = 18, scale = 2)
    private BigDecimal soTien;

    public ChiTietPhieuDenBu() {
    }

    public ChiTietPhieuDenBuId getId() {
        return id;
    }

    public void setId(ChiTietPhieuDenBuId id) {
        this.id = id;
    }

    public String getMucDoThietHai() {
        return mucDoThietHai;
    }

    public void setMucDoThietHai(String mucDoThietHai) {
        this.mucDoThietHai = mucDoThietHai;
    }

    public BigDecimal getSoTien() {
        return soTien;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }
}