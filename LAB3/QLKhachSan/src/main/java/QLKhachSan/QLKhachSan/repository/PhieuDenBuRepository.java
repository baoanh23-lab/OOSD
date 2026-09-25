package QLKhachSan.QLKhachSan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.PhieuDenBu;

@Repository
public interface PhieuDenBuRepository extends JpaRepository<PhieuDenBu, String> {
}