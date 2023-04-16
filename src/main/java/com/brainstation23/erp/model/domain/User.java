package com.brainstation23.erp.model.domain;


import com.brainstation23.erp.constant.UserRole;
import com.brainstation23.erp.persistence.entity.OrganizationEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private double balance;
    private OrganizationEntity organization;
    private UserRole userRole;

}
