package gooin.github.io.geoquiz;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowApiActivity extends AppCompatActivity {

    private Button showApiButton;
    private TextView showApiTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_api);
        final int apiLevel = Build.VERSION.SDK_INT;

        showApiButton=(Button) findViewById(R.id.show_api_button);
        showApiTextView = (TextView) findViewById(R.id.show_api_textview);
        showApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showApiTextView.setText("The API Level is : " + apiLevel);
            }
        });

    }
}
