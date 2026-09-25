package QLKhachSan.QLKhachSan.controller;

import QLKhachSan.QLKhachSan.model.*;
import QLKhachSan.QLKhachSan.repository.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api/dich-vu")
@CrossOrigin(origins = "*")
public class DichVuController {

    private final DichVuRepository dichVuRepository;
    private final PhieuSuDungDVRepository phieuRepository;
    private final ChiTietPhieuSuDungDVRepository chiTietRepository;
    private final NhanVienRepository nhanVienRepository;
    private final PhieuDatPhongRepository phieuDatPhongRepository;

    public DichVuController(
            DichVuRepository dichVuRepository,
            PhieuSuDungDVRepository phieuRepository,
            ChiTietPhieuSuDungDVRepository chiTietRepository,
            NhanVienRepository nhanVienRepository, 
            PhieuDatPhongRepository phieuDatPhongRepository) {

        this.dichVuRepository = dichVuRepository;
        this.phieuRepository = phieuRepository;
        this.chiTietRepository = chiTietRepository;
        this.nhanVienRepository = nhanVienRepository;
        this.phieuDatPhongRepository = phieuDatPhongRepository;
    }

    // =========================
    // DANH SÁCH DỊCH VỤ
    // =========================

    @GetMapping
    public List<DichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }
    @GetMapping("/phieu-dang-o")
    public List<PhieuDatPhong> getPhieuDangO() {
        return phieuDatPhongRepository.findByTrangThai("Đang ở");
    }

    // =========================
    // GHI NHẬN DỊCH VỤ
    // =========================

    @PostMapping("/ghi-nhan")
    public ResponseEntity<?> ghiNhan(@RequestBody GhiNhanDichVuRequest request) {

        if (request.getSoPhieuDat() == null ||
                request.getSoPhieuDat().isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Vui lòng chọn phiếu đang ở.");
        }

        if (request.getSoPhong() == null ||
                request.getSoPhong().isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Không xác định được phòng.");
        }

        if (request.getMaDV() == null ||
                request.getMaDV().isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Vui lòng chọn dịch vụ.");
        }

        if (request.getMaNV() == null ||
                request.getMaNV().isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Vui lòng chọn nhân viên.");
        }

        if (request.getSoLuong() <= 0) {

            return ResponseEntity.badRequest()
                    .body("Số lượng phải lớn hơn 0.");
        }

        // Kiểm tra phiếu đặt
        Optional<PhieuDatPhong> phieuDat =
                Optional.empty();

        // Kiểm tra bằng repository PhieuDatPhong nếu bạn đã có
        // Phần dưới dùng EntityManager đơn giản hơn.
        try {

            // kiểm tra dịch vụ
            Optional<DichVu> dichVu =
                    dichVuRepository.findById(request.getMaDV());

            if (dichVu.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Không tìm thấy dịch vụ.");
            }

            BigDecimal donGia = dichVu.get().getDonGia();

            LocalDate ngay = request.getNgaySuDung();

            // Tìm phiếu dịch vụ của đúng:
            // Phiếu đặt + phòng + ngày
            Optional<PhieuSuDungDV> phieuDV =
                    phieuRepository
                            .findBySoPhieuDatAndSoPhongAndNgaySuDung(
                                    request.getSoPhieuDat(),
                                    request.getSoPhong(),
                                    ngay
                            );

            PhieuSuDungDV phieuSuDung;

            if (phieuDV.isPresent()) {

                // Đã có phiếu dịch vụ trong ngày
                phieuSuDung = phieuDV.get();

            } else {

                // Chưa có → tạo phiếu mới
                phieuSuDung = new PhieuSuDungDV();

                String soPhieuDV =
                        "SD" + LocalDateTime.now()
                                .format(DateTimeFormatter.ofPattern(
                                        "yyyyMMddHHmmssSSS"));

                phieuSuDung.setSoPhieuSDDV(soPhieuDV);
                phieuSuDung.setSoPhieuDat(request.getSoPhieuDat());
                phieuSuDung.setSoPhong(request.getSoPhong());
                phieuSuDung.setNgaySuDung(ngay);
                phieuSuDung.setMaNV(request.getMaNV());

                phieuSuDung =
                        phieuRepository.save(phieuSuDung);
            }

            // =========================
            // CHI TIẾT DỊCH VỤ
            // =========================

            String soPhieuDV =
                    phieuSuDung.getSoPhieuSDDV();

            ChiTietPhieuSuDungDVId id =
                    new ChiTietPhieuSuDungDVId(
                            soPhieuDV,
                            request.getMaDV()
                    );

            Optional<ChiTietPhieuSuDungDV> chiTietCu =
                    chiTietRepository.findById(id);

            if (chiTietCu.isPresent()) {

                // DV02:
                // Cùng dịch vụ + cùng ngày
                // → cộng số lượng

                ChiTietPhieuSuDungDV chiTiet =
                        chiTietCu.get();

                chiTiet.setSoLuong(
                        chiTiet.getSoLuong()
                                + request.getSoLuong()
                );

                chiTiet.setDonGia(donGia);

                chiTietRepository.save(chiTiet);

            } else {

                // DV01:
                // Dịch vụ lần đầu
                // → INSERT

                ChiTietPhieuSuDungDV chiTiet =
                        new ChiTietPhieuSuDungDV();

                chiTiet.setId(id);
                chiTiet.setSoLuong(request.getSoLuong());
                chiTiet.setDonGia(donGia);

                chiTietRepository.save(chiTiet);
            }

            return ResponseEntity.ok(
                    "Đã ghi nhận dịch vụ."
            );

        } catch (Exception e) {

            return ResponseEntity.internalServerError()
                    .body("Lỗi: " + e.getMessage());
        }
    }

    // =========================
    // REQUEST
    // =========================

    public static class GhiNhanDichVuRequest {

        private String soPhieuDat;
        private String soPhong;
        private LocalDate ngaySuDung;
        private String maNV;
        private String maDV;
        private int soLuong;

        public String getSoPhieuDat() {
            return soPhieuDat;
        }

        public void setSoPhieuDat(String soPhieuDat) {
            this.soPhieuDat = soPhieuDat;
        }

        public String getSoPhong() {
            return soPhong;
        }

        public void setSoPhong(String soPhong) {
            this.soPhong = soPhong;
        }

        public LocalDate getNgaySuDung() {
            return ngaySuDung;
        }

        public void setNgaySuDung(LocalDate ngaySuDung) {
            this.ngaySuDung = ngaySuDung;
        }

        public String getMaNV() {
            return maNV;
        }

        public void setMaNV(String maNV) {
            this.maNV = maNV;
        }

        public String getMaDV() {
            return maDV;
        }

        public void setMaDV(String maDV) {
            this.maDV = maDV;
        }

        public int getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(int soLuong) {
            this.soLuong = soLuong;
        }
    }
}