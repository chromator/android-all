package com.test.crmengine;

/**
 * Created by swaroop.kulkarni on 3/18/2016.
 */
public class PhoneTrouble extends Failure {

    public static final String PHONE_HEATING = "Are you facing issue of phone heating?";

    public PhoneTrouble() {
        super();
    }

    public PhoneTrouble(String message) {
        super(message);
    }
}
