package com.lynavision.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();

    private Button funFactButton;
    private TextView funFactTextView;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        funFactButton = findViewById(R.id.funFactButton);
        funFactTextView = findViewById(R.id.funFactTextView);
        layout = findViewById(R.id.layout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = colorWheel.getColor();
                layout.setBackgroundColor(color);
                funFactTextView.setText(factBook.getFact());
                funFactButton.setTextColor(color);
            }
        };

        funFactButton.setOnClickListener(listener);
        Toast.makeText(this, "This is a toast message!", Toast.LENGTH_LONG).show();
        Log.d(TAG, "We're logging from the OnCreate() method!");
    }


}
