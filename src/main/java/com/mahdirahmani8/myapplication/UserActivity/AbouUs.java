package com.mahdirahmani8.myapplication.UserActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.R;
import com.pnikosis.materialishprogress.ProgressWheel;

public class AbouUs extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abou_us);

        video();
        Lan();

    }

    private void video() {
        textView = findViewById(R.id.TV_about);


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

        String str ="من مهدی  هستم و خوشحالم که از برنامه من استفاده میکنید.\n" +
                "من همیشه کتاب خواندن را دوست داشتم و البته کتاب شنیدن را. اما نمی خواستم برایش هزینه کنم پس رفتم سراغ دوست قدیمی ام گوگل :)\n" +
                "و سرچ کردم و سرچ کردم و تقریبا توانستم تمام کتاب های مورد علاقه ام را جمع آوری کنم اما خودتان میدانید این همه لینک در اینترنت موجود است \n" +
                "و پس از مدتی کتاب هایی که در می خواستم آنها را بخوانم فراموش میکردم یا نام آنها را و یا لینک انها را :)\n" +
                "بعد تصمیم گرفتم که یک فایل txt بسازم و همه را در آنجا نگهدارم اما این جا مساله ای پیش می آمد. \n" +
                "من دوست داشتم که دانشم را با دیگران شریک شوم و دانش را برای خودم نمی خواهم چون من یک هکرم ...\n" +
                "\n" +
                "نکته ای که همه باید بدانند این است که هکر ها دزد نیستند این به این معنی نیست که هکر دزد وجود ندارد . منظور من این است که یک هکر در دنیای \n" +
                "خودش زندگی میکند در یک دنیای آزاد ...\n" +
                "\n" +
                "خوب بعدش به این فکر افتادم که یک اپلیکیشن موبایلی طراحی کنم که خودم از آن استفاده کنم اما لحظه به لحظه برنامه بزرگ تر و بزرگ تر شد و این\n" +
                "ایده به ذهنم رسید که این برنامه را رایگان و آزاد برای همه مردم جهان به اشتراک بگذارم تا باشد که این جهان پر از عشق و دانایی شود \n" +
                "دنیای زیبا تا بهتر و راحت تر در آن زندگی کنیم ...\n" +
                "\n";
        return str;
    }

    // sp
    private String SP_lan() {

        String str = "Soy Mehdi y me alegro de que esté utilizando mi programa.\n" +
                "Siempre me ha gustado leer libros y por supuesto escuchar libros. Pero no quería pagarlo, así que fui a mi viejo amigo Google :)\n" +
                "Y busqué y busqué y pude recopilar casi todos mis libros favoritos, pero sabes que todos estos enlaces están disponibles en Internet.\n" +
                "Y después de un tiempo, olvidé los libros que quería leer, ya sea sus nombres o sus enlaces :)\n" +
                "Luego decidí crear un archivo txt y mantenerlo todo allí, pero aquí estaba el problema.\n" +
                "Quería compartir mis conocimientos con los demás y no quiero conocimientos para mí porque soy un hacker ...\n" +
                "\n" +
                "El caso es que los piratas informáticos no son ladrones, lo que no significa que los piratas informáticos no sean ladrones. Me refiero a un hacker en el mundo\n" +
                "Vive en un mundo libre ...\n" +
                "\n" +
                "Bueno, entonces pensé en diseñar una aplicación móvil para usarla yo mismo, pero de vez en cuando la aplicación se hizo más y más grande\n" +
                "Se me ocurrió la idea de compartir este programa de forma gratuita y gratuita para todas las personas del mundo para que este mundo estuviera lleno de amor y conocimiento.\n" +
                "Hermoso mundo para vivir mejor y más cómodo ...";
        return str;
    }

    // gr
    private String GR_lan() {

        String str = "Ich bin Mehdi und ich bin froh, dass Sie mein Programm verwenden.\n" +
                "Ich habe es immer geliebt, Bücher zu lesen und natürlich Bücher zu hören. Aber ich wollte nicht dafür bezahlen, also ging ich zu meinem alten Freund Google :)\n" +
                "Ich habe gesucht und gesucht und konnte fast alle meine Lieblingsbücher sammeln, aber Sie wissen, dass all diese Links im Internet verfügbar sind\n" +
                "Und nach einer Weile vergaß ich die Bücher, die ich lesen wollte, entweder ihre Namen oder ihre Links :)\n" +
                "Dann habe ich beschlossen, eine txt-Datei zu erstellen und alles dort zu belassen, aber hier war das Problem.\n" +
                "Ich wollte mein Wissen mit anderen teilen und ich möchte kein Wissen für mich selbst, weil ich ein Hacker bin ...\n" +
                "\n" +
                "Der Punkt ist, Hacker sind keine Diebe. Dies bedeutet nicht, dass Hacker keine Diebe sind. Ich meine einen Hacker auf der Welt\n" +
                "Er lebt in einer freien Welt ...\n" +
                "\n" +
                "Nun, dann dachte ich daran, eine mobile App für mich selbst zu entwerfen, aber von Moment zu Moment wurde die App immer größer und das auch\n" +
                "Mir kam die Idee, dieses Programm kostenlos und frei für alle Menschen auf der Welt zu teilen, damit diese Welt voller Liebe und Wissen ist.\n" +
                "Schöne Welt, um besser und komfortabler zu leben ...";
        return str;
    }

    // ar
    private String AR_lan() {

        String str = "أنا مهدي وأنا سعيد لأنك تستخدم برنامجي.\n" +
                "لطالما أحببت قراءة الكتب وبالطبع الاستماع إلى الكتب. لكنني لم أرغب في دفع ثمنها ، فذهبت إلى صديقي القديم Google :)\n" +
                "وبحثت وبحثت وتمكنت من جمع كل كتبي المفضلة تقريبًا ولكنك تعلم أن كل هذه الروابط متوفرة على الإنترنت\n" +
                "وبعد فترة نسيت الكتب التي أردت قراءتها ، إما أسمائها أو روابطها :)\n" +
                "ثم قررت إنشاء ملف txt والاحتفاظ به جميعًا ، ولكن هنا كانت المشكلة.\n" +
                "كنت أرغب في مشاركة معرفتي مع الآخرين ولا أريد المعرفة بنفسي لأنني مخترق ...\n" +
                "\n" +
                "النقطة المهمة هي أن المتسللين ليسوا لصوصًا ، وهذا لا يعني أن المتسللين ليسوا لصوصًا. أعني مخترق في العالم\n" +
                "يعيش في عالم حر ...\n" +
                "\n" +
                "حسنًا ، فكرت بعد ذلك في تصميم تطبيق جوال لاستخدام نفسي ، ولكن لحظة بلحظة أصبح التطبيق أكبر وأكبر ، وهذا\n" +
                "خطرت لي فكرة لمشاركة هذا البرنامج مجانًا وحرية لجميع شعوب العالم حتى يكون هذا العالم مليئًا بالحب والمعرفة.\n" +
                "عالم جميل للعيش فيه أفضل وأكثر راحة ...";
        return str;
    }

    // en
    private String EN_lan() {

        String str = "I am Mehdi and I am glad that you are using my program.\n" +
                "I have always loved reading books and of course listening to books. But I did not want to pay for it, so I went to my old friend Google :)\n" +
                "And I searched and searched and I was able to collect almost all my favorite books but you know all these links are available on the internet\n" +
                "And after a while, I forgot the books I wanted to read, either their names or their links :)\n" +
                "Then I decided to create a txt file and keep it all there, but here was the problem.\n" +
                "I wanted to share my knowledge with others and I do not want knowledge for myself because I am a hacker ...\n" +
                "\n" +
                "The point is, hackers are not thieves. This does not mean that hackers are not thieves. I mean a hacker in the world\n" +
                "He lives in a free world ...\n" +
                "\n" +
                "Well, then I thought of designing a mobile app to use myself, but from time to time the app got bigger and bigger, and this\n" +
                "The idea came to me to share this program for free and freely for all the people of the world so that this world would be full of love and knowledge.\n" +
                "Beautiful world to live in better and more comfortable ...";
        return str;
    }


}