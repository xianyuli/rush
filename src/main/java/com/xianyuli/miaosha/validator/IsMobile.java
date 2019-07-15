package com.xianyuli.miaosha.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * @ProjectName: rush
 * @Package: com.xianyuli.miaosha.validator
 * @ClassName: IsMobile
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2019/7/14 0014 22:03
 * @UpdateUser: LW
 * @UpdateDate: 2019/7/14 0014 22:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IsMobileValidator.class}
)
public @interface IsMobile {

    boolean required() default true;

    String message() default "手机号码格式不正确！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
