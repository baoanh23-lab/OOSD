package QLKhachSan.QLKhachSan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chi_tiet_dat_phong")
@IdClass(ChiTietDatPhongId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDatPhong {

    @Id
    @Column(name = "so_phieu_dat", length = 30)
    private String soPhieuDat;

    @Id
    @Column(name = "SoPhong", length = 20)
    private String soPhong;

    @Column(name = "so_nguoi", nullable = false)
    private Integer soNguoi;

    @ManyToOne
    @JoinColumn(
        name = "so_phieu_dat",
        insertable = false,
        updatable = false
    )
    private PhieuDatPhong phieuDatPhong;

    @ManyToOne
    @JoinColumn(
        name = "SoPhong",
        insertable = false,
        updatable = false
    )
    private Phong phong;
}