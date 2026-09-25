package QLKhachSan.QLKhachSan.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.PhieuLapDat;

@Repository
public interface PhieuLapDatRepository extends JpaRepository<PhieuLapDat, String> {

    List<PhieuLapDat> findByPhong_SoPhongOrderByNgayLapDesc(String soPhong);

    List<PhieuLapDat> findAllByOrderByNgayLapDesc();

    boolean existsByTienNghi_MaTienNghiAndNgayLap(
            String maTienNghi,
            LocalDate ngayLap
    );
}