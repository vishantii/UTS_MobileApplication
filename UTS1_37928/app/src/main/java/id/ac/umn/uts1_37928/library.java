package id.ac.umn.uts1_37928;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;

public class library extends AppCompatActivity {

    RecyclerView rvDaftarSfx;
    ListViewAdapter mAdapter;
    Button btnDelete;
    LinkedList<SFX> listSfx = new LinkedList<SFX>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent intent = getIntent();
        String userinput = intent.getStringExtra("Input");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(userinput);
        Toast.makeText(this, "Selamat datang , " + userinput, Toast.LENGTH_SHORT).show();
        rvDaftarSfx = findViewById(R.id.recyclerView);
        mAdapter = new ListViewAdapter(this, listSfx);
        rvDaftarSfx.setAdapter(mAdapter);
        rvDaftarSfx.setLayoutManager(new LinearLayoutManager(this));
        btnDelete = (Button) findViewById(R.id.btnDelete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listSFX();
    }
    public void listSFX(){
        listSfx.add(new SFX("FDB", "iPhone Ringtone", "android.resource://" + getPackageName() + "/" + R.raw.fdb));
        listSfx.add(new SFX("Glitch", "Effect Sound", "android.resource://" + getPackageName() + "/" + R.raw.glitch));
        listSfx.add(new SFX("Whoosh", "Effect Sound", "android.resource://" + getPackageName() + "/" + R.raw.whoosh));
        listSfx.add(new SFX("Cinematic", "Effect Sound", "android.resource://" + getPackageName() + "/" + R.raw.trans));
        listSfx.add(new SFX("Say Im Sorry", "Afgan", "android.resource://" + getPackageName() + "/" + R.raw.sorry));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent profileIntent = new Intent(library.this,profile.class);
                startActivity(profileIntent);
                return true;
            case R.id.home:
                Intent homeIntent = new Intent(library.this,MainActivity.class);
                startActivity(homeIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}