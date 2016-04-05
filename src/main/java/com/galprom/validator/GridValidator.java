package com.galprom.validator;

import com.galprom.model.Grid;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Home on 01.04.2016.
 */

@Component
public class GridValidator implements Validator{


    public boolean supports(Class<?> aClass) {
        return Grid.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "grid.name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "grid.price.required");
    }
}
