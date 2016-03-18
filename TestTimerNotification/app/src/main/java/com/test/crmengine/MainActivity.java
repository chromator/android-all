package com.test.crmengine;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements HomeApplianceFailureListener {
    private String TAG = MainActivity.class.getName();
    private CRMService mCrmService;
    private TextView mRouterTextView;
    private TextView mTvFailureTextView;
    private TextView mPhoneFailureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            Failure extra = bundle.getParcelable("FAILURE");
            Log.d(TAG, "EXTRA ALA RE! " + extra);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRouterTextView = (TextView) findViewById(R.id.router);
        mTvFailureTextView = (TextView) findViewById(R.id.tv);
        mPhoneFailureTextView = (TextView) findViewById(R.id.phone);

        mCrmService = new CRMService();
        mCrmService.setmListener(this);

        mRouterTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "INSIDE ONCLICK ROUTER FAILURE");
                mCrmService.loadRouterFailure();
            }
        });

        mTvFailureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "INSIDE ONCLICK TV FAILURE");
                mCrmService.loadTvFailure();
            }
        });

        mPhoneFailureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "INSIDE ONCLICK PHONE FAILURE");
                mCrmService.loadPhoneHealthFailure();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            Failure extra = bundle.getParcelable("FAILURE");
            Log.d(TAG, "NEW INTENT ALA RE! " + extra);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCrmService.startService();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mCrmService.stopService();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onApplianceFailure(final int failure, final Failure data) {
        switch (failure) {
            case ROUTER_FAILURE:
                Log.d(TAG, "ROUTER FAILURE DETECTED. YOU NEED TO RESTART ROUTER");
                generateNotification(failure, "Router Failure", data);

                break;

            case TV_FAILURE:
                Log.d(TAG, "TV FAILURE DETECTED.");
                generateNotification(failure, "TV Failure", data);
                break;

            case PHONE_HEALTH_TROUBLE:
                Log.d(TAG, "PROBLEM WITH PHONE BATTERY. IT IS TOO LOW.");
                generateNotification(failure, "Phone Failure", data);
                break;
        }
    }

    private void generateNotification(int failureId, String title, Failure data) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle(title)
                        .setContentText(data.getMessage())
                        .setAutoCancel(true);

        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra("FAILURE", data);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, failureId, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(failureId, mBuilder.build());
    }
}
