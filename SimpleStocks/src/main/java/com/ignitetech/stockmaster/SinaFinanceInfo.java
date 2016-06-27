package com.ignitetech.stockmaster;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.junit.Test;


/**
 * Created by mxia on 6/25/16.
 */
public class SinaFinanceInfo {
  /**
   *  Items in response. 顺序号从0开始。
   0：”大秦铁路”，股票名字；
   1：”27.55″，今日开盘价；
   2：”27.25″，昨日收盘价；
   3：”26.91″，当前价格；
   4：”27.55″，今日最高价；
   5：”26.20″，今日最低价；
   6：”26.91″，竞买价，即“买一”报价；
   7：”26.92″，竞卖价，即“卖一”报价；
   8：”22114263″，成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百；
   9：”589824680″，成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万；
   10：”4695″，“买一”申请4695股，即47手；
   11：”26.91″，“买一”报价；
   12：”57590″，“买二”
   13：”26.90″，“买二”
   14：”14700″，“买三”
   15：”26.89″，“买三”
   16：”14300″，“买四”
   17：”26.88″，“买四”
   18：”15100″，“买五”
   19：”26.87″，“买五”
   20：”3100″，“卖一”申报3100股，即31手；
   21：”26.92″，“卖一”报价
   (22, 23), (24, 25), (26,27), (28, 29)分别为“卖二”至“卖四的情况”
   30：”2008-01-11″，日期；
   31：”15:05:32″，时间；
   */
  final static int STOCK_NAME_INDEX = 0;
  final static int OPEN_PRICE_INDEX = 1;
  final static int PREV_CLOSE_INDEX = 2;
  final static int CUR_PRICE_INDEX = 3;
  final static int DAY_HIGH_INDEX = 4;
  final static int DAY_LOW_INDEX = 5;
  final static int BID_1_INDEX = 6;
  final static int ASK_1_INDEX = 7;
  final static int VOLUME_INDEX = 8;
  final static int TRANSACTION_AMOUNT_INDEX = 9;
  final static int BID_1_VOLUME_INDEX = 10;
  final static int BID_1_PRICE_INDEX = 11;
  final static int BID_2_VOLUME_INDEX = 12;
  final static int BID_2_PRICE_INDEX = 13;
  final static int BID_3_VOLUME_INDEX = 14;
  final static int BID_3_PRICE_INDEX = 15;
  final static int BID_4_VOLUME_INDEX = 16;
  final static int BID_4_PRICE_INDEX = 17;
  final static int BID_5_VOLUME_INDEX = 18;
  final static int BID_5_PRICE_INDEX = 19;
  final static int ASK_1_VOLUME_INDEX = 20;
  final static int ASK_1_PRICE_INDEX = 21;
  final static int ASK_2_VOLUME_INDEX = 22;
  final static int ASK_2_PRICE_INDEX = 23;
  final static int ASK_3_VOLUME_INDEX = 24;
  final static int ASK_3_PRICE_INDEX = 25;
  final static int ASK_4_VOLUME_INDEX = 26;
  final static int ASK_4_PRICE_INDEX = 27;
  final static int ASK_5_VOLUME_INDEX = 28;
  final static int ASK_5_PRICE_INDEX = 29;
  final static int DATE_INDEX = 30;
  final static int TIME_INDEX = 31;

  public static SinaStock getStockData(String stockNumber) {
    String[] responseData;
    SinaStock sinaStock = new SinaStock();
    sinaStock.setStockNumber(stockNumber);

    try {
      URL url = new URL("http://hq.sinajs.cn/list=" + stockNumber);
      URLConnection urlConnection = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "GBK"));

      // Split CSV by comma and quotes
      responseData = in.readLine().split(",");
      in.close();

      sinaStock.setStockName(responseData[STOCK_NAME_INDEX].split("\"")[1]);
      sinaStock.setOpenPrice(responseData[OPEN_PRICE_INDEX]);
      sinaStock.setPreCosePrice(responseData[PREV_CLOSE_INDEX]);
      sinaStock.setCurPrice(responseData[CUR_PRICE_INDEX]);
      sinaStock.setDayHigh(responseData[DAY_HIGH_INDEX]);
      sinaStock.setDayLow(responseData[DAY_LOW_INDEX]);
      sinaStock.setBid1(responseData[BID_1_INDEX]);
      sinaStock.setAsk1(responseData[ASK_1_INDEX]);
      sinaStock.setVolume(responseData[VOLUME_INDEX]);
      sinaStock.setTransactionAmount(responseData[TRANSACTION_AMOUNT_INDEX]);
      sinaStock.setBid1Volume(responseData[BID_1_VOLUME_INDEX]);
      sinaStock.setBid1Price(responseData[BID_1_PRICE_INDEX]);
      sinaStock.setBid2Volume(responseData[BID_2_VOLUME_INDEX]);
      sinaStock.setBid2Price(responseData[BID_2_PRICE_INDEX]);
      sinaStock.setBid3Volume(responseData[BID_3_VOLUME_INDEX]);
      sinaStock.setBid3Price(responseData[BID_3_PRICE_INDEX]);
      sinaStock.setBid4Volume(responseData[BID_4_VOLUME_INDEX]);
      sinaStock.setBid4Price(responseData[BID_4_PRICE_INDEX]);
      sinaStock.setBid5Volume(responseData[BID_5_VOLUME_INDEX]);
      sinaStock.setBid5Price(responseData[BID_5_PRICE_INDEX]);
      sinaStock.setAsk1Volume(responseData[ASK_1_VOLUME_INDEX]);
      sinaStock.setAsk1Price(responseData[ASK_1_PRICE_INDEX]);
      sinaStock.setAsk2Volume(responseData[ASK_2_VOLUME_INDEX]);
      sinaStock.setAsk2Price(responseData[ASK_2_PRICE_INDEX]);
      sinaStock.setAsk3Volume(responseData[ASK_3_VOLUME_INDEX]);
      sinaStock.setAsk3Price(responseData[ASK_3_PRICE_INDEX]);
      sinaStock.setAsk4Volume(responseData[ASK_4_VOLUME_INDEX]);
      sinaStock.setAsk4Price(responseData[ASK_4_PRICE_INDEX]);
      sinaStock.setAsk5Volume(responseData[ASK_5_VOLUME_INDEX]);
      sinaStock.setAsk5Price(responseData[ASK_5_PRICE_INDEX]);
      sinaStock.setDate(responseData[DATE_INDEX]);
      sinaStock.setTime(responseData[TIME_INDEX]);
    } catch (Exception e) {
      Log.d("DEBUG", "Error occurred during generating data from http response:" + e.toString());
    }
    return sinaStock;
  }

  /**
   * This method will retrieve the price chart from Sina and returns it as a drawable. Example:
   * 分时  http://image.sinajs.cn/newchart/min/n/sh000001.gif
   * 日K线 http://image.sinajs.cn/newchart/daily/n/sh000001.gif
   * 周K线 http://image.sinajs.cn/newchart/weekly/n/sh000001.gif
   * 月K线 http://image.sinajs.cn/newchart/monthly/n/sh000001.gif
   * @param stockNumber The stock number.
   * @param timeScale The time granularity of the stock chart.
   * @return Stock chart as a {@link Drawable}.
   */
  public static Drawable getPriceChart(String stockNumber, TimeScale timeScale) {
    // Log.d("Debug111", "getting stock chart for " + stockNumber);
    Drawable drawable = null;
    try {
      String targetUrl = "http://image.sinajs.cn/newchart/" + getTimeScale(timeScale) + "/n/" + stockNumber + ".gif";
      System.out.println(targetUrl);
      URL url = new URL(targetUrl);
      InputStream content = (InputStream) url.getContent();
      drawable = Drawable.createFromStream(content, "src");
      // Log.d("Debug111", "getPriceChart: got something.");
    } catch (Exception e) {
      System.out.println(e.fillInStackTrace());
    }
    return drawable;
  }

  private static String getTimeScale(TimeScale timeScale) {
    switch (timeScale) {
      case MIN:
        return "min";
      case DAY:
        return "daily";
      case WEEK:
        return "weekly";
      case MONTH:
        return "monthly";
      default:
        return "UnknownTimeScale";
    }
  }

  @Test
  public void testTextAPI() {
    SinaStock sinaStock = SinaFinanceInfo.getStockData("sh601006");
    System.out.print(sinaStock.toString());
  }

  @Test
  public void testChartAPI() {
    Drawable drawble = getPriceChart("sh601006", TimeScale.DAY);
    System.out.println(drawble.toString());
  }
}
