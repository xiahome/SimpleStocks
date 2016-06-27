package com.ignitetech.stockmaster.StockPage;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import com.ignitetech.stockmaster.SinaFinanceInfo;
import com.ignitetech.stockmaster.SinaStock;
import com.ignitetech.stockmaster.TimeScale;
import com.ignitetech.stockmaster.R;

/**
 * This fragment retrieves and displays the price chart for the current stock from Sina.
 * */

public class PriceChartFragment extends Fragment {

  RelativeLayout rlPriceChartContainer;
  LinearLayout llChartProgress;
  ImageView imageViewPriceChart;

  RadioButton radioButtonMinute;
  RadioButton radioButtonDay;
  RadioButton radioButtonWeek;
  RadioButton radioButtonMonth;

  RadioButton rbPlotTypeLine;
  RadioButton rbPlotTypeBar;
  RadioButton rbPlotTypeCandle;

  SinaStock stock;

  public PriceChartFragment() {
  }

  public static PriceChartFragment newInstance(SinaStock stock) {
    PriceChartFragment fragment = new PriceChartFragment();
    fragment.stock = stock;
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_pricechart, container, false);

    rlPriceChartContainer = (RelativeLayout) rootView.findViewById(R.id.rlPriceChartContainer);
    imageViewPriceChart = (ImageView) rootView.findViewById(R.id.imageViewPriceChart);
    llChartProgress = (LinearLayout) rootView.findViewById(R.id.llChartProgress);

    radioButtonMinute = (RadioButton) rootView.findViewById(R.id.radioButtonMinute);
    radioButtonDay = (RadioButton) rootView.findViewById(R.id.radioButtonDay);
    radioButtonWeek = (RadioButton) rootView.findViewById(R.id.radioButtonWeek);
    radioButtonMonth = (RadioButton) rootView.findViewById(R.id.radioButtonMonth);

    radioButtonMinute.setOnClickListener(new OnTimeIntervalRadioButtonListener());
    radioButtonDay.setOnClickListener(new OnTimeIntervalRadioButtonListener());
    radioButtonWeek.setOnClickListener(new OnTimeIntervalRadioButtonListener());
    radioButtonMonth.setOnClickListener(new OnTimeIntervalRadioButtonListener());

    rbPlotTypeLine = (RadioButton) rootView.findViewById(R.id.rbPlotTypeLine);
    rbPlotTypeBar = (RadioButton) rootView.findViewById(R.id.rbPlotTypeBar);
    rbPlotTypeCandle = (RadioButton) rootView.findViewById(R.id.rbPlotTypeCandle);

    rbPlotTypeLine.setOnClickListener(new OnTimeIntervalRadioButtonListener());
    rbPlotTypeBar.setOnClickListener(new OnTimeIntervalRadioButtonListener());
    rbPlotTypeCandle.setOnClickListener(new OnTimeIntervalRadioButtonListener());

    new GetPriceChartAsyncTask().execute(stock.getStockNumber());
    return rootView;
  }

  private class OnTimeIntervalRadioButtonListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
      new GetPriceChartAsyncTask().execute(stock.getStockNumber());
    }
  }

  private class GetPriceChartAsyncTask extends AsyncTask<String, Void, SinaStock> {

    @Override
    protected void onPreExecute() {
      llChartProgress.setVisibility(View.VISIBLE);
      imageViewPriceChart.setVisibility(View.INVISIBLE);
    }

    @Override
    protected SinaStock doInBackground(String... arg) {

      String stockNumber = arg[0];
      TimeScale timeScale;
      Log.d("DEBUG111", "stock: " + stockNumber);

      // Chosen time interval
      if (radioButtonMinute.isChecked()) {
        timeScale = TimeScale.MIN;
      } else if (radioButtonDay.isChecked()) {
        timeScale = TimeScale.DAY;
      } else if (radioButtonWeek.isChecked()) {
        timeScale = TimeScale.WEEK;
      } else if (radioButtonMonth.isChecked()) {
        timeScale = TimeScale.MONTH;
      } else {
        timeScale = TimeScale.MIN;
      }

      /*// Plot type (bar, candle, line)
      if (rbPlotTypeBar.isChecked()) {
        plotType = "b";
      } else if (rbPlotTypeCandle.isChecked()) {
        plotType = "c";
      } else if (rbPlotTypeLine.isChecked()) {
        plotType = "l";
      } else {
        plotType = "b";
      }
      Log.d("Debug111", "Trying to get drawble from Sina API.");*/

      try {
        // Drawable d = YahooFinanceInfo.getPriceChart(tick, timeInterval, plotType);
        Drawable d = SinaFinanceInfo.getPriceChart(stockNumber, timeScale);
        Log.d("DEBUG", "doInBackground: " + "Got drawable" + d.toString());
        stock.setPriceChart(d);
      } catch (Exception e) {
        Log.d("ERROR", e.toString());
      }
      return stock;
    }

    @Override
    protected void onPostExecute(SinaStock stock) {
      // Turns off progress view and sets price chart visible
      llChartProgress.setVisibility(View.INVISIBLE);
      imageViewPriceChart.setVisibility(View.VISIBLE);

      // Sets the imageview to the retrieved drawable
      imageViewPriceChart.setImageDrawable(stock.getPriceChart());
    }
  }
}
