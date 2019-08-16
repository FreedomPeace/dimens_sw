package com.example.lib.generator;

import com.example.lib.constants.DimenTypes;
import com.example.lib.constants.PxTypes;
import com.example.lib.utils.MakeUtils;

import java.io.File;


public class PXGenerator {

    /**
     * 设计稿尺寸单位px(将自己设计师的设计稿的宽度填入)
     */
    private static final int DESIGN_WIDTH = 1920;


    public static void main(String[] args) {
        PxTypes[] values = PxTypes.values();
        for (PxTypes value : values) {
            float swWidthPx = value.getSwWidthPx();
            System.out.println(swWidthPx);
            File file = new File("E:\\Demo\\dimens_sw\\app\\src\\main\\res");
            MakeUtils.makeAllPxFile(DESIGN_WIDTH, value, file.getAbsolutePath());
        }

    }

}
