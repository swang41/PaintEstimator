package edu.orange.cs273.swang41.paintestimator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member variables for the Views
    private EditText mLengthEditText;
    private EditText mWidthEditText;
    private EditText mHeightEditText;

    private EditText mDoorsEditText;
    private EditText mWindowsEditText;

    private TextView mGallonTextView;

    // Member variable for the model
    private InteriorRoom mRoom = new InteriorRoom();

    // Member variable for SharedPreferences
    private SharedPreferences mPrefs;

    private void initializeViews() {
        mLengthEditText = (EditText) findViewById(R.id.lengthEditText);
        mWidthEditText = (EditText) findViewById(R.id.widthEditText);
        mHeightEditText = (EditText) findViewById(R.id.heightEditText);

        mDoorsEditText = (EditText) findViewById(R.id.doorEditText);

    }

    private void loadSharedPreferences() {
        mPrefs = getSharedPreferences("edu.orange.cs273.PaintEstimator", MODE_PRIVATE);
        if (mPrefs != null) {
            // Load all the room information.
            mRoom.setmLength(mPrefs.getFloat("length", 0.0f));
            mDoorsEditText.setText(String.valueOf(mRoom.getmDoors()));

            mRoom.setmHeight(mPrefs.getFloat("height", 0.0f));
        }
    }

    private void saveSharedPreferences(){
        SharedPreferences.Editor editor =mPrefs.edit();
        editor.clear();
        editor.putFloat("length", mRoom.getmLength());
        editor.putFloat("width", mRoom.getmWidth());
        editor.putFloat("heigth", mRoom.getmHeight());
        editor.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        loadSharedPreferences();
    }

    protected void computeGallons(View v) {
        // Update model first, then calculate
        mRoom.setmLength(Float.parseFloat(mLengthEditText.getText().toString()));
        mRoom.setmHeight(Float.parseFloat(mWidthEditText.getText().toString()));


        mGallonTextView.setText(String.valueOf(getString(R.string.interior_surface_text) + mRoom.totalSurfaceArea() +
                "\n" + getString(R.string.gallon_need_text) + mRoom.gallonOfPaintRequired()));
        saveSharedPreferences();
    }

    protected void gotoHelp(View v) {
        // Construct an Explicit Intent to go to HelpActivity
        // Intent: specify where to start context and where we're going next acitvity
        Intent helpIntent = new Intent(this, HelpActivity.class);
        helpIntent.putExtra("gallons", mRoom.gallonOfPaintRequired());
    }
}
