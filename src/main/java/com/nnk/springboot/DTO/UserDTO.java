package com.nnk.springboot.DTO;

import com.nnk.springboot.constraint.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO {

    @NotBlank
    private String username;

    @NotBlank
    @ValidPassword
    private String password;

    @NotBlank
    private String fullname;

    @NotBlank
    private String role;
}
