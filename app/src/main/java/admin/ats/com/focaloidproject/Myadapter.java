package admin.ats.com.focaloidproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 4/3/2017.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.RecyclerVH> {
    Context c;
    private Collections[] coll;

    public Myadapter(Context c, Collections[] coll) {
        this.c = c;
        this.coll = coll;
    }



    @Override
    public RecyclerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new RecyclerVH(v);
    }

    @Override
    public void onBindViewHolder(RecyclerVH holder, int position) {
        holder.name.setText(coll[position].getName());
        holder.price.setText(coll[position].getPrice());
        holder.iv.setImageResource(coll[position].getImageurl());

    }

    @Override
    public int getItemCount() {
        return coll.length;
    }

    public class RecyclerVH extends RecyclerView.ViewHolder
    {
        TextView name,price;
        ImageView iv;
        public RecyclerVH(View itemView){
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            price=(TextView)itemView.findViewById(R.id.price);
            iv=(ImageView)itemView.findViewById(R.id.photo);
        }
    }
}
