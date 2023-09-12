package com.conversionChannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conversionChannel.model.FileTransferEnd;



public interface FileTransferEndRepository extends JpaRepository<FileTransferEnd , Long>{

	List<FileTransferEnd> findByParticipentId(Long id);

}
