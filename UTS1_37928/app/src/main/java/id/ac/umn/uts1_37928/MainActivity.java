package id.ac.umn.uts1_37928;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button library_button;
    private Button profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profile=(Button) this.findViewById(R.id.profile);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(MainActivity.this,profile.class);
                startActivityForResult(intent2,1);
            }
        });
        library_button=(Button) this.findViewById(R.id.library_button);
        library_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,formInput.class);

                startActivityForResult(intent1, 1);
            }
        });
    }
}