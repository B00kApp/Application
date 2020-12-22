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

import com.mahdirahmani8.myapplication.Adopter.SP;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.R;

public class Programmers extends AppCompatActivity {

    private ImageView github, gitlab, imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmers);

        cast();
        video();
        Lan();


        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/B00kApp/"));
                    startActivity(github_intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Programmers.this, "You should install Browser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        gitlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent github_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gitlab.com/B00kApp/"));
                    startActivity(github_intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Programmers.this, "You should install Browser", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }

    private void cast() {

        github = (ImageView) findViewById(R.id.github_img);
        gitlab = (ImageView) findViewById(R.id.gitlab_img);
        textView = (TextView) findViewById(R.id.TV_pro);
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

        String str = "دوستان ، خیلی خوشحالم که از این برنامه توانسته است نظر شما را جلب کند. اما همانطور که میدانید همه برنامه ها باگ ها و مشکل هایی دارند\n" +
                "و برای خیلی از علاقه مندان سوال بوده که چگونه برنامه ها طراحی میشوند و چگونه قطعه ای از کد کار های جادویی میکند ...\n" +
                "من تصمیم گرفتم برنامه را آزاد در Github و GitLab منتشر کنم تا هم برنامه نویس های جوان بتوانند کد های مرا ببینند و هم برنامه نویس های حرفه ای\n" +
                "خوشحال میشم که بتوانید عیب ها و باگ های برنامه را رفع کنید و pull request بزنید . کلنجار بروید و بازی کنید. \n" +
                "به امید دنیای آزاد تر ، زیبا تر ، شاد تر و خفن تر ...\n" +
                "لینک دسترسی به کد ها در گیت هاب و گیت لب : ";
        return str;
    }

    // sp
    private String SP_lan() {

        String str = "Amigos, estoy muy feliz de que este programa haya podido atraer su atención. Pero como sabes, todos los programas tienen errores y problemas.\n" +
                "Y para muchos entusiastas, la pregunta ha sido cómo se diseñan los programas y cómo funciona mágicamente un fragmento de código ...\n" +
                "Decidí publicar el programa libremente en Github y GitLab para que tanto los programadores jóvenes como los programadores profesionales puedan ver mi código.\n" +
                "Estoy feliz de poder corregir errores y errores en el programa y la solicitud de extracción. Lucha y juega.\n" +
                "Esperando un mundo más libre, más hermoso, más feliz y más caliente ...\n" +
                "Enlace para acceder a los códigos en Gate Hub y Gate Lab:";
        return str;
    }

    // gr
    private String GR_lan() {

        String str = "Freunde, ich freue mich sehr, dass dieses Programm Ihre Aufmerksamkeit erregen konnte. Aber wie Sie wissen, haben alle Programme Fehler und Probleme\n" +
                "Und für viele Enthusiasten war die Frage, wie Programme entworfen werden und wie ein Code magisch funktioniert ...\n" +
                "Ich habe beschlossen, das Programm frei auf Github und GitLab zu veröffentlichen, damit sowohl junge Programmierer als auch professionelle Programmierer meinen Code sehen können.\n" +
                "Ich bin froh, Fehler und Bugs im Programm beheben und Anfragen abrufen zu können. Ringen und spielen.\n" +
                "In der Hoffnung auf eine freiere, schönere, glücklichere und heißere Welt ...\n" +
                "Link zum Zugriff auf die Codes in Gate Hub und Gate Lab:";
        return str;
    }

    // ar
    private String AR_lan() {

        String str = "أصدقائي ، أنا سعيد جدًا لأن هذا البرنامج نجح في جذب انتباهكم. لكن كما تعلم ، كل البرامج بها أخطاء ومشاكل\n" +
                "وبالنسبة للعديد من المتحمسين ، كان السؤال هو كيف يتم تصميم البرامج وكيف يعمل جزء من التعليمات البرمجية بطريقة سحرية ...\n" +
                "قررت أن أنشر البرنامج مجانًا على Github و GitLab بحيث يمكن للمبرمجين الشباب والمبرمجين المحترفين رؤية الكود الخاص بي.\n" +
                "يسعدني أن أكون قادرًا على إصلاح الأخطاء والأخطاء في البرنامج وسحب الطلب. تصارع والعب.\n" +
                "آملا في عالم أكثر حرية وجمال وسعادة وسخونة ...\n" +
                "رابط للوصول إلى الرموز في Gate Hub و Gate Lab:";
        return str;
    }

    // en
    private String EN_lan() {

        String str = "Friends, I am very happy that this program has been able to attract your attention. But as you know, all programs have bugs and problems\n" +
                "And for many enthusiasts, the question has been how programs are designed and how a piece of code works magically ...\n" +
                "I decided to publish the program freely on Github and GitLab so that both young programmers and professional programmers can see my code.\n" +
                "I'm happy to be able to fix bugs and bugs in the program and pull request. Wrestle and play.\n" +
                "Hoping for a freer, more beautiful, happier and hotter world ...\n" +
                "Link to access the codes in Gate Hub and Gate Lab:";
        return str;
    }


}