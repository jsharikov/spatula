package spatula.web.mvc.standart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spatula.entity.standart.Resource;
import spatula.entity.standart.Standart;

@Component("resourceValidator")
public class ResourceValidator implements Validator {

    private final Validator standartValidator;

    @Autowired
    public ResourceValidator(@Qualifier("standartValidator") Validator standartValidator) {
        if (standartValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is "
        + "required and must not be null.");
        }
        if (!standartValidator.supports(Standart.class)) {
            throw new IllegalArgumentException("The supplied [Validator] must "
        + "support the validation of [Standart] instances.");
        }
        this.standartValidator = standartValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Resource.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Resource resource = (Resource) target;
        try {
            errors.pushNestedPath("standart");
            ValidationUtils.invokeValidator(this.standartValidator, resource.getStandart(), errors);
        } finally {
            errors.popNestedPath();
        }
    }

}
