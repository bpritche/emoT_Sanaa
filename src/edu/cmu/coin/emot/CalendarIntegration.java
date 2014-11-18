package edu.cmu.coin.emot;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract.Instances;

public class CalendarIntegration extends Activity {
	
	public static class TrendData {
		String eventName;
		String moodName;
	}
	
	public static List<TrendData> getDataForListView() {
		//Modified slightly 
		//This will return a list of events and the most common emotion that was felt during that
		// event.
		List<TrendData> trendList = new ArrayList<TrendData>();
		//For now, this is all we're interested in.
		String[] projection = new String [] {
				Instances.TITLE, Instances.BEGIN};
		//Returns title and beginning time for all events between 1970 and now (may be changed later)
		ContentResolver cr = MainActivity.mainContentResolver();
		//URI Uri.Builder eventsUriBuilder = CalendarContract.Instances.CONTENT_URI.buildUpon();
		Cursor trendCursor = 
				Instances.query(
						cr,
						projection,
						0,
						System.currentTimeMillis());
		
		if(trendCursor.moveToFirst()) {
			do {
				TrendData trend = new TrendData();
				trend.eventName = trendCursor.getString(0);
				//will work on getting the actual emotion that they felt at that time a bit later.
				// For now, just say they were always happy.
				//long time = trendCursor.getLong(1);
				trend.moodName = "happy";
				trendList.add(trend);
			} while(trendCursor.moveToNext());
		}
		
		return trendList;
	}
}
