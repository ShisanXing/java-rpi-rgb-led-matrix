package com.matrix;

public class Canvas {

    /**
     * 初始化
     * 固定如下参数，得到一个64 x 32的屏幕
     * @param rows 32
     * @param cols 64
     * @param disableHardWarePluse true
     */
    public static native void init(int rows, int cols, boolean disableHardWarePluse);

    /**
     * 设置像素点
     * @param x
     * @param y
     * @param r
     * @param g
     * @param b
     */
    public static native void setPixel(int x, int y, int r, int g, int b);

    /**
     * 交换
     * rgbmatrix库开辟了两块像素点内存区，
     * 将setPixel后调用swap异步将一块写入到屏幕，并得到另一个，以提高效率
     */
    public static native void swap();

    /**
     * 清空屏幕
     */
    public static native void clear();

    /**
     * 退出时销毁
     */
    public static native void destroy();

}
