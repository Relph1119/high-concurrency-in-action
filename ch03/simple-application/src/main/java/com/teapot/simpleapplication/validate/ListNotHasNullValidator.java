package com.teapot.simpleapplication.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ListNotHasNullValidator implements ConstraintValidator<ListNotHasNull, List> {
    private int value;

    @Override
    public void initialize(ListNotHasNull constraint) {
        this.value = constraint.value();
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        for (Object object: list) {
            if (object == null) {
                return false;
            }
        }
        return true;
    }
}
