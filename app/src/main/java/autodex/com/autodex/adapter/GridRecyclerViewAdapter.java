package autodex.com.autodex.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import autodex.com.autodex.R;
import autodex.com.autodex.model.Contact;

/**
 * Created by yasar on 13/9/17.
 */

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.ViewHolder> {

    List<Contact> list;
    Context mContext;
    protected ItemListener mListener;

    public GridRecyclerViewAdapter(Context context, List<Contact> list, ItemListener itemListener) {

        this.list = list;
        mContext = context;
        mListener = itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView, number;
        public ImageView imageView, favorite;
        public RelativeLayout relativeLayout;
        Contact item;

        public ViewHolder(View v) {

            super(v);

//            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.textView);
            number = (TextView) v.findViewById(R.id.number);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            favorite = (ImageView) v.findViewById(R.id.favorite);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);


        }

        public void setData(final Contact item) {
            this.item = item;

            textView.setText(item.getName());
//            imageView.setImageResource(item.getImgId());
            Picasso.with(mContext).load(item.getImgId()).fit().into(imageView);
            number.setText(item.getNumber());

            if (item.is_favourite()) {
                favorite.setColorFilter(ContextCompat.getColor(mContext, R.color.red));
            } else {
                favorite.setColorFilter(ContextCompat.getColor(mContext, R.color.white));
            }

            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Ok", Toast.LENGTH_SHORT).show();
                    if (item.is_favourite()) {
                        item.setIs_favourite(false);
//                        favorite.setColorFilter(ContextCompat.getColor(view.getContext(), R.color.red));
                    } else {
                        item.setIs_favourite(true);
//                        favorite.setColorFilter(ContextCompat.getColor(view.getContext(), R.color.colorPrimary));
                    }

                    notifyItemChanged(getPosition());

                }
            });

//            relativeLayout.setBackgroundColor(Color.parseColor(item.color));

        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public GridRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.row_favourites, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = list.get(position);
        holder.setData(contact);
    }


    @Override
    public int getItemCount() {

        return list.size();
    }

    public interface ItemListener {
        void onItemClick(Contact item);
    }
}