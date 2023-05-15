package com.bpcha.core_banking_bpcha.domain.model.shared;

import java.lang.reflect.Field;
import java.util.Objects;

public class ValidationTool {

    public static void idNotNull(Integer id) {
        if (id == null) throw new BusinessException(TypeExceptions.ID_CANNOT_BE_NULL.toString());
    }

    public static void validEntity(Object entity) {
        boolean isValid = validateFields(entity);
        if (!isValid) throw new BusinessException(TypeExceptions.REQUEST_CANNOT_BE_NULL_CHECK_REQUEST.toString());
    }

    public static void entityNotNull(Object entity) {
        if (Objects.isNull(entity)) throw new BusinessException(TypeExceptions.ENTITY_NOT_FOUND_CHECK_ID.toString());
    }

    private ValidationTool() {
    }

    public static boolean validateFields(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                Object value = field.get(obj);
                if (value == null) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                throw new BusinessException(TypeExceptions.SOME_FIELDS_ARE_NULL_CHECK_THE_REQUEST.toString());
            }
        }
        return true;
    }
}
