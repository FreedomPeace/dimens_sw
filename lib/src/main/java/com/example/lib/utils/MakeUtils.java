package com.example.lib.utils;


import com.example.lib.constants.DimenTypes;
import com.example.lib.constants.PxTypes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;




public class MakeUtils {

    private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n";
    private static final String XML_RESOURCE_START = "<resources>\r\n";
    private static final String XML_RESOURCE_END = "</resources>\r\n";
    private static final String XML_DIMEN_TEMPLETE = "<dimen name=\"vl_%1$sdp_%2$d\">%3$.2fdp</dimen>\r\n";

   
    private static final String XML_BASE_DPI = "<dimen name=\"base_dpi\">%fdp</dimen>\r\n";

    private static final String XML_BASE_PX = "<dimen name=\"base_px\">%fpx</dimen>\r\n";
    private static final String XML_PX_TEMPLETE = "<dimen name=\"vl_%1$spx_%2$d\">%3$.2fpx</dimen>\r\n";

    private  static final int MAX_SIZE = 720;
    private  static final int MAX_PX_SIZE = 1920;

    /**
     * 生成的文件名
     */
    private static final String XML_NAME = "dimens.xml";


    public static float px2dip(float pxValue, float sw,float designWidth) {
        float dpValue =   (pxValue/ designWidth) * sw;
        BigDecimal bigDecimal = new BigDecimal(dpValue);
        float finDp = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return finDp;
    }
    

    /**
     * 生成所有的尺寸数据(dp)
     *
     * @param type
     * @return
     */
    private static String makeAllDimens(DimenTypes type, float designWidth) {
        float dpValue;
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(XML_HEADER);
            sb.append(XML_RESOURCE_START);
            //备份生成的相关信息
            temp = String.format(XML_BASE_DPI, type.getSwWidthDp());
            sb.append(temp);
            for (int i = 0; i <= MAX_SIZE; i++) {
            	
                dpValue = px2dip((float) i,type.getSwWidthDp(),designWidth);
                temp = String.format(XML_DIMEN_TEMPLETE,"", i, dpValue);
                sb.append(temp);
            }


            sb.append(XML_RESOURCE_END);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    /**
     * 生成所有的尺寸数据(px)
     *
     * @param type
     * @return
     */
    private static String makeAllPxContent(PxTypes type, float designWidth) {
        float dpValue;
        String temp;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(XML_HEADER);
            sb.append(XML_RESOURCE_START);
            //备份生成的相关信息
            temp = String.format(XML_BASE_PX, type.getSwWidthPx());
            sb.append(temp);
            for (int i = 0; i <= MAX_PX_SIZE; i+=2) {

                dpValue = px2dip((float) i,type.getSwWidthPx(),designWidth);
                temp = String.format(XML_PX_TEMPLETE,"", i, dpValue);
                sb.append(temp);
            }


            sb.append(XML_RESOURCE_END);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }



    /**
     * 生成的目标文件夹
     * 只需传宽进来就行
     *
     * @param type 枚举类型
     * @param buildDir 生成的目标文件夹
     */
    public static void makeAll(int designWidth, DimenTypes type, String buildDir) {
        try {
            //生成规则
            final String folderName;
            float swWidthDp = type.getSwWidthDp();
            if (swWidthDp > 0) {
                //适配Android 3.2+
                folderName = "values-sw" + (int) swWidthDp + "dp";
            }else {
            	return;
            }
            
            //生成目标目录
            File file = new File(buildDir + File.separator + folderName);
            if (!file.exists()) {
                file.mkdirs();
            }

            //生成values文件
            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + File.separator + XML_NAME);
            fos.write(makeAllDimens(type,designWidth).getBytes());
            fos.flush();
            fos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 生成的目标文件夹
     * 只需传宽进来就行
     *
     * @param type 枚举类型
     * @param buildDir 生成的目标文件夹
     */
    public static void makeAllPxFile(int designWidth, PxTypes type, String buildDir) {
        try {
            //生成规则
            final String folderName;
            float swWidthPx = type.getSwWidthPx();
            int swHeightPx = (int) type.getSwHeightPx();
            if (swWidthPx > 1800) {
                //适配Android 3.2+
                folderName = "values-xhdpi-" + (int) swWidthPx + "x"+swHeightPx;
            } else if (swWidthPx >= 1024) {
                folderName = "values-xhdpi-" + (int) swWidthPx + "x"+swHeightPx;
            } else {
                return;
            }

            //生成目标目录
            File file = new File(buildDir + File.separator + folderName);
            if (!file.exists()) {
                file.mkdirs();
            }

            //生成values文件
            FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + File.separator + XML_NAME);
            fos.write(makeAllPxContent(type,designWidth).getBytes());
            fos.flush();
            fos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
