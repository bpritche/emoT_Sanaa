package edu.cmu.coin.emot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TrendsFragment extends Fragment {
	
	View mRootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//First inflate view so that we can see listView1
		if(mRootView == null) {
			mRootView = inflater.inflate(R.layout.fragment_movies, container, false);
		} else {
			((ViewGroup) mRootView.getParent()).removeView(mRootView);
		}
		
		TrendsAdapter trendAdapter = new TrendsAdapter();
		ListView trendView = (ListView) mRootView.findViewById(R.id.listView1);
		trendView.setAdapter(trendAdapter);
		
		return mRootView;
	}

}