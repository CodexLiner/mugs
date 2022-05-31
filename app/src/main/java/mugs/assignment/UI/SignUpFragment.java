package mugs.assignment.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import mugs.assignment.R;
import mugs.assignment.databinding.FragmentSignUpBinding;
import mugs.assignment.utils.common;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;
    private FirebaseAuth auth;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUpFragment() {
        // Required empty public constructor
    }
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentSignUpBinding.inflate(inflater);
       auth = FirebaseAuth.getInstance();
       binding.backLogin.setOnClickListener(v->{
           requireActivity().onBackPressed();
       });
       binding.sendOtpButton.setOnClickListener(v->{
           if (!(common.isEmpty(binding.userName) && common.isEmpty(binding.userEmail) && common.isEmpty(binding.password))){
               Toast.makeText(requireContext(), "calling", Toast.LENGTH_SHORT).show();
               nextStep();
           }
       });
       return binding.getRoot();
    }

    private void nextStep() {
        auth.createUserWithEmailAndPassword(binding.userEmail.getText().toString() , binding.password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()){
                   Toast.makeText(requireContext(), "sss", Toast.LENGTH_SHORT).show();
               }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("TAG", "onFailure: "+e);
            }
        });
    }
}