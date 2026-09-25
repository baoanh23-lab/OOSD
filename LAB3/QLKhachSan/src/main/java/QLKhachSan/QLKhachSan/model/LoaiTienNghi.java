package QLKhachSan.QLKhachSan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LoaiTienNghi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiTienNghi {

    @Id
    @Column(name = "MaLoaiTN", length = 20)
    private String maLoaiTN;

    @Column(name = "TenLoaiTN", nullable = false, unique = true, length = 100)
    private String tenLoaiTN;

    public void setMaLoaiTN(String maLoaiTN) {
        this.maLoaiTN = maLoaiTN;
    }

    public void setTenLoaiTN(String tenLoaiTN) {
        this.tenLoaiTN = tenLoaiTN;
    }
    public String getMaLoaiTN() {
        return maLoaiTN; // Đảm bảo tên biến bên trong class của bạn khớp (ví dụ: maLoaiTN hoặc maLoaiTienNghi)
    }
}