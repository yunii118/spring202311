package controllers.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestLogin {
    @NotBlank
    @Size(min = 6)
    private String userId;
    @NotBlank
    @Size(max = 8)
    private String userPw;
}
