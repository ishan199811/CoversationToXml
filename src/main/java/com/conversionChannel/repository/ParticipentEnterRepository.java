package com.conversionChannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.conversionChannel.model.ParticipentEnter;

public interface ParticipentEnterRepository extends JpaRepository<ParticipentEnter , Long>{

	List<ParticipentEnter> findByFileDumpId(Long id);

}
