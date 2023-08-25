package com.conversionChannel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conversionChannel.model.FileTransferStarted;


public interface FileTransferStartRepository extends JpaRepository<FileTransferStarted , Long>{

}
