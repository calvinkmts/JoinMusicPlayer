package com.example.calvi.joinmusicplayer;

import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private ImageView ImageViewAlbum;
    private TextView textViewTitle;
    private int position;
    private ArrayList<DataModel> songList = new ArrayList<>();
    private FloatingActionButton playButton;
    private FloatingActionButton nextButton;
    private FloatingActionButton previousButton;
    private PlayerAdapter mPlayerAdapter;
    private String file_path;
    private boolean isPlaying;
    private SeekBar mSeekBar;
    private boolean mUserIsSeeking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        playButton = (FloatingActionButton) findViewById(R.id.playButton);
        nextButton = (FloatingActionButton) findViewById(R.id.nextButton);
        previousButton = (FloatingActionButton) findViewById(R.id.previousButton);

        textViewTitle = (TextView) findViewById(R.id.image_description);
        ImageViewAlbum = (ImageView) findViewById(R.id.image);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);

        getIncomingIntent();

        DatabaseHelper songs = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = songs.getReadableDatabase();

        songList = songs.getData();

        mediaPlayer = new MediaPlayer();
        file_path = songList.get(position).getUrl();

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        isPlaying = true;

        try {
            mediaPlayer.setDataSource(file_path);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

        initializeSeekbar();
        initializePlaybackController();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isPlaying) {
                    isPlaying = false;
                    playButton.setImageResource(android.R.drawable.ic_media_pause);
                    mediaPlayer.pause();
                } else {
                    isPlaying = true;
                    playButton.setImageResource(android.R.drawable.ic_media_play);
                    mediaPlayer.start();
                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playNext();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPrevious();
            }
        });

        if (!mediaPlayer.isPlaying()) {
            playNext();
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                playNext();
            }
        });
    }


    private void initializeSeekbar() {
        mSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int userSelectedPosition = 0;

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        mUserIsSeeking = true;
                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            userSelectedPosition = progress;
                        }
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mUserIsSeeking = false;
                        mediaPlayer.seekTo(userSelectedPosition);
                    }
                });
    }

    private void initializePlaybackController() {
        MediaPlayerHolder mMediaPlayerHolder = new MediaPlayerHolder(this);
        mMediaPlayerHolder.setPlaybackInfoListener(new PlaybackListener());
        mPlayerAdapter = mMediaPlayerHolder;
    }

    public class PlaybackListener extends PlaybackInfoListener {

        @Override
        public void onDurationChanged(int duration) {
            mSeekBar.setMax(duration);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onPositionChanged(int position) {
            if (!mUserIsSeeking) {
                mSeekBar.setProgress(position, true);
            }
        }

        @Override
        public void onStateChanged(@State int state) {
            String stateToString = PlaybackInfoListener.convertStateToString(state);
        }

        @Override
        public void onPlaybackCompleted() {
        }
    }

    private void playNext() {
        mediaPlayer.reset();
        position++;
        if (position == songList.size()) {
            mediaPlayer.release();
        } else {
            file_path = songList.get(position).getUrl();

            textViewTitle.setText(songList.get(position).getTitle());

            try {
                mediaPlayer.setDataSource(file_path);
                mediaPlayer.prepare();
                mediaPlayer.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void playPrevious() {
        mediaPlayer.pause();
        position--;
        if (position == 0) {
            mediaPlayer.release();
        } else {
            file_path = songList.get(position).getUrl();

            textViewTitle.setText(songList.get(position).getTitle());

            try {
                mediaPlayer.setDataSource(file_path);
                mediaPlayer.prepare();
                mediaPlayer.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.release();
        super.onBackPressed();
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            this.position = getIntent().getIntExtra("position", 0);

            setImage(imageUrl, imageName);
        }
    }

    private void setImage(String imageUrl, String imageName){

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
