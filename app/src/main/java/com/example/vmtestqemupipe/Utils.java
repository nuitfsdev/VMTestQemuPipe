package com.example.vmtestqemupipe;

import static android.Manifest.permission.READ_PHONE_NUMBERS;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_PRECISE_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.hardware.Sensor.TYPE_GYROSCOPE;
import static android.hardware.Sensor.TYPE_ORIENTATION;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Debug;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Utils {

    // qemu pipes testing
    private static String[] known_pipes = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    public static boolean hasPipes(TextView textView) {
        for (String pipe : known_pipes) {
            File qemu_socket = new File(pipe);
            if (qemu_socket.exists()) {
                Log.d("test", "find qemu pipes");
                textView.setText("Find qemu pipes: " + pipe+". This is an emulator!");
                return true;
            }
        }
        textView.setText("Not find qemu pipes! This is a real Android device!");
        return false;
    }


}