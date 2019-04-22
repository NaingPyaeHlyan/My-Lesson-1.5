package mm.com.fairway.mylesson15;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private String[ ] imageLabels;
    private Context context;
    private LayoutInflater thisInflater;

    private Integer[ ] petImages = {
            R.drawable.cat,
            R.drawable.dog,
            R.drawable.fish,
            R.drawable.horse,
            R.drawable.rabbit,
            R.drawable.parrot,
            R.drawable.pigeon,
            R.drawable.duck
    };

    public CustomAdapter(Context con, String[ ] labs){
        this.context = con;
        this.thisInflater = LayoutInflater.from(con);
        this.imageLabels = labs;
    }

    @Override
    public int getCount() {
        return petImages.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = thisInflater.inflate( R.layout.grid_item, viewGroup, false );
            TextView textView = (TextView)view.findViewById(R.id.petHeading);
            ImageView imageView = (ImageView)view.findViewById(R.id.petImage);

            textView.setText(imageLabels[i]);
            imageView.setImageResource(petImages[i]);
        }
        return view;
    }
}
