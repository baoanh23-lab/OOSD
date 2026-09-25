package QLKhachSan.QLKhachSan.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import QLKhachSan.QLKhachSan.model.KhuVuc;
import QLKhachSan.QLKhachSan.model.LoaiTienNghi;
import QLKhachSan.QLKhachSan.model.NhanVien;
import QLKhachSan.QLKhachSan.model.PhieuLapDat;
import QLKhachSan.QLKhachSan.model.Phong;
import QLKhachSan.QLKhachSan.model.TienNghi;
import QLKhachSan.QLKhachSan.repository.KhuVucRepository;
import QLKhachSan.QLKhachSan.repository.LoaiTienNghiRepository;
import QLKhachSan.QLKhachSan.repository.NhanVienRepository;
import QLKhachSan.QLKhachSan.repository.PhieuLapDatRepository;
import QLKhachSan.QLKhachSan.repository.PhongRepository;
import QLKhachSan.QLKhachSan.repository.TienNghiRepository;

@Service
public class PhongTienNghiService {

    private final PhongRepository phongRepository;
    private final TienNghiRepository tienNghiRepository;
    private final PhieuLapDatRepository phieuLapDatRepository;

    private final KhuVucRepository khuVucRepository;
    private final LoaiTienNghiRepository loaiTienNghiRepository;
    private final NhanVienRepository nhanVienRepository;

    public PhongTienNghiService(
            PhongRepository phongRepository,
            TienNghiRepository tienNghiRepository,
            PhieuLapDatRepository phieuLapDatRepository,
            KhuVucRepository khuVucRepository,
            LoaiTienNghiRepository loaiTienNghiRepository,
            NhanVienRepository nhanVienRepository) {

        this.phongRepository = phongRepository;
        this.tienNghiRepository = tienNghiRepository;
        this.phieuLapDatRepository = phieuLapDatRepository;

        this.khuVucRepository = khuVucRepository;
        this.loaiTienNghiRepository = loaiTienNghiRepository;
        this.nhanVienRepository = nhanVienRepository;
    }

    // =========================
    // LẤY PHÒNG
    // =========================

    public List<Phong> layPhong() {
        return phongRepository.findAllByOrderBySoPhongAsc();
    }

    // =========================
    // LẤY TIỆN NGHI
    // =========================

    public List<TienNghi> layTienNghi() {

        System.out.println("========== LAY TIEN NGHI ==========");
    
        List<TienNghi> danhSach =
                tienNghiRepository.findAllByOrderByMaTienNghiAsc();
    
        System.out.println("SO LUONG = " + danhSach.size());
    
        for (TienNghi tn : danhSach) {
            System.out.println(
                    "MA = " + tn.getMaTienNghi()
                    + " | LOAI = "
                    + (tn.getLoaiTienNghi() != null
                        ? tn.getLoaiTienNghi().getMaLoaiTN()
                        : "NULL")
            );
        }
    
        return danhSach;
    }

    // =========================
    // LẤY PHIẾU LẮP ĐẶT
    // =========================

    public List<PhieuLapDat> layLapDat() {
        return phieuLapDatRepository.findAllByOrderByNgayLapDesc();
    }

    // =========================
    // THÊM PHÒNG
    // =========================

    public String themPhong(
            String so,
            String khu,
            int max,
            BigDecimal gia) {

        if (so == null || so.trim().isEmpty()
                || khu == null || khu.trim().isEmpty()
                || max <= 0
                || gia == null
                || gia.compareTo(BigDecimal.ZERO) < 0) {

            return "Thông tin phòng không hợp lệ.";
        }

        try {

            // Tìm khu vực
            KhuVuc khuVuc = khuVucRepository
                    .findById(khu.trim())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Không tìm thấy khu vực."
                            )
                    );

            // Tạo phòng
            Phong phong = new Phong();

            phong.setSoPhong(so.trim());
            phong.setKhuVuc(khuVuc);
            phong.setSoNguoiToiDa(max);
            phong.setDonGiaNgay(gia);
            phong.setTrangThai("Trống");

            phongRepository.save(phong);

            return "Đã thêm phòng.";

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    // =========================
    // THÊM TIỆN NGHI
    // =========================

    public String themTienNghi(
            String ma,
            String loai,
            int stt,
            String tinhTrang) {

        if (ma == null || ma.trim().isEmpty()
                || loai == null || loai.trim().isEmpty()
                || stt <= 0) {

            return "Thông tin tiện nghi không hợp lệ.";
        }

        try {

            // Tìm loại tiện nghi
            LoaiTienNghi loaiTienNghi = loaiTienNghiRepository
                    .findById(loai.trim())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Không tìm thấy loại tiện nghi."
                            )
                    );

            // Tạo tiện nghi
            TienNghi tienNghi = new TienNghi();

            tienNghi.setMaTienNghi(ma.trim());
            tienNghi.setLoaiTienNghi(loaiTienNghi);
            tienNghi.setSoThuTu(stt);
            tienNghi.setTinhTrangHienTai(
                    tinhTrang == null ? "" : tinhTrang.trim()
            );

            tienNghiRepository.save(tienNghi);

            return "Đã thêm tiện nghi.";

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    // =========================
    // LẬP ĐẶT
    // =========================

    @Transactional
    public String lapDat(
            String soPhieu,
            String maTN,
            String soPhong,
            LocalDate ngay,
            String tinhTrang,
            String maNV,
            String ghiChu) {

        if (soPhieu == null || soPhieu.trim().isEmpty()
                || maTN == null || maTN.trim().isEmpty()
                || soPhong == null || soPhong.trim().isEmpty()
                || ngay == null
                || tinhTrang == null || tinhTrang.trim().isEmpty()
                || maNV == null || maNV.trim().isEmpty()) {

            return "Phiếu lắp đặt chưa đủ thông tin.";
        }

        try {

            // =========================
            // TÌM TIỆN NGHI
            // =========================

            TienNghi tienNghi = tienNghiRepository
                    .findById(maTN.trim())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Không tìm thấy tiện nghi."
                            )
                    );

            // =========================
            // TÌM PHÒNG
            // =========================

            Phong phong = phongRepository
                    .findById(soPhong.trim())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Không tìm thấy phòng."
                            )
                    );

            // =========================
            // TÌM NHÂN VIÊN
            // =========================

            NhanVien nhanVien = nhanVienRepository
                    .findById(maNV.trim())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Không tìm thấy nhân viên."
                            )
                    );

            // =========================
            // KIỂM TRA THIẾT BỊ
            // ĐÃ LẮP TRONG NGÀY CHƯA
            // =========================

            boolean daLap = phieuLapDatRepository
                    .existsByTienNghi_MaTienNghiAndNgayLap(
                            maTN.trim(),
                            ngay
                    );

            if (daLap) {
                return "Thiết bị này đã được lắp cho một phòng khác trong ngày đã chọn.";
            }

            // =========================
            // TẠO PHIẾU LẮP ĐẶT
            // =========================

            PhieuLapDat phieu = new PhieuLapDat();

            phieu.setSoPhieuLapDat(soPhieu.trim());
            phieu.setTienNghi(tienNghi);
            phieu.setPhong(phong);
            phieu.setNgayLap(ngay);
            phieu.setTinhTrang(tinhTrang.trim());
            phieu.setNhanVien(nhanVien);
            phieu.setGhiChu(
                    ghiChu == null ? "" : ghiChu.trim()
            );

            phieuLapDatRepository.save(phieu);

            // =========================
            // CẬP NHẬT TÌNH TRẠNG
            // TIỆN NGHI
            // =========================

            tienNghi.setTinhTrangHienTai(
                    tinhTrang.trim()
            );

            tienNghiRepository.save(tienNghi);

            return "Đã lập phiếu lắp đặt.";

        } catch (Exception e) {

            return e.getMessage();
        }
    }
}