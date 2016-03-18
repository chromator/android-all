package com.test.crmengine;

/**
 * Created by swaroop.kulkarni on 3/18/2016.
 */
public class TVFailure extends Failure {

    public static final String TV_ISSUE = "We heard from @paredes_flo that you are having issue with your tv. We resynced your signal & it looks like things should be working now.";

    public TVFailure() {
        super();
    }

    public TVFailure(String message) {
        super(message);
    }
}
