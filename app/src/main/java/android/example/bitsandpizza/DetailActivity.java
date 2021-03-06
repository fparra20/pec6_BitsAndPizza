package android.example.bitsandpizza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    //Declaramos las constantes para el paso de los putExtra.
    public static final String EXTRA_NAME = "Name";
    public static final String EXTRA_IMG = "Img";
    public static final String EXTRA_FIELD = "ExtraField";

    //Declaramos los elementos visuales que vamos a usar en el layout
    private TextView name;
    private ImageView img;
    private TextView ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Recuperamos el Bundle con los extras del Intent
        Bundle data = getIntent().getExtras();

        //Rellenamos el textView nombre
        name = findViewById(R.id.tvNameDetail);
        name.setText(data.getString("Name"));

        //Rellenamos el imageView img
        img = findViewById(R.id.ivDetail);
        img.setImageResource(data.getInt("Img"));

        //Rellenamos el textView extra
        ext = findViewById(R.id.tvExtraDetail);
        ext.setText(data.getString("ExtraField"));
    }
}