package logistics.dto.user;

import logistics.enums.Speciality;
import logistics.enums.TransporteurStatus;
import logistics.enums.UserRole;
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
