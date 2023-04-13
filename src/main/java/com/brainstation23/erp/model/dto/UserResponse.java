package com.brainstation23.erp.model.dto;

import com.brainstation23.erp.constant.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class UserResponse {

    @Schema(description = "User First Name", example = "Zahid")
    private String firstName;


    @Schema(description = "User Last Name", example = "Hasan")
    private String lastName;

    @Schema(description = "User Email", example = "zahid@gmail.com")
    private String email;


    @Schema(description = "User Salary", example = "10000.00")
    private double salary;

    @Schema(description = "User Role", example = "ADMIN/EMPLOYEE")
    private UserRole userRole;
}
