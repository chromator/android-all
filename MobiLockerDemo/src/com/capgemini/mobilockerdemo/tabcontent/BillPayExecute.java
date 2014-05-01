package com.capgemini.mobilockerdemo.tabcontent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.capgemini.mobilockerdemo.R;

public class BillPayExecute extends Fragment {
	
	private Button pay;
	
	private FragmentManager fragmentManager;

	
    public BillPayExecute(FragmentManager fragmentManager) {
    	this.fragmentManager = fragmentManager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.tab_bill_pay_execute, container, false);
        pay = (Button) fragView.findViewById(R.id.button_pay);
        pay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getActivity(), "Payment done successfully!", 500);
				toast.show();
				fragmentManager.beginTransaction().replace(R.id.container, new TabQuickPay(fragmentManager)).commit();
			}
		});
		
        return fragView;
    }

}
