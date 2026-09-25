package QLKhachSan.QLKhachSan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
}