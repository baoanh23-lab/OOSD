package QLKhachSan.QLKhachSan.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import QLKhachSan.QLKhachSan.model.DichVu;
import QLKhachSan.QLKhachSan.model.KhuVuc;
import QLKhachSan.QLKhachSan.model.LoaiTienNghi;
import QLKhachSan.QLKhachSan.model.NhanVien;
import QLKhachSan.QLKhachSan.model.QuyDinhDenBu;
import QLKhachSan.QLKhachSan.service.DanhMucService;

@RestController
@RequestMapping("/api/danh-muc")
@CrossOrigin(origins = "http://localhost:5173")
public class DanhMucController {

    private final DanhMucService service;

    public DanhMucController(DanhMucService service) {
        this.service = service;
    }

    // =====================================================
    // KHU VỰC
    // =====================================================

    @GetMapping("/khu-vuc")
    public List<KhuVuc> layKhuVuc() {
        return service.layKhuVuc();
    }

    // THÊM
    @PostMapping("/khu-vuc")
    public String themKhu(
            @RequestParam String ma,
            @RequestParam String ten) {

        return service.themKhu(ma, ten);
    }

    // =====================================================
    // NHÂN VIÊN
    // =====================================================

    @GetMapping("/nhan-vien")
    public List<NhanVien> layNhanVien() {
        return service.layNhanVien();
    }

    // THÊM
    @PostMapping("/nhan-vien")
    public String themNhanVien(
            @RequestParam String ma,
            @RequestParam String ten,
            @RequestParam String vaiTro,
            @RequestParam(required = false) String sdt) {

        return service.themNhanVien(
                ma,
                ten,
                vaiTro,
                sdt
        );
    }

    

   

    // =====================================================
    // LOẠI TIỆN NGHI
    // =====================================================

    @GetMapping("/loai-tien-nghi")
    public List<LoaiTienNghi> layLoaiTienNghi() {
        return service.layLoaiTienNghi();
    }

    // THÊM
    @PostMapping("/loai-tien-nghi")
    public String themLoaiTN(
            @RequestParam String ma,
            @RequestParam String ten) {

        return service.themLoaiTN(ma, ten);
    }

  

    


    // =====================================================
    // DỊCH VỤ
    // =====================================================

    @GetMapping("/dich-vu")
    public List<DichVu> layDichVu() {
        return service.layDichVu();
    }

    // THÊM
    @PostMapping("/dich-vu")
    public String themDichVu(
            @RequestParam String ma,
            @RequestParam String ten,
            @RequestParam String dvt,
            @RequestParam BigDecimal gia) {

        return service.themDichVu(
                ma,
                ten,
                dvt,
                gia
        );
    }


    // =====================================================
    // QUY ĐỊNH ĐỀN BÙ
    // =====================================================

    @GetMapping("/quy-dinh-den-bu")
    public List<QuyDinhDenBu> layQuyDinhDenBu() {
        return service.layQuyDinhDenBu();
    }

    // THÊM
    @PostMapping("/quy-dinh-den-bu")
    public String themQuyDinh(
            @RequestParam String ma,
            @RequestParam String maLoaiTN,
            @RequestParam String mucDo,
            @RequestParam BigDecimal tien) {

        return service.themQuyDinh(
                ma,
                maLoaiTN,
                mucDo,
                tien
        );
    }
}