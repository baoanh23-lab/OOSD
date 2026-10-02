package lab4.lab4.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lab4.lab4.entity.GioHang;

public interface GioHangRepository
        extends JpaRepository<GioHang, Integer> {

    Optional<GioHang> findByMaKhachHang(Integer maKhachHang);
}