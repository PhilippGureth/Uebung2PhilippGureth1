package dei.info3.uebung2philippgureth1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSendMessage = this.findViewById(R.id.buttonSendMessage);

        EditText editMessage = this.findViewById(R.id.editMessage);

        TextView textMessage = this.findViewById(R.id.txtMessage);

        Button openDepartures = this.findViewById(R.id.btnOpenDepartures);

        Button buttonKarte = this.findViewById(R.id.buttonKarte);

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editMessage.getText().toString();
                textMessage.setText(message);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("MESSAGE", message);

                startActivity(intent);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();

        Log.i("TAG", "OnResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();


        Log.i("TAG", "OnPause!");
    }

    public void openUrl(View view)
    {
        EditText txtUrl = this.findViewById(R.id.edtUrl);
        String url = txtUrl.getText().toString();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent browserChooser = Intent.createChooser(browserIntent, "Wählen Sie einen Browser");

        this.startActivity(browserChooser);
    }

    public void openDepartures(View view)
    {
        Intent intent = new Intent(this, DepartureActivity.class);
        this.startActivity(intent);
    }
}