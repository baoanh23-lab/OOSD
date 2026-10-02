package lab4.lab4.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "ChiTietGioHang")
@IdClass(ChiTietGioHangId.class)
public class ChiTietGioHang {

    @Id
    private Integer maGioHang;

    @Id
    private Integer maSanPham;

    private Integer soLuong;

    private Double donGia;

    public Integer getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(Integer maGioHang) {
        this.maGioHang = maGioHang;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
}