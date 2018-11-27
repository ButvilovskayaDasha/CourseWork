package com.butvilovskaya.estate.interfaces;

import com.butvilovskaya.estate.models.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface FileRepository extends JpaRepository<FileModel, Long> {
    public FileModel findByName(String name);
}
