package ru.bse71.examples.java.rmi.common;

public class TimeConverter implements TimeConverterRemote {

  @Override
  public Integer convertToSeconds(Integer hours, Integer minutes) {
    return (hours * 60 + minutes) * 60;
  }
}
