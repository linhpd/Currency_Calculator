package vn.edu.gmaillayout;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    public  List<ContactModel> contacts;

    public ContactAdapter(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item1, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.imageAvatar = view.findViewById(R.id.img_avatar);
            viewHolder.name = view.findViewById((R.id.text_name));
            viewHolder.isFavourite = view.findViewById(R.id.favourite);
            viewHolder.content = view.findViewById((R.id.text_content));
            view.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) view.getTag();

        final ContactModel contact = contacts.get(i);
        viewHolder.imageAvatar.setText(contact.getName().substring(0,1));
        viewHolder.name.setText(contact.getName());
        viewHolder.content.setText(contact.getContent());
        viewHolder.imageAvatar.getBackground().setColorFilter(Color.parseColor(contact.getColor()), PorterDuff.Mode.DARKEN);
        if(!contact.isChecked)
            viewHolder.isFavourite.setImageResource(R.drawable.ic_star);
        else
            viewHolder.isFavourite.setImageResource(R.drawable.ic_star_favorite);

        viewHolder.isFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = contact.isChecked;
                contact.setChecked(!isChecked);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    class ViewHolder {
        TextView imageAvatar;
        TextView name;
        ImageView isFavourite;
        TextView content;
    }
}
