package QLKhachSan.QLKhachSan.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ChiTietPhieuSuDungDVId implements Serializable {

    @Column(name = "SoPhieuSDDV", length = 30)
    private String soPhieuSDDV;

    @Column(name = "MaDV", length = 20)
    private String maDV;

    // Constructor rỗng
    public ChiTietPhieuSuDungDVId() {
    }

    // Constructor có 2 tham số
    public ChiTietPhieuSuDungDVId(String soPhieuSDDV, String maDV) {
        this.soPhieuSDDV = soPhieuSDDV;
        this.maDV = maDV;
    }

    // Getter + Setter

    public String getSoPhieuSDDV() {
        return soPhieuSDDV;
    }

    public void setSoPhieuSDDV(String soPhieuSDDV) {
        this.soPhieuSDDV = soPhieuSDDV;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ChiTietPhieuSuDungDVId)) {
            return false;
        }

        ChiTietPhieuSuDungDVId that =
                (ChiTietPhieuSuDungDVId) o;

        return soPhieuSDDV.equals(that.soPhieuSDDV)
                && maDV.equals(that.maDV);
    }

    @Override
    public int hashCode() {
        return 31 * soPhieuSDDV.hashCode()
                + maDV.hashCode();
    }
}