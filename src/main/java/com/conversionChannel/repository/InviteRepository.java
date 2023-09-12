package com.conversionChannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conversionChannel.model.Invite;

public interface InviteRepository extends JpaRepository<Invite , Long> {

	List<Invite> findByParticipentId(Long id);

}
