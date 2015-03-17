package com.example.testreadkeystore;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView textView = (TextView) findViewById(R.id.textview1);
		textView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d(TAG, "on click-->");
				loadKeystore();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void loadKeystore() {
		InputStream in = getResources().openRawResource(R.raw.file);
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			keyStore.load(in, "password".toCharArray());
			Log.d(TAG, "LOADED KEYSTORE -->" + keyStore.size());
			Enumeration<String> e = keyStore.aliases();
			Key key = null;
			while (e.hasMoreElements()) {
				String string = (String) e.nextElement();
				Log.d(TAG, "KEY STORE ALIASES--->" + string);
				key = keyStore.getKey(string, "password".toCharArray());
				Log.d(TAG, "KEY--->" + key);
			}

			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory.generatePrivate(keyFactory.getKeySpec(key,
					RSAPrivateKeySpec.class));
			Log.d(TAG, "PRIVATE KEY--->" + privateKey);

		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e1) {
			e1.printStackTrace();
		} catch (InvalidKeySpecException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
