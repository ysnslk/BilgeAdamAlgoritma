package com.yasinsolak.repository;

import com.yasinsolak.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IKitapRepository extends JpaRepository<Kitap,Long> {

    Kitap findByBaslik(String baslik);

    List<Kitap> findAllBySayfasayisi(int sayfaSayisi);

    Optional<Kitap> findOptionalByBaslik(String baslik);
}
