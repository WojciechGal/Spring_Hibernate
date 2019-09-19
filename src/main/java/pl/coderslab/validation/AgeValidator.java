package pl.coderslab.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    int legalAge;


    @Override
    public void initialize(Age constraintAnnotation) {

        this.legalAge = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        //skoro już tu trafiłeś to wiedz że teraz jeśli ktoś nie poda wieku to jest dobrze
        if (yearOfBirth == null) {
            return true;
        }


        int age = LocalDate.now().getYear() - yearOfBirth;
        return age >= legalAge;
    }
}
