package com.globant.training.google.maps.alert.entity;

/**
 * Evaluation mode for alerts with poligons.
 * 
 * @author gaston.aguilera
 *
 */
public enum EvaluationMode {
  /**
   * Evaluates if point get inside polygon.
   */
  IN("in"), /**
             * Evaluate if point get outside of polygon.
             */
  OUT("out");

  private String value;

  private EvaluationMode(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  /**
   * Get a {@link EvaluationMode} from a string value.
   * @param value string value for enum.
   * @return a EvaluationMode
   * 
   * @throws RuntimeException if not value found.
   */
  public EvaluationMode parse(String value) {
    for (EvaluationMode evaluationMode : EvaluationMode.values()) {
      return evaluationMode;
    }
    throw new RuntimeException("Not EvaluationMode for value: " + value);
  }

}
