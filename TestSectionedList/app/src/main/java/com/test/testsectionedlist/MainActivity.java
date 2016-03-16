package com.test.testsectionedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private OnVersionNameSelectionChangeListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.version_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<DataModal> dataModalList = new ArrayList<DataModal>();
        dataModalList.add(new DataModal("Label1", "Description1"));
        dataModalList.add(new DataModal("Label2", "Description2"));
        dataModalList.add(new DataModal("Label3", "Description3"));
        dataModalList.add(new DataModal("Label4", "Description4"));
        dataModalList.add(new DataModal("Label5", "Description5"));

        RecyclerAdapter adapter = new RecyclerAdapter(this, dataModalList);
        adapter.setListener(mListener);
        List<RecyclerSectionedList.Section> sectionList = prepareSectionList();
        RecyclerSectionedList.Section[] sectionArray = new RecyclerSectionedList.Section[sectionList.size()];
        RecyclerSectionedList sectionedAdapter = new
                RecyclerSectionedList(this, R.layout.section_layout, R.id.section_title, adapter);
        sectionedAdapter.setSections(sectionList.toArray(sectionArray));
        mRecyclerView.setAdapter(sectionedAdapter);
    }

    private List<RecyclerSectionedList.Section> prepareSectionList() {
        List<RecyclerSectionedList.Section> sections =
                new ArrayList<RecyclerSectionedList.Section>();
        sections.add(new RecyclerSectionedList.Section(0, "Section 1"));
        sections.add(new RecyclerSectionedList.Section(2, "Section 2"));
        return sections;
    }

}
