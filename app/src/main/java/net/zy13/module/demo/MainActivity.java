package net.zy13.module.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import net.zy13.module.modulea.fragment.ModuleAFragment;
import net.zy13.module.moduleb.fragment.ModuleBFragment;
import net.zy13.module.modulec.fragment.ModuleCFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //定义碎片集合
    private Fragment[] fragments = new Fragment[3];
    //当前显示的fragment的索引位置
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    /**
     * 初始化Fragment碎片
     */
    private void initFragment() {
        if (fragments[0] == null) {
            fragments[0] = new ModuleAFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.content, fragments[0], "moduleA").commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(fragments[0]);
        }
    }

    /**
     * 导航选择事件
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_a:
                if (currentIndex == 0) return true;//如果已经是当前的fragment，不用切换
                FragmentTransaction transition0 = getSupportFragmentManager().beginTransaction();
                hideAndShow(0,transition0);
                return true;

            case R.id.navigation_b:
                if (currentIndex == 1) return true;//如果已经是当前的fragment，不用切换
                FragmentTransaction transition1 = getSupportFragmentManager().beginTransaction();
                if (fragments[1] == null) {
                    fragments[1] = new ModuleBFragment();
                    transition1.add(R.id.content, fragments[1], "moduleB");
                }
                hideAndShow(1,transition1);
                return true;

            case R.id.navigation_c:
                if (currentIndex == 2) return true;//如果已经是当前的fragment，不用切换
                FragmentTransaction transition2 = getSupportFragmentManager().beginTransaction();
                if (fragments[2] == null) {
                    fragments[2] = new ModuleCFragment();
                    transition2.add(R.id.content, fragments[2], "modulec");
                }
                hideAndShow(2,transition2);
                return true;
        }
        return false;
    }

    /**
     * 除了指定的fragment不hide，其他fragment全hide
     * @param expectIndex 指定的fragment在fragments中的位置
     * @param transition
     */
    private void hideAndShow(int expectIndex,FragmentTransaction transition) {
        for (int i = 0; i < fragments.length; i++) {
            if (i != expectIndex && fragments[i] != null) {
                transition.hide(fragments[i]);
            }
        }
        transition.show(fragments[expectIndex]);
        transition.commit();
        currentIndex = expectIndex;
    }
}
