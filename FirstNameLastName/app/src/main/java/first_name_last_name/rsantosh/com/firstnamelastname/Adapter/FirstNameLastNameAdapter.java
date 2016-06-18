package first_name_last_name.rsantosh.com.firstnamelastname.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import first_name_last_name.rsantosh.com.firstnamelastname.Model.FirstNameLastNameModel;
import first_name_last_name.rsantosh.com.firstnamelastname.R;

/**
 * Created by C S Ramachandran on 17-06-2016.
 */
public class FirstNameLastNameAdapter extends ArrayAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<FirstNameLastNameModel> mArray;

    public FirstNameLastNameAdapter(Context context, int resource,ArrayList<FirstNameLastNameModel> mArray) {
        super(context, resource);
        this.mContext = context;
        this.mLayoutInflater = mLayoutInflater.from(context);
        this.mArray = mArray;
    }

    @Override
    public int getCount() {
        return mArray.size();
    }

    @Override
    public Object getItem(int position) {
        return mArray.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = mLayoutInflater.inflate(R.layout.first_name_ite,parent,false);

        }

        TextView mTextViewId;
        TextView mTextViewFname;
        TextView mTextViewLname;

        mTextViewId = (TextView) convertView.findViewById(R.id.name_id);
        mTextViewFname = (TextView) convertView.findViewById(R.id.first_name);
        mTextViewLname = (TextView) convertView.findViewById(R.id.last_name);

        FirstNameLastNameModel firstNameLastNameModel = (FirstNameLastNameModel) getItem(position);

        mTextViewId.setText("Id : " + String.valueOf(firstNameLastNameModel.strId + ","));
        mTextViewFname.setText("First Name : " + firstNameLastNameModel.strFName + ",");
        mTextViewLname.setText("Last Name : " + firstNameLastNameModel.strLName);

        return convertView;
    }
}
