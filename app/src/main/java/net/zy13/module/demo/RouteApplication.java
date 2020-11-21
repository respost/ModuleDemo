package net.zy13.module.demo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author 安阳 QQ：15577969
 * @version 1.0
 * @team 美奇软件开发工作室
 * @date 2020/11/14 14:56
 */
public class RouteApplication extends Application {
    //ARouter调用开关
    private boolean isDebugARouter=true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
