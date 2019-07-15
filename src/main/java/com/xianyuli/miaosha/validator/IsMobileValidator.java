package com.xianyuli.miaosha.validator;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ProjectName: rush
 * @Package: com.xianyuli.miaosha.validator
 * @ClassName: IsMobileValidator
 * @Description: java类作用描述
 * @Author: LW
 * @CreateDate: 2019/7/14 0014 22:12
 * @UpdateUser: LW
 * @UpdateDate: 2019/7/14 0014 22:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private static final String REGEX = "^[1][3,4,5,7,8]\\d{9}$";

    private boolean required = false;

    @Override
    public void initialize(IsMobile isMobile) {
        required = isMobile.required();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (required) {
            return ReUtil.isMatch(REGEX, value);
        } else {
            if (StrUtil.isEmpty(value)) {
                return true;
            } else {
                return ReUtil.isMatch(REGEX, value);
            }
        }

    }
}
