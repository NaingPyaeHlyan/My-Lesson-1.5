package mm.com.fairway.mylesson15;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider share = null;

    String[] labels;
    String[] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        labels = resources.getStringArray(R.array.headings);
        pages = resources.getStringArray(R.array.web_pages);

        GridView gridView = (GridView)findViewById(R.id.petsGrid);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),labels);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent webPageIntent = new Intent(getApplicationContext(), DisplayActivity.class);
                webPageIntent.putExtra("WEB_PAGE", pages[ i ] );

                startActivity( webPageIntent );
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);

        MenuItem item = menu.findItem(R.id.action_share);
        share = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        if(share != null){
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "This is the subject");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "This is the body text");
            share.setShareIntent(shareIntent);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.favourites_page:
                Intent intent = new Intent(this,FavouritesActivity.class);
                startActivity(intent);
                return true;

         /*   case R.id.action_share:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "This is the subject");
                share.putExtra(Intent.EXTRA_TEXT, "This is the body text");
                startActivity(Intent.createChooser(share, "Share this text"));
                return true; */

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
