package QLKhachSan.QLKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import QLKhachSan.QLKhachSan.model.KhuVuc;

public interface KhuVucRepository
        extends JpaRepository<KhuVuc, String> {

    List<KhuVuc> findAllByOrderByMaKhuVucAsc();
}