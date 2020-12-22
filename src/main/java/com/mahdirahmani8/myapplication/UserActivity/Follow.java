package com.mahdirahmani8.myapplication.UserActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.R;

public class Follow extends AppCompatActivity {

    private TextView textView;
    private ImageView instagram,linkedin ,telegram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);

        cast();
        Lan();



        // Telegram on Click
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/B00kApp/"));
                    startActivity(github_intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Follow.this, "You should install Browser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        //  Linkedin on Click
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mahdi-rahmani-180218202/"));
                    startActivity(github_intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Follow.this, "You should install Browser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        // Instagram on Click
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/b00kapp/"));
                    startActivity(github_intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Follow.this, "You should install Browser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }

    private void cast() {
        textView = (TextView) findViewById(R.id.TV_about);
        instagram = (ImageView) findViewById(R.id.instagram_img);
        linkedin = (ImageView) findViewById(R.id.linkedin_img);
        telegram = (ImageView) findViewById(R.id.telegram_img);

    }

    private void Lan() {
        DataBase db = new DataBase(this);
        String str = db.lanValue();

        textView.setTextSize(18);

        if ( str != null  && str.hashCode() == 3259) {   // fa

            textView.setText(FA_lan());

        } else if (str != null  && str.hashCode() == 3246) {   //sp

            textView.setText(SP_lan());

        } else if (str != null  && str.hashCode() == 3307) {   // gr

            textView.setText(GR_lan());

        } else if (str != null  && str.hashCode() == 3121) {    // ar

            textView.setText(AR_lan());

        } else {    //en

            textView.setText(EN_lan());
        }

    }

    // fa
    private String FA_lan() {

        String str = "دوستان ،\n" +
                "اگر می خواهید از جدید ترین اخبار برنامه و امکانات جدید مطلع شوید و در باره آن بحث و گفتگو کنید میتوانید ما را در رسانه های اجتماعی\n" +
                "دنبال کنید.\n" +
                "از همکاری و لطف شما سپاس گذاریم.\n" +
                "ما همیشه از ایده های جالب و نقد های سازنده استقبال میکنیم . شما میتوانید از روش های زیر با ما در ارتباط باشید.";
        return str;
    }

    // sp
    private String SP_lan() {

        String str = "Amigos ,\n" +
                "Si quieres estar informado sobre las últimas novedades y novedades del programa y comentarlo, puedes seguirnos en las redes sociales.\n" +
                "seguir.\n" +
                "Gracias por su cooperación y amabilidad.\n" +
                "Siempre damos la bienvenida a ideas interesantes y comentarios constructivos. Puede contactarnos de las siguientes formas.";
        return str;
    }

    // gr
    private String GR_lan() {

        String str ="Freunde,\n" +
                "Wenn Sie über die neuesten Programmnachrichten und neuen Funktionen informiert und diskutiert werden möchten, können Sie uns in den sozialen Medien folgen.\n" +
                "Folgen.\n" +
                "Vielen Dank für Ihre Mitarbeit und Freundlichkeit.\n" +
                "Wir freuen uns immer über interessante Ideen und konstruktive Bewertungen. Sie können uns auf folgende Weise kontaktieren.";
        return str;
    }

    // ar
    private String AR_lan() {

        String str ="اصحاب ،\n" +
                "إذا كنت تريد أن تكون على علم بآخر أخبار البرنامج ومميزاته الجديدة ومناقشتها ، يمكنك متابعتنا على وسائل التواصل الاجتماعي.\n" +
                "إتبع.\n" +
                "شكرا لتعاونك ولطفك.\n" +
                "نرحب دائمًا بالأفكار الشيقة والمراجعات البناءة. يمكنك الاتصال بنا بالطرق التالية.";
        return str;
    }

    // en
    private String EN_lan() {

        String str ="Friends ,\n" +
                "If you want to be informed about the latest program news and new features and discuss it, you can follow us on social media.\n" +
                "follow.\n" +
                "Thank you for your cooperation and kindness.\n" +
                "We always welcome interesting ideas and constructive reviews. You can contact us in the following ways.";
        return str;
    }




}