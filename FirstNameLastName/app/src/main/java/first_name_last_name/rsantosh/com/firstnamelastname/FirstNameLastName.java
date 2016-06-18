package first_name_last_name.rsantosh.com.firstnamelastname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import first_name_last_name.rsantosh.com.firstnamelastname.Adapter.FirstNameLastNameAdapter;
import first_name_last_name.rsantosh.com.firstnamelastname.DBHelper.DBHelper;
import first_name_last_name.rsantosh.com.firstnamelastname.Model.FirstNameLastNameModel;

public class FirstNameLastName extends AppCompatActivity {

    private ArrayList<FirstNameLastNameModel> mArray;
    private FirstNameLastNameAdapter mFirstNameLastNameAdapter;
    private DBHelper mDbhelper;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_name_last_name);

        mArray = new ArrayList<>();
        mDbhelper = new DBHelper(getApplicationContext());

        mArray = mDbhelper.getData();

        mFirstNameLastNameAdapter = new FirstNameLastNameAdapter(this,R.layout.first_name_ite,mArray);

        mListView = (ListView) findViewById(R.id.fname_lname);

        mListView.setAdapter(mFirstNameLastNameAdapter);

    }
}
