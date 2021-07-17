package app.riju.applanguagechange;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text, dialog_language;
    int lang_selected;
    RelativeLayout show_lan_dialog;

    TextView firstName_TV, lastName_TV, phoneNumber_TV, email_TV, formTitle;
    EditText firstName_ET, lastName_ET, phoneNumber_ET, email_ET;
    Button submitBtn;

    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        dialog_language = findViewById(R.id.dialog_language);
        show_lan_dialog = findViewById(R.id.showlangdialog);

        firstName_TV = findViewById(R.id.firstName_TV);
        firstName_ET = findViewById(R.id.firstName_ET);
        lastName_TV = findViewById(R.id.lastName_TV);
        lastName_ET = findViewById(R.id.lastName_ET);
        phoneNumber_TV = findViewById(R.id.phoneNumber_TV);
        phoneNumber_ET = findViewById(R.id.phoneNumber_ET);
        email_TV = findViewById(R.id.email_TV);
        email_ET = findViewById(R.id.email_ET);

        formTitle=findViewById(R.id.formTitle);
        submitBtn = findViewById(R.id.submitBtn);

        if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en")) {
            context = LocaleHelper.setLocale(MainActivity.this, "en");
            resources = context.getResources();

            lang_selected = 0;

            dialog_language.setText("ENGLISH");

            text.setText(resources.getString(R.string.text));
            setTitle(resources.getString(R.string.app_name));

            setString();

        } else if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("hi")) {
            context = LocaleHelper.setLocale(MainActivity.this, "hi");
            resources = context.getResources();

            lang_selected = 1;

            dialog_language.setText("हिंदी");

            text.setText(resources.getString(R.string.text));
            setTitle(resources.getString(R.string.app_name));

            setString();

        } else if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("bn")) {
            context = LocaleHelper.setLocale(MainActivity.this, "bn");
            resources = context.getResources();

            lang_selected = 2;

            dialog_language.setText("বাংলা");

            text.setText(resources.getString(R.string.text));
            setTitle(resources.getString(R.string.app_name));

            setString();

        }

        show_lan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] Language = {"ENGLISH", "हिंदी", "বাংলা"};

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("SELECT A LANGUAGE")
                        .setSingleChoiceItems(Language, lang_selected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog_language.setText(Language[i]);

                                if (Language[i].equals("ENGLISH")) {
                                    context = LocaleHelper.setLocale(MainActivity.this, "en");
                                    resources = context.getResources();

                                    lang_selected = 0;

                                    //dialog_language.setText("ENGLISH");

                                    text.setText(resources.getString(R.string.text));
                                    setTitle(resources.getString(R.string.app_name));

                                    setString();
                                }
                                if (Language[i].equals("हिंदी")) {
                                    context = LocaleHelper.setLocale(MainActivity.this, "hi");
                                    resources = context.getResources();

                                    lang_selected = 1;

                                    //dialog_language.setText("ENGLISH");

                                    text.setText(resources.getString(R.string.text));
                                    setTitle(resources.getString(R.string.app_name));

                                    setString();
                                }
                                if (Language[i].equals("বাংলা")) {
                                    context = LocaleHelper.setLocale(MainActivity.this, "bn");
                                    resources = context.getResources();

                                    lang_selected = 2;

                                    //dialog_language.setText("ENGLISH");

                                    text.setText(resources.getString(R.string.text));
                                    setTitle(resources.getString(R.string.app_name));
                                    setString();
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
    void setString(){
        firstName_TV.setText(resources.getString(R.string.first_name));
        lastName_TV.setText(resources.getString(R.string.last_name));
        email_TV.setText(resources.getString(R.string.email));
        phoneNumber_TV.setText(resources.getString(R.string.phone_number));

        firstName_ET.setHint(resources.getString(R.string.enter_your_first_name));
        lastName_ET.setHint(resources.getString(R.string.enter_your_last_name));
        email_ET.setHint(resources.getString(R.string.enter_your_email_id));
        phoneNumber_ET.setHint(resources.getString(R.string.enter_your_phone_number));

        formTitle.setText(resources.getString(R.string.fill_form));
        submitBtn.setText(resources.getString(R.string.submit));
    }
}