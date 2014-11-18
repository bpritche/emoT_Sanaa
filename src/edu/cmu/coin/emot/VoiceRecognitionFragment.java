package edu.cmu.coin.emot;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class VoiceRecognitionFragment extends Fragment implements OnClickListener{

	protected static final int REQUEST_OK = 1;
	protected static final int RESULT_OK = -1;
	private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);
		rootView.findViewById(R.id.button1).setOnClickListener(this);
		view = rootView;
		return rootView;
	}
	
	@Override
	public void onClick(View v) {
	Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	         i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	        	 try {
	             startActivityForResult(i, REQUEST_OK);
	         } catch (Exception e) {
	        	 	Toast.makeText(getActivity(), "Error initializing speech to text engine.", Toast.LENGTH_LONG).show();
	         }
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	        Log.d(getTag(), "Result code is: " + resultCode);
	        if (requestCode==REQUEST_OK  && resultCode==RESULT_OK) {
	        		ArrayList<String> thingsYouSaid = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
	        		if(thingsYouSaid.get(0).equals("happy")){
	        			
	        			view.setBackgroundColor(Color.parseColor("#FFFF00"));
	        			for(int i = 0; i <100000; i++) {
		        			((TextView)view.findViewById(R.id.text1)).setText("It might seem crazy, what I'm about to say...");

	        			}
	        	
	        			((TextView)view.findViewById(R.id.text1)).setText("I'm a hot air balloon that could go to space...");
	        		} else if(thingsYouSaid.get(0).equals("angry")) {
	        			view.setBackgroundColor(Color.parseColor("#CC0000"));
	        			((TextView)view.findViewById(R.id.text1)).setText("Getting angry is just punishing yourself for the fault of another!");
	        		} else if(thingsYouSaid.get(0).equals("sad")) {
	        			view.setBackgroundColor(Color.parseColor("#666699"));
	        			((TextView)view.findViewById(R.id.text1)).setText("Don't be sad, everything's going to work out soon! Do you want to talk about it?");
	        		} else if(thingsYouSaid.get(0).equals("calm")) {
	        			view.setBackgroundColor(Color.parseColor("#0099FF"));
	        			((TextView)view.findViewById(R.id.text1)).setText("That's great, it's important to relax every now and then!");
	        		} else {
	        			view.setBackgroundColor(Color.parseColor("#000000"));
	        			((TextView)view.findViewById(R.id.text1)).setText(thingsYouSaid.get(0));
	        		}
	        		
	        }
	    }


}
