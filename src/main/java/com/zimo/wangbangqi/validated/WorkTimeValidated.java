package com.zimo.wangbangqi.validated;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *自定义注解
 */
public class WorkTimeValidated implements ConstraintValidator<WorkTime,Integer> {

    private Integer max;

    @Override
    public void initialize(WorkTime workTime) {
        max = workTime.max();
    }

    /**
     * 自定义注解验证的实现类。实现ConstraintValidator<WorkTime,Integer>
     * 接口，WorkTime为注解的名称，Integer为所传递的值的参数。
     * @param value 要验证的值
     * @param constraintValidatorContext
     * @return 为true，说明值符合我们的要求，验证通过。
     *         为false，说明值不符合参数的属性要求。
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {

        return (value == null || value <= max)?true:false;
    }
}
