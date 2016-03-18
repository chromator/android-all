package com.test.crmengine;

import android.util.Log;
import android.util.SparseArray;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by swaroop.kulkarni on 3/18/2016.
 */
public class CRMService {
    private static String TAG = CRMService.class.getName();
    private static int INTERVAL = 20 * 1000;
    private static int START_INTERVAL = 15 * 1000;
    private HomeApplianceFailureListener mListener;
    private SparseArray<Failure> mFailuresMap;
    private Timer mTimer;

    public CRMService() {
        mFailuresMap = new SparseArray<Failure>();
    }

    public void startService() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.d(TAG, "INSIDE TIMER TASK RUN");
                int mapSize = mFailuresMap.size();
                if (mListener != null && mapSize > 0) {
                    while (mFailuresMap.size() > 0){
                        int failureId = mFailuresMap.keyAt(0);
                        Failure failure = mFailuresMap.get(failureId);
                        mFailuresMap.remove(failureId);
                        mListener.onApplianceFailure(failureId, failure);
                    }

                }
            }
        }, START_INTERVAL, INTERVAL);

    }

    public void stopService() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public HomeApplianceFailureListener getmListener() {
        return mListener;
    }

    public void setmListener(HomeApplianceFailureListener mListener) {
        this.mListener = mListener;
    }

    public void loadRouterFailure() {
        mFailuresMap.put(HomeApplianceFailureListener.ROUTER_FAILURE, new RouterFailure(RouterFailure.ROUTER_NOT_RESPONDING));
    }

    public void loadPhoneHealthFailure() {
        mFailuresMap.put(HomeApplianceFailureListener.PHONE_HEALTH_TROUBLE, new PhoneTrouble(PhoneTrouble.PHONE_HEATING));
    }

    public void loadTvFailure() {
        mFailuresMap.put(HomeApplianceFailureListener.TV_FAILURE, new TVFailure(TVFailure.TV_ISSUE));
    }

    private void clearAll() {
        mFailuresMap.clear();
    }

}
