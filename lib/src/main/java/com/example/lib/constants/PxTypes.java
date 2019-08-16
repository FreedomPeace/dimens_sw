package com.example.lib.constants;


/**
 * 这个是根据设计的宽度，是px的设计稿
 */
public enum PxTypes {

    //

	 Px_sw__1920(1920,1136),
     Px_sw__1024(1024,768);

	// 想生成多少自己以此类推


    /**
     * 屏幕宽度
     */
    private float swWidthPx;
    private float swHeightPx;

    public float getSwHeightPx() {
        return swHeightPx;
    }

    public void setSwHeightPx(float swHeightPx) {
        this.swHeightPx = swHeightPx;
    }

    PxTypes(float swWidthPx, float swHeightPx) {

        this.swWidthPx = swWidthPx;
        this.swHeightPx = swHeightPx;
    }

    public float getSwWidthPx() {
        return swWidthPx;
    }

    public void setSwWidthPx(float swWidthPx) {
        this.swWidthPx = swWidthPx;
    }

}
