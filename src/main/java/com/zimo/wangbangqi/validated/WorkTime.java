package com.zimo.wangbangqi.validated;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = { WorkTimeValidated.class })
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface WorkTime {
    String message() default "工作时间不能超过8小时";

    int max() default 8;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
