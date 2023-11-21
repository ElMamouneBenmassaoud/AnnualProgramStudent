package g58112.webg5.pae;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Component
public class BeanValidationUtil<T> {
    @Autowired
    private Validator validator;

    public void assertIsValid(T entity) {
        assertTrue(validator.validate(entity).isEmpty());
    }

    public void assertHasError(T entity, String invalidField, Class<? extends Annotation> violatedConstraint) {
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        assertTrue(violations.size() >= 1);
        ConstraintViolation<T> violation = violations.iterator().next();
        assertEquals(invalidField, violation.getPropertyPath().toString());
        assertEquals(violatedConstraint, violation.getConstraintDescriptor().getAnnotation().annotationType());
    }
}
