package nyc.c4q.mustafizurmatin.geniusplaza.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nyc.c4q.mustafizurmatin.geniusplaza.R;
import nyc.c4q.mustafizurmatin.geniusplaza.model.Users;
import nyc.c4q.mustafizurmatin.geniusplaza.views.UserViewHolder;

/**
 * Created by Mustafizur Matin on 7/16/19.
 */

public class UserAdpater extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<Users> dataList;

    public UserAdpater(ArrayList<Users> dataList) {
        this.dataList = dataList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.onBind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
