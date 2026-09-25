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
@Table(name = "KhuVuc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhuVuc {

    @Id
    @Column(name = "MaKhuVuc", length = 20)
    private String maKhuVuc;

    @Column(name = "TenKhuVuc", nullable = false, unique = true, length = 100)
    private String tenKhuVuc;

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }
}