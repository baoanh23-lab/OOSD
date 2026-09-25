package QLKhachSan.QLKhachSan.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "thanh_toan")
public class ThanhToan {

    @Id
    @Column(name = "ma_thanh_toan", length = 30)
    private String maThanhToan;

    @ManyToOne
    @JoinColumn(name = "so_hoa_don", nullable = false)
    private HoaDon hoaDon;

    @Column(name = "ngay_thanh_toan", nullable = false)
    private LocalDateTime ngayThanhToan;

    @Column(name = "hinh_thuc", nullable = false, length = 30)
    private String hinhThuc;

    @Column(name = "so_tien", nullable = false, precision = 18, scale = 2)
    private BigDecimal soTien;


    // =========================
    // GETTER
    // =========================

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public LocalDateTime getNgayThanhToan() {
        return ngayThanhToan;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public BigDecimal getSoTien() {
        return soTien;
    }


    // =========================
    // SETTER
    // =========================

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public void setNgayThanhToan(LocalDateTime ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }
}