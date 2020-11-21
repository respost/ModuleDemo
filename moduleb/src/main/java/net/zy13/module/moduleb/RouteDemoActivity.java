package net.zy13.module.moduleb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import net.zy13.module.common.service.IService;

/**
 * 在支持路由的页面上添加注解(必选)
 * 注意：这里的路径需至少需要有两级，/xx/xx
 */
@Route(path = "/test/RouteActivity")
public class RouteDemoActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;

    //为每一个参数声明一个字段，并使用@Autowired标注
    @Autowired
    String name;

    // 通过name来映射URL中的不同参数
    @Autowired(name = "age")
    int age;
    //
    @Autowired(name = "/service/demo")
    IService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //自动注入初始化，ARouter会自动对字段进行赋值，无需主动获取
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_route_demo);
        //按键
        button = (Button) findViewById(R.id.serviceDemoButton);
        //文本
        textView = (TextView) findViewById(R.id.urlTextView);

        textView.setText("URL参数是： " + "name: " + name + "  age: " + age);

        //监听点击事件（匿名类方式，或叫内部类方式）
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //调用接口服务的方法
                service.demo(getApplicationContext());
            }
        });
    }
}
