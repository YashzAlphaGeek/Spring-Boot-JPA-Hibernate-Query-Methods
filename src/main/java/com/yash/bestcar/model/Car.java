package com.yash.bestcar.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yashwanth
 */
@Entity
@Table(name = "bestcars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long carId;

  @Column(name = "car_rank", nullable = false)
  private int carRank;

  @Column(name = "car_name", nullable = false)
  private String carName;

  @Column(name = "car_type", nullable = false)
  private String carType;

  @Column(name = "car_color", nullable = false)
  private String carColor;

  @Column(name = "car_desc", nullable = false)
  private String carDesc;

  @ElementCollection
  @Column(name = "car_features", nullable = false)
  private List<String> features;

  @Column(name = "car_mpg", nullable = false)
  private int carMpg;

  @Column(name = "car_from_year", nullable = false)
  private int carFromYear;

  @Column(name = "car_to_year", nullable = false)
  private int carToYear;

  @Column(name = "car_review_points", nullable = false)
  private int carReviewPoints;
}
