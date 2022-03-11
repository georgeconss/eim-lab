package ro.pub.cs.systems.eim.lab01.myfirstandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final private static long TRANSPARENCY_EFFECT_DURATION = 5000;

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText userNameEditText = (EditText)findViewById(R.id.user_name_edit_text);
            TextView greetingTextView = (TextView)findViewById(R.id.greeting_text_view);
            greetingTextView.setAlpha(1);

            // TODO: exercise 9a
            greetingTextView.setText(greetingTextView.getText().toString().replace("xxx", userNameEditText.getText()));
            // TODO: exercise 9b
            final AlphaAnimation fadeEffect = new AlphaAnimation(0.f, 1.f);
            fadeEffect.setDuration(TRANSPARENCY_EFFECT_DURATION);
            fadeEffect.setFillAfter(true);
            greetingTextView.setAnimation(fadeEffect);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button)findViewById(R.id.submit_button);
        submitButton.setOnClickListener(buttonClickListener);
    }
}
