package net.zy13.module.common;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author 安阳 QQ：15577969
 * @version 1.0
 * @team 美奇软件开发工作室
 * @date 2020/11/12 11:55
 */
public class PageUtils {
    /**
     * 页面跳转
     * @param context
     * @param className
     */
    public static void jump(Context context, String className){
        try {
            Class c = Class.forName(className);
            Intent intent = new Intent(context,c);
            context.startActivity(intent);
        } catch (ClassNotFoundException e) {
            Log.e("组件","未集成，无法跳转");
        }
    }

    /**
     * 页面跳转，可以传参，参数放在intent中，所以需要传入一个intent
     * @param context
     * @param className
     * @param intent
     */
    public static void jump(Context context,String className,Intent intent){
        try {
            Class c = Class.forName(className);
            intent.setClass(context,c);
            context.startActivity(intent);
        } catch (ClassNotFoundException e) {
            Log.e("组件","未集成，无法跳转");
        }
    }
}
