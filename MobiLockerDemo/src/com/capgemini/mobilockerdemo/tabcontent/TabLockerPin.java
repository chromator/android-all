package com.capgemini.mobilockerdemo.tabcontent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.capgemini.mobilockerdemo.R;

public class TabLockerPin extends Fragment {
	
		private FragmentManager fragmentManager;

        public TabLockerPin(FragmentManager fragmentManager) {
        	this.fragmentManager = fragmentManager;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View fragView = inflater.inflate(R.layout.tab_locker_pin, container, false);
            EditText pin = (EditText) fragView.findViewById(R.id.pin_edit);
            pin.setOnKeyListener(new View.OnKeyListener() {
				
				@Override
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					String inputText = ((EditText)v).getEditableText().toString();
					if(inputText.length() >= 4 && ("1234".equals(inputText)))
					{
						fragmentManager.beginTransaction().replace(R.id.container, new TabLockerContent()).commit();
//						FragmentTransaction transact = fragmentManager.beginTransaction(); 
//						transact.add(new TabLockerContent(), "");
//						transact.commit();
					}
					return false;
				}
			});
            return fragView;
        }


}
