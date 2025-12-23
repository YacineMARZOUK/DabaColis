package org.example.dabacolis.dto.user;

import jakarta.validation.constraints.NotNull;
import org.example.dabacolis.enums.Speciality;
import org.example.dabacolis.enums.TransporteurStatus;
import lombok.Data;

@Data

public class TransporteurRequest {
    //    @NotBlank(message = "Login is required")
    private String login;

    //    @NotBlank(message = "Password is required")
    private String password;

    @NotNull(message = "Speciality is required")
    private Speciality speciality;

    private Boolean active;


    private TransporteurStatus status;
}