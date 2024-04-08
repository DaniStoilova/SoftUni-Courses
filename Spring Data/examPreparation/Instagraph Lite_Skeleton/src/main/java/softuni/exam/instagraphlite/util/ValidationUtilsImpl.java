package softuni.exam.instagraphlite.util;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;


@Component
public class ValidationUtilsImpl implements ValidationUtils{

    public final Validator validator;

    public ValidationUtilsImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).isEmpty();
    }
}
