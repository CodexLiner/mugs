package mugs.assignment.UI;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

import mugs.assignment.R;
import mugs.assignment.databinding.FragmentLoginBinding;
import mugs.assignment.utils.change;
import mugs.assignment.utils.changeHelper;
import mugs.assignment.utils.common;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding ;
    private FirebaseAuth auth;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentLoginBinding.inflate(inflater);
      auth = FirebaseAuth.getInstance();
      binding.sendOtpButton.setOnClickListener(v->{
          nextStep();
      });
      binding.signUp.setOnClickListener(v->{
          new change(new changeHelper(requireActivity().getSupportFragmentManager() , R.id.MainFrame))
                  .go(SignUpFragment.class);
      });
      if (common.isEmpty(binding.mobileText) && common.isEmpty(binding.password)){
          nextStep();
      }
      return binding.getRoot();
    }
    private void nextStep() {
        auth.signInWithEmailAndPassword("", "").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //TODO:HOME ACTIVITY
                }else{
                    Toast.makeText(requireContext(), "Sign In Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}