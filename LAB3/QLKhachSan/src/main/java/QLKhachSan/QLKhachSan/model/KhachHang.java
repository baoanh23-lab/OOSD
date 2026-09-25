package QLKhachSan.QLKhachSan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @Column(name = "MaKhach", length = 20)
    private String maKhach;

    @Column(name = "HoTen", nullable = false, length = 120)
    private String hoTen;

    @Column(name = "SoCMND", nullable = false, unique = true, length = 30)
    private String soCMND;

    @Column(name = "QuocTich", nullable = false, length = 80)
    private String quocTich;

    @Column(name = "SoDienThoai", length = 20)
    private String soDienThoai;

    // Constructor rỗng
    public KhachHang() {
    }

    // Getter và Setter
    public String getMaKhach() {
        return maKhach;
    }

    public void setMaKhach(String maKhach) {
        this.maKhach = maKhach;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}