package QLKhachSan.QLKhachSan.model;

import java.math.BigDecimal;

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
    name = "quy_dinh_den_bu",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_qddb_loai_mucdo",
            columnNames = {"ma_loai_tn", "muc_do_thiet_hai"}
        )
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuyDinhDenBu {

    @Id
    @Column(name = "ma_quy_dinh", length = 30)
    private String maQuyDinh;

    @ManyToOne
    @JoinColumn(name = "ma_loai_tn", nullable = false)
    private LoaiTienNghi loaiTienNghi;

    @Column(name = "muc_do_thiet_hai", nullable = false, length = 80)
    private String mucDoThietHai;

    @Column(name = "muc_den_bu", nullable = false, precision = 18, scale = 2)
    private BigDecimal mucDenBu;
    public void setMaQuyDinh(String maQuyDinh) {
        this.maQuyDinh = maQuyDinh;
    }
    
    public void setLoaiTienNghi(LoaiTienNghi loaiTienNghi) {
        this.loaiTienNghi = loaiTienNghi;
    }
    
    public void setMucDoThietHai(String mucDoThietHai) {
        this.mucDoThietHai = mucDoThietHai;
    }
    
    public void setMucDenBu(BigDecimal mucDenBu) {
        this.mucDenBu = mucDenBu;
    }
}