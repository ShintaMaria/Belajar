package com.example.belajar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class SecondFragment extends Fragment{
    View view;
    Button firstButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Using LayoutInflater to convert XML file first_fragment.xml into a View object,
        // and saving that reference in the 'view' variable. Since this is a fragment,
        // we don't need to attach it to the ViewGroup container yet, so false is passed.
        view = inflater.inflate(R.layout.activity_second_fragment, container, false);

        // Finding a button with the ID firstButton in the layout fragment and assigning it to the variable firstButton.
        Button secondButton = view.findViewById(R.id.secondButton);

        // Setting an OnClickListener to the firstButton to handle the event when the button is clicked.
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Displaying a short toast message saying "First Fragment" when the firstButton is clicked.
                // getActivity() is used to get the context of the activity associated with the fragment.
                Toast.makeText(getActivity(), "Second Fragment", Toast.LENGTH_SHORT).show();
            }
        });

        // Returning the 'view' object, which contains the fragment layout to be displayed within the activity.
        return view;
    }
}