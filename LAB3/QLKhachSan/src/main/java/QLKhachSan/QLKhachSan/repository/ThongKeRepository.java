
package QLKhachSan.QLKhachSan.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import QLKhachSan.QLKhachSan.model.PhieuDatPhong;

public interface ThongKeRepository
        extends JpaRepository<PhieuDatPhong, String> {

    // ==========================
    // TỔNG HỢP
    // ==========================

    @Query("""
        SELECT COUNT(p)
        FROM PhieuDatPhong p
        WHERE p.ngayLap >= :tu
        AND p.ngayLap < :den
    """)
    Long demPhieuDat(
            @Param("tu") LocalDate tu,
            @Param("den") LocalDate den
    );


    @Query("""
        SELECT COUNT(p)
        FROM PhieuDatPhong p
        WHERE p.trangThai = 'Đang ở'
    """)
    Long demDangO();


    // ==========================
    // HÓA ĐƠN
    // ==========================

    @Query("""
        SELECT COUNT(h)
        FROM HoaDon h
        WHERE h.ngayLap >= :tu
        AND h.ngayLap < :den
    """)
    Long demHoaDon(
            @Param("tu") LocalDate tu,
            @Param("den") LocalDate den
    );


    @Query("""
        SELECT COALESCE(
            SUM(h.tienPhong + h.tienDichVu),
            0
        )
        FROM HoaDon h
        WHERE h.ngayLap >= :tu
        AND h.ngayLap < :den
    """)
    BigDecimal doanhThuHoaDon(
            @Param("tu") LocalDate tu,
            @Param("den") LocalDate den
    );


    // ==========================
    // ĐỀN BÙ
    // ==========================

    @Query("""
        SELECT COALESCE(SUM(p.tongTien), 0)
        FROM PhieuDenBu p
        WHERE p.ngayLap >= :tu
        AND p.ngayLap < :den
    """)
    BigDecimal tongDenBu(
            @Param("tu") LocalDate tu,
            @Param("den") LocalDate den
    );


    // ==========================
    // THỐNG KÊ DỊCH VỤ
    // ==========================

    @Query(value = """
        SELECT
            d.MaDV AS maDV,
            d.TenDV AS tenDV,
            SUM(c.SoLuong) AS tongSoLuong,
            SUM(c.ThanhTien) AS tongTien
        FROM PhieuSuDungDV p
        JOIN ChiTietPhieuSuDungDV c
            ON p.SoPhieuSDDV = c.SoPhieuSDDV
        JOIN DichVu d
            ON c.MaDV = d.MaDV
        WHERE p.NgaySuDung >= :tu
          AND p.NgaySuDung < :den
        GROUP BY d.MaDV, d.TenDV
        ORDER BY tongTien DESC
    """, nativeQuery = true)
    List<Map<String, Object>> thongKeDichVu(
            @Param("tu") LocalDate tu,
            @Param("den") LocalDate den
    );
}

