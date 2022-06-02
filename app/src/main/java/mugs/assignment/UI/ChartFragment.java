package mugs.assignment.UI;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.eazegraph.lib.models.PieModel;

import mugs.assignment.R;
import mugs.assignment.databinding.FragmentChartBinding;

public class ChartFragment extends Fragment {
    private FragmentChartBinding binding;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChartFragment() {
        // Required empty public constructor
    }
    public static ChartFragment newInstance(String param1, String param2) {
        ChartFragment fragment = new ChartFragment();
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
        binding = FragmentChartBinding.inflate(inflater);
//        binding.tvR.setText(Integer.toString(40));
//        binding.tvPython.setText(Integer.toString(30));
//        binding.tvCPP.setText(Integer.toString(5));
//        binding.tvJava.setText(Integer.toString(25));
        // Set the data and color to the pie chart

        binding.piechart.addPieSlice(new PieModel("Freetime", 40, Color.parseColor("#FE6DA8")));
        binding.piechart.addPieSlice(new PieModel("Sleep", 30, Color.parseColor("#56B7F1")));
        binding.piechart.addPieSlice(new PieModel("Work", 20, Color.parseColor("#CDA67F")));
        binding.piechart.addPieSlice(new PieModel("Eating", 10, Color.parseColor("#FED70E")));
        binding.piechart.startAnimation();
        return binding.getRoot();
    }
}