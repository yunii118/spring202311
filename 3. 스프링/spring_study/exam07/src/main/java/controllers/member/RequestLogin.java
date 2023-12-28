package controllers.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestLogin(
        @NotBlank
        String userId,
        @NotBlank
        String userPw

) {}
