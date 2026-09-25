package QLKhachSan.QLKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.ChiTietDatPhong;
import QLKhachSan.QLKhachSan.model.ChiTietDatPhongId;

@Repository
public interface ChiTietDatPhongRepository
        extends JpaRepository<ChiTietDatPhong, ChiTietDatPhongId> {

    @Query("""
        SELECT c
        FROM ChiTietDatPhong c
        WHERE c.id.soPhieuDat = :soPhieuDat
    """)
    List<ChiTietDatPhong> findBySoPhieuDat(
            @Param("soPhieuDat") String soPhieuDat
    );
}