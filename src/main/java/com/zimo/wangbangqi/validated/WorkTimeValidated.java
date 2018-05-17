package com.zimo.wangbangqi.validated;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 */
public class WorkTimeValidated implements ConstraintValidator<WorkTime,Integer> {

    private Integer max;

    @Override
    public void initialize(WorkTime workTime) {
        max = workTime.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {

        return (value == null || value <= max)?true:false;
    }
}
