package com.game.cryptid.model.entity;

/**
 * This class is used to store the clue of the game.
 * It contains the serial number and the content of the clue.
 */
public class Clue {
  private Integer serialNumber;
  private String content;

  public static Clue create(Integer serialNumber, String content) {
    return new Clue(serialNumber, content);
  }

  public Clue(Integer serialNumber, String content) {
    this.serialNumber = serialNumber;
    this.content = content;
  }

  public Integer getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(Integer serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
