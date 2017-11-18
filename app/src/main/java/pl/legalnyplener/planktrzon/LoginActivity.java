package pl.legalnyplener.planktrzon;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    private String downloaded_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        new PobierzPlakaty().execute();

    }

    public void GoInButtonClick(View view){
        if(!downloaded_data.isEmpty()){
            Intent intent = new Intent(this, PosterListActivity.class);
            intent.putExtra("data", downloaded_data);
            startActivity(intent);
        }else {
            Toast toast = Toast.makeText(this, R.string.checkConnection, Toast.LENGTH_SHORT);
            toast.show();
            new PobierzPlakaty().execute();
        }

    }

    public void LogInButtonClick(View view){

    }

    public class PobierzPlakaty extends AsyncTask<Void, Void, String>{
        private String LINK_URL = "http://plakat.legalnyplener.pl/SiiHackaton/pobierz_plakaty.php";;
        @Override
        protected void onPostExecute(String s) {
            downloaded_data = s;
        }

        @Override
        protected String doInBackground(Void... voids) {
            return DownloadData(LINK_URL);
        }

        private String DownloadData(String adress) {
            String data = new String();
            try {
                URL url = new URL(adress);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String temp;
                while ((temp = bufferedReader.readLine()) != null){
                    data += temp;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
    }
}
