package QLKhachSan.QLKhachSan.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phieu_den_bu")
public class PhieuDenBu {

    @Id
    @Column(name = "so_phieu_den_bu", length = 30)
    private String soPhieuDenBu;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(
            name = "so_phieu_dat",
            referencedColumnName = "so_phieu_dat"
        ),
        @JoinColumn(
            name = "SoPhong",
            referencedColumnName = "SoPhong"
        )
    })
    private ChiTietDatPhong chiTietDatPhong;

    @Column(name = "ngay_lap", nullable = false)
    private LocalDateTime ngayLap;

    @ManyToOne
    @JoinColumn(name = "ma_nv", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "tong_tien", nullable = false, precision = 18, scale = 2)
    private BigDecimal tongTien = BigDecimal.ZERO;


    // =========================
    // GETTER
    // =========================

    public String getSoPhieuDenBu() {
        return soPhieuDenBu;
    }

    public ChiTietDatPhong getChiTietDatPhong() {
        return chiTietDatPhong;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }


    // =========================
    // SETTER
    // =========================

    public void setSoPhieuDenBu(String soPhieuDenBu) {
        this.soPhieuDenBu = soPhieuDenBu;
    }

    public void setChiTietDatPhong(ChiTietDatPhong chiTietDatPhong) {
        this.chiTietDatPhong = chiTietDatPhong;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }
}