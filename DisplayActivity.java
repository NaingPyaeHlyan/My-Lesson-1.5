package mm.com.fairway.mylesson15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent page = getIntent();

        String myPage = page.getStringExtra("WEB_PAGE");
        WebView myWebView = (WebView) findViewById( R.id.webPageView );
        myWebView.setWebViewClient( new WebViewClient( ) );
        myWebView.loadUrl(myPage);
        setTitle("Web View");
    }
}
