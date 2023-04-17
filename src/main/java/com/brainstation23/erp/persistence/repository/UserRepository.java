package com.brainstation23.erp.persistence.repository;

import com.brainstation23.erp.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository  extends JpaRepository<UserEntity, UUID> {
    public Optional<UserEntity> findByEmail(String email);
}
