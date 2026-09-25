package QLKhachSan.QLKhachSan.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import QLKhachSan.QLKhachSan.model.DichVu;

public interface DichVuRepository
        extends JpaRepository<DichVu, String> {

    List<DichVu> findAllByOrderByMaDVAsc();
}