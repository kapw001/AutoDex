package autodex.com.autodex.fragments;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import autodex.com.autodex.R;
import autodex.com.autodex.adapter.AutoFitGridLayoutManager;
import autodex.com.autodex.adapter.GridRecyclerViewAdapter;
import autodex.com.autodex.model.Contact;

/**
 * Created by yasar on 11/9/17.
 */

public class FavouritesFragment extends BaseFragment implements GridRecyclerViewAdapter.ItemListener {

    private RecyclerView recyclerView;
    private GridRecyclerViewAdapter gridRecyclerViewAdapter;
    private List<Contact> list=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_favourites, container, false);

        list = new ArrayList<>();
        list.add(new Contact("Thirumal", R.drawable.sundarpichai, "+91 9883238181"));
        list.add(new Contact("Karthik", R.drawable.trump, "+91 9883212312"));
        list.add(new Contact("Sathish", R.drawable.cute, "+91 98832365765"));
        list.add(new Contact("Yasar", R.drawable.testimg, "+91 98832384532"));
        list.add(new Contact("Siva", R.drawable.testimg, "+91 9883238181"));
        list.add(new Contact("Senthil", R.drawable.testimg, "+91 9883232381"));
        list.add(new Contact("Thirumal", R.drawable.sundarpichai, "+91 9883238181"));
        list.add(new Contact("Karthik", R.drawable.trump, "+91 9883212312"));
        list.add(new Contact("Sathish", R.drawable.cute, "+91 98832365765"));
        list.add(new Contact("Yasar", R.drawable.testimg, "+91 98832384532"));
        list.add(new Contact("Siva", R.drawable.testimg, "+91 9883238181"));
        list.add(new Contact("Senthil", R.drawable.testimg, "+91 9883232381"));
        list.add(new Contact("Thirumal", R.drawable.sundarpichai, "+91 9883238181"));
        list.add(new Contact("Karthik", R.drawable.trump, "+91 9883212312"));
        list.add(new Contact("Sathish", R.drawable.cute, "+91 98832365765"));
        list.add(new Contact("Yasar", R.drawable.testimg, "+91 98832384532"));
        list.add(new Contact("Siva", R.drawable.testimg, "+91 9883238181"));
        list.add(new Contact("Senthil", R.drawable.testimg, "+91 9883232381"));

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        gridRecyclerViewAdapter = new GridRecyclerViewAdapter(getActivity(), list, this);
        recyclerView.setAdapter(gridRecyclerViewAdapter);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getContext(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);

//        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(getActivity(), 500);
//        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


    public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

        private int mItemOffset;

        public ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }

    @Override
    public void onItemClick(Contact item) {
        Toast.makeText(getActivity(), item.getmName() + " is clicked", Toast.LENGTH_SHORT).show();
    }
}
