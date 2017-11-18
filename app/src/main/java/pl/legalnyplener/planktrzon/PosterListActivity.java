package pl.legalnyplener.planktrzon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PosterListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posterlist);

        Bundle data = getIntent().getExtras();
        ArrayList<Poster> posters = changeToPosterList(data.getString("data"));
    }


    private ArrayList<Poster> changeToPosterList(String raw_data){
        ArrayList<Poster> posterList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(raw_data);
            JSONObject poster;

            for(int i=0; i != jsonArray.length(); i++){
                poster = jsonArray.getJSONObject(i);
                posterList.add(new Poster(poster.getInt("ID_PLAKAT"),
                        poster.getString("NAZWA"),
                        poster.getString("OPIS"),
                        poster.getString("MIASTO"),
                        poster.getString("ADRES"),
                        poster.getString("DATA_POCZATEK"),
                        poster.getString("DATA_KONIEC"),
                        poster.getString("GODZIN_POCZATEK"),
                        poster.getString("GODZINA_KONIEC"),
                        poster.getString("IMG_URL"),
                        poster.getString("INFO_URL"),
                        poster.getString("FACEBOOK_URL"),
                        poster.getString("BILET_URL")));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return posterList;
    }
}
