package QLKhachSan.QLKhachSan.service;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import QLKhachSan.QLKhachSan.model.DichVu;
import QLKhachSan.QLKhachSan.model.KhuVuc;
import QLKhachSan.QLKhachSan.model.LoaiTienNghi;
import QLKhachSan.QLKhachSan.model.NhanVien;
import QLKhachSan.QLKhachSan.model.QuyDinhDenBu;
import QLKhachSan.QLKhachSan.repository.DichVuRepository;
import QLKhachSan.QLKhachSan.repository.KhuVucRepository;
import QLKhachSan.QLKhachSan.repository.LoaiTienNghiRepository;
import QLKhachSan.QLKhachSan.repository.NhanVienRepository;
import QLKhachSan.QLKhachSan.repository.QuyDinhDenBuRepository;

@Service
public class DanhMucService {

    private final KhuVucRepository khuVucRepository;
    private final NhanVienRepository nhanVienRepository;
    private final LoaiTienNghiRepository loaiTienNghiRepository;
    private final DichVuRepository dichVuRepository;
    private final QuyDinhDenBuRepository quyDinhDenBuRepository;

    public DanhMucService(
            KhuVucRepository khuVucRepository,
            NhanVienRepository nhanVienRepository,
            LoaiTienNghiRepository loaiTienNghiRepository,
            DichVuRepository dichVuRepository,
            QuyDinhDenBuRepository quyDinhDenBuRepository) {

        this.khuVucRepository = khuVucRepository;
        this.nhanVienRepository = nhanVienRepository;
        this.loaiTienNghiRepository = loaiTienNghiRepository;
        this.dichVuRepository = dichVuRepository;
        this.quyDinhDenBuRepository = quyDinhDenBuRepository;
    }

    // =========================
    // LẤY DANH SÁCH
    // =========================

    public List<KhuVuc> layKhuVuc() {
        return khuVucRepository.findAllByOrderByMaKhuVucAsc();
    }

    public List<NhanVien> layNhanVien() {
        return nhanVienRepository.findAllByOrderByMaNVAsc();
    }

    public List<LoaiTienNghi> layLoaiTienNghi() {
        return loaiTienNghiRepository.findAllByOrderByMaLoaiTNAsc();
    }

    public List<DichVu> layDichVu() {
        return dichVuRepository.findAllByOrderByMaDVAsc();
    }

    public List<QuyDinhDenBu> layQuyDinhDenBu() {
        return quyDinhDenBuRepository.findAllByOrderByMaQuyDinhAsc();
    }


    // =========================
    // THÊM KHU VỰC
    // =========================

    public String themKhu(String ma, String ten) {

        if (ma == null || ma.trim().isEmpty()
                || ten == null || ten.trim().isEmpty()) {

            return "Mã khu vực và tên khu vực không được để trống.";
        }

        try {
            KhuVuc khuVuc = new KhuVuc();

            khuVuc.setMaKhuVuc(ma.trim());
            khuVuc.setTenKhuVuc(ten.trim());

            khuVucRepository.save(khuVuc);

            return "Đã thêm khu vực.";

        } catch (Exception e) {
            return e.getMessage();
        }
    }


    // =========================
    // THÊM NHÂN VIÊN
    // =========================

    public String themNhanVien(
            String ma,
            String ten,
            String vaiTro,
            String sdt) {

        if (ma == null || ma.trim().isEmpty()
                || ten == null || ten.trim().isEmpty()
                || vaiTro == null || vaiTro.trim().isEmpty()) {

            return "Thông tin nhân viên chưa đầy đủ.";
        }

        try {
            NhanVien nhanVien = new NhanVien();

            nhanVien.setMaNV(ma.trim());
            nhanVien.setHoTen(ten.trim());
            nhanVien.setVaiTro(vaiTro.trim());
            nhanVien.setSoDienThoai(
                    sdt == null || sdt.trim().isEmpty()
                            ? null
                            : sdt.trim()
            );

            nhanVienRepository.save(nhanVien);

            return "Đã thêm nhân viên.";

        } catch (Exception e) {
            return e.getMessage();
        }
    }


    // =========================
    // THÊM LOẠI TIỆN NGHI
    // =========================

    public String themLoaiTN(String ma, String ten) {

        if (ma == null || ma.trim().isEmpty()
                || ten == null || ten.trim().isEmpty()) {

            return "Thông tin loại tiện nghi chưa đủ.";
        }

        try {
            LoaiTienNghi loaiTienNghi = new LoaiTienNghi();

            loaiTienNghi.setMaLoaiTN(ma.trim());
            loaiTienNghi.setTenLoaiTN(ten.trim());

            loaiTienNghiRepository.save(loaiTienNghi);

            return "Đã thêm loại tiện nghi.";

        } catch (Exception e) {
            return e.getMessage();
        }
    }


    // =========================
    // THÊM DỊCH VỤ
    // =========================

    public String themDichVu(
            String ma,
            String ten,
            String dvt,
            BigDecimal gia) {

        if (ma == null || ma.trim().isEmpty()
                || ten == null || ten.trim().isEmpty()
                || dvt == null || dvt.trim().isEmpty()
                || gia == null
                || gia.compareTo(BigDecimal.ZERO) < 0) {

            return "Thông tin dịch vụ không hợp lệ.";
        }

        try {
            DichVu dichVu = new DichVu();

            dichVu.setMaDV(ma.trim());
            dichVu.setTenDV(ten.trim());
            dichVu.setDonViTinh(dvt.trim());
            dichVu.setDonGia(gia);

            dichVuRepository.save(dichVu);

            return "Đã thêm dịch vụ.";

        } catch (Exception e) {
            return e.getMessage();
        }
    }


    // =========================
    // THÊM QUY ĐỊNH ĐỀN BÙ
    // =========================

    public String themQuyDinh(
            String ma,
            String maLoaiTN,
            String mucDo,
            BigDecimal tien) {

        if (ma == null || ma.trim().isEmpty()
                || maLoaiTN == null || maLoaiTN.trim().isEmpty()
                || mucDo == null || mucDo.trim().isEmpty()
                || tien == null
                || tien.compareTo(BigDecimal.ZERO) < 0) {

            return "Quy định đền bù không hợp lệ.";
        }

        try {

            LoaiTienNghi loaiTienNghi =
                    loaiTienNghiRepository.findById(maLoaiTN)
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Không tìm thấy loại tiện nghi."
                                    )
                            );

            QuyDinhDenBu quyDinh = new QuyDinhDenBu();

            quyDinh.setMaQuyDinh(ma.trim());
            quyDinh.setLoaiTienNghi(loaiTienNghi);
            quyDinh.setMucDoThietHai(mucDo.trim());
            quyDinh.setMucDenBu(tien);

            quyDinhDenBuRepository.save(quyDinh);

            return "Đã thêm quy định đền bù.";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}