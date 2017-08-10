package com.advinity.afdolash.androtim.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.advinity.afdolash.androtim.adapter.DevicesAdapter;
import com.advinity.afdolash.androtim.R;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    // Relative layout tint
    private RelativeLayout tint_redCrimson, tint_darkOrange, tint_deepPink,
            tint_orange, tint_carrot, tint_blueCobalt,
            tint_skylight, tint_indigo, tint_purple,
            tint_darkMagenta, tint_peanut, tint_yellowCanary,
            tint_lightYellow, tint_greenPine, tint_emeraldGreen,
            tint_greenOcean;

    // Member fields
    private BluetoothAdapter mBtAdapter = null;
    private BluetoothSocket mBtSocket = null;
    private OutputStream mOutStream = null;

    //  Double back to exit
    boolean doubleBackToExit = false;

    // UUID service - This is the type of Bluetooth device that the BT module is
    // It is very likely yours will be the same, if not google UUID for your manufacturer
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // MAC-address of Bluetooth module
    public String mBtAddress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Initialize tint variables
        tint_blueCobalt = (RelativeLayout) findViewById(R.id.tint_blueCobalt);
        tint_carrot = (RelativeLayout) findViewById(R.id.tint_carrot);
        tint_darkMagenta = (RelativeLayout) findViewById(R.id.tint_darkMagenta);
        tint_darkOrange = (RelativeLayout) findViewById(R.id.tint_darkOrange);
        tint_deepPink = (RelativeLayout) findViewById(R.id.tint_deepPink);
        tint_emeraldGreen = (RelativeLayout) findViewById(R.id.tint_emeraldGreen);
        tint_greenOcean = (RelativeLayout) findViewById(R.id.tint_greenOcean);
        tint_greenPine = (RelativeLayout) findViewById(R.id.tint_greenPine);
        tint_indigo = (RelativeLayout) findViewById(R.id.tint_indigo);
        tint_lightYellow = (RelativeLayout) findViewById(R.id.tint_lightYellow);
        tint_orange = (RelativeLayout) findViewById(R.id.tint_orange);
        tint_peanut = (RelativeLayout) findViewById(R.id.tint_peanut);
        tint_purple = (RelativeLayout) findViewById(R.id.tint_purple);
        tint_redCrimson = (RelativeLayout) findViewById(R.id.tint_redCrimson);
        tint_skylight = (RelativeLayout) findViewById(R.id.tint_skylight);
        tint_yellowCanary = (RelativeLayout) findViewById(R.id.tint_yellowCanary);

        //getting the bluetooth adapter value and calling checkBTstate function
        mBtAdapter = BluetoothAdapter.getDefaultAdapter();
        checkBTState();

        /**************************************************************************************************************************8
         *  Buttons are set up with onclick listeners so when pressed a method is called
         *  In this case send data is called with a value and a toast is made
         *  to give visual feedback of the selection made
         */
        tint_redCrimson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!A@");
                Toast.makeText(MainActivity.this, "Red Crimson", Toast.LENGTH_SHORT).show();
            }
        });

        tint_darkOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!B@");
                Toast.makeText(MainActivity.this, "Dark Orange", Toast.LENGTH_SHORT).show();
            }
        });

        tint_deepPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!C@");
                Toast.makeText(MainActivity.this, "Deep  Pink", Toast.LENGTH_SHORT).show();
            }
        });

        tint_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!D@");
                Toast.makeText(MainActivity.this, "Orange", Toast.LENGTH_SHORT).show();
            }
        });

        tint_carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!E@");
                Toast.makeText(MainActivity.this, "Carrot", Toast.LENGTH_SHORT).show();
            }
        });

        tint_blueCobalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!F@");
                Toast.makeText(MainActivity.this, "Blue Cobalt", Toast.LENGTH_SHORT).show();
            }
        });

        tint_skylight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!G@");
                Toast.makeText(MainActivity.this, "Skylight", Toast.LENGTH_SHORT).show();
            }
        });

        tint_indigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!H@");
                Toast.makeText(MainActivity.this, "Indigo", Toast.LENGTH_SHORT).show();
            }
        });

        tint_purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!I@");
                Toast.makeText(MainActivity.this, "Purple", Toast.LENGTH_SHORT).show();
            }
        });

        tint_darkMagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!J@");
                Toast.makeText(MainActivity.this, "Dark Magenta", Toast.LENGTH_SHORT).show();
            }
        });

        tint_peanut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!K@");
                Toast.makeText(MainActivity.this, "Peanut", Toast.LENGTH_SHORT).show();
            }
        });

        tint_yellowCanary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!L@");
                Toast.makeText(MainActivity.this, "Yellow Canary", Toast.LENGTH_SHORT).show();
            }
        });

        tint_lightYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!M@");
                Toast.makeText(MainActivity.this, "Light Yellow", Toast.LENGTH_SHORT).show();
            }
        });

        tint_greenPine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!N@");
                Toast.makeText(MainActivity.this, "Green Pine", Toast.LENGTH_SHORT).show();
            }
        });

        tint_emeraldGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!O@");
                Toast.makeText(MainActivity.this, "Emerald Green", Toast.LENGTH_SHORT).show();
            }
        });

        tint_greenOcean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!P@");
                Toast.makeText(MainActivity.this, "Green Ocean", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExit) {
            if (sendData("Y")) {
                super.onBackPressed();
                try {
                    mOutStream.close();
                    mBtSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
            return;
        }

        this.doubleBackToExit = true;
        Toast.makeText(this, "Please click back again to exit.", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExit = false;
            }
        }, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Connection methods are best here in case program goes into the background etc

        // Get MAC address from DeviceListActivity
        Intent intent = getIntent();
        mBtAddress = intent.getStringExtra(DevicesAdapter.EXTRA_DEVICE_ADDRESS);

        // Set up a pointer to the remote device using its address.
        BluetoothDevice device = mBtAdapter.getRemoteDevice(mBtAddress);

        // Attempt to create a bluetooth socket for comms
        try {
            mBtSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e1) {
            Toast.makeText(getBaseContext(), "ERROR - Could not create Bluetooth socket", Toast.LENGTH_SHORT).show();
        }

        // Establish the connection.
        try {
            mBtSocket.connect();
        } catch (IOException e) {
            try {
                mBtSocket.close();        //If IO exception occurs attempt to close socket
            } catch (IOException e2) {
                Toast.makeText(getBaseContext(), "ERROR - Could not close Bluetooth socket", Toast.LENGTH_SHORT).show();
            }
        }

        // Create a data stream so we can talk to the device
        try {
            mOutStream = mBtSocket.getOutputStream();
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), "ERROR - Could not create bluetooth outstream", Toast.LENGTH_SHORT).show();
        }

        // When activity is resumed, attempt to send a piece of junk data ('x') so that it will fail if not connected
        // i.e don't wait for a user to press button to recognise connection failure
        sendData("X");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sendData("Y");
        try {
            mOutStream.close();
            mBtSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //Pausing can be the end of an app if the device kills it or the user doesn't open it again
        //close all connections so resources are not wasted

        //Close BT socket to device
        try {
            mBtSocket.close();
        } catch (IOException e2) {
            Toast.makeText(getBaseContext(), "ERROR - Failed to close Bluetooth socket", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method to check bt state
     */
    private void checkBTState() {
        // Check device has Bluetooth and that it is turned on
        if(mBtAdapter == null) {
            Toast.makeText(getBaseContext(), "ERROR - Device does not support bluetooth", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            if (mBtAdapter.isEnabled()) {
            } else {
                //Prompt user to turn on Bluetooth
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }

    /**
     * Method to send data
     */
    private boolean sendData(String message) {
        byte[] msgBuffer = message.getBytes();

        try {
            //attempt to place data on the outstream to the BT device
            mOutStream.write(msgBuffer);
            return true;
        } catch (IOException e) {
            //if the sending fails this is most likely because device is no longer there
            Toast.makeText(getBaseContext(), "ERROR - Device not found", Toast.LENGTH_SHORT).show();
            finish();
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_clearRed:
                sendData("!1@");
                Toast.makeText(MainActivity.this, "Kuras cat merah.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_clearYellow:
                sendData("!2@");
                Toast.makeText(MainActivity.this, "Kuras cat kuning.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_clearBlue:
                sendData("!3@");
                Toast.makeText(MainActivity.this, "Kuras cat biru.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_clearWhite:
                sendData("!4@");
                Toast.makeText(MainActivity.this, "Kuras cat putih.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_calibrateRed:
                sendData("!6@");
                Toast.makeText(MainActivity.this, "Kalibrasi cat merah.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_calibrateYellow:
                sendData("!7@");
                Toast.makeText(MainActivity.this, "Kalibrasi cat kuning.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_calibrateBlue:
                sendData("!8@");
                Toast.makeText(MainActivity.this, "Kalibrasi cat biru.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_calibrateWhite:
                sendData("!9@");
                Toast.makeText(MainActivity.this, "Kalibrasi cat putih.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
