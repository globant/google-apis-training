package com.globant.training.google.maps.core.endpoint.dto;

import com.globant.training.google.maps.core.entity.BaseEntity;

import java.util.List;

/**
 * Wrapper for paginated entities.
 * 
 * @author gabriel.sideri
 */
public class PaginatedResponseDto implements Dto {

  private static final long serialVersionUID = 1L;

  private List<BaseEntity> items;

  private int pageIndex;

  private int total;

  private int pageSize;

  @SuppressWarnings({"unchecked", "rawtypes"})
  private PaginatedResponseDto(Builder builder) {
    this.items = builder.items;
    this.pageIndex = builder.pageIndex;
    this.pageSize = builder.pageSize;
    this.total = builder.total;

  }

  /**
   * Gets items.
   * 
   * @return tje items paginated
   */
  public List<BaseEntity> getItems() {
    return items;
  }

  /**
   * Gets page index.
   * 
   * @return the page index
   */
  public int getPageIndex() {
    return pageIndex;
  }

  /**
   * Gets the total of items (no paginated).
   * 
   * @return the total
   */
  public int getTotal() {
    return total;
  }

  /**
   * Gets the page size.
   * 
   * @return the page size
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Dto Builder.
   */
  public static class Builder<T extends BaseEntity> {
    private List<T> items;
    private int pageIndex;
    private int total;
    private int pageSize;

    /**
     * Sets the items paginated.
     * 
     * @param items the items
     * @return the Builder
     */
    public Builder<T> items(List<T> items) {
      this.items = items;
      return this;
    }

    /**
     * Sets the page index.
     * 
     * @param pageIndex the page index
     * @return the builder
     */
    public Builder<T> pageIndex(int pageIndex) {
      this.pageIndex = pageIndex;
      return this;
    }

    /**
     * Sets the page size.
     * 
     * @param pageSize the page size
     * @return the builder
     */
    public Builder<T> pageSize(int pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    /**
     * Sets the total.
     * 
     * @param total the total items
     * @return the builder
     */
    public Builder<T> total(int total) {
      this.total = total;
      return this;
    }

    /**
     * Builds the Paginated Response Dto.
     * 
     * @return the Dto
     */
    public PaginatedResponseDto build() {
      return new PaginatedResponseDto(this);
    }

  }

}
