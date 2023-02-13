package space.sakibnm.inclass03simplifiedversion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayFragment extends Fragment {

    private static final String ARG_ProfileObj = "profile";

    private Profile profile;

    private TextView textViewDisplayName, textViewDisplayEmail, textViewDisplayAge;
    private ImageView imageViewAvatar;


    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance(Profile profile) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ProfileObj, profile);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profile = getArguments().getParcelable(ARG_ProfileObj);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Display Profile");
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_display, container, false);
        textViewDisplayName = rootView.findViewById(R.id.textViewDisplayName);
        textViewDisplayEmail = rootView.findViewById(R.id.textViewDisplayEmail);
        textViewDisplayAge = rootView.findViewById(R.id.textViewDisplayAge);
        imageViewAvatar = rootView.findViewById(R.id.imageViewDisplayAvatar);

        textViewDisplayName.setText(profile.getName());
        textViewDisplayEmail.setText(profile.getEmail());
        textViewDisplayAge.setText(profile.getAge());
        imageViewAvatar.setImageResource(profile.getAvatarDrawable());
        return rootView;
    }
}