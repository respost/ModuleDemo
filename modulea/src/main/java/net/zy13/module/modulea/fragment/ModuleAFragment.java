package net.zy13.module.modulea.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import net.zy13.module.modulea.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ModuleAFragment extends Fragment implements View.OnClickListener {

    private WebView contentWebView = null;
    private Button button;

    public ModuleAFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_module_a, container, false);
        //点击按钮
        button = (Button) rootView.findViewById(R.id.routeDemoButton);
        button.setOnClickListener(this);

        // 从assets目录加载html文件
        contentWebView = (WebView) rootView.findViewById(R.id.webview);
        contentWebView.loadUrl("file:///android_asset/demo.html");
        return rootView;
    }

    @Override
    public void onClick(View v) {
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
        ARouter.getInstance().build("/test/RouteActivity").navigation(getContext(), new NavCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.e("监听路由过程", "onArrival: 找到了路由");
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.e("监听路由过程", "onArrival: 找不到路由");
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.e("监听路由过程", "onArrival: 路由跳转完成");
                String group = postcard.getGroup();
                Log.e("监听路由过程", "当前路由分组是: " + group);
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.e("监听路由过程", "onArrival: 路由被拦截了");
            }
        });
        // 2. 跳转并携带参数
        /*
        ARouter.getInstance().build("/demo/RouteActivity")
                .withLong("id", 1)
                .withString("name", "张三")
                .withObject("obj", this)
                .navigation();
         */
    }
}
