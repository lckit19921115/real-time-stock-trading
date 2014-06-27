package com.example.assignment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {
    SQLiteDatabase fiveStockDb;
    String sql;
	Cursor cursor = null;
	String[] columns = { "portfolioId", "stockCode", "stockName", "lotSize", "quantityOnHand" };
	String dataStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       if (savedInstanceState == null) {
//           getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//       }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    		// Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater =getMenuInflater();
    	inflater.inflate(R.menu.mainmenu, menu);
    	return true;
     
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	Toast.makeText(this, "MenuItem " +item.getTitle()+" selected" , Toast.LENGTH_SHORT).show();
    	return true;
    	
    }
    
    public void initialDB() {
		try {
			
			/*  create a SQLite Database connection */
			fiveStockDb = SQLiteDatabase.openDatabase("/data/data/com.example.assignment/stockDB", null, SQLiteDatabase.CREATE_IF_NECESSARY);

			
			/*  drop the table if exits, and create a table */
			sql="DROP TABLE if exists Portfolio";
			fiveStockDb.execSQL(sql);
			
			
		
			sql="CREATE TABLE Portfolio (portfolioId int PRIMARY KEY, stockCode int, stockName text, lotSize int, quantityOnHand int);";
			fiveStockDb.execSQL(sql);

			// insert into 
			fiveStockDb.execSQL("INSERT INTO Portfolio(portfolioId, stockCode, stockName, lotSize, quantityOnHand) values (1001, 00001, 'CHEUNG KONG', 1000, 2000);");
			
			fiveStockDb.execSQL("INSERT INTO Portfolio(portfolioId, stockCode, stockName, lotSize, quantityOnHand) values (1002, 00002, 'CLP HOLDINGS', 500, 5000);");
			
			fiveStockDb.execSQL("INSERT INTO Portfolio(portfolioId, stockCode, stockName, lotSize, quantityOnHand) values (1003, 00003, 'HK & CHINA GAS', 1000, 3000);");
			
			fiveStockDb.execSQL("INSERT INTO Portfolio(portfolioId, stockCode, stockName, lotSize, quantityOnHand) values (1004, 00005, 'HSBC HOLDINGS', 400, 2000);");
			
			fiveStockDb.execSQL("INSERT INTO Portfolio(portfolioId, stockCode, stockName, lotSize, quantityOnHand) values (1005, 00066, 'MTR COOPOARTION', 500, 1000);");

			
			fiveStockDb.close();
		}
		catch (SQLiteException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
    
    /**
     * A placeholder fragment containing a simple view.
     */
   /* public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }*/

}
