package lab4.lab4.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lab4.lab4.entity.ChiTietGioHang;
import lab4.lab4.entity.GioHang;
import lab4.lab4.repository.ChiTietGioHangRepository;
import lab4.lab4.repository.GioHangRepository;

@Controller
public class GioHangController {

    private final GioHangRepository gioHangRepository;
    private final ChiTietGioHangRepository chiTietGioHangRepository;

    public GioHangController(
            GioHangRepository gioHangRepository,
            ChiTietGioHangRepository chiTietGioHangRepository) {

        this.gioHangRepository = gioHangRepository;
        this.chiTietGioHangRepository = chiTietGioHangRepository;
    }

    @GetMapping("/gio-hang")
    public String hienThiGioHang(Model model) {

        // Tạm lấy giỏ hàng của khách hàng có MaKhachHang = 1
        GioHang gioHang =
                gioHangRepository
                        .findByMaKhachHang(1)
                        .orElse(null);

        if (gioHang != null) {

            List<ChiTietGioHang> chiTiet =
                    chiTietGioHangRepository
                            .findByMaGioHang(
                                    gioHang.getMaGioHang()
                            );

            model.addAttribute("gioHang", gioHang);
            model.addAttribute("chiTiet", chiTiet);
        }

        return "giohang";
    }
}