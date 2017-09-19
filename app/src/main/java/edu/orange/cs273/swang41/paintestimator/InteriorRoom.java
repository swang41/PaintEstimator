package edu.orange.cs273.swang41.paintestimator;

/**
 * Created by swang41 on 9/19/2017.
 */

public class InteriorRoom {
    public static final float DOOR_AREA = 21;
    public static final float WINDOW_AREA = 16;
    public static final float SQ_FEET_PER_GALLON = 275;

    private float mLength;
    private float mWidth;
    private float mHeight;

    private int mDoors;
    private int mWindows;

    public float getmLength() {
        return mLength;
    }

    public void setmLength(float mLength) {
        this.mLength = mLength;
    }

    public float getmWidth() {
        return mWidth;
    }

    public void setmWidth(float mWidth) {
        this.mWidth = mWidth;
    }

    public float getmHeight() {
        return mHeight;
    }

    public void setmHeight(float mHeight) {
        this.mHeight = mHeight;
    }

    public int getmDoors() {
        return mDoors;
    }

    public void setmDoors(int mDoors) {
        this.mDoors = mDoors;
    }

    public int getmWindows() {
        return mWindows;
    }

    public void setmWindows(int mWindows) {
        this.mWindows = mWindows;
    }

    public float doorAndWindowArea() {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    public float wallSurfaceArea() {
        return 2* mLength * mHeight + 2 * mWidth * mHeight + mLength * mWidth;
    }

    public float totalSurfaceArea() {
        return wallSurfaceArea() - doorAndWindowArea();
    }

    public float gallonOfPaintRequired() {
        return totalSurfaceArea() / SQ_FEET_PER_GALLON;
    }
}
