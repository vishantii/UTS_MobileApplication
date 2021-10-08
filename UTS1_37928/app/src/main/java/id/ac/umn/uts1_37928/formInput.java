package id.ac.umn.uts1_37928;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class formInput extends AppCompatActivity {
    private EditText input_name;
    private Button enter_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);
        input_name=(EditText) this.findViewById(R.id.input_name);
        enter_button=(Button) this.findViewById(R.id.enter_button);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(formInput.this,library.class);
                String userInput = input_name.getText().toString();
                if(userInput.length() == 0){
                    input_name.setError("Harap Di Isi");
                }else{
                    intent.putExtra("Input",userInput);
                    startActivityForResult(intent,1);
                }
            }
        });


    }
}