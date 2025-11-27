package logistics.dto.auth;

import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Login is required")
    private String login;

    @NotBlank(message = "Password is required")
    private String password;
}