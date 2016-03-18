package com.test.crmengine;

/**
 * Created by swaroop.kulkarni on 3/18/2016.
 */
public interface HomeApplianceFailureListener {
    int ROUTER_FAILURE  = 0;
    int TV_FAILURE = 1;
    int PHONE_HEALTH_TROUBLE = 2;

    void onApplianceFailure(int failure, Failure data );
}
