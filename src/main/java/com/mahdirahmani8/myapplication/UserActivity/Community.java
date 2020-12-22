package com.mahdirahmani8.myapplication.UserActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.R;

public class Community extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        cast();
        Lan();
        video();


        //  Telegram link
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/B00kApp/"));
                    startActivity(github_intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Community.this, "You should install Browser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }


    private void cast() {
        textView = (TextView) findViewById(R.id.TV_about);
        imageView = (ImageView) findViewById(R.id.telegram_img);
    }


    private void video() {
        MediaController mediaController = new MediaController(this);


    }

    private void Lan() {
        DataBase db = new DataBase(this);
        String str = db.lanValue();

        textView.setTextSize(18);

        if (str != null && str.hashCode() == 3259) {   // fa

            textView.setText(FA_lan());

        } else if (str != null && str.hashCode() == 3246) {   //sp

            textView.setText(SP_lan());

        } else if (str != null && str.hashCode() == 3307) {   // gr

            textView.setText(GR_lan());

        } else if (str != null && str.hashCode() == 3121) {    // ar

            textView.setText(AR_lan());

        } else {    //en

            textView.setText(EN_lan());
        }

    }

    // fa
    private String FA_lan() {

        String str = "فکر کردم ایده جالبی است که مردم بتوانند با هم حرف بزنند و نظر بدهند و از داستان هایی که مینویسند و در برنامه قرار میدهند بازخورد بگیرند .\n" +
                "یا جایی برای گفتن تشکر به آنها و پیدا کردن دوست های جدید . چون انسان ها ذاتا ارتباط برقرار کردن و نقد کردن را دوست داند ...\n" +
                " ملحق شدن به انجمن ما در تلگرام :  ";
        return str;
    }

    // sp
    private String SP_lan() {

        String str = "Pensé que era una idea interesante que las personas pudieran hablar y comentar y recibir retroalimentación de las historias que escriben y programan.\n" +
                "O un lugar para agradecerles y hacer nuevos amigos. Porque a los humanos les gusta intrínsecamente comunicarse y criticar ...\n" +
                "  Únete a nuestra comunidad de Telegram:";
        return str;
    }

    // gr
    private String GR_lan() {

        String str = "Ich fand es eine interessante Idee für die Leute, sprechen und kommentieren zu können und Feedback zu den Geschichten zu erhalten, die sie schreiben und in das Programm aufnehmen.\n" +
                "Oder ein Ort, um sich bei ihnen zu bedanken und neue Freunde zu finden. Weil Menschen von Natur aus gerne kommunizieren und kritisieren ...\n" +
                "  Treten Sie unserer Telegramm-Community bei:";
        return str;
    }

    // ar
    private String AR_lan() {

        String str = "اعتقدت أنها فكرة مثيرة للاهتمام أن يتمكن الأشخاص من التحدث والتعليق والحصول على تعليقات على القصص التي يكتبونها ويضعونها في البرنامج.\n" +
                "أو مكان لتقديم الشكر لهم وتكوين صداقات جديدة. لأن البشر بطبيعتهم يحبون التواصل والنقد ...\n" +
                "  انضم إلى مجتمع Telegram:";
        return str;
    }

    // en
    private String EN_lan() {

        String str = "I thought it was an interesting idea for people to be able to talk and comment and get feedback on the stories they write and put into the program.\n" +
                "Or a place to say thank you to them and make new friends. Because humans inherently like to communicate and critique ...\n" +
                "  Join our Telegram community:";
        return str;
    }


}