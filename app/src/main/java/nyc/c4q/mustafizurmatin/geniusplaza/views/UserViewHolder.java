package nyc.c4q.mustafizurmatin.geniusplaza.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.mustafizurmatin.geniusplaza.R;
import nyc.c4q.mustafizurmatin.geniusplaza.model.Users;

/**
 * Created by Mustafizur Matin on 7/16/19.
 */

public class UserViewHolder  extends RecyclerView.ViewHolder {
    TextView userName;
    ImageView userAvatar;

    public UserViewHolder(View itemView) {
        super(itemView);
        userAvatar = itemView.findViewById(R.id.user_picture);
        userName = itemView.findViewById(R.id.first_name);
    }
    public void onBind(Users results) {
        userName.setText(results.getFirst_name() + " " +  results.getLast_name());
        Picasso.with(itemView.getContext()).load(results.getAvatar())
                .into(userAvatar);

    }
}
