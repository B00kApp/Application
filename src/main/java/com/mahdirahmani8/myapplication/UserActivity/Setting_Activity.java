package com.mahdirahmani8.myapplication.UserActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.MainActivity;
import com.mahdirahmani8.myapplication.Model.Setting;
import com.mahdirahmani8.myapplication.R;
import com.mahdirahmani8.myapplication.UserFragment;

import java.util.List;

public class Setting_Activity extends AppCompatActivity {

    private ImageView en, sp, gr, ar, fa;
    private RelativeLayout relLan, relSize, relFont, BgBG;
    private TextView lan, size, font, bg, wColor, setting, size_txt, tvParagrass;
    private LinearLayout lanShow, sizeShow, linFont, linBG;
    private TextView f1, f2, f3, f4, f5, f6, f7, f8, f9, font_txt;
    private Button img1, img2, img3, img4, img5, img6, img7, img8, showBG;
    private SeekBar seekBar;
    LinearLayout all;
    int txtSize = 5, saveParagrass;
    private SwitchCompat sw;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_user);

        cast();

        // setting
        lanOnClick();
        sizeOnClick();
        fontOnClick();
        setShowBG();
        bgOnCkick();
        wColorOnClick();

        openDB();

        Lan();
    }

    private void setShowBG() {
        DataBase db = new DataBase(this);
        int i = db.getBg();

        if (i ==1){
            showBG.setVisibility(View.VISIBLE);
            showBG.setBackgroundResource(R.drawable.a);
        }else if (i ==2){
            showBG.setVisibility(View.VISIBLE);
            showBG.setBackgroundResource(R.drawable.b);
        }else if (i ==3){
            showBG.setVisibility(View.VISIBLE);
            showBG.setBackgroundResource(R.drawable.c);
        }else if (i ==4){
            showBG.setVisibility(View.VISIBLE);
            showBG.setBackgroundResource(R.drawable.d);
        }else if (i ==5){
            showBG.setVisibility(View.VISIBLE);
            showBG.setBackgroundResource(R.drawable.e);
        }else if (i ==6){
            showBG.setVisibility(View.VISIBLE);
            showBG.setBackgroundResource(R.drawable.f);
        }else if (i ==7){
            showBG.setVisibility(View.VISIBLE);
            showBG.setBackgroundResource(R.drawable.g);
        }else if (i ==8){
            showBG.setVisibility(View.VISIBLE);
            showBG.setBackgroundResource(R.drawable.i);
        }
    }

    int bCount = 1;

    private void bgOnCkick() {

        BgBG.setVisibility(View.GONE);

        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount += 1;
                showBG.setBackgroundResource(R.drawable.a);

                if (bCount % 2 == 0) {
                    linBG.setVisibility(View.VISIBLE);
                    BgBG.setVisibility(View.VISIBLE);
                    showBG.setVisibility(View.GONE);
                } else {
                    setShowBG();
                    BgBG.setVisibility(View.GONE);
                    showBG.setVisibility(View.VISIBLE);
                }
            }
        });



        // on click bg
        DataBase db = new DataBase(this);



        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount +=1;
                showBG.setVisibility(View.VISIBLE);
                showBG.setBackgroundResource(R.drawable.a);

                db.setBG(1);
                BgBG.setVisibility(View.GONE);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount +=1;
                showBG.setVisibility(View.VISIBLE);
                showBG.setBackgroundResource(R.drawable.b);

                db.setBG(2);
                BgBG.setVisibility(View.GONE);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount +=1;
                showBG.setVisibility(View.VISIBLE);
                showBG.setBackgroundResource(R.drawable.c);

                db.setBG(3);
                BgBG.setVisibility(View.GONE);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount +=1;
                showBG.setVisibility(View.VISIBLE);
                showBG.setBackgroundResource(R.drawable.d);

                db.setBG(4);
                BgBG.setVisibility(View.GONE);
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount +=1;
                showBG.setVisibility(View.VISIBLE);
                showBG.setBackgroundResource(R.drawable.e);

                db.setBG(5);
                BgBG.setVisibility(View.GONE);
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount +=1;
                showBG.setVisibility(View.VISIBLE);
                showBG.setBackgroundResource(R.drawable.f);

                db.setBG(6);
                BgBG.setVisibility(View.GONE);
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount +=1;
                showBG.setVisibility(View.VISIBLE);
                showBG.setBackgroundResource(R.drawable.g);

                db.setBG(7);
                BgBG.setVisibility(View.GONE);
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bCount +=1;
                showBG.setVisibility(View.VISIBLE);
                showBG.setBackgroundResource(R.drawable.i);

                db.setBG(8);
                BgBG.setVisibility(View.GONE);
            }
        });



    }

    private void wColorOnClick() {

        DataBase db = new DataBase(this);
        boolean bool = sw.isChecked();

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    db.ColorValue(1);
                } else {
                    db.ColorValue(0);
                }

            }
        });


        if (db.getColor() == 1) {
            sw.setChecked(true);
        } else {
            sw.setChecked(false);
        }

    }

    int fCount = 1;

    private void fontOnClick() {

        relFont.setVisibility(View.GONE);

        font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fCount += 1;

                // show visibility
                if (fCount % 2 == 0) {

                    linFont.setVisibility(View.VISIBLE);
                    relFont.setVisibility(View.VISIBLE);
                } else {

                    linFont.setVisibility(View.VISIBLE);
                    relFont.setVisibility(View.GONE);
                }
            }
        });

        setFontText();

        // on click fonts
        DataBase db = new DataBase(this);

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(1);
                f1.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f2.setBackgroundResource(R.color.Background);
                f3.setBackgroundResource(R.color.Background);
                f4.setBackgroundResource(R.color.Background);
                f5.setBackgroundResource(R.color.Background);
                f6.setBackgroundResource(R.color.Background);
                f7.setBackgroundResource(R.color.Background);
                f8.setBackgroundResource(R.color.Background);
                f9.setBackgroundResource(R.color.Background);

                font_txt.setText("Amiry");
                Typeface F1 = Typeface.createFromAsset(getAssets(), "font/amiri.ttf");
                font_txt.setTypeface(F1);
            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(2);
                f2.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f1.setBackgroundResource(R.color.Background);
                f3.setBackgroundResource(R.color.Background);
                f4.setBackgroundResource(R.color.Background);
                f5.setBackgroundResource(R.color.Background);
                f6.setBackgroundResource(R.color.Background);
                f7.setBackgroundResource(R.color.Background);
                f8.setBackgroundResource(R.color.Background);
                f9.setBackgroundResource(R.color.Background);

                font_txt.setText("Banoo");
                Typeface F2 = Typeface.createFromAsset(getAssets(), "font/banoo.ttf");
                font_txt.setTypeface(F2);
            }
        });

        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(3);
                f3.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f1.setBackgroundResource(R.color.Background);
                f2.setBackgroundResource(R.color.Background);
                f4.setBackgroundResource(R.color.Background);
                f5.setBackgroundResource(R.color.Background);
                f6.setBackgroundResource(R.color.Background);
                f7.setBackgroundResource(R.color.Background);
                f8.setBackgroundResource(R.color.Background);
                f9.setBackgroundResource(R.color.Background);

                font_txt.setText("Changa");
                Typeface F3 = Typeface.createFromAsset(getAssets(), "font/changa.ttf");
                font_txt.setTypeface(F3);
            }
        });

        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(4);
                f4.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f1.setBackgroundResource(R.color.Background);
                f2.setBackgroundResource(R.color.Background);
                f3.setBackgroundResource(R.color.Background);
                f5.setBackgroundResource(R.color.Background);
                f6.setBackgroundResource(R.color.Background);
                f7.setBackgroundResource(R.color.Background);
                f8.setBackgroundResource(R.color.Background);
                f9.setBackgroundResource(R.color.Background);

                font_txt.setText("Jomhuria");
                Typeface F4 = Typeface.createFromAsset(getAssets(), "font/jomhuria.ttf");
                font_txt.setTypeface(F4);

            }
        });

        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(5);
                f5.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f1.setBackgroundResource(R.color.Background);
                f2.setBackgroundResource(R.color.Background);
                f3.setBackgroundResource(R.color.Background);
                f4.setBackgroundResource(R.color.Background);
                f6.setBackgroundResource(R.color.Background);
                f7.setBackgroundResource(R.color.Background);
                f8.setBackgroundResource(R.color.Background);
                f9.setBackgroundResource(R.color.Background);

                font_txt.setText("Kodakku");
                Typeface F5 = Typeface.createFromAsset(getAssets(), "font/kodakku.ttf");
                font_txt.setTypeface(F5);
            }
        });

        f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(6);
                f6.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f1.setBackgroundResource(R.color.Background);
                f2.setBackgroundResource(R.color.Background);
                f3.setBackgroundResource(R.color.Background);
                f4.setBackgroundResource(R.color.Background);
                f5.setBackgroundResource(R.color.Background);
                f7.setBackgroundResource(R.color.Background);
                f8.setBackgroundResource(R.color.Background);
                f9.setBackgroundResource(R.color.Background);

                font_txt.setText("Mirza");
                Typeface F6 = Typeface.createFromAsset(getAssets(), "font/mirza.ttf");
                font_txt.setTypeface(F6);

            }
        });

        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(7);
                f7.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f1.setBackgroundResource(R.color.Background);
                f2.setBackgroundResource(R.color.Background);
                f3.setBackgroundResource(R.color.Background);
                f4.setBackgroundResource(R.color.Background);
                f5.setBackgroundResource(R.color.Background);
                f6.setBackgroundResource(R.color.Background);
                f8.setBackgroundResource(R.color.Background);
                f9.setBackgroundResource(R.color.Background);

                font_txt.setText("Nazanin");
                Typeface F7 = Typeface.createFromAsset(getAssets(), "font/nazanin.TTF");
                font_txt.setTypeface(F7);

            }
        });

        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(8);
                f8.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f1.setBackgroundResource(R.color.Background);
                f2.setBackgroundResource(R.color.Background);
                f3.setBackgroundResource(R.color.Background);
                f4.setBackgroundResource(R.color.Background);
                f5.setBackgroundResource(R.color.Background);
                f6.setBackgroundResource(R.color.Background);
                f7.setBackgroundResource(R.color.Background);
                f9.setBackgroundResource(R.color.Background);

                font_txt.setText("Roya");
                Typeface F8 = Typeface.createFromAsset(getAssets(), "font/roya.ttf");
                font_txt.setTypeface(F8);
            }
        });

        f9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fCount += 1;

                db.setFont(9);
                f9.setBackgroundResource(R.drawable.item_bg);
                relFont.setVisibility(View.GONE);

                f1.setBackgroundResource(R.color.Background);
                f2.setBackgroundResource(R.color.Background);
                f3.setBackgroundResource(R.color.Background);
                f4.setBackgroundResource(R.color.Background);
                f5.setBackgroundResource(R.color.Background);
                f6.setBackgroundResource(R.color.Background);
                f7.setBackgroundResource(R.color.Background);
                f8.setBackgroundResource(R.color.Background);

                font_txt.setText("Vazir");
                Typeface F9 = Typeface.createFromAsset(getAssets(), "font/vazir.ttf");
                font_txt.setTypeface(F9);
            }
        });

        int i = db.getFont();

        if (i == 1) {
            font_txt.setText("Amiri");
            Typeface F1 = Typeface.createFromAsset(getAssets(), "font/amiri.ttf");
            font_txt.setTypeface(F1);
            f1.setBackgroundResource(R.drawable.item_bg);

        } else if (i == 2) {
            font_txt.setText("Banoo");
            Typeface F2 = Typeface.createFromAsset(getAssets(), "font/banoo.ttf");
            font_txt.setTypeface(F2);
            f2.setBackgroundResource(R.drawable.item_bg);

        } else if (i == 3) {
            font_txt.setText("Changa");
            Typeface F3 = Typeface.createFromAsset(getAssets(), "font/changa.ttf");
            font_txt.setTypeface(F3);
            f3.setBackgroundResource(R.drawable.item_bg);

        } else if (i == 4) {
            font_txt.setText("Jomhuria");
            Typeface F4 = Typeface.createFromAsset(getAssets(), "font/jomhuria.ttf");
            font_txt.setTypeface(F4);
            f4.setBackgroundResource(R.drawable.item_bg);

        } else if (i == 5) {
            font_txt.setText("Kodakku");
            Typeface F5 = Typeface.createFromAsset(getAssets(), "font/kodakku.ttf");
            font_txt.setTypeface(F5);
            f5.setBackgroundResource(R.drawable.item_bg);

        } else if (i == 6) {
            font_txt.setText("Mirza");
            Typeface F6 = Typeface.createFromAsset(getAssets(), "font/mirza.ttf");
            font_txt.setTypeface(F6);
            f6.setBackgroundResource(R.drawable.item_bg);

        } else if (i == 7) {
            font_txt.setText("Nazanin");
            Typeface F7 = Typeface.createFromAsset(getAssets(), "font/nazanin.TTF");
            font_txt.setTypeface(F7);
            f7.setBackgroundResource(R.drawable.item_bg);

        } else if (i == 8) {
            font_txt.setText("Roya");
            Typeface F8 = Typeface.createFromAsset(getAssets(), "font/roya.ttf");
            font_txt.setTypeface(F8);
            f8.setBackgroundResource(R.drawable.item_bg);

        } else if (i == 9) {
            font_txt.setText("Vazir");
            Typeface F9 = Typeface.createFromAsset(getAssets(), "font/vazir.ttf");
            font_txt.setTypeface(F9);
            f9.setBackgroundResource(R.drawable.item_bg);
        }
    }

    // set text and set font
    private void setFontText() {
        DataBase db = new DataBase(this);

        String str = db.lanValue();

        if (str != null && str.hashCode() == 3259) {   // fa

            f1.setText("متن تستی");
            f2.setText("متن تستی");
            f3.setText("متن تستی");
            f4.setText("متن تستی");
            f5.setText("متن تستی");
            f6.setText("متن تستی");
            f7.setText("متن تستی");
            f8.setText("متن تستی");
            f9.setText("متن تستی");

        } else if (str != null && str.hashCode() == 3246) {   //sp

            f1.setText("Texto de prueba");
            f2.setText("Texto de prueba");
            f3.setText("Texto de prueba");
            f4.setText("Texto de prueba");
            f5.setText("Texto de prueba");
            f6.setText("Texto de prueba");
            f7.setText("Texto de prueba");
            f8.setText("Texto de prueba");
            f9.setText("Texto de prueba");

        } else if (str != null && str.hashCode() == 3307) {   // gr

            f1.setText("Testtext");
            f2.setText("Testtext");
            f3.setText("Testtext");
            f4.setText("Testtext");
            f5.setText("Testtext");
            f6.setText("Testtext");
            f7.setText("Testtext");
            f8.setText("Testtext");
            f9.setText("Testtext");

        } else if (str != null && str.hashCode() == 3121) {    // ar

            f1.setText("نص الاختبار");
            f2.setText("نص الاختبار");
            f3.setText("نص الاختبار");
            f4.setText("نص الاختبار");
            f5.setText("نص الاختبار");
            f6.setText("نص الاختبار");
            f7.setText("نص الاختبار");
            f8.setText("نص الاختبار");
            f9.setText("نص الاختبار");

        } else {    //en

            f1.setText("Test text");
            f2.setText("Test text");
            f3.setText("Test text");
            f4.setText("Test text");
            f5.setText("Test text");
            f6.setText("Test text");
            f7.setText("Test text");
            f8.setText("Test text");
            f9.setText("Test text");
        }

        Typeface F1 = Typeface.createFromAsset(getAssets(), "font/amiri.ttf");
        f1.setTypeface(F1);
        Typeface F2 = Typeface.createFromAsset(getAssets(), "font/banoo.ttf");
        f2.setTypeface(F2);
        Typeface F3 = Typeface.createFromAsset(getAssets(), "font/changa.ttf");
        f3.setTypeface(F3);
        Typeface F4 = Typeface.createFromAsset(getAssets(), "font/jomhuria.ttf");
        f4.setTypeface(F4);
        Typeface F5 = Typeface.createFromAsset(getAssets(), "font/kodakku.ttf");
        f5.setTypeface(F5);
        Typeface F6 = Typeface.createFromAsset(getAssets(), "font/mirza.ttf");
        f6.setTypeface(F6);
        Typeface F7 = Typeface.createFromAsset(getAssets(), "font/nazanin.TTF");
        f7.setTypeface(F7);
        Typeface F8 = Typeface.createFromAsset(getAssets(), "font/roya.ttf");
        f8.setTypeface(F8);
        Typeface F9 = Typeface.createFromAsset(getAssets(), "font/vazir.ttf");
        f9.setTypeface(F9);
    }

    int sCount = 1;

    private void sizeOnClick() {

        relSize.setVisibility(View.GONE);

        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sCount += 1;


                if (sCount % 2 == 0) {
                    relSize.setVisibility(View.VISIBLE);
                    sizeShow.setVisibility(View.VISIBLE);
                    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                            DataBase db = new DataBase(Setting_Activity.this);

                            if (fromUser) {
                                txtSize += (progress - saveParagrass);
                                saveParagrass = progress;
                                size_txt.setTextSize(txtSize);
                                db.sizeValue(txtSize);

                                tvParagrass.setText("" + db.sizeValue());
                            }

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                } else {
                    relSize.setVisibility(View.GONE);
                    sizeShow.setVisibility(View.VISIBLE);
                }


            }
        });

    }

    // for visible or gone
    int count = 1;

    private void lanOnClick() {


        relLan.setVisibility(View.GONE);
        showLan();
        lan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;

                if (count % 2 == 0) {
                    relLan.setVisibility(View.VISIBLE);
                    lanShow.setVisibility(View.GONE);
                } else {
                    relLan.setVisibility(View.GONE);
                    lanShow.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void showLan() {
        DataBase db = new DataBase(Setting_Activity.this);

        String str = db.lanValue();

        if (str != null && str.hashCode() == 3259) {
            lanShow.setBackgroundResource(R.drawable.iran);
        } else if (str != null && str.hashCode() == 3246) {
            lanShow.setBackgroundResource(R.drawable.spain);
        } else if (str != null && str.hashCode() == 3307) {
            lanShow.setBackgroundResource(R.drawable.germany);
        } else if (str != null && str.hashCode() == 3121) {
            lanShow.setBackgroundResource(R.drawable.arabic);
        } else {
            lanShow.setBackgroundResource(R.drawable.english);
        }

    }

    private void cast() {

        // lan
        en = (ImageView) findViewById(R.id.en);
        sp = (ImageView) findViewById(R.id.es);
        gr = (ImageView) findViewById(R.id.gr);
        ar = (ImageView) findViewById(R.id.ar);
        fa = (ImageView) findViewById(R.id.fa);

        // setting
        lan = (TextView) findViewById(R.id.Language_setting);
        size = (TextView) findViewById(R.id.Size_setting);
        font = (TextView) findViewById(R.id.Font_setting);
        bg = (TextView) findViewById(R.id.background_setting);
        sw = (SwitchCompat) findViewById(R.id.SC_btn);

        // includes
        relLan = (RelativeLayout) findViewById(R.id.REL_Setting_Lan);
        relSize = (RelativeLayout) findViewById(R.id.REL_Setting_Size);
        lanShow = (LinearLayout) findViewById(R.id.LAN_SHOW);
        sizeShow = (LinearLayout) findViewById(R.id.SIZE);
        all = (LinearLayout) findViewById(R.id.ID);
        wColor = (TextView) findViewById(R.id.WColoe_txt);
        size_txt = (TextView) findViewById(R.id.TEXT_id);
        setting = (TextView) findViewById(R.id.SETTING_txt);
        seekBar = (SeekBar) findViewById(R.id.sw);
        tvParagrass = (TextView) findViewById(R.id.tv_prograss);

        // font
        f1 = (TextView) findViewById(R.id.f1);
        f2 = (TextView) findViewById(R.id.f2);
        f3 = (TextView) findViewById(R.id.f3);
        f4 = (TextView) findViewById(R.id.f4);
        f5 = (TextView) findViewById(R.id.f5);
        f6 = (TextView) findViewById(R.id.f6);
        f7 = (TextView) findViewById(R.id.f7);
        f8 = (TextView) findViewById(R.id.f8);
        f9 = (TextView) findViewById(R.id.f9);
        relFont = (RelativeLayout) findViewById(R.id.REL_FONT);
        linFont = (LinearLayout) findViewById(R.id.Lin_font);
        font_txt = (TextView) findViewById(R.id.FONT_txt);

        // BG
        BgBG = (RelativeLayout) findViewById(R.id.BG_BG);
        linBG = (LinearLayout) findViewById(R.id.LIN_bg);
        img1 = (Button) findViewById(R.id.img1);
        img2 = (Button) findViewById(R.id.img2);
        img3 = (Button) findViewById(R.id.img3);
        img4 = (Button) findViewById(R.id.img4);
        img5 = (Button) findViewById(R.id.img5);
        img6 = (Button) findViewById(R.id.img6);
        img7 = (Button) findViewById(R.id.img7);
        img8 = (Button) findViewById(R.id.img8);
        showBG = (Button) findViewById(R.id.showBG);

    }

    private void openDB() {

        DataBase db = new DataBase(this);

        List<Setting> s = db.getSetting();
        String str = s.get(0).getLan();
        lAN(db, str);

        size_txt.setTextSize(db.sizeValue());
        seekBar.setProgress(db.sizeValue());
        tvParagrass.setText("" + +db.sizeValue());


    }

    String Lan;

    private void lAN(DataBase db, String lan) {

        // English
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lan = "en";
                Toast.makeText(Setting_Activity.this, "English", Toast.LENGTH_LONG).show();
                relLan.setVisibility(View.GONE);
                lanShow.setVisibility(View.VISIBLE);
                count += 1;

                db.setLan(Lan);
                lanShow.setBackgroundResource(R.drawable.english);
            }
        });

//      Spanish
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lan = "es";
                Toast.makeText(Setting_Activity.this, "Spanish", Toast.LENGTH_LONG).show();
                relLan.setVisibility(View.GONE);
                lanShow.setVisibility(View.VISIBLE);
                count += 1;

                db.setLan(Lan);
                lanShow.setBackgroundResource(R.drawable.spain);
            }
        });

//      Persian
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lan = "fa";
                Toast.makeText(Setting_Activity.this, "Persian", Toast.LENGTH_LONG).show();
                relLan.setVisibility(View.GONE);
                lanShow.setVisibility(View.VISIBLE);
                count += 1;

                db.setLan(Lan);
                lanShow.setBackgroundResource(R.drawable.iran);
            }
        });

//        Germany
        gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lan = "gr";
                Toast.makeText(Setting_Activity.this, "Germany", Toast.LENGTH_LONG).show();
                relLan.setVisibility(View.GONE);
                lanShow.setVisibility(View.VISIBLE);
                count += 1;

                db.setLan( Lan);
                lanShow.setBackgroundResource(R.drawable.germany);
            }
        });

//        Arabic
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lan = "ar";
                Toast.makeText(Setting_Activity.this, "Arabic", Toast.LENGTH_LONG).show();
                relLan.setVisibility(View.GONE);
                lanShow.setVisibility(View.VISIBLE);
                count += 1;

                db.setLan( Lan);
                lanShow.setBackgroundResource(R.drawable.arabic);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

        boolean b = getIntent().getExtras().getBoolean("IF");
        if (b) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent();
            setResult(1, intent);
        }

    }

    private void Lan() {
        DataBase db = new DataBase(this);
        String str = db.lanValue();


        if (str != null && str.hashCode() == 3259) {   // fa

            lan.setText("زبان");
            font.setText("فونت");
            size.setText("اندازه متن");
            bg.setText("زمینه مطالعه");
            wColor.setText("رنگ سفید برای متن");
            setting.setText("تنظیمات");

        } else if (str != null && str.hashCode() == 3246) {   //sp

            lan.setText("idioma");
            font.setText("fuente");
            size.setText("Talla");
            bg.setText("fondo de estudio");
            wColor.setText("color blanco para texto");
            setting.setText("ajuste");
            lanShow.setVerticalGravity(View.LAYOUT_DIRECTION_LTR);

        } else if (str != null && str.hashCode() == 3307) {   // gr

            lan.setText("Sprache");
            font.setText("Schriftart");
            size.setText("Größe");
            bg.setText("Hintergrund studieren");
            wColor.setText("weiße Farbe für Text");
            setting.setText("Rahmen");

        } else if (str != null && str.hashCode() == 3121) {    // ar

            lan.setText("لغة");
            font.setText("الخط");
            size.setText("بحجم");
            bg.setText("خلفية الدراسة");
            wColor.setText("اللون الأبيض للنص");
            setting.setText("ضبط");
            lanShow.setVerticalGravity(View.LAYOUT_DIRECTION_LTR);

        } else {    //en


        }
    }




}