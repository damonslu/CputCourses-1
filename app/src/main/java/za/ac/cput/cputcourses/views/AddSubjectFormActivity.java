package za.ac.cput.cputcourses.views;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import za.ac.cput.cputcourses.R;
import za.ac.cput.cputcourses.model.Subject;
import za.ac.cput.cputcourses.respositories.rest.RestSubjectAPI;

public class AddSubjectFormActivity extends Activity {
    private RestSubjectAPI restSubjectAPI = new RestSubjectAPI();
    EditText inputCode;
    EditText inputName;
    Button saveSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course_form);
        inputName = (EditText) findViewById(R.id.input_subject_name);
        inputCode = (EditText) findViewById(R.id.input_subject_code);
        saveSubject = (Button) findViewById(R.id.save_button);

        saveSubject.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new saveSubject().execute();

            }
        });


    }

    private class saveSubject extends AsyncTask<Void, Void, Void> {

        public Subject CreateSubject() {
            Subject newSubject = new Subject();
            String name = inputName.getText().toString();
            String code = inputCode.getText().toString();
            newSubject.setName(name);
            newSubject.setCode(code);
            return newSubject;

        }

        @Override
        protected Void doInBackground(Void ... params) {
            Subject sub;
            try{
                sub = CreateSubject();
                restSubjectAPI.post(sub);

            } catch (Exception e) {
                Log.e("log_tag", "Error:  " + e.toString());
            }
            return null;
        }



    }

}
