package gidm.es.appmulti;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SensoresFragment extends Fragment {

    private static final String TAG = "SensoresFragment";


    public SensoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG,getClass().getSimpleName()+":entra en onCreateView()");
        return inflater.inflate(R.layout.fragment_sensores,container,false);
    }

    public interface LisSelectionListener {
    }
}
