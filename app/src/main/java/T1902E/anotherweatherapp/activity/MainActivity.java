package T1902E.anotherweatherapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import T1902E.anotherweatherapp.R;
import T1902E.anotherweatherapp.adapter.HourAdapter;
import T1902E.anotherweatherapp.model.Weather;
import T1902E.anotherweatherapp.network.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTem = (TextView) findViewById(R.id.tvTem);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        getHours();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        rvHour = (RecyclerView) findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);
    }

    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(ApiManager.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        ApiManager service = retrofit.create(ApiManager.class);

        service.getHour().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.body() == null) return;

                List<Weather> listWeather = response.body();
                HourAdapter adapter = new HourAdapter(MainActivity.this,listWeather);
                rvHour.setAdapter(adapter);

                Weather weather = listWeather.get(0);
                tvTem.setText(weather.getTemperature().getValue().intValue()+"°");
                tvStatus.setText(weather.getIconPhrase());
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                Log.d("TAG","error");

            }
        });
    }
}