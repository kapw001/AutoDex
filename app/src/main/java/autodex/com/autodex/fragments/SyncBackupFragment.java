package autodex.com.autodex.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import autodex.com.autodex.R;

/**
 * Created by yasar on 11/9/17.
 */

public class SyncBackupFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_syncbackup, container, false);


        return view;
    }


}
