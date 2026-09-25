package QLKhachSan.QLKhachSan.controller;

import QLKhachSan.QLKhachSan.model.KhachHang;
import QLKhachSan.QLKhachSan.repository.KhachHangRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khach-hang")
@CrossOrigin(origins = "*")
public class KhachHangController {

    private final KhachHangRepository khachHangRepository;

    public KhachHangController(KhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    // Lấy danh sách khách hàng
    @GetMapping
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    // Lấy khách hàng theo mã
    @GetMapping("/{maKhach}")
    public ResponseEntity<KhachHang> getById(
            @PathVariable String maKhach) {

        return khachHangRepository.findById(maKhach)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Thêm khách hàng
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody KhachHang khachHang) {

        if (khachHangRepository.existsById(khachHang.getMaKhach())) {
            return ResponseEntity.badRequest()
                    .body("Mã khách hàng đã tồn tại.");
        }

        KhachHang saved = khachHangRepository.save(khachHang);

        return ResponseEntity.ok(saved);
    }
}