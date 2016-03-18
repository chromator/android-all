package com.test.crmengine;

/**
 * Created by swaroop.kulkarni on 3/18/2016.
 */
public class RouterFailure extends Failure {
    public static String ROUTER_NOT_RESPONDING = "Looks like your router is not responding. We recommend you restart your system.";

    public RouterFailure() {
        super();
    }

    public RouterFailure(String message) {
        super(message);
    }
}
