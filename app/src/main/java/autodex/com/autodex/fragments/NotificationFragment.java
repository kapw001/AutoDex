package autodex.com.autodex.fragments;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import autodex.com.autodex.R;
import autodex.com.autodex.adapter.GridRecyclerViewAdapter;
import autodex.com.autodex.adapter.NotificationAdapter;
import autodex.com.autodex.model.Contact;
import autodex.com.autodex.model.NotificationModel;

/**
 * Created by yasar on 11/9/17.
 */

public class NotificationFragment extends BaseFragment {

    private List<NotificationModel> list = new ArrayList<>();

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_notification, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        notificationAdapter = new NotificationAdapter(getActivity(), list);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(notificationAdapter);
        prepareNotificationData();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        menu.clear();
        inflater.inflate(R.menu.notificationonly, menu);
        Drawable drawable = menu.getItem(0).getIcon();
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        }

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notification:
//                Toast.makeText(getActivity(), "Noti", Toast.LENGTH_SHORT).show();
                break;


        }
        return true;

    }

    private void prepareNotificationData() {
        list.clear();
        NotificationModel n = new NotificationModel();
        n.setImgId(R.drawable.sundarpichai);
        n.setName("Sundar Pichai");
        n.setnDate("");
        n.setnType("First");
        list.add(n);

        n = new NotificationModel();
        n.setImgId(R.drawable.cute);
        n.setName("Cute");
        n.setnDate("");
        n.setnType("First");
        list.add(n);


        n = new NotificationModel();
        n.setImgId(R.drawable.trump);
        n.setName("It's Donald Trump's Birthday");
        n.setnDate("12-6-2017");
        n.setnType("Second");
        list.add(n);

        n = new NotificationModel();
        n.setImgId(R.drawable.testimg);
        n.setName("It's Bill Gates Birthday");
        n.setnDate("12-6-2017");
        n.setnType("Second");
        list.add(n);


        notificationAdapter.notifyDataSetChanged();
    }


}
