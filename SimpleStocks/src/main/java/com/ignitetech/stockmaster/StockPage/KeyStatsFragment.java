package com.ignitetech.stockmaster.StockPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ignitetech.stockmaster.R;
import com.ignitetech.stockmaster.SinaStock;


public class KeyStatsFragment extends Fragment {

  TextView tvMarketCap;
  TextView tvTrailingPE;
  TextView tvForwardPE;
  TextView tvPEGRatio;
  TextView tvPriceSales;
  TextView tvPriceBook;
  TextView tvEBITDA;

  SinaStock stock;

  public KeyStatsFragment() {
  }

  public static KeyStatsFragment newInstance(SinaStock stock) {

    KeyStatsFragment fragment = new KeyStatsFragment();
    fragment.stock = stock;
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_keystats, container, false);

    tvMarketCap = (TextView) rootView.findViewById(R.id.tvMarketCap);
    tvTrailingPE = (TextView) rootView.findViewById(R.id.tvTrailingPE);
    tvForwardPE = (TextView) rootView.findViewById(R.id.tvForwardPE);
    tvPEGRatio = (TextView) rootView.findViewById(R.id.tvPEGRatio);
    tvPriceSales = (TextView) rootView.findViewById(R.id.tvPriceSales);
    tvPriceBook = (TextView) rootView.findViewById(R.id.tvPriceBook);
    tvEBITDA = (TextView) rootView.findViewById(R.id.tvEBITDA);

    /*tvMarketCap.setText(stock.getMarketCap());
    tvTrailingPE.setText(stock.getTrailingPE());
    tvForwardPE.setText(stock.getForwardPE());
    tvPEGRatio.setText(stock.getPegRatio());
    tvPriceSales.setText(stock.getPriceSales());
    tvPriceBook.setText(stock.getPriceBook());
    tvEBITDA.setText(stock.getEbitda());*/

    return rootView;
  }
}
