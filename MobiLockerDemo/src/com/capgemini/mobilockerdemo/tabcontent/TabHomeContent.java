package com.capgemini.mobilockerdemo.tabcontent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.capgemini.mobilockerdemo.R;

public class TabHomeContent extends Fragment {

        public TabHomeContent() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View fragView = inflater.inflate(R.layout.tab_home, container, false);

            return fragView;
        }

}
