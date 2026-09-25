package QLKhachSan.QLKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.HoaDon;
import QLKhachSan.QLKhachSan.model.ThanhToan;

@Repository
public interface ThanhToanRepository
        extends JpaRepository<ThanhToan, String> {

    List<ThanhToan> findByHoaDon(HoaDon hoaDon);
}