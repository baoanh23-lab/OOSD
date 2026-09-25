package QLKhachSan.QLKhachSan.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PhieuSuDungDV")
public class PhieuSuDungDV {

    @Id
    @Column(name = "SoPhieuSDDV", length = 30)
    private String soPhieuSDDV;

    @Column(name = "SoPhieuDat", nullable = false, length = 30)
    private String soPhieuDat;

    @Column(name = "SoPhong", nullable = false, length = 20)
    private String soPhong;

    @Column(name = "NgaySuDung", nullable = false)
    private LocalDate ngaySuDung;

    @Column(name = "MaNV", nullable = false, length = 20)
    private String maNV;


    // Constructor rỗng
    public PhieuSuDungDV() {
    }


    // =========================
    // GETTER + SETTER
    // =========================

    public String getSoPhieuSDDV() {
        return soPhieuSDDV;
    }

    public void setSoPhieuSDDV(String soPhieuSDDV) {
        this.soPhieuSDDV = soPhieuSDDV;
    }


    public String getSoPhieuDat() {
        return soPhieuDat;
    }

    public void setSoPhieuDat(String soPhieuDat) {
        this.soPhieuDat = soPhieuDat;
    }


    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }


    public LocalDate getNgaySuDung() {
        return ngaySuDung;
    }

    public void setNgaySuDung(LocalDate ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }


    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
}