# java-rpi-rgb-led-matrix
Controlling up to three chains of 64x64, 32x32, 16x32 or similar RGB LED displays using Raspberry Pi GPIO by java

### 原项目来自 https://github.com/hzeller/rpi-rgb-led-matrix

貌似每找到java操作彩色LED屏幕的，我也在原项目的issue上问过作者可不可以出一个"java binding"，有go bindng, c#binding，甚至还有node binding，就是没有java binding，看样子java不受作者待见。

### java binding

本人java出身，对c++不甚了解，所以照猫画虎跟着c#binding写了一个java binding简易版。过去了很长时间我也用了很久，回过头来发现源码找不到了，所以只能上传三个文件。有兴趣的可以自己将它们打包到jar里实现引入即可使用。

## 说明
1、拷贝Canvas.java类到自己的项目;
2、将两个so文件放到项目根目录或自己喜欢的目录
3、加入如下代码：

```java
static {
    System.load(new File("lib/librgbmatrix.so.1").getAbsolutePath()); //目录自己看着办
    System.load(new File("lib/libuntitled.so").getAbsolutePath()); //目录自己看着办
    Canvas.init(32, 64, true);
}
```

4、使用示范

```java

//这是示范代码，如果在static中引入了则不需要这里再写一遍。
System.load(new File("lib/librgbmatrix.so.1").getAbsolutePath());
System.load(new File("lib/libuntitled.so").getAbsolutePath());
Canvas.init(32, 64, true);

Canvas.clear();
for (int i = 0; i < points.length; i++) { //points为提前准备好的所有点
    int color = points[i];
    if (color == 0) {
        continue;
    }
    Canvas.setPixel(i % 64, i / 64, getR(points[i]), getG(points[i]), getB(points[i])); //设置坐标填充RGB颜色，换成自己的坐标和颜色即可
}
Canvas.swap();
Thread.sleep(5000)
Canvas.destroy();
```
