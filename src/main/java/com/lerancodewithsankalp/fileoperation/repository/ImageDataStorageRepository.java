package com.lerancodewithsankalp.fileoperation.repository;

import com.lerancodewithsankalp.fileoperation.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDataStorageRepository  extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findByName(String flieName);
}
