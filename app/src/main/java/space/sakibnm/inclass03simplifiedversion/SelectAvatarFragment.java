package space.sakibnm.inclass03simplifiedversion;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SelectAvatarFragment extends Fragment {
    private ImageView imageViewAvatar1;
    private ImageView imageViewAvatar2;

    private int drawableID;

    private InterfaceToInClass03Activity fromSelectAvatarToActivity;

    public SelectAvatarFragment() {
        // Required empty public constructor
    }

    public static SelectAvatarFragment newInstance() {
        SelectAvatarFragment fragment = new SelectAvatarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Select Avatar");
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_select_avatar, container, false);
        imageViewAvatar1 = rootView.findViewById(R.id.imageViewSelectAvatar1);
        imageViewAvatar2 = rootView.findViewById(R.id.imageViewSelectAvatar2);

        imageViewAvatar1.setOnClickListener(this::clickedOnAvatar1);
        imageViewAvatar2.setOnClickListener(this::clickedOnAvatar2);

        return rootView;
    }

    //Avatar 1 selected, sending back the drawable ID for the avatar....
    private void clickedOnAvatar1(View view) {
        fromSelectAvatarToActivity.avatarClickedInSelectAvatar(R.drawable.avatar_1);
    }

    //Avatar 2 selected, sending back the drawable ID for the avatar....
    private void clickedOnAvatar2(View view) {
        fromSelectAvatarToActivity.avatarClickedInSelectAvatar(R.drawable.avatar_2);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof InterfaceToInClass03Activity){
            fromSelectAvatarToActivity = (InterfaceToInClass03Activity) context;
        }else{
            throw new RuntimeException(context.toString()+ "must implement InterfaceFromSelectAvatarToActivity");
        }
    }
}