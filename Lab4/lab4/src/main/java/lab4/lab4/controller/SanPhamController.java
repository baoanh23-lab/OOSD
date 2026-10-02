package lab4.lab4.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lab4.lab4.entity.ChiTietGioHang;
import lab4.lab4.entity.GioHang;
import lab4.lab4.entity.NhomSanPham;
import lab4.lab4.entity.SanPham;
import lab4.lab4.repository.ChiTietGioHangRepository;
import lab4.lab4.repository.GioHangRepository;
import lab4.lab4.repository.NhomSanPhamRepository;
import lab4.lab4.repository.SanPhamRepository;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {

    private final SanPhamRepository sanPhamRepository;
    private final NhomSanPhamRepository nhomSanPhamRepository;
    private final GioHangRepository gioHangRepository;
    private final ChiTietGioHangRepository chiTietGioHangRepository;

    public SanPhamController(
            SanPhamRepository sanPhamRepository,
            NhomSanPhamRepository nhomSanPhamRepository,
            GioHangRepository gioHangRepository,
            ChiTietGioHangRepository chiTietGioHangRepository) {

        this.sanPhamRepository = sanPhamRepository;
        this.nhomSanPhamRepository = nhomSanPhamRepository;
        this.gioHangRepository = gioHangRepository;
        this.chiTietGioHangRepository = chiTietGioHangRepository;
    }

    @GetMapping
    public String hienThiSanPham(Model model) {

        List<SanPham> danhSachSanPham =
                sanPhamRepository.findAll();

        List<NhomSanPham> danhSachNhom =
                nhomSanPhamRepository.findAll();

        model.addAttribute("danhSachSanPham", danhSachSanPham);
        model.addAttribute("danhSachNhom", danhSachNhom);

        return "sanpham";
    }


    @GetMapping("/nhom/{maNhom}")
    public String xemTheoNhom(
            @PathVariable Integer maNhom,
            Model model) {

        List<SanPham> danhSachSanPham =
                sanPhamRepository.findByNhomSanPham_MaNhom(maNhom);

        List<NhomSanPham> danhSachNhom =
                nhomSanPhamRepository.findAll();

        model.addAttribute("danhSachSanPham", danhSachSanPham);
        model.addAttribute("danhSachNhom", danhSachNhom);

        return "sanpham";
    }


    // =========================
    // THÊM VÀO GIỎ HÀNG
    // =========================

    @GetMapping("/them-vao-gio/{maSanPham}")
    public String themVaoGio(
            @PathVariable Integer maSanPham) {

        // Tạm dùng khách hàng có mã 1 để test
        Integer maKhachHang = 1;

        // Lấy sản phẩm
        SanPham sanPham = sanPhamRepository
                .findById(maSanPham)
                .orElse(null);

        if (sanPham == null) {
            return "redirect:/san-pham";
        }

        // Tìm giỏ hàng của khách hàng
        GioHang gioHang = gioHangRepository
                .findByMaKhachHang(maKhachHang)
                .orElse(null);

        // Nếu chưa có giỏ hàng thì tạo mới
        if (gioHang == null) {

            gioHang = new GioHang();

            gioHang.setMaKhachHang(maKhachHang);
            gioHang.setTongTien(0.0);

            gioHang = gioHangRepository.save(gioHang);
        }

        // Kiểm tra sản phẩm đã có trong giỏ chưa
        List<ChiTietGioHang> danhSach =
                chiTietGioHangRepository
                        .findByMaGioHang(gioHang.getMaGioHang());

        ChiTietGioHang chiTietTimThay = null;

        for (ChiTietGioHang ct : danhSach) {

            if (ct.getMaSanPham().equals(maSanPham)) {
                chiTietTimThay = ct;
                break;
            }
        }


        // Nếu đã có sản phẩm
        if (chiTietTimThay != null) {

            chiTietTimThay.setSoLuong(
                    chiTietTimThay.getSoLuong() + 1
            );

            chiTietGioHangRepository.save(chiTietTimThay);

        }

        // Nếu chưa có sản phẩm
        else {

            ChiTietGioHang chiTiet =
                    new ChiTietGioHang();

            chiTiet.setMaGioHang(
                    gioHang.getMaGioHang()
            );

            chiTiet.setMaSanPham(
                    sanPham.getMaSanPham()
            );

            chiTiet.setSoLuong(1);

            chiTiet.setDonGia(
                    sanPham.getGiaBanHienHanh()
            );

            chiTietGioHangRepository.save(chiTiet);
        }


        // Tính lại tổng tiền
        List<ChiTietGioHang> chiTietMoi =
                chiTietGioHangRepository
                        .findByMaGioHang(
                                gioHang.getMaGioHang()
                        );

        double tongTien = 0;

        for (ChiTietGioHang ct : chiTietMoi) {

            tongTien +=
                    ct.getDonGia() *
                    ct.getSoLuong();
        }

        gioHang.setTongTien(tongTien);

        gioHangRepository.save(gioHang);


        // Chuyển sang giỏ hàng
        return "redirect:/gio-hang";
    }
}