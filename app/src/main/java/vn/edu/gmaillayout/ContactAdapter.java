package vn.edu.gmaillayout;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ContactModel> items;

    public ContactAdapter(List<ContactModel> items) {
        this.items = items;
    }
    public void CopyAdapter(List<ContactModel> items){
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item1, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ContactModel item = items.get(position);
        MyViewHolder viewHolder = (MyViewHolder) holder;

        viewHolder.textName.setText(item.getName());
        viewHolder.textAvatar.setText(item.getName().substring(0,1));
        Drawable background = viewHolder.textAvatar.getBackground();
        background.setColorFilter(new PorterDuffColorFilter(item.getColor(),PorterDuff.Mode.SRC_ATOP));
        viewHolder.textContent.setText(item.getContent());
        viewHolder.textTime.setText(item.getTime());
        if(item.isFavorite){
            viewHolder.isFavourite.setImageResource(R.drawable.ic_star_favorite);
        }else viewHolder.isFavourite.setImageResource(R.drawable.ic_star);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textAvatar;
        TextView textName;
        ImageView isFavourite;
        TextView textContent;
        TextView textTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textAvatar = itemView.findViewById(R.id.text_avatar);
            this.textContent = itemView.findViewById(R.id.text_content);
            this.textName = itemView.findViewById(R.id.text_name);
            this.isFavourite = itemView.findViewById(R.id.favourite);
            this.textTime = itemView.findViewById(R.id.text_time);

            this.isFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isFavorite = items.get(getAdapterPosition()).isFavorite;
                    items.get(getAdapterPosition()).setFavorite(!isFavorite);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
