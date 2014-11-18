package edu.cmu.coin.emot;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class TrendsAdapter extends BaseAdapter {
	

	List<CalendarIntegration.TrendData> trendList = CalendarIntegration.getDataForListView();
	
	Context mContext;
			
	@Override
	public int getCount() {
		// Tells listview the number of rows it will require.  Can come from data
		return trendList.size();
	}

	@Override
	public CalendarIntegration.TrendData getItem(int position) {
		// Helps listview get data for each row.  position is the row number, 
		// starting from 0.  This returns the object at index "position"
		return trendList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// Can ignore, returns same value as passed
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Called to get view for each row.  Can use our custom listitem, then
		// bind it with the data.  "position" = row number.  "convertView = recycled view reference.
		// "parent" = parent this view will get attached to.
		
		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.trendlistitem, parent, false);
		}
		
		TextView eventName = (TextView)convertView.findViewById(R.id.eventText);
        TextView eventMood = (TextView)convertView.findViewById(R.id.moodText);

        CalendarIntegration.TrendData trendEvent = trendList.get(position);

        eventName.setText(trendEvent.eventName);
        eventMood.setText(trendEvent.moodName);

        return convertView;
	}

}