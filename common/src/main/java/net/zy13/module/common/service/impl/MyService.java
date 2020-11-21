package net.zy13.module.common.service.impl;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import net.zy13.module.common.service.IService;

/**
 * @author 安阳 QQ：15577969
 * @version 1.0
 * @team 美奇软件开发工作室
 * @date 2020/11/21 14:14
 */
@Route(path = "/service/demo", name = "测试服务")
public class MyService implements IService {
    @Override
    public void demo(Context context) {
        Toast.makeText(  context , "这是一个对外暴露的接口服务！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {

    }
}
