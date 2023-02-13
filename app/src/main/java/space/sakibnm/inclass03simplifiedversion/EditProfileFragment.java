package space.sakibnm.inclass03simplifiedversion;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditProfileFragment extends Fragment{
    private Profile profile;
    private String name,email,age;
    private int avatarDrawable;


    private EditText editTextName, editTextEmail, editTextAge;
    private ImageView imageViewAvatar;
    private Button buttonSubmit;

    private InterfaceToInClass03Activity fromEditToActivity;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    public static EditProfileFragment newInstance() {
        EditProfileFragment fragment = new EditProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creating the empty profile....
        profile = new Profile();

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Setting the title of the screen...
        getActivity().setTitle("Edit Profile Screen");
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_edit_profile, container, false);

//        defining the UI elements....
        editTextName = rootView.findViewById(R.id.editTextName);
        editTextEmail = rootView.findViewById(R.id.editTextEmailAddress);
        editTextAge = rootView.findViewById(R.id.editTextAge);
        imageViewAvatar = rootView.findViewById(R.id.imageViewAvatar);
        buttonSubmit = rootView.findViewById(R.id.buttonSubmit);

        imageViewAvatar.setOnClickListener(this::onSelectAvatarClicked); // Select avatar clicked...
        buttonSubmit.setOnClickListener(this::onSubmitButtonClicked); // Submit Button clicked...

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getArguments() != null){
            Bundle receivedData = getArguments();
            // Checking if we have a new selected avatar here.....
            if(receivedData.containsKey(Tags.TAG_ARG_DRAWABLW_ID)){
                avatarDrawable = receivedData.getInt(Tags.TAG_ARG_DRAWABLW_ID);
                imageViewAvatar.setImageResource(avatarDrawable);
            }
        }
    }

    // On Select Avatar Clicked....
    private void onSelectAvatarClicked(View view) {
        fromEditToActivity.selectAvatarClickedInEditProfile();
    }

    // On Submit button clicked....
    private void onSubmitButtonClicked(View view) {
        //TODO: validation checks, update the profile, and send the profile object to activity....
        //Omitting validation for this example...
        name = String.valueOf(editTextName.getText());
        email = String.valueOf(editTextEmail.getText());
        age = String.valueOf(editTextAge.getText());

        profile.setName(name);
        profile.setEmail(email);
        profile.setAge(age);
        profile.setAvatarDrawable(avatarDrawable);

        //sending the profile object to Activity......
        fromEditToActivity.submitButtonClickedInEditProfile(profile);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof InterfaceToInClass03Activity){
            fromEditToActivity = (InterfaceToInClass03Activity) context;
        }else {
            throw new RuntimeException(context.toString()+ "must implement InterfaceFromEditToActivity");
        }

    }
}