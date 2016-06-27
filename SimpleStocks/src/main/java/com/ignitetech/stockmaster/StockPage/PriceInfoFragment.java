package com.ignitetech.stockmaster.StockPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ignitetech.stockmaster.R;
import com.ignitetech.stockmaster.SinaStock;


public class PriceInfoFragment extends Fragment {
  TextView textViewStockName;
  TextView textViewCurrentPrice;
  TextView textViewPrevClose;
  TextView textViewOpen;
  TextView textViewVolume;
  TextView textViewTransactionAmount;
  TextView textViewBid1;
  TextView textViewAsk1;
  TextView textViewDayHigh;
  TextView textViewDayLow;

  SinaStock stock;

  public PriceInfoFragment() {
  }

  public static PriceInfoFragment newInstance(SinaStock stock) {
    PriceInfoFragment fragment = new PriceInfoFragment();
    fragment.stock = stock;
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_priceinfo, container, false);
    textViewStockName = (TextView) rootView.findViewById(R.id.textViewStockName);
    textViewCurrentPrice = (TextView) rootView.findViewById(R.id.textViewCurrentPrice);
    textViewPrevClose = (TextView) rootView.findViewById(R.id.textViewPreClose);
    textViewOpen = (TextView) rootView.findViewById(R.id.textViewOpen);
    textViewVolume = (TextView) rootView.findViewById(R.id.textViewVolume);
    textViewTransactionAmount = (TextView) rootView.findViewById(R.id.textViewTransactionAmount);
    textViewBid1 = (TextView) rootView.findViewById(R.id.textViewBid1);
    textViewAsk1 = (TextView) rootView.findViewById(R.id.textViewAsk1);
    textViewDayHigh = (TextView) rootView.findViewById(R.id.textViewDayHigh);
    textViewDayLow = (TextView) rootView.findViewById(R.id.textViewDayLow);

    textViewStockName.setText(stock.getStockName());
    textViewCurrentPrice.setText(stock.getCurPrice());
    textViewPrevClose.setText(stock.getPreCosePrice());
    textViewOpen.setText(stock.getOpenPrice());
    textViewVolume.setText(stock.getVolume());
    textViewTransactionAmount.setText(stock.getTransactionAmount());
    textViewBid1.setText(stock.getBid1());
    textViewAsk1.setText(stock.getAsk1());
    textViewDayHigh.setText(stock.getDayHigh());
    textViewDayLow.setText(stock.getDayLow());
    return rootView;
  }
}
