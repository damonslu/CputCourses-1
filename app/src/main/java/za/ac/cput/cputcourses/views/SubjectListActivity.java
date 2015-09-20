package za.ac.cput.cputcourses.views;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.cputcourses.R;
import za.ac.cput.cputcourses.model.Subject;
import za.ac.cput.cputcourses.respositories.rest.RestSubjectAPI;
import za.ac.cput.cputcourses.views.adapters.SubjectListAdapter;

public class SubjectListActivity extends Activity{
    private RestSubjectAPI restSubjectAPI = new RestSubjectAPI();
    List<Subject> subjectList = new ArrayList<Subject>();
    ListView subjectsList;
    SubjectListAdapter adapter ;
    Subject[] subjectsl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);
        subjectsList = (ListView) findViewById(R.id.list);
        new GetSubjectsTask().execute();
    }


     class GetSubjectsTask extends AsyncTask<Void, Void, List<Subject>> {
        List<Subject> subjects = new ArrayList<Subject>();

        protected List<Subject> doInBackground(Void... params) {
            subjects = restSubjectAPI.getAll();
            return subjects;
        }
         protected void onPostExecute( List<Subject> subjects) {
             subjectList = subjects;
             subjectsl = subjectList.toArray(new Subject[subjectList.size()]);
             adapter = new SubjectListAdapter(SubjectListActivity.this, R.id.list, subjectsl);
             subjectsList.setAdapter(adapter);

         }

    }

}