package lab4.lab4.entity;


import java.io.Serializable;
import java.util.Objects;

public class ChiTietGioHangId implements Serializable {

    private Integer maGioHang;
    private Integer maSanPham;

    public ChiTietGioHangId() {
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof ChiTietGioHangId)) return false;

        ChiTietGioHangId that = (ChiTietGioHangId) o;

        return Objects.equals(maGioHang, that.maGioHang)
                && Objects.equals(maSanPham, that.maSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGioHang, maSanPham);
    }
}