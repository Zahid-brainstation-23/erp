package com.brainstation23.erp.persistence.entity;


import com.brainstation23.erp.constant.EntityConstant;
import com.brainstation23.erp.constant.UserRole;
import com.brainstation23.erp.model.domain.Organization;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = EntityConstant.USER)
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double balance;
    private UserRole userRole;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private OrganizationEntity organization;
}
