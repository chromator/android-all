package com.capgemini.mobilockerdemo.tabcontent;

import com.capgemini.mobilockerdemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TabMyCards extends Fragment {
	private Button submit;
	private FragmentManager fragmentManager;
    
    public TabMyCards(FragmentManager fragmentManager) {
    	this.fragmentManager = fragmentManager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.tab_your_card, container, false);
        submit = (Button) fragView.findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.addToBackStack("test");
				fragmentTransaction.replace(R.id.container, new RegisteredCard(fragmentManager) );
				fragmentTransaction.commit();
			}
		});

        return fragView;
    }


}
