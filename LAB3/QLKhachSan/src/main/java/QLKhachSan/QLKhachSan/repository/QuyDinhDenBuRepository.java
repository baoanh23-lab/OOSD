package QLKhachSan.QLKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import QLKhachSan.QLKhachSan.model.QuyDinhDenBu;

public interface QuyDinhDenBuRepository
        extends JpaRepository<QuyDinhDenBu, String> {

    List<QuyDinhDenBu> findAllByOrderByMaQuyDinhAsc();
}