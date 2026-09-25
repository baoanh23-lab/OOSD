package QLKhachSan.QLKhachSan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.ChiTietPhieuSuDungDV;
import QLKhachSan.QLKhachSan.model.ChiTietPhieuSuDungDVId;

@Repository
public interface ChiTietPhieuSuDungDVRepository
        extends JpaRepository<ChiTietPhieuSuDungDV, ChiTietPhieuSuDungDVId> {

    Optional<ChiTietPhieuSuDungDV> findByIdSoPhieuSDDVAndIdMaDV(
            String soPhieuSDDV,
            String maDV
    );
}