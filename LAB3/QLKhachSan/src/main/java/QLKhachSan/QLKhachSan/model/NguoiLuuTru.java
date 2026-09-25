package QLKhachSan.QLKhachSan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nguoi_luu_tru")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NguoiLuuTru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nguoi_lt")
    private Integer maNguoiLT;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(
            name = "so_phieu_dat",
            referencedColumnName = "so_phieu_dat"
        ),
        @JoinColumn(
            name = "SoPhong",
            referencedColumnName = "SoPhong"
        )
    })
    private ChiTietDatPhong chiTietDatPhong;

    @Column(name = "ho_ten", nullable = false, length = 120)
    private String hoTen;

    @Column(name = "so_cmnd", nullable = false, length = 30)
    private String soCMND;

    @Column(name = "quoc_tich", nullable = false, length = 80)
    private String quocTich;
}