package lab4.lab4.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lab4.lab4.entity.ChiTietGioHang;
import lab4.lab4.entity.ChiTietGioHangId;

public interface ChiTietGioHangRepository
        extends JpaRepository<ChiTietGioHang, ChiTietGioHangId> {

    List<ChiTietGioHang>
    findByMaGioHang(Integer maGioHang);
}