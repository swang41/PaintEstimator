package edu.orange.cs273.swang41.paintestimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
    TextView mEstimatePaintTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        mEstimatePaintTextView = (TextView) findViewById(R.id.estimatedPaintTextView);
        Intent helperIntent = getIntent();
        Bundle extra = helperIntent.getExtras();

        if(extra != null) {
            String output = "Estimated Paint Required: " + extra.getString("gallons") +
                    " gallons";
            mEstimatePaintTextView.setText(output);
        }
    }

    public void goBack(View v) {
        this.finish();
    }
}
