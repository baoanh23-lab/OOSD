package QLKhachSan.QLKhachSan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Danh mục
    @GetMapping("/danhmuc")
    public String danhMuc() {
        return "danhmuc";
    }

    // Phòng - Tiện nghi
    @GetMapping("/phongtiennghi")
    public String phongTienNghi() {
        return "phongtiennghi";
    }

    // Đặt / Nhận phòng
    @GetMapping("/dat-phong")
    public String datPhong() {
        return "dat-phong";
    }

    // Sử dụng dịch vụ
    @GetMapping("/dich-vu")
    public String dichVu() {
        return "dich-vu";
    }

    // Trả phòng - Thanh toán
    @GetMapping("/tra-phong")
    public String traPhong() {
        return "tra-phong";
    }

    // Thống kê
    @GetMapping("/thong-ke")
    public String thongKe() {
        return "thong-ke";
    }
}