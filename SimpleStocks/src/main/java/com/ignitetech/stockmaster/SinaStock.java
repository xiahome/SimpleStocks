package com.ignitetech.stockmaster;

import android.graphics.drawable.Drawable;

/**
 *
 */
public class SinaStock {
  private String stockName;
  private String openPrice;
  private String preCosePrice;
  private String curPrice;
  private String dayHigh;
  private String dayLow;
  private String bid1;
  private String ask1;
  private String volume;
  private String transactionAmount;
  private String bid1Volume;
  private String bid1Price;
  private String bid2Volume;
  private String bid2Price;
  private String bid3Volume;
  private String bid3Price;
  private String bid4Volume;
  private String bid4Price;
  private String bid5Volume;
  private String bid5Price;
  private String ask1Volume;
  private String ask1Price;
  private String ask2Volume;
  private String ask2Price;
  private String ask3Volume;
  private String ask3Price;
  private String ask4Volume;
  private String ask4Price;
  private String ask5Volume;
  private String ask5Price;
  private String date;
  private String time;

  private int ticketNumber;
  private Drawable priceChart;

  public String getStockName() {
    return stockName;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }

  public String getOpenPrice() {
    return openPrice;
  }

  public void setOpenPrice(String openPrice) {
    this.openPrice = openPrice;
  }

  public String getPreCosePrice() {
    return preCosePrice;
  }

  public void setPreCosePrice(String preCosePrice) {
    this.preCosePrice = preCosePrice;
  }

  public String getCurPrice() {
    return curPrice;
  }

  public void setCurPrice(String curPrice) {
    this.curPrice = curPrice;
  }

  public String getDayHigh() {
    return dayHigh;
  }

  public void setDayHigh(String dayHigh) {
    this.dayHigh = dayHigh;
  }

  public String getDayLow() {
    return dayLow;
  }

  public void setDayLow(String dayLow) {
    this.dayLow = dayLow;
  }

  public String getBid1() {
    return bid1;
  }

  public void setBid1(String bid1) {
    this.bid1 = bid1;
  }

  public String getAsk1() {
    return ask1;
  }

  public void setAsk1(String ask1) {
    this.ask1 = ask1;
  }

  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public String getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(String transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  public String getBid1Volume() {
    return bid1Volume;
  }

  public void setBid1Volume(String bid1Volume) {
    this.bid1Volume = bid1Volume;
  }

  public String getBid1Price() {
    return bid1Price;
  }

  public void setBid1Price(String bid1Price) {
    this.bid1Price = bid1Price;
  }

  public String getBid2Volume() {
    return bid2Volume;
  }

  public void setBid2Volume(String bid2Volume) {
    this.bid2Volume = bid2Volume;
  }

  public String getBid2Price() {
    return bid2Price;
  }

  public void setBid2Price(String bid2Price) {
    this.bid2Price = bid2Price;
  }

  public String getBid3Volume() {
    return bid3Volume;
  }

  public void setBid3Volume(String bid3Volume) {
    this.bid3Volume = bid3Volume;
  }

  public String getBid3Price() {
    return bid3Price;
  }

  public void setBid3Price(String bid3Price) {
    this.bid3Price = bid3Price;
  }

  public String getBid4Volume() {
    return bid4Volume;
  }

  public void setBid4Volume(String bid4Volume) {
    this.bid4Volume = bid4Volume;
  }

  public String getBid4Price() {
    return bid4Price;
  }

  public void setBid4Price(String bid4Price) {
    this.bid4Price = bid4Price;
  }

  public String getBid5Volume() {
    return bid5Volume;
  }

  public void setBid5Volume(String bid5Volume) {
    this.bid5Volume = bid5Volume;
  }

  public String getBid5Price() {
    return bid5Price;
  }

  public void setBid5Price(String bid5Price) {
    this.bid5Price = bid5Price;
  }

  public String getAsk1Volume() {
    return ask1Volume;
  }

  public void setAsk1Volume(String ask1Volume) {
    this.ask1Volume = ask1Volume;
  }

  public String getAsk1Price() {
    return ask1Price;
  }

  public void setAsk1Price(String ask1Price) {
    this.ask1Price = ask1Price;
  }

  public String getAsk2Volume() {
    return ask2Volume;
  }

  public void setAsk2Volume(String ask2Volume) {
    this.ask2Volume = ask2Volume;
  }

  public String getAsk2Price() {
    return ask2Price;
  }

  public void setAsk2Price(String ask2Price) {
    this.ask2Price = ask2Price;
  }

  public String getAsk3Volume() {
    return ask3Volume;
  }

  public void setAsk3Volume(String ask3Volume) {
    this.ask3Volume = ask3Volume;
  }

  public String getAsk3Price() {
    return ask3Price;
  }

  public void setAsk3Price(String ask3Price) {
    this.ask3Price = ask3Price;
  }

  public String getAsk4Volume() {
    return ask4Volume;
  }

  public void setAsk4Volume(String ask4Volume) {
    this.ask4Volume = ask4Volume;
  }

  public String getAsk4Price() {
    return ask4Price;
  }

  public void setAsk4Price(String ask4Price) {
    this.ask4Price = ask4Price;
  }

  public String getAsk5Volume() {
    return ask5Volume;
  }

  public void setAsk5Volume(String ask5Volume) {
    this.ask5Volume = ask5Volume;
  }

  public String getAsk5Price() {
    return ask5Price;
  }

  public void setAsk5Price(String ask5Price) {
    this.ask5Price = ask5Price;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(int ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public Drawable getPriceChart() {
    return priceChart;
  }

  public void setPriceChart(Drawable priceChart) {
    this.priceChart = priceChart;
  }

  @Override
  public String toString() {
    StringBuilder sb= new StringBuilder();
    sb.append("Ticker number: " + ticketNumber + "\r\n");
    sb.append("Name: " + stockName + "\r\n");
    sb.append("Open price: " + openPrice + "\r\n");
    sb.append("Previous day close price: " + preCosePrice + "\r\n");
    sb.append("Current price: " + curPrice + "\r\n");
    sb.append("Highest price in the day: " + dayHigh + "\r\n");
    sb.append("Lowest price in the day: " + dayLow + "\r\n");
    sb.append("Bid-1 price: " + bid1 + "\r\n");
    sb.append("Ask-1 price: " + ask1 + "\r\n");
    sb.append("Volume: " + volume + "\r\n");
    sb.append("Transaction amount: " + transactionAmount + "\r\n");
    sb.append("Bid-1 volume: " + bid1Volume + "\r\n");
    sb.append("Bid-1 price: " + bid1Price + "\r\n");
    sb.append("Bid-2 volume: " + bid2Volume + "\r\n");
    sb.append("Bid-2 price: " + bid2Price + "\r\n");
    sb.append("Bid-3 volume: " + bid3Volume + "\r\n");
    sb.append("Bid-3 price: " + bid3Price + "\r\n");
    sb.append("Bid-4 volume: " + bid4Volume + "\r\n");
    sb.append("Bid-4 price: " + bid4Price + "\r\n");
    sb.append("Bid-5 volume: " + bid5Volume + "\r\n");
    sb.append("Bid-5 price: " + bid5Price + "\r\n");
    sb.append("Ask-1 volume: " + ask1Volume + "\r\n");
    sb.append("Ask-1 price: " + ask1Price + "\r\n");
    sb.append("Ask-2 volume: " + ask2Volume + "\r\n");
    sb.append("Ask-2 price: " + ask2Price + "\r\n");
    sb.append("Ask-3 volume: " + ask3Volume + "\r\n");
    sb.append("Ask-3 price: " + ask3Price + "\r\n");
    sb.append("Ask-4 volume: " + ask4Volume + "\r\n");
    sb.append("Ask-4 price: " + ask4Price + "\r\n");
    sb.append("Ask-5 volume: " + ask5Volume + "\r\n");
    sb.append("Ask-5 price: " + ask5Price + "\r\n");
    sb.append("Date: " + date + "\r\n");
    sb.append("Time: " + time + "\r\n");
    return sb.toString();
  }
}
