package QLKhachSan.QLKhachSan.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "phieu_lap_dat",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_phieu_lap_dat_thiet_bi_ngay",
            columnNames = {"ma_tien_nghi", "ngay_lap"}
        )
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhieuLapDat {

    @Id
    @Column(name = "so_phieu_lap_dat", length = 30)
    private String soPhieuLapDat;

    @ManyToOne
    @JoinColumn(name = "ma_tien_nghi", nullable = false)
    private TienNghi tienNghi;

    @ManyToOne
    @JoinColumn(name = "SoPhong", nullable = false)
    private Phong phong;

    @Column(name = "ngay_lap", nullable = false)
    private LocalDate ngayLap;

    @Column(name = "tinh_trang", nullable = false, length = 100)
    private String tinhTrang;

    @ManyToOne
    @JoinColumn(name = "ma_nv", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "ghi_chu", length = 250)
    private String ghiChu;
    public String getSoPhieuLapDat() {
        return soPhieuLapDat;
    }
    
    public void setSoPhieuLapDat(String soPhieuLapDat) {
        this.soPhieuLapDat = soPhieuLapDat;
    }
    
    public TienNghi getTienNghi() {
        return tienNghi;
    }
    
    public void setTienNghi(TienNghi tienNghi) {
        this.tienNghi = tienNghi;
    }
    
    public Phong getPhong() {
        return phong;
    }
    
    public void setPhong(Phong phong) {
        this.phong = phong;
    }
    
    public LocalDate getNgayLap() {
        return ngayLap;
    }
    
    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }
    
    public String getTinhTrang() {
        return tinhTrang;
    }
    
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public NhanVien getNhanVien() {
        return nhanVien;
    }
    
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
    
    public String getGhiChu() {
        return ghiChu;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
}