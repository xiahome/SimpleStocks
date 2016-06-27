package com.ignitetech.stockmaster;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SearchView;

public class MainActivity extends FragmentActivity {
  private ActionBar actionBar;
  private MenuItem searchItem;
  private MenuItem refreshItem;
  private String curStockNumber;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d("DEBUG", "onCreate");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    actionBar = getActionBar();
    // When starting app, search for "大秦铁路"
    curStockNumber = "sh601006";
    Log.d("DEBUG", "Set current stock number: " + curStockNumber);
    new GetKeyStatsAsyncTask().execute(curStockNumber);
    actionBar.setTitle(getResources().getString(R.string.app_name));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    Log.d("DEBUG", "onCreateOptionsMenu");
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    searchItem = menu.findItem(R.id.search);
    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    SearchView searchView = (SearchView) searchItem.getActionView();
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    searchView.setIconifiedByDefault(false);
    searchView.setQueryHint("请输入股票代码，例如sh601006");
    searchView.setSubmitButtonEnabled(true); // For a submit button

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      public boolean onQueryTextChange(String newText) {
        // this is your adapter that will be filtered
        return true;
      }

      public boolean onQueryTextSubmit(String query) {
        // Here u can get the value "query" which is entered in the search box.
        Log.d("DEBUG", "OnQuerySubmit");
        curStockNumber = query;
        new GetKeyStatsAsyncTask().execute(curStockNumber);
        searchItem.collapseActionView();
        return false;
      }
    });
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.

    switch (item.getItemId()) {
      case R.id.refresh:
        refreshItem = item;
        new GetKeyStatsAsyncTask().execute(curStockNumber);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private class GetKeyStatsAsyncTask extends AsyncTask<String, String, SinaStock> {
    LinearLayout linlaHeaderProgress = (LinearLayout) findViewById(R.id.progress_linearlayout);
    LinearLayout llNoInternetConnection = (LinearLayout) findViewById(R.id.llNoInternetConnection);
    FrameLayout fragment_container = (FrameLayout) findViewById(R.id.fragment_container);

    @Override
    protected void onPreExecute() {
      // Sets company info invisible, and progress indicator visible
      linlaHeaderProgress.setVisibility(View.VISIBLE);
      fragment_container.setVisibility(View.INVISIBLE);
      llNoInternetConnection.setVisibility(View.GONE);
    }

    protected SinaStock doInBackground(String... stockNumber) {
      Log.d("DEBUG", "Doing in backgorund for stock: " + stockNumber[0]);
      SinaStock sinaStock = null;
      if (isNetworkAvailable()) {
        try {
          sinaStock = SinaFinanceInfo.getStockData(stockNumber[0]);
          Log.d("DEBUG", "Got stock: " + stockNumber[0]);
          if(sinaStock == null) {
            Log.d("DEBUG", "Got null object.");
          } else {
            Log.d("DEBUG", "Got non-null object.");
          }
        } catch (Exception e) {
          Log.d("DEBUG", e.toString());
        }
      }
      Log.d("DEBUG", "Got SinaStock object: " + sinaStock);
      return sinaStock;
    }

    protected void onPostExecute(SinaStock stock) {
      linlaHeaderProgress.setVisibility(View.GONE);
      Log.d("DEBUG", "Doing post execution for stock: " + stock);
      if (stock != null) {
        // Create a new Fragment to be placed in the activity layout
        StockPageFragment stockPageFragment = StockPageFragment.newInstance(stock);
        if (findViewById(R.id.fragment_container) != null) {
          getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, stockPageFragment).commit();
        } else {
          getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, stockPageFragment).commit();
        }
        fragment_container.setVisibility(View.VISIBLE);
        Log.d("DEBUG", "fregment set visible.");
      } else {
        llNoInternetConnection.setVisibility(View.VISIBLE);
      }
    }
  }

  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }
}

