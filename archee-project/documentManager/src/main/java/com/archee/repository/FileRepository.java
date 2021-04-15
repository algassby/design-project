package com.archee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.archee.model.FileInfo;

@Repository
public interface FileRepository extends JpaRepository<FileInfo, String> {

}
