package pane.multi.test.com.testmultipanefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescriptionFragment extends Fragment {
    final static String KEY_POSITION = "position";
    private int mCurrentPosition = -1;
    private String[] mVersionDescriptions;
    private TextView mVersionDescriptionTextView;

    public DescriptionFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mVersionDescriptions = getResources().getStringArray(R.array.version_descriptions);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // If the Activity is recreated, the savedInstanceStare Bundle isn't empty
        // we restore the previous version name selection set by the Bundle.
        // This is necessary when in two pane layout
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(KEY_POSITION);
        }

        View view = inflater.inflate(R.layout.fragment_description, container, false);
        mVersionDescriptionTextView = (TextView) view.findViewById(R.id.version_description);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            // Set description based on argument passed in
            setDescription(args.getInt(KEY_POSITION));
        } else if (mCurrentPosition > -1) {
            // Set description based on savedInstanceState defined during onCreateView()
            setDescription(mCurrentPosition);
        }
    }

    public void setDescription(int descriptionIndex) {
        mVersionDescriptionTextView.setText(mVersionDescriptions[descriptionIndex]);
        mCurrentPosition = descriptionIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current description selection in case we need to recreate the fragment
        outState.putInt(KEY_POSITION, mCurrentPosition);
    }

}
