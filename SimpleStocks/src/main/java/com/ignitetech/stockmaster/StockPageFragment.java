package com.ignitetech.stockmaster;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ignitetech.stockmaster.StockPage.PriceInfoFragment;
import com.ignitetech.stockmaster.StockPage.PriceChartFragment;


public class StockPageFragment extends Fragment {
  TextView textViewStockName;
  TextView textViewStockNumber;
  TextView textViewCurrentPrice;
  TextView textViewPriceChange;
  TextView textViewTradeDate;
  TextView textViewUpdateTime;
  ViewPager mViewPager;
  StockInfoPagerAdapter mStockInfoPagerAdapter;
  SinaStock stock;

  public StockPageFragment() {
  }

  public static StockPageFragment newInstance(SinaStock stock) {
    StockPageFragment fragment = new StockPageFragment();
    fragment.stock = stock;
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_stockpage, container, false);

    textViewStockName = (TextView) rootView.findViewById(R.id.textViewStockName);
    textViewStockNumber = (TextView) rootView.findViewById(R.id.textViewStockNumber);
    textViewCurrentPrice = (TextView) rootView.findViewById(R.id.textViewCurrentPrice);
    textViewPriceChange = (TextView) rootView.findViewById(R.id.textViewPriceChange);
    textViewTradeDate = (TextView) rootView.findViewById(R.id.textViewTradeDate);
    textViewUpdateTime = (TextView) rootView.findViewById(R.id.textViewUpdateTime);

    // Sets company name, price, etc
    textViewStockName.setText(stock.getStockName());
    textViewStockNumber.setText(stock.getStockNumber());
    textViewCurrentPrice.setText(stock.getCurPrice());
    // @todo price change has not been supported yet.
    textViewPriceChange.setText(stock.getCurPrice());
    textViewTradeDate.setText(stock.getDate());
    textViewUpdateTime.setText("Updated: " + stock.getTime());

    /*    // If price change is positive, set TextView to green. Otherwise Red.
    if (stock.getPriceChangeDirection() >= 0) {
      textViewPriceChange.setTextColor(getResources().getColor(R.color.change_green));
    } else {
      textViewPriceChange.setTextColor(getResources().getColor(R.color.change_red));
    }*/

    // Sets up the ViewPager
    mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
    mStockInfoPagerAdapter = new StockInfoPagerAdapter(getActivity().getSupportFragmentManager());
    mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
    mViewPager.setAdapter(mStockInfoPagerAdapter);
    mViewPager.setCurrentItem(1);          // Set default starting page to the 1st item
    mViewPager.setOffscreenPageLimit(2);   // Keep all pages loaded
    return rootView;
  }

  public class StockInfoPagerAdapter extends FragmentPagerAdapter {

    public StockInfoPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int i) {
      switch (i) {
        case 0:
          return PriceInfoFragment.newInstance(stock);
        case 1:
          return PriceChartFragment.newInstance(stock);
        default:
          return PriceInfoFragment.newInstance(stock);
      }
    }

    @Override
    public int getCount() {
      return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      switch (position) {
        case 0:
          return getResources().getString(R.string.price_info);
        case 1:
          return getResources().getString(R.string.charts);
        default:
          return "What";
      }
    }
  }
}