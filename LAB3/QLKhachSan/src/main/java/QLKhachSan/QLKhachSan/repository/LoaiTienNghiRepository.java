package QLKhachSan.QLKhachSan.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import QLKhachSan.QLKhachSan.model.LoaiTienNghi;

public interface LoaiTienNghiRepository
        extends JpaRepository<LoaiTienNghi, String> {

    List<LoaiTienNghi> findAllByOrderByMaLoaiTNAsc();
}