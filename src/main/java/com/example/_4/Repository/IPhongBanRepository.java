package com.example._4.Repository;

import com.example._4.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository  extends JpaRepository<PhongBan, Long> {
}
