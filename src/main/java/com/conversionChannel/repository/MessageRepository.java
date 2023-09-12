package com.conversionChannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conversionChannel.model.Message;

public interface MessageRepository extends JpaRepository<Message , Long>{

	List<Message> findByParticipentId(Long id);

}
