package com.ferdyrodriguez.toptenapps.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ferdyrodriguez.toptenapps.Models.Entry;
import com.ferdyrodriguez.toptenapps.R;
import com.ferdyrodriguez.toptenapps.Utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ferdyrod on 2/1/17.
 */

public class AppDataAdapter extends RecyclerView.Adapter<AppDataAdapter.ViewHolder> {

    private AppItemClickListener listener;

    public interface AppItemClickListener {

        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(AppItemClickListener listener) {
        this.listener = listener;
    }

    private final Context context;

    private final List<Entry> appData;

    public AppDataAdapter(Context context, List<Entry> appData, AppItemClickListener listener) {
        super();
        this.context = context;
        this.appData = appData;
        this.listener = listener;
    }

    @Override
    public AppDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        int length = appData.get(position).getImage().size();

        for (int i = 0; i < length; i++) {
            String height = appData.get(position).getImage().get(i).getImageAttributes().getHeight();

            if (height.equals("100")) {
                String imageUrl = appData.get(position).getImage().get(i).getLabel();
                Picasso.with(context)
                        .load(imageUrl)
                        .fit()
                        .into(holder.appImage);
            }
        }
        holder.appName.setText(appData.get(position).getName().getAppName());
        holder.appArtist.setText(appData.get(position).getArtist().getAppArtist());

        String price = appData.get(position).getPrice().getPriceAttribute().getAppPrice();

        String freeOrPrice = Utils.verifyPrice(price);
        holder.appPrice.setText(freeOrPrice);
    }

    @Override
    public int getItemCount() {
        return appData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView appImage;
        TextView appName;
        TextView appArtist;
        TextView appPrice;

        public ViewHolder(final View itemView) {
            super(itemView);
            appImage = (ImageView) itemView.findViewById(R.id.appImage);
            appName = (TextView) itemView.findViewById(R.id.appName);
            appArtist = (TextView) itemView.findViewById(R.id.appDeveloper);
            appPrice = (TextView) itemView.findViewById(R.id.appPrice);
        }
    }

    public void setEntriesList(List<Entry> entries) {
        this.appData.clear();
        if (entries == null) {
            return;
        }
        this.appData.addAll(entries);
        notifyDataSetChanged();
    }
}