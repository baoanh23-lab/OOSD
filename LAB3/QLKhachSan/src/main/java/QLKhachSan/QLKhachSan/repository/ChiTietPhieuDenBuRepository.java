package QLKhachSan.QLKhachSan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.ChiTietPhieuDenBu;
import QLKhachSan.QLKhachSan.model.ChiTietPhieuDenBuId;

@Repository
public interface ChiTietPhieuDenBuRepository
        extends JpaRepository<ChiTietPhieuDenBu, ChiTietPhieuDenBuId> {
}