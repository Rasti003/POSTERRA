package pl.legalnyplener.planktrzon;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PosterFragment extends Fragment  {

    ImageView PosterImage;
    Button ButtonFacebook;
    Button ButtonTicket;
    Button ButtonDescription;


    TextView Descryption;
    TextView Title;
    TextView City;
    TextView Address;
    TextView Date;

    String PosterImgUrl;
    String FacebookUrl;
    String TicketUrl;
    String DescryptionUrl;

    String TitleText;
    String DateText;
    String CityText;
    String AddressText;
    String DescryptionText;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_poster, container, false);

        Bundle bundle = getArguments();



        TitleText = bundle.getString("NAME");
        DateText = bundle.getString("START_DATE");
        CityText = bundle.getString("CITY");
        AddressText = bundle.getString("ADDRESS");
        DescryptionText = bundle.getString("INFO");

       FacebookUrl = bundle.getString("FACEBOOK_URL");
       TicketUrl = bundle.getString("TICKET_URL");
       DescryptionUrl = bundle.getString("INFO_URL");
       PosterImgUrl= bundle.getString("IMG_URL");

        PosterImage = (ImageView) view.findViewById(R.id.PosterImage);
        Title = (TextView) view.findViewById(R.id.Title);
        City = (TextView) view.findViewById(R.id.City) ;
        Address = (TextView) view.findViewById(R.id.Address);
        Date = (TextView) view.findViewById(R.id.Date);
        Descryption = (TextView)view.findViewById(R.id.Description);



        Picasso.with(getActivity()).load(String.valueOf(PosterImgUrl)).error(R.drawable.picklerick_error).into(PosterImage);

        Title.setText(TitleText);
        City.setText(CityText);
        Address.setText(AddressText);
        Date.setText(DateText);
        Descryption.setText(DescryptionText);


        WebView webview = (WebView) view.findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("URL");





        ButtonDescription  = (Button) view.findViewById(R.id.ButtonDescription);
        ButtonFacebook  = (Button) view.findViewById(R.id.ButtonFacebook);
        ButtonTicket  = (Button) view.findViewById(R.id.ButtonTicket);

        HidingButtons(ButtonFacebook, ButtonTicket ,ButtonDescription);


        ButtonDescription.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent iDescryption = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(DescryptionUrl));
                startActivity(iDescryption);

            }
        });





        ButtonFacebook.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent IFacebook = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(FacebookUrl));
                startActivity(IFacebook);

            }
        });




        ButtonTicket.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent iTicket = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(TicketUrl));
                startActivity(iTicket);

            }
        });



        return view;
    }

    public void HidingButtons ( Button ButtonFacebook, Button  ButtonTicket, Button ButtonDescription ){
        if (new String(FacebookUrl).equals("0")  == true ){
            ButtonFacebook.setVisibility(View.GONE);
        }

        if (new String(TicketUrl).equals("0")  == true ){
       ButtonTicket.setVisibility(View.GONE);
        }
        if (new String(DescryptionUrl).equals("0")  == true ){
            ButtonDescription.setVisibility(View.GONE);
        }

    }

}
