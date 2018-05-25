package com.zimo.wangbangqi.validated;

import org.springframework.util.Assert;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;




/**
 * @desc 校验枚举值有效性，该类有两个参数，一个数要校验的枚举类，一个是要校验的方法。
 *
 *  要点:校验的方法必须是静态且返回值必须是boolean类型，不然返回为null时会默认校验失败。
 */

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValue.Validator.class)
public @interface EnumValue {

    String message() default "{custom.value.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 该两变量的值是在使用注解的时候进行赋予，
     * enumClass 为我们的枚举类。其内有校验的方法和 枚举变量。
     * enumMethod为我们所要验证的值的校验方法。判断传递的参数是否在枚举类中。
     */
    Class<? extends Enum<?>> enumClass();
    String enumMethod();    //要校验的方法

    class Validator implements ConstraintValidator<EnumValue ,Object>{

        private Class<? extends Enum<?>> enumClass;
        private String enumMethod;

        /**
         * //@EnumValue(enumClass = GirlStatusEnum.class,enumMethod = "isValidName",message = "值是无效的")
         * //private String status;
         * 将使用注解时，确定的枚举类，方法名赋予给该Validator中的两个变量enumClass和enumMethod
         * @param constraintAnnotation
         */
        @Override
        public void initialize(EnumValue constraintAnnotation) {
            Assert.notNull(constraintAnnotation.getClass(),"The enumClass must not be null !");
            Assert.notNull(constraintAnnotation.enumMethod(),"The enumMethod must not be null !");
            enumClass =  constraintAnnotation.enumClass();
            enumMethod = constraintAnnotation.enumMethod();
        }
        /**
         *
         * @param value 传递的值。
         * @param constraintValidatorContext
         * @return the true 表示验证通过。
         */
        @Override
        public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
            if (value == null) {
                //没有值，说明不需要去进行验证。
                return Boolean.TRUE;
            }
            if (enumClass == null || enumMethod == null) {
                //最少其中一个为空，说明没有赋值成功。不过我在初始化中加入了断言，所以如果为空也不会执行到这里。
                return Boolean.TRUE;
            }
            //传递的值的类型
            Class<?> valueClass = value.getClass();

            try {
                //获取类中的方法
                Method method = enumClass.getMethod(enumMethod, valueClass);
                if (!Boolean.TYPE.equals(method.getReturnType()) && !Boolean.class.equals(method.getReturnType())) {
                    throw new RuntimeException(String.format("%s method return is not boolean type in the %s class", enumMethod, enumClass));
                }

                if(!Modifier.isStatic(method.getModifiers())) {
                    throw new RuntimeException(String.format("%s method is not static method in the %s class", enumMethod, enumClass));
                }
                //
                Boolean result = (Boolean)method.invoke(null, value);
                return result == null ? false : result;
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException | SecurityException e) {
                throw new RuntimeException(String.format("This %s(%s) method does not exist in the %s", enumMethod, valueClass, enumClass), e);
            }

        }
    }
}
