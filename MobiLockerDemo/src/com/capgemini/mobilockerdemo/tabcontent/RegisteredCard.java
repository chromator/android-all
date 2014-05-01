package com.capgemini.mobilockerdemo.tabcontent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.capgemini.mobilockerdemo.R;

public class RegisteredCard extends Fragment {
	
	private FragmentManager fragmentManager;
	public RegisteredCard(FragmentManager fragmentManager) {
    	this.fragmentManager = fragmentManager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.tab_registered_card, container, false);
        
        return fragView;
    }

}
