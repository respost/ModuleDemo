package net.zy13.module.modulec.fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

import net.zy13.module.modulec.R;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * 添加Fragment碎片路由
 */
@Route(path = "/demo/ModuleFragment")
public class ModuleCFragment extends Fragment {


    public ModuleCFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_c, container, false);
    }

}
