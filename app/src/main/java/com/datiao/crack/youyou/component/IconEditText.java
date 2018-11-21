package com.datiao.crack.youyou.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;


public class IconEditText extends android.support.v7.widget.AppCompatEditText {
    //声明命名空间的值
    private final String namespace="http://widgets.demo.com";
    //保存图片资源ID的变量
    private int resourceId=0;
    //声明图片对象变量
    private Bitmap bitmap;
    //编写控制构造方法
    public IconEditText(Context context, AttributeSet attrs){
        //由于该空间类是从TextView继承，其构造过程应先构建父类，然后才是本身
        super(context,attrs);
        //使用AttributeResourceValue获得布局文件中控件属性的值
        //该方法有3个参数：
        //第一个参数表示命名空间
        //第二个参数表示属性名
        //第三个参数表示默认值，若在布局文件中不能得到该属性的值则返回该值
        resourceId=attrs.getAttributeResourceValue(namespace, "iconSrc",0);
        if(resourceId>0){
            //若成功获得图像资源ID则装载图像并实例化Bitmap对象
            bitmap=BitmapFactory.decodeResource(getResources(), resourceId);
        }
    }
    //重载onDraw方法
    @Override
    protected void onDraw(Canvas canvas) {
        // 保证要绘制的内容存在
        if(bitmap!=null){
            //从原图截取图像区域，本例使用的全图
            Rect src=new Rect();//放宽区域
            //将图像区域复制到目标区域
            Rect target=new Rect();
            //定义从原图中截取的区域的边界
            src.left=0;
            src.top=0;
            src.right=bitmap.getWidth();
            src.bottom=bitmap.getHeight();
            //获取文本大小
            int textHeight=(int)getTextSize();
            //指定截取的图像绘制到目标区域
            target.left=0;
            target.top=(getMeasuredHeight()-textHeight)/2;
            target.bottom=target.top+textHeight;
            //为了截取的图像不变形，图像大小要重新计算
            target.right=(int)(textHeight*20/(float)20);
            //绘制截图
            canvas.drawBitmap(bitmap,src,target,getPaint());
            //让文本与截图有点间距
            canvas.translate(target.right+2, 0);
        }
        super.onDraw(canvas);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}