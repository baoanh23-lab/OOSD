package QLKhachSan.QLKhachSan.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "hoa_don")
public class HoaDon {

    @Id
    @Column(name = "so_hoa_don", length = 30)
    private String soHoaDon;

    @OneToOne
    @JoinColumn(name = "so_phieu_dat", nullable = false, unique = true)
    private PhieuDatPhong phieuDatPhong;

    @Column(name = "ngay_lap", nullable = false)
    private LocalDateTime ngayLap;

    @ManyToOne
    @JoinColumn(name = "ma_nv", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "so_ngay_tinh_tien", nullable = false)
    private Integer soNgayTinhTien;

    @Column(name = "tien_phong", nullable = false, precision = 18, scale = 2)
    private BigDecimal tienPhong;

    @Column(name = "tien_dich_vu", nullable = false, precision = 18, scale = 2)
    private BigDecimal tienDichVu;

    @Transient
    public BigDecimal getTongTien() {
        return tienPhong.add(tienDichVu);
    }

    @Column(name = "trang_thai", nullable = false, length = 30)
    private String trangThai = "Chưa thanh toán";


    // =========================
    // GETTER
    // =========================

    public String getSoHoaDon() {
        return soHoaDon;
    }

    public PhieuDatPhong getPhieuDatPhong() {
        return phieuDatPhong;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public Integer getSoNgayTinhTien() {
        return soNgayTinhTien;
    }

    public BigDecimal getTienPhong() {
        return tienPhong;
    }

    public BigDecimal getTienDichVu() {
        return tienDichVu;
    }

    public String getTrangThai() {
        return trangThai;
    }


    // =========================
    // SETTER
    // =========================

    public void setSoHoaDon(String soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
        this.phieuDatPhong = phieuDatPhong;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setSoNgayTinhTien(Integer soNgayTinhTien) {
        this.soNgayTinhTien = soNgayTinhTien;
    }

    public void setTienPhong(BigDecimal tienPhong) {
        this.tienPhong = tienPhong;
    }

    public void setTienDichVu(BigDecimal tienDichVu) {
        this.tienDichVu = tienDichVu;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}