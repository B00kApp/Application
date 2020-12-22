package com.mahdirahmani8.myapplication.OnBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.MainActivity;
import com.mahdirahmani8.myapplication.R;
import com.mahdirahmani8.myapplication.UserActivity.Setting_Activity;

public class OnBoarding extends AppCompatActivity {

    private TextView textView, txtBtn;
    private ImageView setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        cast();
        SetText();
        GoToSetting();
        GoToApp();


    }

    private void GoToApp() {
        txtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMainActivity = new Intent(OnBoarding.this, MainActivity.class);
                startActivity(goMainActivity);
                finish();
            }
        });
    }

    private void GoToSetting() {

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent(OnBoarding.this, Setting_Activity.class);
                setting.putExtra("IF",true);
                startActivity(setting);
                finish();
            }
        });

    }

    private void SetText() {
        DataBase db = new DataBase(this);
        String str = db.lanValue();

        if (str != null && str.hashCode() == 3259) {   // fa

            txtBtn.setText("بزن بریم");
            textView.setText("سلام دوستان\n" +
                    "برنامه ما دارای دو قسمت کتاب صوتی و داستان های کوتاه است\n" +
                    "که به صورت رایگان و آزاد در اختیار شما عزیزان قرار داده ایم \n" +
                    "شما میتوانید با انتشار این برنامه به دوستانتان همان سنت پسندیده اهدای کتاب را معنای جدید ببخشید . برای شخصی سازی از آیکون زیر استفاده کنید.\n" +
                    "امیدوارم که از برنامه لذت ببرید.\n" +
                    " ");

        } else if (str != null && str.hashCode() == 3246) {   //sp

            txtBtn.setText("Vamonos");
            textView.setText("Hola amigos\n" +
                    "Nuestro programa tiene dos partes: audiolibros e historias cortas.\n" +
                    "Que les hemos proporcionado queridos míos gratis y gratis\n" +
                    "Al publicar este programa, puedes darle un nuevo significado a la misma buena tradición de donar libros a tus amigos. Utilice el icono de abajo para personalizarlo.\n" +
                    "Espero que disfrutes de la aplicación.");


        } else if (str != null && str.hashCode() == 3307) {   // gr

            txtBtn.setText("Lass uns gehen");
            textView.setText("Hallo Freunde\n" +
                    "Unser Programm besteht aus zwei Teilen: Hörbüchern und Kurzgeschichten\n" +
                    "Was wir Ihnen, meine Lieben, kostenlos und kostenlos zur Verfügung gestellt haben\n" +
                    "Durch die Veröffentlichung dieses Programms können Sie der gleichen guten Tradition, Bücher an Ihre Freunde zu spenden, eine neue Bedeutung geben. Verwenden Sie das Symbol unten zur Personalisierung.\n" +
                    "Ich hoffe euch gefällt die App.");


        } else if (str != null && str.hashCode() == 3121) {    // ar

            txtBtn.setText("لنذهب");
            textView.setText("مرحبا اصدقاء\n" +
                    "يتكون برنامجنا من جزأين: كتب صوتية وقصص قصيرة\n" +
                    "التي قدمناها لكم أعزائي مجاناً ومجانا\n" +
                    "من خلال نشر هذا البرنامج ، يمكنك إعطاء معنى جديد لنفس التقليد الجيد للتبرع بالكتب لأصدقائك. استخدم الرمز أدناه للتخصيص.\n" +
                    "أتمنى أن تستمتع بالتطبيق.");

        } else {    //en

            textView.setText("Hello friends\n" +
                    "Our program has two parts: audiobooks and short stories\n" +
                    "Which we have provided to you dear ones for free and free\n" +
                    "By publishing this program, you can give a new meaning to the same good tradition of donating books to your friends. Use the icon below for personalization.\n" +
                    "I hope you enjoy the app.");

        }
    }

    private void cast() {

        textView = (TextView) findViewById(R.id.TEXT_id);
        txtBtn = (TextView) findViewById(R.id.go_to_app_id);
        setting = (ImageView) findViewById(R.id.setting_id);
    }
}