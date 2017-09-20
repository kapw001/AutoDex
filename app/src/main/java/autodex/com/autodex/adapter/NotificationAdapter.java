package autodex.com.autodex.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import autodex.com.autodex.R;
import autodex.com.autodex.model.NotificationModel;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by yasar on 14/9/17.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private List<NotificationModel> list;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, birthdayname, genre;
        public RelativeLayout circlelayout;
        public AppCompatImageView notificationimg;
        public LinearLayout firstnotification, secondnotification;
        public CircleImageView circleImageView;


        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            birthdayname = (TextView) view.findViewById(R.id.birthdayname);
            circlelayout = (RelativeLayout) view.findViewById(R.id.circlelayout);
            notificationimg = (AppCompatImageView) view.findViewById(R.id.notificationimg);
            secondnotification = (LinearLayout) view.findViewById(R.id.secondnotification);
            firstnotification = (LinearLayout) view.findViewById(R.id.firstnotification);
            circleImageView = (CircleImageView) view.findViewById(R.id.circleImageView);

        }
    }


    public NotificationAdapter(Context context, List<NotificationModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_notification, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NotificationModel n = list.get(position);
        holder.name.setText(n.getName());
        holder.birthdayname.setText(n.getName());
        holder.circleImageView.setImageResource(n.getImgId());
        GradientDrawable bgShape = (GradientDrawable) holder.circlelayout.getBackground();

        if (n.getnType().equalsIgnoreCase("First")) {
            holder.notificationimg.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_favoritesborder));
            holder.notificationimg.setColorFilter(ContextCompat.getColor(context, R.color.white));

            bgShape.setColor(Color.parseColor("#F56A60"));
            holder.firstnotification.setVisibility(View.VISIBLE);
            holder.secondnotification.setVisibility(View.GONE);
        } else {
            holder.notificationimg.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_message));
            holder.notificationimg.setColorFilter(ContextCompat.getColor(context, R.color.white));
            bgShape.setColor(Color.parseColor("#59AE43"));
            holder.firstnotification.setVisibility(View.GONE);
            holder.secondnotification.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
//        return list.size();
        return (list == null) ? 0 : list.size();
    }
}
