package spatula.web.mvc.standart.work;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spatula.entity.standart.ResourceWork;
import spatula.entity.standart.Standart;
import spatula.entity.standart.Work;
import spatula.enums.StandartEnum;

@Component("workValidator")
public class WorkValidator implements Validator {

    private final Validator standartValidator;

    @Autowired
    public WorkValidator(@Qualifier("standartValidator") Validator standartValidator) {
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
        return Work.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Work work = (Work) target;
        validateResources(work.getResources(), errors);
        try {
            errors.pushNestedPath("standart");
            ValidationUtils.invokeValidator(this.standartValidator, work.getStandart(), errors);
        } finally {
            errors.popNestedPath();
        }
    }

    private void validateResources(List<ResourceWork> resources, Errors errors) {
        for (int i = 0; i < resources.size(); i++) {
            ResourceWork resourceWork = resources.get(i);
            validateResourceWork(resourceWork, i, errors);
        }
    }

    private void validateResourceWork(ResourceWork resourceWork, int index, Errors errors) {
        validateStandartId(resourceWork.getResource().getStandartId(), index, errors);
        validateQuantity(resourceWork.getQuantity(), index, errors);
        validateCost(resourceWork.getResource().getCost(), resourceWork.getResource().getStandartId(), index, errors);
    }

    private void validateQuantity(BigDecimal quantity, int index, Errors errors) {
        if (quantity == null) {
            errors.rejectValue("resources[" + index + "].quantity", "required");
        }
    }

    private void validateCost(BigDecimal cost, Long standartId, int index, Errors errors) {
        if (StandartEnum.exclusion(standartId) && cost == null) {
            errors.rejectValue("resources[" + index + "].resource.cost", "required");
        }
    }

    private void validateStandartId(Long standartId, int index, Errors errors) {
        if (standartId == null) {
            errors.rejectValue("resources[" + index + "].resource.standartId", "required");
        }
    }

}
