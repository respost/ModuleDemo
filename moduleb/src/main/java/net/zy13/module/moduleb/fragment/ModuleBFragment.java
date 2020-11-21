package net.zy13.module.moduleb.fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.zy13.module.moduleb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModuleBFragment extends Fragment {


    public ModuleBFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_b, container, false);
    }

}
