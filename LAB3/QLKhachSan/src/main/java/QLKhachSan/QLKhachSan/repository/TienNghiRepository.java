package QLKhachSan.QLKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.TienNghi;

@Repository
public interface TienNghiRepository extends JpaRepository<TienNghi, String> {

    List<TienNghi> findAllByOrderByMaTienNghiAsc();
}