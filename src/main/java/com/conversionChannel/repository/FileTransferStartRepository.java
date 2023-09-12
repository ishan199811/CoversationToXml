package com.conversionChannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conversionChannel.model.FileTransferStarted;


public interface FileTransferStartRepository extends JpaRepository<FileTransferStarted , Long>{

	List<FileTransferStarted> findByParticipentId(Long id);

}
