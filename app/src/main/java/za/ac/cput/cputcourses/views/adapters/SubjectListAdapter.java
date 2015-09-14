package za.ac.cput.cputcourses.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import za.ac.cput.cputcourses.R;
import za.ac.cput.cputcourses.model.Subject;

/**
 * Created by chantell witbooi on 9/13/2015.
 */
public class SubjectListAdapter extends ArrayAdapter<Subject> {
    private Subject[] values;
    public SubjectListAdapter(Context context, int resource, Subject[] values) {
        super(context, resource, values);
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.subject_list_row, null);
        }

        TextView subjectListCode = (TextView) view.findViewById(R.id.subject_list_code);
        TextView subjectListName = (TextView) view.findViewById(R.id.subject_list_name);
        subjectListCode.setText(values[position].getCode());
        subjectListName.setText(values[position].getName());
        return view;

    }
}
