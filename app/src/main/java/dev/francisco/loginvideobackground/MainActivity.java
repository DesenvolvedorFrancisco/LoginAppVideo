package dev.francisco.loginvideobackground;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;


import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout container;
    Button btnShowLogin,btnLogin;
    VideoView videoBackground;
    TextInputLayout textInputLayoutUsername,textInputLayoutPassword;
    Animation slide_up;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.relative_container);
        videoBackground = findViewById(R.id.video_background);
        btnShowLogin = findViewById(R.id.btn_show_login);
        btnLogin = findViewById(R.id.btn_login);
        textInputLayoutUsername = findViewById(R.id.input_layout_username);
        textInputLayoutPassword = findViewById(R.id.input_layout_password);


        btnShowLogin.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        slide_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);

        init();

        //  Da inicio ao video

        videoBackground.setMediaController(null);
        videoBackground.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.bmw);
        videoBackground.start();

        // Controla o video e activa o looping

        videoBackground.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

    }

    public void init(){
        textInputLayoutUsername.setVisibility(View.INVISIBLE);
        textInputLayoutPassword.setVisibility(View.INVISIBLE);
        RelativeLayout.LayoutParams layoutParams =
                (RelativeLayout.LayoutParams)container.getLayoutParams();
        layoutParams.height = 150;
        container.setLayoutParams(layoutParams);
        container.startAnimation(slide_up);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_show_login) {
                    textInputLayoutUsername.setVisibility(View.VISIBLE);
                    textInputLayoutPassword.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams layoutParams =
                            (RelativeLayout.LayoutParams) container.getLayoutParams();
                    layoutParams.height = 900;
                    container.setLayoutParams(layoutParams);
                    container.startAnimation(slide_up);
                    flag = false;
        } else if (view.getId() == R.id.btn_login) {
                Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();
        }

    }
}