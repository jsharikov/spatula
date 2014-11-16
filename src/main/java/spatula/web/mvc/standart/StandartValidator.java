package spatula.web.mvc.standart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spatula.entity.standart.Standart;
import spatula.service.standart.StandartService;

@Component("standartValidator")
public class StandartValidator implements Validator {

    @Autowired
    private StandartService standartService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Standart.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Standart standart = (Standart) target;
        if (standart.getCode() != null && !standart.getCode().isEmpty() && invalidCode(standart)) {
            errors.rejectValue("code", "exists");
        }
    }


    public void validateCode(Standart standart, Errors errors) {
        String code = standart.getCode();
        if (code != null && !code.isEmpty() && invalidCode(standart)) {
            errors.rejectValue("standart.code", "exists");
        }
    }

    private boolean invalidCode(Standart standart) {
        if (standart.getId() != null && !changeCode(standart)) {
            return false;
        }
        return standartService.existsByCode(standart.getCode());
    }

    private boolean changeCode(Standart standart) {
        return !standartService.get(standart.getId()).getCode().equals(standart.getCode());
    }
}
