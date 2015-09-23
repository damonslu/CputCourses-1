package za.ac.cput.cputcourses.views;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import za.ac.cput.cputcourses.R;
import za.ac.cput.cputcourses.model.Subject;
import za.ac.cput.cputcourses.respositories.rest.RestSubjectAPI;

/**
 * Created by chantell witbooi on 9/23/2015.
 */
public class ViewSubjectActivity extends Activity {

    private RestSubjectAPI restSubjectAPI = new RestSubjectAPI();
    EditText inputCode;
    EditText inputName;
    Button editSubject;
    Button deleteSubject;
    long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_subject_details);
        inputName = (EditText) findViewById(R.id.view_input_subject_name);
        inputCode = (EditText) findViewById(R.id.view_input_subject_code);

        id = getIntent().getExtras().getLong("id");
        inputName.setText(getIntent().getExtras().getString("name"));
        inputCode.setText(getIntent().getExtras().getString("code"));

        editSubject = (Button) findViewById(R.id.edit_button);
        deleteSubject = (Button) findViewById(R.id.delete_button);
//        editSubject.setEnabled(false);
//        deleteSubject.setEnabled(false);



        editSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new editSubject().execute();
            }
        });

        deleteSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new deleteSubject().execute();

            }
        });

        //Add a back button that will execute a task getting a list of all subjects again(so that your list can be updated with the edited/deleted items.

    }

    private class editSubject extends AsyncTask<Void, Void, Void> {
        public Subject CreateSubject() {
            Subject newSubject = new Subject();
            long subjectId = id;
            String name = inputName.getText().toString();
            String code = inputCode.getText().toString();
            newSubject.setId(subjectId);
            newSubject.setName(name);
            newSubject.setCode(code);
            return newSubject;
        }

        @Override
        protected Void doInBackground(Void ... params) {
            Subject sub = CreateSubject();
            restSubjectAPI.put(sub);
            return null;
        }



    }

    private class deleteSubject extends AsyncTask<Void, Void, Void> {
        public Subject CreateSubject() {
            Subject newSubject = new Subject();
            long subjectId = id;
            String name = inputName.getText().toString();
            String code = inputCode.getText().toString();
            newSubject.setId(subjectId);
            newSubject.setName(name);
            newSubject.setCode(code);
            return newSubject;
        }
        @Override
        protected Void doInBackground(Void ... params) {
            Subject sub = CreateSubject();
            restSubjectAPI.delete(sub);
            return null;
        }



    }

}



