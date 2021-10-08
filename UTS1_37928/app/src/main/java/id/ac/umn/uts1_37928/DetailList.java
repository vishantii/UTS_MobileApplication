package id.ac.umn.uts1_37928;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailList extends AppCompatActivity {

    private TextView detTitle;
    private TextView detKeterangan;
    private Button btnPlay;
    private MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);
        detTitle =(TextView) this.findViewById(R.id.detTitle);
        detKeterangan = (TextView) this.findViewById(R.id.detKeterangan);
        btnPlay = findViewById(R.id.btnPlay);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SFX sound = (SFX) bundle.getSerializable("SoundDetail");
        setTitle(sound.getTitle());
        media = MediaPlayer.create(getApplicationContext(), Uri.parse(sound.getSfxURI()));
        detTitle.setText(sound.getTitle());
        detKeterangan.setText(sound.getKeterangan());
        btnPlay.setOnClickListener(v -> media.start());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}