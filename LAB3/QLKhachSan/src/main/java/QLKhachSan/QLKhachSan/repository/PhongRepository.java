package QLKhachSan.QLKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QLKhachSan.QLKhachSan.model.Phong;

@Repository
public interface PhongRepository extends JpaRepository<Phong, String> {

    List<Phong> findAllByOrderBySoPhongAsc();
}