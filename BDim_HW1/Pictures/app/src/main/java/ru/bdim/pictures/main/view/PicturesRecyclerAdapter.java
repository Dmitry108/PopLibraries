package ru.bdim.pictures.main.view;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.squareup.picasso.Picasso;

import ru.bdim.pictures.R;
import ru.bdim.pictures.main.view.PicturesRecyclerAdapter.PictureViewHolder;

public class PicturesRecyclerAdapter extends RecyclerView.Adapter<PictureViewHolder> {

    private int pictures;
    private int count;
    private OnItemClickListener listener;

    public PicturesRecyclerAdapter(Resources res, int pictures){
        this.pictures = pictures;
        count = res.getIntArray(pictures).length;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_pictures, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        ImageView image = holder.itemView.findViewById(R.id.img_recycler_image);
        TypedArray imageArray = holder.itemView.getResources().obtainTypedArray(pictures);
        int id = imageArray.getResourceId(position, -1);
        Picasso.with(holder.itemView.getContext())
                .load(id)
                .into(image);
        count++;
        imageArray.recycle();
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    class PictureViewHolder extends ViewHolder{

        public PictureViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                    return false;
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}