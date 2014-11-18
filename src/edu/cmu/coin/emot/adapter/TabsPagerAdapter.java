package edu.cmu.coin.emot.adapter;

import edu.cmu.coin.emot.AdviceFragment;
import edu.cmu.coin.emot.TrendsFragment;
import edu.cmu.coin.emot.VoiceRecognitionFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new VoiceRecognitionFragment();
		case 1:
			// Games fragment activity
			return new AdviceFragment();
		case 2:
			// Movies fragment activity
			return new TrendsFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
