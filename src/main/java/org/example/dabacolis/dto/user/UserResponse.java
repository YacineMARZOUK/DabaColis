package org.example.dabacolis.dto.user;

import org.example.dabacolis.enums.Speciality;
import org.example.dabacolis.enums.TransporteurStatus;
import org.example.dabacolis.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String id;
    private String login;
    private UserRole role;
    private boolean active;


    private TransporteurStatus status;
    private Speciality speciality;
}
