package com.thienthai.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tw, tw1;
    SeekBar sb1, sb2, sb3;
    CheckBox cb1, cb2, cb3;
    ImageButton btn, btn1, btn2;
    int sodiem = 100;
    @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                //Ánh sạ
                Anhsa();
                sb1.setEnabled(false);
                sb2.setEnabled(false);
                sb3.setEnabled(false);

                CountDownTimer count = new CountDownTimer(60000, 200) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Random rd = new Random();
                        int sord = 3;
                        int run1 = rd.nextInt(sord);
                        int run2 = rd.nextInt(sord);
                    int run3 = rd.nextInt(sord);
                    sb1.setProgress(sb1.getProgress() + run1);
                    sb2.setProgress(sb2.getProgress() + run2);
                    sb3.setProgress(sb3.getProgress() + run3);
                    if(sb1.getProgress() == sb1.getMax()){
                        btn.setVisibility(View.VISIBLE);
                        this.cancel();
                        tw1.setText("Susi Win");
                        if(cb1.isChecked()){
                            sodiem += 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán chính xác cộng 10 điểm", Toast.LENGTH_LONG).show();
                        }else {
                            sodiem -= 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán sai trừ 10 điểm", Toast.LENGTH_LONG).show();
                        }
                        tw.setText(sodiem + "");
                        EnableCheckBox();
                    }

                    if(sb2.getProgress() == sb2.getMax()){
                        btn.setVisibility(View.VISIBLE);
                        this.cancel();
                        tw1.setText("Zuki Win");
                        if(cb2.isChecked()){
                            sodiem += 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán chính xác cộng 10 điểm", Toast.LENGTH_LONG).show();
                        }else {
                            sodiem -= 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán sai trừ 10 điểm", Toast.LENGTH_LONG).show();

                        }
                        tw.setText(sodiem + "");
                        EnableCheckBox();
                    }
                    if(sb3.getProgress() == sb3.getMax()){
                        btn.setVisibility(View.VISIBLE);
                        this.cancel();
                        tw1.setText("Hari Win");
                        if(cb3.isChecked()){
                            sodiem += 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán chính xác cộng 10 điểm", Toast.LENGTH_LONG).show();
                        }else {
                            sodiem -= 10;
                            Toast.makeText(MainActivity.this, "Bạn đoán sai trừ 10 điểm", Toast.LENGTH_LONG).show();

                        }
                        tw.setText(sodiem + "");
                        EnableCheckBox();
                    }
                }


                @Override
                public void onFinish() {

                }
            };
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cb1.isChecked() || cb2.isChecked() ||cb3.isChecked()){
                        btn.setVisibility(View.INVISIBLE);
                        count.start();
                        sb1.setProgress(0);
                        sb2.setProgress(0);
                        sb3.setProgress(0);
                        DisableCheckBox();
                    }else {
                        Toast.makeText(MainActivity.this, "Bạn phải chọn nhân vật", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                    tw.setText("100");
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    tw1.setText("");
                    count.cancel();

                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        cb2.setChecked(false);
                        cb3.setChecked(false);
                    }
                }
            });
            cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        cb1.setChecked(false);
                        cb3.setChecked(false);
                    }
                }
            });
            cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        cb2.setChecked(false);
                        cb1.setChecked(false);
                    }
                }
            });

        }
        private void EnableCheckBox(){
            cb1.setEnabled(true);
            cb2.setEnabled(true);
            cb3.setEnabled(true);
        }
        private void DisableCheckBox() {
            cb1.setEnabled(false);
            cb2.setEnabled(false);
            cb3.setEnabled(false);
        }
        private void Anhsa(){
            tw = (TextView) findViewById(R.id.textView);
            sb1 = (SeekBar) findViewById(R.id.seekBar1);
            sb2 = (SeekBar) findViewById(R.id.seekBar2);
            sb3 = (SeekBar) findViewById(R.id.seekBar3);
            cb1 = (CheckBox) findViewById(R.id.checkBox1);
            cb2 = (CheckBox) findViewById(R.id.checkBox2);
            cb3 = (CheckBox) findViewById(R.id.checkBox3);
            btn = (ImageButton) findViewById(R.id.button2);
            tw1 = (TextView) findViewById(R.id.textView2);
            btn1 = (ImageButton) findViewById(R.id.imageButton);
            btn2 = (ImageButton) findViewById(R.id.imageButton2);

        }
}