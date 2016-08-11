package com.globant.training.google.maps.core.endpoint.validation;

import com.globant.training.google.maps.core.endpoint.dto.Dto;
import com.globant.training.google.maps.core.exception.ValidationException;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Dto Validator. Its validates using Javax Validation API.
 * 
 * @author gabriel.sideri
 */
public class DtoValidator {

  private static Validator validator;

  /**
   * Validates Dto information. It will throw a RuntimeException with messages if an error is found.
   * 
   * @param dto a {@link Dto}
   */
  public static void validate(final Dto dto, Class<?>... group) {

    validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    Set<ConstraintViolation<Dto>> constraintViolations;
    
    if (group.length > 0) {
      constraintViolations = validator.validate(dto, group);
    } else {
      constraintViolations = validator.validate(dto);
    }

    if (!constraintViolations.isEmpty()) {
      Set<String> errorMessages = new HashSet<String>();

      for (ConstraintViolation<Dto> constraintViolation : constraintViolations) {
        errorMessages
            .add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
      }

      throwErrors(errorMessages);
    }

  }

  /**
   * Throw a validation errors.
   * 
   * @param errorMessages Set of validation error messages.
   */
  public static void throwErrors(Set<String> errorMessages) {
    throw new ValidationException("API Errors: " + errorMessages);
  }

  /**
   * Throw a validation error.
   * 
   * @param errorMessage error message.
   */
  public static void throwError(String errorMessage) {
    throw new ValidationException("API Error: " + errorMessage);
  }
  
  /**
   * Validates the provided errors if errors are present the a validation error is thrown.
   * 
   * @param errorMessages error message.
   */
  public static void validateForErrors(Set<String> errorMessages) {
    if (!errorMessages.isEmpty()) {
      throwErrors(errorMessages);
    }
  }

}
