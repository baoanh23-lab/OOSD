package QLKhachSan.QLKhachSan.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.PhieuSuDungDV;

@Repository
public interface PhieuSuDungDVRepository extends JpaRepository<PhieuSuDungDV, String> {

    Optional<PhieuSuDungDV> findBySoPhieuDatAndSoPhongAndNgaySuDung(
            String soPhieuDat,
            String soPhong,
            LocalDate ngaySuDung
    );
}