package QLKhachSan.QLKhachSan.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Phong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phong {

    @Id
    @Column(name = "SoPhong", length = 20)
    private String soPhong;

    @ManyToOne
    @JoinColumn(name = "MaKhuVuc", nullable = false)
    private KhuVuc khuVuc;

    @Column(name = "SoNguoiToiDa", nullable = false)
    private Integer soNguoiToiDa;

    @Column(name = "DonGiaNgay", nullable = false, precision = 18, scale = 2)
    private BigDecimal donGiaNgay;

    @Column(name = "TrangThai", nullable = false, length = 30)
    private String trangThai = "Trống";

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public KhuVuc getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(KhuVuc khuVuc) {
        this.khuVuc = khuVuc;
    }

    public Integer getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(Integer soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public BigDecimal getDonGiaNgay() {
        return donGiaNgay;
    }

    public void setDonGiaNgay(BigDecimal donGiaNgay) {
        this.donGiaNgay = donGiaNgay;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}