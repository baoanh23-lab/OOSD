package QLKhachSan.QLKhachSan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import QLKhachSan.QLKhachSan.model.NhanVien;
import QLKhachSan.QLKhachSan.repository.NhanVienRepository;

@RestController
@RequestMapping("/api/nhan-vien")
@CrossOrigin(origins = "*")
public class NhanVienController {

    private final NhanVienRepository nhanVienRepository;

    public NhanVienController(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    @GetMapping
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }
}