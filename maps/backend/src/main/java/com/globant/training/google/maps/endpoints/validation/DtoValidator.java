package com.globant.training.google.maps.endpoints.validation;

import com.globant.training.google.maps.endpoints.dtos.BaseDto;

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
   * @param dto a {@link BaseDto}
   */
  public static void validate(final BaseDto dto) {

    validator = Validation.buildDefaultValidatorFactory().getValidator();

    Set<ConstraintViolation<BaseDto>> constraintViolations = validator.validate(dto);

    if (!constraintViolations.isEmpty()) {
      Set<String> errorMessages = new HashSet<String>();

      for (ConstraintViolation<BaseDto> constraintViolation : constraintViolations) {
        errorMessages
            .add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
      }

      throw new RuntimeException("API Errors: " + errorMessages);
    }

  }

}
