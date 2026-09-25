package QLKhachSan.QLKhachSan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
}