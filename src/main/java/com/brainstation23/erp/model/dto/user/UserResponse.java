package com.brainstation23.erp.model.dto.user;

import com.brainstation23.erp.constant.UserRole;
import com.brainstation23.erp.persistence.entity.OrganizationEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class UserResponse {

    @Schema(description = "User ID", example = "3F41A301-25ED-4F0F-876F-7657BEABB00F")
    private UUID id;

    @Schema(description = "User First Name", example = "Zahid")
    private String firstName;


    @Schema(description = "User Last Name", example = "Hasan")
    private String lastName;

    @Schema(description = "User Email", example = "zahid@gmail.com")
    private String email;


    @Schema(description = "User Account Balance", example = "10000.00")
    private double balance;

    @Schema(description = "Organization ID", example = " id: d4f4927d-1097-465e-9879-812eedfa1c9d," +
            " name: Brain Station 23," +
            " code: JC68VA")
    private OrganizationEntity organization;

    @Schema(description = "User Role", example = "ADMIN/EMPLOYEE")
    private UserRole userRole;
}
