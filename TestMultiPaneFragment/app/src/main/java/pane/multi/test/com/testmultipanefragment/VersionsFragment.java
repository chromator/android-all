package pane.multi.test.com.testmultipanefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class VersionsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private OnVersionNameSelectionChangeListener mListener;

    public VersionsFragment() {}

    public VersionsFragment(OnVersionNameSelectionChangeListener listener) {
        mListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_versions, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.version_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<DataModal> dataModalList = new ArrayList<DataModal>();
        dataModalList.add(new DataModal("Label1", "Description1"));
        dataModalList.add(new DataModal("Label2", "Description2"));
        dataModalList.add(new DataModal("Label3", "Description3"));
        dataModalList.add(new DataModal("Label4", "Description4"));
        dataModalList.add(new DataModal("Label5", "Description5"));

        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), dataModalList);
        adapter.setListener(mListener);
        mRecyclerView.setAdapter(adapter);
    }

}
