package lab4.lab4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lab4.lab4.entity.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    List<SanPham> findByNhomSanPham_MaNhom(Integer maNhom);
}