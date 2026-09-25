package QLKhachSan.QLKhachSan.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import QLKhachSan.QLKhachSan.model.ChiTietDatPhong;
import QLKhachSan.QLKhachSan.model.ChiTietDatPhongId;
import QLKhachSan.QLKhachSan.model.ChiTietPhieuDenBu;
import QLKhachSan.QLKhachSan.model.ChiTietPhieuDenBuId;
import QLKhachSan.QLKhachSan.model.HoaDon;
import QLKhachSan.QLKhachSan.model.NhanVien;
import QLKhachSan.QLKhachSan.model.PhieuDatPhong;
import QLKhachSan.QLKhachSan.model.PhieuDenBu;
import QLKhachSan.QLKhachSan.model.PhieuLapDat;
import QLKhachSan.QLKhachSan.model.QuyDinhDenBu;
import QLKhachSan.QLKhachSan.model.ThanhToan;
import QLKhachSan.QLKhachSan.repository.ChiTietDatPhongRepository;
import QLKhachSan.QLKhachSan.repository.ChiTietPhieuDenBuRepository;
import QLKhachSan.QLKhachSan.repository.HoaDonRepository;
import QLKhachSan.QLKhachSan.repository.NhanVienRepository;
import QLKhachSan.QLKhachSan.repository.PhieuDatPhongRepository;
import QLKhachSan.QLKhachSan.repository.PhieuDenBuRepository;
import QLKhachSan.QLKhachSan.repository.PhieuLapDatRepository;
import QLKhachSan.QLKhachSan.repository.QuyDinhDenBuRepository;
import QLKhachSan.QLKhachSan.repository.ThanhToanRepository;

@RestController
@RequestMapping("/api/tra-phong")
@CrossOrigin(origins = "*")
public class TraPhongController {

    private final PhieuDatPhongRepository phieuDatPhongRepository;
    private final ChiTietDatPhongRepository chiTietDatPhongRepository;
    private final PhieuLapDatRepository phieuLapDatRepository;

    private final QuyDinhDenBuRepository quyDinhRepository;
    private final PhieuDenBuRepository phieuDenBuRepository;
    private final ChiTietPhieuDenBuRepository chiTietDenBuRepository;
    private final NhanVienRepository nhanVienRepository;

    private final HoaDonRepository hoaDonRepository;
    private final ThanhToanRepository thanhToanRepository;

    public TraPhongController(
            PhieuDatPhongRepository phieuDatPhongRepository,
            ChiTietDatPhongRepository chiTietDatPhongRepository,
            PhieuLapDatRepository phieuLapDatRepository,
            QuyDinhDenBuRepository quyDinhRepository,
            PhieuDenBuRepository phieuDenBuRepository,
            ChiTietPhieuDenBuRepository chiTietDenBuRepository,
            NhanVienRepository nhanVienRepository,
            HoaDonRepository hoaDonRepository,
            ThanhToanRepository thanhToanRepository) {

        this.phieuDatPhongRepository = phieuDatPhongRepository;
        this.chiTietDatPhongRepository = chiTietDatPhongRepository;
        this.phieuLapDatRepository = phieuLapDatRepository;

        this.quyDinhRepository = quyDinhRepository;
        this.phieuDenBuRepository = phieuDenBuRepository;
        this.chiTietDenBuRepository = chiTietDenBuRepository;
        this.nhanVienRepository = nhanVienRepository;

        this.hoaDonRepository = hoaDonRepository;
        this.thanhToanRepository = thanhToanRepository;
    }

    // =====================================================
    // 1. LẤY PHIẾU ĐANG Ở
    // =====================================================

    @GetMapping("/phieu-dang-o")
    public List<PhieuDatPhong> layPhieuDangO() {

        return phieuDatPhongRepository.findByTrangThai("Đang ở");
    }

    // =====================================================
    // 2. LẤY PHÒNG THEO PHIẾU
    // =====================================================

    @GetMapping("/phong/{soPhieuDat}")
    public List<ChiTietDatPhong> layPhongTheoPhieu(
            @PathVariable String soPhieuDat) {

        return chiTietDatPhongRepository.findBySoPhieuDat(soPhieuDat);
    }

    // =====================================================
    // 3. LẤY TIỆN NGHI CỦA PHÒNG
    // =====================================================

    @GetMapping("/tien-nghi/{soPhong}")
    public List<PhieuLapDat> layTienNghiPhong(
            @PathVariable String soPhong) {

                return phieuLapDatRepository
        .findByPhong_SoPhongOrderByNgayLapDesc(soPhong);
    }

    // =====================================================
    // 4. LẤY QUY ĐỊNH ĐỀN BÙ
    // =====================================================

    @GetMapping("/quy-dinh-den-bu")
    public List<QuyDinhDenBu> layQuyDinh() {

        return quyDinhRepository.findAll();
    }

    // =====================================================
    // 5. LẬP PHIẾU ĐỀN BÙ
    // =====================================================

    @PostMapping("/den-bu")
    public ResponseEntity<?> lapPhieuDenBu(
            @RequestBody PhieuDenBuRequest request) {

        try {

            // -------------------------------
            // KIỂM TRA DỮ LIỆU
            // -------------------------------

            if (request.getSoPhieuDenBu() == null
                    || request.getSoPhieuDenBu().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Vui lòng nhập số phiếu đền bù.");
            }

            if (request.getSoPhieuDat() == null
                    || request.getSoPhieuDat().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Chưa chọn phiếu đặt phòng.");
            }

            if (request.getSoPhong() == null
                    || request.getSoPhong().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Chưa chọn phòng.");
            }

            if (request.getMaNV() == null
                    || request.getMaNV().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Chưa chọn nhân viên.");
            }

            if (request.getChiTiet() == null
                    || request.getChiTiet().isEmpty()) {

                return ResponseEntity.badRequest()
                        .body("Chưa có tiện nghi đền bù.");
            }

            // -------------------------------
            // KIỂM TRA PHÒNG TRONG PHIẾU
            // -------------------------------

            ChiTietDatPhongId idChiTiet =
                    new ChiTietDatPhongId(
                            request.getSoPhieuDat(),
                            request.getSoPhong()
                    );

            Optional<ChiTietDatPhong> optionalChiTiet =
                    chiTietDatPhongRepository.findById(idChiTiet);

            if (optionalChiTiet.isEmpty()) {

                return ResponseEntity.badRequest()
                        .body("Phòng không thuộc phiếu đặt phòng.");
            }

            ChiTietDatPhong chiTietDatPhong =
                    optionalChiTiet.get();

            // -------------------------------
            // TÍNH TỔNG TIỀN ĐỀN BÙ
            // -------------------------------

            BigDecimal tongTien = BigDecimal.ZERO;

            for (DenBuItem item : request.getChiTiet()) {

                if (item.getMaTienNghi() == null
                        || item.getMaTienNghi().isBlank()) {

                    return ResponseEntity.badRequest()
                            .body("Thiếu mã tiện nghi.");
                }

                if (item.getSoTien() == null
                        || item.getSoTien()
                        .compareTo(BigDecimal.ZERO) < 0) {

                    return ResponseEntity.badRequest()
                            .body("Số tiền đền bù không hợp lệ.");
                }

                tongTien = tongTien.add(
                        item.getSoTien()
                );
            }

            // -------------------------------
            // TÌM NHÂN VIÊN
            // -------------------------------

            NhanVien nhanVien =
                    nhanVienRepository
                            .findById(request.getMaNV())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Không tìm thấy nhân viên."
                                    )
                            );

            // -------------------------------
            // TẠO PHIẾU ĐỀN BÙ
            // -------------------------------

            PhieuDenBu phieu =
                    new PhieuDenBu();

            phieu.setSoPhieuDenBu(
                    request.getSoPhieuDenBu()
            );

            phieu.setChiTietDatPhong(
                    chiTietDatPhong
            );

            phieu.setNgayLap(
                    LocalDateTime.now()
            );

            phieu.setNhanVien(
                    nhanVien
            );

            phieu.setTongTien(
                    tongTien
            );

            phieuDenBuRepository.save(phieu);

            // -------------------------------
            // LƯU CHI TIẾT ĐỀN BÙ
            // -------------------------------

            for (DenBuItem item : request.getChiTiet()) {

                ChiTietPhieuDenBu chiTiet =
                        new ChiTietPhieuDenBu();

                ChiTietPhieuDenBuId id =
                        new ChiTietPhieuDenBuId(
                                request.getSoPhieuDenBu(),
                                item.getMaTienNghi()
                        );

                chiTiet.setId(id);

                chiTiet.setMucDoThietHai(
                        item.getMucDoThietHai()
                );

                chiTiet.setSoTien(
                        item.getSoTien()
                );

                chiTietDenBuRepository.save(
                        chiTiet
                );
            }

            return ResponseEntity.ok(
                    "Đã lập phiếu đền bù."
            );

        } catch (Exception e) {

            return ResponseEntity.internalServerError()
                    .body("Lỗi: " + e.getMessage());
        }
    }

    // =====================================================
    // 6. LẤY DANH SÁCH HÓA ĐƠN
    // =====================================================

    @GetMapping("/hoa-don")
    public List<HoaDon> layHoaDon() {

        return hoaDonRepository.findAll();
    }

    // =====================================================
    // 7. LẬP HÓA ĐƠN
    // =====================================================

    @PostMapping("/hoa-don")
    public ResponseEntity<?> lapHoaDon(
            @RequestBody HoaDonRequest request) {

        try {

            // -------------------------------
            // KIỂM TRA DỮ LIỆU
            // -------------------------------

            if (request.getSoHoaDon() == null
                    || request.getSoHoaDon().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Vui lòng nhập số hóa đơn.");
            }

            if (request.getSoPhieuDat() == null
                    || request.getSoPhieuDat().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Chưa chọn phiếu đặt phòng.");
            }

            if (request.getMaNV() == null
                    || request.getMaNV().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Chưa chọn nhân viên.");
            }

            if (request.getSoNgay() <= 0) {

                return ResponseEntity.badRequest()
                        .body("Số ngày phải lớn hơn 0.");
            }

            // -------------------------------
            // TÌM PHIẾU ĐẶT
            // -------------------------------

            PhieuDatPhong phieuDatPhong =
                    phieuDatPhongRepository
                            .findById(request.getSoPhieuDat())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Không tìm thấy phiếu đặt phòng."
                                    )
                            );

            // -------------------------------
            // TÌM NHÂN VIÊN
            // -------------------------------

            NhanVien nhanVien =
                    nhanVienRepository
                            .findById(request.getMaNV())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Không tìm thấy nhân viên."
                                    )
                            );

            // -------------------------------
            // TẠM TÍNH TIỀN
            // -------------------------------

            BigDecimal tienPhong =
                    BigDecimal.ZERO;

            BigDecimal tienDichVu =
                    BigDecimal.ZERO;

            // -------------------------------
            // TẠO HÓA ĐƠN
            // -------------------------------

            HoaDon hoaDon =
                    new HoaDon();

            hoaDon.setSoHoaDon(
                    request.getSoHoaDon()
            );

            hoaDon.setPhieuDatPhong(
                    phieuDatPhong
            );

            hoaDon.setNgayLap(
                    LocalDateTime.now()
            );

            hoaDon.setNhanVien(
                    nhanVien
            );

            hoaDon.setSoNgayTinhTien(
                    request.getSoNgay()
            );

            hoaDon.setTienPhong(
                    tienPhong
            );

            hoaDon.setTienDichVu(
                    tienDichVu
            );

            hoaDon.setTrangThai(
                    "Chưa thanh toán"
            );

            hoaDonRepository.save(
                    hoaDon
            );

            return ResponseEntity.ok(
                    "Đã lập hóa đơn."
            );

        } catch (Exception e) {

            return ResponseEntity.internalServerError()
                    .body("Lỗi: " + e.getMessage());
        }
    }

    // =====================================================
    // 8. THANH TOÁN
    // =====================================================

    @PostMapping("/thanh-toan")
    public ResponseEntity<?> thanhToan(
            @RequestBody ThanhToanRequest request) {

        try {

            // -------------------------------
            // KIỂM TRA DỮ LIỆU
            // -------------------------------

            if (request.getMaTT() == null
                    || request.getMaTT().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Vui lòng nhập mã thanh toán.");
            }

            if (request.getSoHoaDon() == null
                    || request.getSoHoaDon().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Chưa chọn hóa đơn.");
            }

            if (request.getHinhThuc() == null
                    || request.getHinhThuc().isBlank()) {

                return ResponseEntity.badRequest()
                        .body("Chưa chọn hình thức thanh toán.");
            }

            if (request.getSoTien() == null
                    || request.getSoTien()
                    .compareTo(BigDecimal.ZERO) <= 0) {

                return ResponseEntity.badRequest()
                        .body("Số tiền thanh toán không hợp lệ.");
            }

            // -------------------------------
            // TÌM HÓA ĐƠN
            // -------------------------------

            HoaDon hoaDon =
                    hoaDonRepository
                            .findById(request.getSoHoaDon())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Không tìm thấy hóa đơn."
                                    )
                            );

            // -------------------------------
            // TỔNG HÓA ĐƠN
            // -------------------------------

            BigDecimal tongHoaDon =
                    hoaDon.getTienPhong()
                            .add(
                                    hoaDon.getTienDichVu()
                            );

            // -------------------------------
            // LẤY CÁC THANH TOÁN CŨ
            // -------------------------------

            List<ThanhToan> dsThanhToan =
                    thanhToanRepository
                            .findByHoaDon(hoaDon);

            BigDecimal daThanhToan =
                    BigDecimal.ZERO;

            for (ThanhToan tt : dsThanhToan) {

                if (tt.getSoTien() != null) {

                    daThanhToan =
                            daThanhToan.add(
                                    tt.getSoTien()
                            );
                }
            }

            // -------------------------------
            // TỔNG SAU KHI THANH TOÁN
            // -------------------------------

            BigDecimal sauThanhToan =
                    daThanhToan.add(
                            request.getSoTien()
                    );

            if (sauThanhToan.compareTo(tongHoaDon) > 0) {

                return ResponseEntity.badRequest()
                        .body(
                                "Số tiền thanh toán vượt tổng hóa đơn."
                        );
            }

            // -------------------------------
            // TẠO THANH TOÁN
            // -------------------------------

            ThanhToan thanhToan =
                    new ThanhToan();

            thanhToan.setMaThanhToan(
                    request.getMaTT()
            );

            thanhToan.setHoaDon(
                    hoaDon
            );

            thanhToan.setNgayThanhToan(
                    LocalDateTime.now()
            );

            thanhToan.setHinhThuc(
                    request.getHinhThuc()
            );

            thanhToan.setSoTien(
                    request.getSoTien()
            );

            thanhToanRepository.save(
                    thanhToan
            );

            // -------------------------------
            // ĐỦ TIỀN -> ĐÃ THANH TOÁN
            // -------------------------------

            if (sauThanhToan.compareTo(tongHoaDon) == 0) {

                hoaDon.setTrangThai(
                        "Đã thanh toán"
                );

                hoaDonRepository.save(
                        hoaDon
                );
            }

            return ResponseEntity.ok(
                    "Đã ghi nhận thanh toán."
            );

        } catch (Exception e) {

            return ResponseEntity.internalServerError()
                    .body("Lỗi: " + e.getMessage());
        }
    }

    // =====================================================
    // 9. TRẢ PHÒNG
    // =====================================================

    @PostMapping("/tra-phong/{soPhieuDat}")
    public ResponseEntity<?> traPhong(
            @PathVariable String soPhieuDat) {

        try {

            // -------------------------------
            // TÌM PHIẾU ĐẶT
            // -------------------------------

            PhieuDatPhong phieu =
                    phieuDatPhongRepository
                            .findById(soPhieuDat)
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Không tìm thấy phiếu đặt phòng."
                                    )
                            );

            // -------------------------------
            // TÌM HÓA ĐƠN THEO PHIẾU ĐẶT
            // -------------------------------

            List<HoaDon> dsHoaDon =
                    hoaDonRepository.findAll();

            HoaDon hoaDon = null;

            for (HoaDon hd : dsHoaDon) {

                if (hd.getPhieuDatPhong() != null
                        && hd.getPhieuDatPhong()
                                .getSoPhieuDat()
                                .equals(soPhieuDat)) {

                    hoaDon = hd;
                    break;
                }
            }

            if (hoaDon == null) {

                return ResponseEntity.badRequest()
                        .body(
                                "Chưa lập hóa đơn cho phiếu đặt phòng."
                        );
            }

            // -------------------------------
            // KIỂM TRA THANH TOÁN
            // -------------------------------

            if (!"Đã thanh toán".equals(
                    hoaDon.getTrangThai())) {

                return ResponseEntity.badRequest()
                        .body(
                                "Hóa đơn chưa thanh toán đủ."
                        );
            }

            // -------------------------------
            // CẬP NHẬT TRẠNG THÁI PHIẾU
            // -------------------------------

            phieu.setTrangThai(
                    "Đã trả"
            );

            phieu.setNgayTraThucTe(
                    LocalDateTime.now()
            );

            phieuDatPhongRepository.save(
                    phieu
            );

            return ResponseEntity.ok(
                    "Đã hoàn tất trả phòng."
            );

        } catch (Exception e) {

            return ResponseEntity.internalServerError()
                    .body("Lỗi: " + e.getMessage());
        }
    }

    // =====================================================
    // REQUEST: PHIẾU ĐỀN BÙ
    // =====================================================

    public static class PhieuDenBuRequest {

        private String soPhieuDenBu;
        private String soPhieuDat;
        private String soPhong;
        private String maNV;
        private List<DenBuItem> chiTiet;

        public String getSoPhieuDenBu() {
            return soPhieuDenBu;
        }

        public void setSoPhieuDenBu(String soPhieuDenBu) {
            this.soPhieuDenBu = soPhieuDenBu;
        }

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

        public String getMaNV() {
            return maNV;
        }

        public void setMaNV(String maNV) {
            this.maNV = maNV;
        }

        public List<DenBuItem> getChiTiet() {
            return chiTiet;
        }

        public void setChiTiet(List<DenBuItem> chiTiet) {
            this.chiTiet = chiTiet;
        }
    }

    // =====================================================
    // REQUEST: CHI TIẾT ĐỀN BÙ
    // =====================================================

    public static class DenBuItem {

        private String maTienNghi;
        private String mucDoThietHai;
        private BigDecimal soTien;

        public String getMaTienNghi() {
            return maTienNghi;
        }

        public void setMaTienNghi(String maTienNghi) {
            this.maTienNghi = maTienNghi;
        }

        public String getMucDoThietHai() {
            return mucDoThietHai;
        }

        public void setMucDoThietHai(String mucDoThietHai) {
            this.mucDoThietHai = mucDoThietHai;
        }

        public BigDecimal getSoTien() {
            return soTien;
        }

        public void setSoTien(BigDecimal soTien) {
            this.soTien = soTien;
        }
    }

    // =====================================================
    // REQUEST: HÓA ĐƠN
    // =====================================================

    public static class HoaDonRequest {

        private String soHoaDon;
        private String soPhieuDat;
        private String maNV;
        private int soNgay;

        public String getSoHoaDon() {
            return soHoaDon;
        }

        public void setSoHoaDon(String soHoaDon) {
            this.soHoaDon = soHoaDon;
        }

        public String getSoPhieuDat() {
            return soPhieuDat;
        }

        public void setSoPhieuDat(String soPhieuDat) {
            this.soPhieuDat = soPhieuDat;
        }

        public String getMaNV() {
            return maNV;
        }

        public void setMaNV(String maNV) {
            this.maNV = maNV;
        }

        public int getSoNgay() {
            return soNgay;
        }

        public void setSoNgay(int soNgay) {
            this.soNgay = soNgay;
        }
    }

    // =====================================================
    // REQUEST: THANH TOÁN
    // =====================================================

    public static class ThanhToanRequest {

        private String maTT;
        private String soHoaDon;
        private String hinhThuc;
        private BigDecimal soTien;

        public String getMaTT() {
            return maTT;
        }

        public void setMaTT(String maTT) {
            this.maTT = maTT;
        }

        public String getSoHoaDon() {
            return soHoaDon;
        }

        public void setSoHoaDon(String soHoaDon) {
            this.soHoaDon = soHoaDon;
        }

        public String getHinhThuc() {
            return hinhThuc;
        }

        public void setHinhThuc(String hinhThuc) {
            this.hinhThuc = hinhThuc;
        }

        public BigDecimal getSoTien() {
            return soTien;
        }

        public void setSoTien(BigDecimal soTien) {
            this.soTien = soTien;
        }
    }
}