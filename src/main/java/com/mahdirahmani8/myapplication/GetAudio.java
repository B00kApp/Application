package com.mahdirahmani8.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.mahdirahmani8.myapplication.Model.Audio;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class GetAudio extends AppCompatActivity implements AudioManager.OnAudioFocusChangeListener {

    SeekBar seekBar;
    ProgressWheel progress;
    TextView name, tv_start, tv_end, noti_name;
    MediaPlayer mediaPlayer = new MediaPlayer();
    AudioManager am = null;
    ImageView noti_play, noti_exit;
    Button btn_play, next, back;
    int position;


    int end_pos;
    Timer timer;

    String offerChannelId = "Offers_noti";
    NotificationManager notifManager;

    String Name;
    List<String> links;

    // Notification
    private static Notification notification;
    private static NotificationManager notificationManager;
    private static final int NotificationID = 1005;
    private static NotificationCompat.Builder mBuilder;

    private static RemoteViews contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_audio);


        Cast();

        GetAndSet();

        name.setText(Name);

        String link;
        link = getLink(position);


        PlayMusic(link);


        // Notification


        //      TODO   = >    Notification

    }

    private void Cast() {

        seekBar = (SeekBar) findViewById(R.id.SeekBar);
        name = (TextView) findViewById(R.id.Name_id);
        tv_start = (TextView) findViewById(R.id.tv_start);
        tv_end = (TextView) findViewById(R.id.tv_end);
        btn_play = (Button) findViewById(R.id.btn_Play);
        next = (Button) findViewById(R.id.btn_next);
        back = (Button) findViewById(R.id.btn_back);
        progress = (ProgressWheel) findViewById(R.id.Progress_id);

        // Notification

        noti_exit = (ImageView) findViewById(R.id.Exit_Noti_id);
        noti_play = (ImageView) findViewById(R.id.Play_Npti_id);
        noti_name = (TextView) findViewById(R.id.MusicName_noti_id);
    }

    private void GetAndSet() {
        position = getIntent().getExtras().getInt("POS");
        end_pos = getIntent().getExtras().getInt("END");
        links = getIntent().getExtras().getStringArrayList("LINKS");
        Name = getIntent().getExtras().getString("NAME");


    }

    private void PlayMusic(String link) {

        try {

            mediaPlayer.setDataSource(link);
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {

                    progress.setVisibility(View.GONE);
                    tv_end.setText(set_Time(mediaPlayer.getDuration()));

                    btn_play.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (mediaPlayer != null && mediaPlayer.isPlaying()) {

                                mediaPlayer.pause();
                                btn_play.setBackgroundResource(R.drawable.playing);
                            } else {

                                mediaPlayer.start();

                                // Add Notification
//                                RunNotification();

                                seekBar_Setup();
                                btn_play.setBackgroundResource(R.drawable.pause);
                            }


                        }
                    });
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        ButtonNextBack(end_pos, position);

        mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);

        seekBar.setProgress(0);
        mediaPlayer.seekTo(0);
        tv_start.setText(set_Time(0));


    }

    private String getLink(int position) {

        String link = links.get(position);

        return link;
    }

    private void ButtonNextBack(int ens_pos, int position) {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 5000);
                Toast.makeText(GetAudio.this, " -5 ", Toast.LENGTH_LONG).show();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
                Toast.makeText(GetAudio.this, " +5 ", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void seekBar_Setup() {

        seekBar.setMax(mediaPlayer.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    tv_start.setText(set_Time(mediaPlayer.getCurrentPosition()));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        timer = new Timer();
        timer.schedule(new timer_task(), 0, 1000);
    }

    private String set_Time(long progress) {

        int sec = (int) progress / 1000;
        int min = (int) sec / 60;
        sec %= 60;

        return String.format(Locale.ENGLISH, "%02d", min) + ":" + String.format(Locale.ENGLISH, "%02d", sec);
    }

    @Override
    public void onAudioFocusChange(int focusChange) {

        if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
            // Pause
        } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
            // Resume
        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
            // Stop or pause depending on your need
        }
    }


    public class timer_task extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    tv_start.setText(set_Time(mediaPlayer.getCurrentPosition()));
                }
            });
        }
    }


    // Add Notification

    public void setNotification(String songName) {

        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mediaPlayer.isPlaying() && mediaPlayer != null) {
            timer.cancel();
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }


    @Override
    protected void onDestroy() {

        if (mediaPlayer == null) {

            try {

                timer.cancel();
                mediaPlayer.stop();
                mediaPlayer.release();

            } catch (Exception e) {
            }
        }

        super.onDestroy();

    }

    // test notification

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
