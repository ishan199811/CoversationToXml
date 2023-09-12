package com.conversionChannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conversionChannel.model.Audio;

public interface AudioRepository extends JpaRepository<Audio , Long>{

	List<Audio> findByParticipentId(Long id);

}
