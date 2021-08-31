package zup.proposta.rodolpho.validation;

import zup.proposta.rodolpho.model.CarteiraAssociada;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

public class ExisteCarteiraValidator implements ConstraintValidator<CarteiraValida, String> {

    private String domainAttribute;

    @Override
    public void initialize(CarteiraValida params) {
        domainAttribute = params.fieldName();
    }

    @Override
    public boolean isValid(
            String s,
            ConstraintValidatorContext constraintValidatorContext
    ) {
        Map<String, CarteiraAssociada> carteirasAssociadas = CarteiraAssociada
                .carteirasAssociadas();
        return carteirasAssociadas.containsKey(s);
    }


}
