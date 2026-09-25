package QLKhachSan.QLKhachSan.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import QLKhachSan.QLKhachSan.model.NhanVien;

public interface NhanVienRepository
        extends JpaRepository<NhanVien, String> {

    List<NhanVien> findAllByOrderByMaNVAsc();
}