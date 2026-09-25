package QLKhachSan.QLKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.PhieuDatPhong;

@Repository
public interface PhieuDatPhongRepository
        extends JpaRepository<PhieuDatPhong, String> {

    List<PhieuDatPhong> findByTrangThai(String trangThai);
}