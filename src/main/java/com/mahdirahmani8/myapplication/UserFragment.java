package com.mahdirahmani8.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.UserActivity.AbouUs;
import com.mahdirahmani8.myapplication.UserActivity.Community;
import com.mahdirahmani8.myapplication.UserActivity.Fav;
import com.mahdirahmani8.myapplication.UserActivity.Follow;
import com.mahdirahmani8.myapplication.UserActivity.Programmers;
import com.mahdirahmani8.myapplication.UserActivity.Setting_Activity;
import com.mahdirahmani8.myapplication.UserActivity.Star;
import com.mahdirahmani8.myapplication.UserActivity.Writer;

public class UserFragment extends Fragment implements View.OnClickListener  {

    View view;
    TextView name;
    TextView PRO, COMM, FAV, FOLLOW, WRITER, ABOUT, STAR, SETTING;
    ImageView pro, community, fav, writer, follow, about, star, donate, setting;

    public static final String LOGIN = "login";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.user_fragment, container, false);

        setUpViews();
        Lan();

        setting.setOnClickListener(this);
        pro.setOnClickListener(this);
        community.setOnClickListener(this);
        fav.setOnClickListener(this);
        writer.setOnClickListener(this);
        follow.setOnClickListener(this);
        about.setOnClickListener(this);
        star.setOnClickListener(this);

        return view;
    }

    private void setUpViews() {

        name = (TextView) view.findViewById(R.id.name_id);
        pro = (ImageView) view.findViewById(R.id.pro_id);
        community = (ImageView) view.findViewById(R.id.community_id);
        fav = (ImageView) view.findViewById(R.id.fav_id);
        writer = (ImageView) view.findViewById(R.id.writer);
        about = (ImageView) view.findViewById(R.id.about_us_id);
        follow = (ImageView) view.findViewById(R.id.follow_id);
        star = (ImageView) view.findViewById(R.id.star_id);
        setting = (ImageView) view.findViewById(R.id.Setting_ID);


        PRO = (TextView) view.findViewById(R.id.pro_txt_id);
        COMM = (TextView) view.findViewById(R.id.community_txt_id);
        FOLLOW = (TextView) view.findViewById(R.id.follow_txt_id);
        FAV = (TextView) view.findViewById(R.id.fav_txt_id);
        WRITER = (TextView) view.findViewById(R.id.writer_txt_id);
        ABOUT = (TextView) view.findViewById(R.id.about_txt_id);
        STAR = (TextView) view.findViewById(R.id.star_txt_id);
        SETTING = (TextView) view.findViewById(R.id.setting_txt_id);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(LOGIN, Context.MODE_PRIVATE);
        name.setText(sharedPreferences.getString("NAME", null));
    }
    //======================================

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {

        int View_id = v.getId();
        switch (View_id) {

            case R.id.pro_id:

                Intent pro = new Intent(getActivity(), Programmers.class);
                startActivity(pro);
                break;

            case R.id.community_id:

                Intent comm = new Intent(getActivity(), Community.class);
                startActivity(comm);
                break;

            case R.id.fav_id:

                Intent fav = new Intent(getActivity(), Fav.class);
                startActivity(fav);
                break;

            case R.id.about_us_id:

                Intent about = new Intent(getActivity(), AbouUs.class);
                startActivity(about);
                break;


            case R.id.follow_id:

                Intent follow = new Intent(getActivity(), Follow.class);
                startActivity(follow);
                break;

            case R.id.star_id:

                Intent star = new Intent(getActivity(), Star.class);
                startActivity(star);
                break;

            case R.id.writer:

                Intent writer = new Intent(getActivity(), Writer.class);
                startActivity(writer);
                break;

            case R.id.Setting_ID:

                Intent setting_part = new Intent(getActivity(), Setting_Activity.class);
                setting_part.putExtra("IF",true);
                startActivity(setting_part);
                getActivity().finish();

                break;
        }

    }

    private void Lan() {
        DataBase db = new DataBase(getContext());
        String str = db.lanValue();

        if (str != null && str.hashCode() == 3259) {   // fa

            PRO.setText("برنامه نویس");
            COMM.setText("انجمن");
            FAV.setText("مورد علاقه");
            FOLLOW.setText("ما را دنبال کنید");
            WRITER.setText("نویسنده شوید");
            ABOUT.setText("درباره ما");
            STAR.setText(" ستاره دهید");
            SETTING.setText("تنظیمات");

        } else if (str != null && str.hashCode() == 3246) {   //sp

            PRO.setText("programador");
            COMM.setText("comunidad");
            FAV.setText("favorito");
            FOLLOW.setText("Síguenos");
            WRITER.setText("Conviértete en escritor");
            WRITER.setTextSize(10);
            ABOUT.setText("sobre nosotros");
            STAR.setText("dar una estrella");
            SETTING.setText("ajuste");

        } else if (str != null && str.hashCode() == 3307) {   // gr

            PRO.setText("Programmierer");
            COMM.setText("Gemeinschaft");
            FAV.setText("Lieblings");
            FOLLOW.setText("Folge uns");
            WRITER.setText("Werde Schriftsteller");
            ABOUT.setText("Über uns");
            STAR.setText("gib einen Stern");
            SETTING.setText("Rahmen");

        } else if (str != null && str.hashCode() == 3121) {    // ar

            PRO.setText("مبرمج");
            COMM.setText("تواصل اجتماعي");
            FAV.setText("مفضل");
            FOLLOW.setText("تابعنا");
            WRITER.setText("كن كاتبًا");
            ABOUT.setText("معلومات عنا");
            STAR.setText("يعطي نجمة");
            SETTING.setText("ضبط");

        } else {    //en


        }
    }

}
