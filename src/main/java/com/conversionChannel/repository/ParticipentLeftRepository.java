package com.conversionChannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conversionChannel.model.ParticipentLeft;



public interface ParticipentLeftRepository extends JpaRepository<ParticipentLeft , Long>{

	List<ParticipentLeft> findByFileDumpId(Long id);

}
