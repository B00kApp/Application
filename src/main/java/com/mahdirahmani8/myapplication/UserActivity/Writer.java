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

public class Writer extends AppCompatActivity {

    private TextView textView;
    private ImageView telegram , e_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writer);

        cast();
        video();
        Lan();



        //  telegram on click
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/B00kApp/"));
                    startActivity(github_intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Writer.this, "You should install Browser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        // E-mail on click
        e_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://b00kapp@yahoo.com"));
                    startActivity(github_intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Writer.this, "You should install Browser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });


    }

    private void cast() {
        textView = findViewById(R.id.TV_about);
        telegram = (ImageView) findViewById(R.id.tel_img);
        e_mail   = (ImageView) findViewById(R.id.email_img);
    }

    private void video() {

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

        String str = "دوستان علاقه مند به نوشتن و خواندن یه خبر خوب واستون دارم ...\n" +
                "از اون جایی که برنامه ما خیلی باحاله ، شما میتونید از راه های ارتباطی زیر داستان ها و یا کتاب های صوتی که خوتون خوندید رو بفرستید و ما آن را در برنامه\n" +
                "به اشتراک بگذارید .\n" +
                "نحوه ارسال داستان های کوتاه بسیار راحت است شما میتوانید آن را مستقیما از راه های ارتباطی زیر بفرستید اما برای کتاب های صوتی باید کار کوچکی را انجام دهید\n" +
                "و آن این است که فایل های صوتی را تک تک روی هاست های اینترنتی مثل media fire یا dropbox آپلود کرده و لینک آن را برای ما بفرستید .\n" +
                "\n" +
                "\n" +
                "راه های ارتباطی ما : \n";
        return str;
    }

    // sp
    private String SP_lan() {

        String str = "Tengo amigos que están interesados \u200B\u200Ben escribir y leer buenas noticias en Weston ...\n" +
                "Dado que nuestra aplicación es tan genial, puede enviarla a través de los canales de comunicación debajo de las historias o audiolibros que lea y la enviaremos en la aplicación.\n" +
                "Compártelo .\n" +
                "Cómo enviar cuentos es muy fácil, puedes enviarlo directamente a través de los siguientes canales de comunicación, pero para los audiolibros hay que trabajar un poco.\n" +
                "Es decir, suba los archivos de audio uno por uno a hosts de Internet como media fire o dropbox y envíenos el enlace.\n" +
                "\n" +
                "Nuestros canales de comunicación:";
        return str;
    }

    // gr
    private String GR_lan() {

        String str = "Ich habe Freunde, die daran interessiert sind, gute Nachrichten in Weston zu schreiben und zu lesen ...\n" +
                "Da unsere App so cool ist, können Sie sie über die Kommunikationskanäle unter den von Ihnen gelesenen Geschichten oder Hörbüchern senden, und wir senden sie in der App\n" +
                "teilt es .\n" +
                "Das Versenden von Kurzgeschichten ist sehr einfach. Sie können sie direkt über die folgenden Kommunikationskanäle senden, aber für Hörbücher müssen Sie ein wenig arbeiten.\n" +
                "Laden Sie die Audiodateien einzeln auf Internet-Hosts wie Media Fire oder Dropbox hoch und senden Sie uns den Link.\n" +
                "\n" +
                "Unsere Kommunikationskanäle:";
        return str;
    }

    // ar
    private String AR_lan() {

        String str ="لدي أصدقاء مهتمون بكتابة وقراءة الأخبار الجيدة في ويستون ...\n" +
                "نظرًا لأن تطبيقنا رائع جدًا ، يمكنك إرساله عبر قنوات الاتصال أسفل القصص أو الكتب الصوتية التي تقرأها وسنرسلها في التطبيق\n" +
                "أنشرها .\n" +
                "طريقة إرسال القصص القصيرة سهلة للغاية ، يمكنك إرسالها مباشرة من خلال قنوات الاتصال التالية ، ولكن بالنسبة للكتب الصوتية ، عليك أن تقوم ببعض العمل.\n" +
                "وذلك لتحميل الملفات الصوتية واحدًا تلو الآخر على مضيفي الإنترنت مثل media fire أو dropbox وإرسال الرابط إلينا.\n" +
                "\n" +
                "قنوات الاتصال لدينا:";
        return str;
    }

    // en
    private String EN_lan() {

        String str = "I have friends who are interested in writing and reading good news in Weston ...\n" +
                "Since our app is so cool, you can send it through the communication channels below the stories or audio books you read and we will send it in the app\n" +
                "share it .\n" +
                "How to send short stories is very easy. You can send it directly through the following communication channels, but for audiobooks you have to do a little work.\n" +
                "That is, upload the audio files one by one to Internet hosts such as media fire or dropbox and send us the link.\n" +
                "\n" +
                "Our communication channels:";
        return str;
    }





}