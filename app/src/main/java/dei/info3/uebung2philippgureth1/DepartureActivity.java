package dei.info3.uebung2philippgureth1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import dei.info3.uebung2philippgureth1.network.KvvService;
import dei.info3.uebung2philippgureth1.network.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DepartureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depature);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://projekte.kvv-efa.de/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        KvvService service = retrofit.create(KvvService.class);
        Call<Result> resultCall = service.listDepartures();

        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                Log.i("DepartureActivity", String.valueOf(result.getDepartureList().size()));

                for (int i=0; i < Integer.valueOf(result.getDepartureList().size()) ; i++)
                {

                    Log.i("Nr "+i, result.getDepartureList().get(i).getServingLine().getNumber());
                    Log.i("Name", result.getDepartureList().get(i).getServingLine().getName());

                    Log.i("Stunde", result.getDepartureList().get(i).getDateTime().getHour());
                    Log.i("Minute", result.getDepartureList().get(i).getDateTime().getMinute());



                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("DepartureActivity", "Anfragefehler");
            }
        });
    }
}