package com.advinity.afdolash.androtim.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.advinity.afdolash.androtim.adapter.DevicesAdapter;
import com.advinity.afdolash.androtim.R;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    // Relative layout tint
    private RelativeLayout tint_abu, tint_biru, tint_biruMuda, tint_coklatMuda,tint_hijau,
            tint_hijauMuda, tint_kuning, tint_kuningMuda, tint_magentaTua, tint_merah,
            tint_merahMuda, tint_orange, tint_orangeMerah, tint_tosca, tint_ungu, tint_unguTua;

    // Member fields
    private BluetoothAdapter mBtAdapter = null;
    private BluetoothSocket mBtSocket = null;
    private OutputStream mOutStream = null;

    // UUID service - This is the type of Bluetooth device that the BT module is
    // It is very likely yours will be the same, if not google UUID for your manufacturer
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // MAC-address of Bluetooth module
    public String mBtAddress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        changeStatusBarColor();

        // Initialize tint variables
        tint_abu = (RelativeLayout) findViewById(R.id.tint_abu);
        tint_biru = (RelativeLayout) findViewById(R.id.tint_biru);
        tint_biruMuda = (RelativeLayout) findViewById(R.id.tint_biruMuda);
        tint_coklatMuda = (RelativeLayout) findViewById(R.id.tint_coklatMuda);
        tint_hijau = (RelativeLayout) findViewById(R.id.tint_hijau);
        tint_hijauMuda = (RelativeLayout) findViewById(R.id.tint_hijauMuda);
        tint_kuning = (RelativeLayout) findViewById(R.id.tint_kuning);
        tint_kuningMuda = (RelativeLayout) findViewById(R.id.tint_kuningMuda);
        tint_magentaTua = (RelativeLayout) findViewById(R.id.tint_magentaTua);
        tint_merah = (RelativeLayout) findViewById(R.id.tint_merah);
        tint_merahMuda = (RelativeLayout) findViewById(R.id.tint_merahMuda);
        tint_orange = (RelativeLayout) findViewById(R.id.tint_orange);
        tint_orangeMerah = (RelativeLayout) findViewById(R.id.tint_orangeMerah);
        tint_tosca = (RelativeLayout) findViewById(R.id.tint_tosca);
        tint_ungu = (RelativeLayout) findViewById(R.id.tint_ungu);
        tint_unguTua = (RelativeLayout) findViewById(R.id.tint_unguTua);

        //getting the bluetooth adapter value and calling checkBTstate function
        mBtAdapter = BluetoothAdapter.getDefaultAdapter();
        checkBTState();

        /**************************************************************************************************************************8
         *  Buttons are set up with onclick listeners so when pressed a method is called
         *  In this case send data is called with a value and a toast is made
         *  to give visual feedback of the selection made
         */
        tint_abu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!A@");
            }
        });

        tint_biru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!B@");
            }
        });

        tint_biruMuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!C@");
            }
        });

        tint_coklatMuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!D@");
            }
        });

        tint_hijau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!E@");
            }
        });

        tint_hijauMuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!F@");
            }
        });

        tint_kuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!G@");
            }
        });

        tint_kuningMuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!H@");
            }
        });

        tint_magentaTua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!I@");
            }
        });

        tint_merah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!J@");
            }
        });

        tint_merahMuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!K@");
            }
        });

        tint_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!L@");
            }
        });

        tint_orangeMerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!M@");
            }
        });

        tint_tosca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!N@");
            }
        });

        tint_ungu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!O@");
            }
        });

        tint_unguTua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("!P@");
            }
        });
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
        try     {
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
    private void sendData(String message) {
        byte[] msgBuffer = message.getBytes();

        try {
            //attempt to place data on the outstream to the BT device
            mOutStream.write(msgBuffer);
        } catch (IOException e) {
            //if the sending fails this is most likely because device is no longer there
            Toast.makeText(getBaseContext(), "ERROR - Device not found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
