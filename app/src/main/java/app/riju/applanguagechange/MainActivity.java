package app.riju.applanguagechange;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text, dialog_language;
    int lang_selected;
    RelativeLayout show_lan_dialog;

    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text);
        dialog_language=findViewById(R.id.dialog_language);
        show_lan_dialog=findViewById(R.id.showlangdialog);

        if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en")){
            context = LocaleHelper.setLocale(MainActivity.this,"en");
            resources =context.getResources();

            lang_selected = 0;

            dialog_language.setText("ENGLISH");

            text.setText(resources.getString(R.string.text));
            setTitle(resources.getString(R.string.app_name));
        }
        else if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("hi")){
            context = LocaleHelper.setLocale(MainActivity.this,"hi");
            resources =context.getResources();

            lang_selected = 1;

            dialog_language.setText("हिंदी");

            text.setText(resources.getString(R.string.text));
            setTitle(resources.getString(R.string.app_name));
        }
        else if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("bn")){
            context = LocaleHelper.setLocale(MainActivity.this,"bn");
            resources =context.getResources();

            lang_selected = 2;

            dialog_language.setText("বাংলা");

            text.setText(resources.getString(R.string.text));
            setTitle(resources.getString(R.string.app_name));
        }

        show_lan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  String[] Language= {"ENGLISH","हिंदी","বাংলা"};

                final AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("SELECT A LANGUAGE")
                        .setSingleChoiceItems(Language, lang_selected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog_language.setText(Language[i]);

                                if (Language[i].equals("ENGLISH")){
                                    context = LocaleHelper.setLocale(MainActivity.this,"en");
                                    resources =context.getResources();

                                    lang_selected = 0;

                                    //dialog_language.setText("ENGLISH");

                                    text.setText(resources.getString(R.string.text));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                                if (Language[i].equals("हिंदी")){
                                    context = LocaleHelper.setLocale(MainActivity.this,"hi");
                                    resources =context.getResources();

                                    lang_selected = 1;

                                    //dialog_language.setText("ENGLISH");

                                    text.setText(resources.getString(R.string.text));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                                if (Language[i].equals("বাংলা")){
                                    context = LocaleHelper.setLocale(MainActivity.this,"bn");
                                    resources =context.getResources();

                                    lang_selected = 2;

                                    //dialog_language.setText("ENGLISH");

                                    text.setText(resources.getString(R.string.text));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }
}