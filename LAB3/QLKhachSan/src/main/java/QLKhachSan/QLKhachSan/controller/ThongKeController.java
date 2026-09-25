
package QLKhachSan.QLKhachSan.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import QLKhachSan.QLKhachSan.repository.ThongKeRepository;

@RestController
@RequestMapping("/api/thong-ke")
public class ThongKeController {

    private final ThongKeRepository thongKeRepository;

    public ThongKeController(ThongKeRepository thongKeRepository) {
        this.thongKeRepository = thongKeRepository;
    }


    // ==========================================
    // TỔNG HỢP
    // ==========================================

    @GetMapping("/tong-hop")
    public Map<String, Object> tongHop(
            @RequestParam String tu,
            @RequestParam String den) {

        LocalDate ngayTu = LocalDate.parse(tu);
        LocalDate ngayDen = LocalDate.parse(den);

        if (ngayDen.isBefore(ngayTu)) {
            throw new RuntimeException(
                    "Đến ngày không được trước từ ngày."
            );
        }

        /*
         * C#:
         *
         * SELECT COUNT(*) FROM PhieuDatPhong
         * WHERE CAST(NgayLap AS date) BETWEEN @tu AND @den
         */

        Long soPhieuDat =
                thongKeRepository.demPhieuDat(
                        ngayTu,
                        ngayDen.plusDays(1)
                );


        /*
         * C#:
         *
         * SELECT COUNT(*)
         * FROM PhieuDatPhong
         * WHERE TrangThai = N'Đang ở'
         */

        Long dangO =
                thongKeRepository.demDangO();


        /*
         * Số hóa đơn
         */

        Long soHoaDon =
                thongKeRepository.demHoaDon(
                        ngayTu,
                        ngayDen.plusDays(1)
                );


        /*
         * Doanh thu hóa đơn
         */

        BigDecimal doanhThuHoaDon =
                thongKeRepository.doanhThuHoaDon(
                        ngayTu,
                        ngayDen.plusDays(1)
                );


        /*
         * Tổng tiền đền bù
         */

        BigDecimal tongDenBu =
                thongKeRepository.tongDenBu(
                        ngayTu,
                        ngayDen.plusDays(1)
                );


        Map<String, Object> result =
                new LinkedHashMap<>();

        result.put("soPhieuDat", soPhieuDat);
        result.put("dangO", dangO);
        result.put("soHoaDon", soHoaDon);
        result.put("doanhThuHoaDon",
                doanhThuHoaDon != null
                        ? doanhThuHoaDon
                        : BigDecimal.ZERO);

        result.put("tongDenBu",
                tongDenBu != null
                        ? tongDenBu
                        : BigDecimal.ZERO);

        return result;
    }


    // ==========================================
    // THỐNG KÊ DỊCH VỤ
    // ==========================================

    @GetMapping("/dich-vu")
    public List<Map<String, Object>> dichVu(
            @RequestParam String tu,
            @RequestParam String den) {

        LocalDate ngayTu =
                LocalDate.parse(tu);

        LocalDate ngayDen =
                LocalDate.parse(den);

        if (ngayDen.isBefore(ngayTu)) {
            throw new RuntimeException(
                    "Đến ngày không được trước từ ngày."
            );
        }

        /*
         * Phần này sẽ gọi repository
         * để lấy:
         *
         * Mã dịch vụ
         * Tên dịch vụ
         * Tổng số lượng
         * Tổng tiền
         *
         * giống DichVu() trong C#.
         */

        return thongKeRepository.thongKeDichVu(
                ngayTu,
                ngayDen.plusDays(1)
        );
    }
}

