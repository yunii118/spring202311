package commons.validators;

import models.member.Member;

public interface Validator<T> {
    void validate(T value);
}
