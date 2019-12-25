package com.example.polichudes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


public class Main3Activity extends AppCompatActivity {

    //region Bayroqlar Rasmi
    int[] bayroqlar = new int[]{
            R.drawable.aqsh,
            R.drawable.braziliya,
            R.drawable.janubiy_koreya,
            R.drawable.portugaliya,
            R.drawable.rossiya,
            R.drawable.shimoliy_koreya,
            R.drawable.tojikiston,
            R.drawable.turkiya,
            R.drawable.ukraina,
            R.drawable.urugvay,
            R.drawable.uzbekistan,
            R.drawable.vietnam
    };
    //endregion

    //region Bayroq Nomlari
    String[] bayroq_nomi = new String[]{
            "Aqsh",
            "braziliya",
            "janubiy koreya",
            "portugaliya",
            "Rossiya",
            "shimoliy koreya",
            "tojikiston",
            "turkiya",
            "ukraina",
            "uruguay",
            "Uzbekistan",
            "vietnam"
    };
    //endregion

    //region Mashina Rasmi
    int[] mashina = new int[]{
            R.drawable.aveo5,
            R.drawable.beat,
            R.drawable.captiva,
            R.drawable.colorado,
            R.drawable.epica,
            R.drawable.malibu,
            R.drawable.matiz,
            R.drawable.orlando,
            R.drawable.spark,
            R.drawable.tracker
    };
    //endregion

    //region Mashina Nomi
    String[] mashina_nomi = new String[]{
            "aveo5",
            "beat",
            "captiva",
            "colorado",
            "epica",
            "malibu",
            "matiz",
            "orlando",
            "spark",
            "tracker"

    };
    //endregion

    //region Aktyor
    int[] aktyor = new int[]{
            R.drawable.yodgor_sadiyev,
            R.drawable.sitora_farmonova,
            R.drawable.shahzoda,
            R.drawable.rajab_adashev,
            R.drawable.otabek_mahkamov,
            R.drawable.obid_asomov,
            R.drawable.jamshid_zokirov,
            R.drawable.murod_rajabov,
            R.drawable.gani_agzamov,
            R.drawable.dilnoz_kubayeva
    };
//endregion

    //region Aktyorning FIO
    String[] aktyor_fio = new String[]{
            "yodgor sadiyev",
            "sitora farmonova",
            "shahzoda",
            "rajab adashev",
            "otabek mahkamov",
            "obid asamov",
            "jamshid zokirov",
            "murod rajabov",
            "gani agzamov",
            "dilnoz kubayeva"
    };
//endregion

    //region Ovqatlar
    int[] ovqat = new int[]{
            R.drawable.ovqat_manti,
            R.drawable.ovqat_osh,
            R.drawable.ovqat_qazi,
            R.drawable.ovqat_tandir,
            R.drawable.ovqat_somsa,
            R.drawable.ovqat_shurva,
            R.drawable.ovqat_manti2,
            R.drawable.ovqat_qozon_kabob,
            R.drawable.ovqat_shorva2,
            R.drawable.ovqat_shashlik,
            R.drawable.ovqat_qovurma,
            R.drawable.ovqat_shashlik2,
            R.drawable.ovqat_qovurma2
    };
    //endregion

    //region Ovqat Nomi
    String[] ovqat_nomi = new String[]{
            "Manti",
            "Osh", "Qazi", "Tandir", "somsa", "Shurva", "Manti", "Qozon kabob", "Shorva", "Shashlik",
            "Qovurma", "Shashlik", "Qovurma"
    };
    //endregion

    //region Salatlar
    int[] salat = new int[]{
            R.drawable.salat1,
            R.drawable.salat2,
            R.drawable.salat3,
            R.drawable.salat4,
            R.drawable.salat5,
            R.drawable.salat6,
            R.drawable.salat7,
            R.drawable.salat8,
            R.drawable.salat9,
            R.drawable.salat10,
            R.drawable.salat11,
            R.drawable.salat12,
            R.drawable.salat13,
            R.drawable.salat14,
            R.drawable.salat15
    };
//endregion

    //region Salat Nomi
    String[] salat_nomi = new String[]{
            "Salat1",
            "Salat2",
            "Salat3",
            "Salat4",
            "Salat5",
            "Salat6",
            "Salat7",
            "Salat8",
            "Salat9",
            "Salat10",
            "Salat11",
            "Salat12",
            "Salat13",
            "Salat14",
            "Salat15"
    };
    //endregion

    //region Ozgaruvchilar
    private TextView tv, tv_true, tv_false;
    private EditText editText;
    private ProgressBar bar;
    private Thread thread = new Thread();
    private int index = 0;
    private Handler handler = new Handler();
    private ImageSwitcher imageSwitcher;
    private Button button;
    private int progress = 0;
    private int status = 0, t_sum = 0, x_sum;

    //endregion

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //region A1
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv = findViewById(R.id.savollar);
        imageSwitcher = findViewById(R.id.imageSwitcher);
        button = findViewById(R.id.btn_next);
        tv_true = findViewById(R.id.tv_togri);
        tv_false = findViewById(R.id.tv_xato);
        bar = findViewById(R.id.progressbar1);
        editText = findViewById(R.id.t4);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        int id = bundle.getInt("Id");
        tv_true.setText("0");
        tv_false.setText("0");
        //endregion

        //region Salat
        if (id == 4) {
            tv.setText((index + 1) + "/" + salat.length);
            progress = 300;
            startProgress(progress);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startgame(salat_nomi, salat, "Salat nomini kiriting!!!");
                }
            });
        }
        //endregion

        //region Ovqat
        if (id == 3) {
            tv.setText((index + 1) + "/" + ovqat.length);
            progress = 300;
            startProgress(progress);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startgame(ovqat_nomi, ovqat, "Ovqat nomini kiriting!!!");
                }
            });
        }
        //endregion

        //region Aktyor
        if (id == 2) {
            tv.setText((index + 1) + "/" + aktyor.length);
            progress = 300;
            startProgress(progress);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startgame(aktyor_fio, aktyor, "Aktyorning Ism Familiyasini kiriting!!!");
                }
            });
        }
        //endregion

        //region Mashina
        if (id == 1) {
            tv.setText((index + 1) + "/" + mashina.length);
            progress = 240;
            startProgress(progress);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startgame(mashina_nomi, mashina, "Mashina nomini kiriting!!!");
                }
            });
        }
        //endregion

        //region Bayroq
        if (id == 0) {
            tv.setText((index + 1) + "/" + bayroqlar.length);
            progress = 300;
            startProgress(progress);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startgame(bayroq_nomi, bayroqlar, "Davlat nomini kiriting!!!");
                }
            });
        }
        //endregion

        //region Rasim Animatsiyasi
        if (imageSwitcher != null) {
            imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    ImageView imageView = new ImageView(getApplicationContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    return imageView;
                }
            });
        }
        assert imageSwitcher != null;
        if (id == 2) {
            imageSwitcher.setImageResource(aktyor[index]);
        }
        if (id == 4) {
            imageSwitcher.setImageResource(salat[index]);
        }
        if (id == 3) {
            imageSwitcher.setImageResource(ovqat[index]);
        }
        if (id == 0) {
            imageSwitcher.setImageResource(bayroqlar[index]);
        }
        if (id == 1) {
            imageSwitcher.setImageResource(mashina[index]);
        }
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        imageSwitcher.setInAnimation(in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        imageSwitcher.setOutAnimation(out);
        //endregion
    }

    private void startgame(String[] name, int[] massiv, String toast) {

        String s = editText.getText().toString();

        if (s.length() == 0) {
            Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();

        } else {
            if (name[index].toLowerCase().equals(s.toLowerCase())) {
                ++t_sum;
                tv_true.setText(String.valueOf(t_sum));
            } else {
                ++x_sum;
                tv_false.setText(String.valueOf(x_sum));
            }

            index = (++index < massiv.length) ? index : 0;
            if (index == 0) {
                button.setEnabled(false);
            } else {
                imageSwitcher.setImageResource(massiv[index]);
                tv.setText((index + 1) + "/" + massiv.length);
                editText.setText("");
            }

        }


    }

    public void startProgress(int p) {
        bar.setMax(p);
        bar.setProgress(p);
        status = p;
        thread.interrupt();
        thread = new Thread(new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                while (status > 0) {
                    status -= 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {
                            bar.setProgress(status);
                        }
                    });

                }
            }
        });
        thread.start();
    }
}
