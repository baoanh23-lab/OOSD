package QLKhachSan.QLKhachSan.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import QLKhachSan.QLKhachSan.model.PhieuLapDat;
import QLKhachSan.QLKhachSan.model.Phong;
import QLKhachSan.QLKhachSan.model.TienNghi;
import QLKhachSan.QLKhachSan.service.PhongTienNghiService;

@RestController
@RequestMapping("/api/phong-tien-nghi")
@CrossOrigin(origins = "http://localhost:5173")
public class PhongTienNghiController {

    private final PhongTienNghiService service;

    public PhongTienNghiController(
            PhongTienNghiService service) {

        this.service = service;
    }

    // =========================
    // PHÒNG
    // =========================

    @GetMapping("/phong")
    public List<Phong> layPhong() {
        return service.layPhong();
    }

    @PostMapping("/phong")
    public String themPhong(
            @RequestParam String so,
            @RequestParam String khu,
            @RequestParam int max,
            @RequestParam BigDecimal gia) {

        return service.themPhong(
                so,
                khu,
                max,
                gia
        );
    }


    // =========================
    // TIỆN NGHI
    // =========================

    @GetMapping("/tien-nghi")
    public List<TienNghi> layTienNghi() {

        System.out.println("========== API TIEN NGHI DUOC GOI ==========");

        List<TienNghi> ds = service.layTienNghi();

        System.out.println("SO LUONG TIEN NGHI: " + ds.size());

        return ds;
    }

    @PostMapping("/tien-nghi")
    public String themTienNghi(
            @RequestParam String ma,
            @RequestParam String loai,
            @RequestParam int stt,
            @RequestParam(required = false) String tinhTrang) {

        return service.themTienNghi(
                ma,
                loai,
                stt,
                tinhTrang
        );
    }


    // =========================
    // LẮP ĐẶT
    // =========================

    @GetMapping("/lap-dat")
    public List<PhieuLapDat> layLapDat() {
        return service.layLapDat();
    }

    @PostMapping("/lap-dat")
    public String lapDat(
            @RequestParam String soPhieu,
            @RequestParam String maTN,
            @RequestParam String soPhong,
            @RequestParam LocalDate ngay,
            @RequestParam String tinhTrang,
            @RequestParam String maNV,
            @RequestParam(required = false) String ghiChu) {

        return service.lapDat(
                soPhieu,
                maTN,
                soPhong,
                ngay,
                tinhTrang,
                maNV,
                ghiChu
        );
    }
}