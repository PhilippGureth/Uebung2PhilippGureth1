package dei.info3.uebung2philippgureth1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Intent intent = this.getIntent();
        if (intent != null) {
            String message = intent.getStringExtra ("MESSAGE");

            TextView lblMessage = this.findViewById(R.id.lblMessage);
            lblMessage.setText(message);
        }

    }
}