package com.springKafka.liveDashboard.temperature;

import java.util.Calendar;

public class Reading {
  public Integer temperature;
  public Integer day;

  public Reading() {}

  public Reading(Integer temperature) {
    this.temperature = temperature;
    Calendar calendar = Calendar.getInstance();
    day = calendar.get(Calendar.MINUTE);
  }

  public Integer getTemperature() {
    return temperature;
  }

  public void setTemperature(Integer temperature) {
    this.temperature = temperature;
  }

  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  @Override
  public String toString() {
    return "Reading{" +
            "temperature=" + temperature +
            ", day=" + day +
            '}';
  }
}
