package QLKhachSan.QLKhachSan.model;

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
    name = "tien_nghi",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_tien_nghi_loai_stt",
            columnNames = {"ma_loai_tn", "so_thu_tu"}
        )
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TienNghi {

    @Id
    @Column(name = "ma_tien_nghi", length = 30)
    private String maTienNghi;

    @ManyToOne
    @JoinColumn(name = "ma_loai_tn", nullable = false)
    private LoaiTienNghi loaiTienNghi;

    @Column(name = "so_thu_tu", nullable = false)
    private Integer soThuTu;

    @Column(name = "tinh_trang_hien_tai", length = 100)
    private String tinhTrangHienTai;
    public String getMaTienNghi() {
        return maTienNghi;
    }
    
    public void setMaTienNghi(String maTienNghi) {
        this.maTienNghi = maTienNghi;
    }
    
    public LoaiTienNghi getLoaiTienNghi() {
        return loaiTienNghi;
    }
    
    public void setLoaiTienNghi(LoaiTienNghi loaiTienNghi) {
        this.loaiTienNghi = loaiTienNghi;
    }
    
    public Integer getSoThuTu() {
        return soThuTu;
    }
    
    public void setSoThuTu(Integer soThuTu) {
        this.soThuTu = soThuTu;
    }
    
    public String getTinhTrangHienTai() {
        return tinhTrangHienTai;
    }
    
    public void setTinhTrangHienTai(String tinhTrangHienTai) {
        this.tinhTrangHienTai = tinhTrangHienTai;
    }
}