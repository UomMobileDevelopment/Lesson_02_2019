package android.uom.gr.lesson01_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final List<String> images = new ArrayList<>();
    private static Random randomGen = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = this.findViewById(R.id.button);
        final ImageView imageView = this.findViewById(R.id.imageView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso picasso = Picasso.get();
                picasso.setLoggingEnabled(true);
                picasso.load(getRandomImage()).into(imageView);
                Toast.makeText(MainActivity.this, "Loading image...", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }


    private String getRandomImage(){
        images.add("http://i.imgur.com/DvpvklR.png");
        images.add("https://via.placeholder.com/468x900?text=Android+Mobile+Developement");
        images.add("https://images.fineartamerica.com/images-medium-large-5/bahamas-scene-vertical-bob-sample.jpg");
        images.add("https://media.gettyimages.com/vectors/vertical-design-layout-template-polygonal-orange-and-yellow-sample-vector-id501195367");

       return images.get(randomGen.nextInt(images.size()));
    }
}
