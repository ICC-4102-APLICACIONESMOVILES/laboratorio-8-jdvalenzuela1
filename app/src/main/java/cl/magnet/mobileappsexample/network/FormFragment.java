package cl.magnet.mobileappsexample.network;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import cl.magnet.mobileappsexample.R;
import cl.magnet.mobileappsexample.db.AppDatabase;
import cl.magnet.mobileappsexample.db.Form;
import cl.magnet.mobileappsexample.db.FormViewModel;

/**
 * Created by lenovo on 29-05-2018.
 */

public class FormFragment  extends Fragment {
    Button agregar;
    EditText formtext;
    DatePicker fecha;
    private static final String DATABASE_NAME = "app_database";
    private AppDatabase formDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final FormViewModel mFormViewProvider = ViewModelProviders.of(this).get(FormViewModel.class);

        agregar = (Button) getActivity().findViewById(R.id.agregar);
        formtext = (EditText) getActivity().findViewById(R.id.formtext);
        fecha = (DatePicker) getActivity().findViewById(R.id.fecha);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formtext.getText().toString().equals("") || Integer.toString(fecha.getYear()).equals("")) {
                    Toast.makeText(getActivity(), "Faltan datos por completar", Toast.LENGTH_LONG).show();
                } else {

                    String formtextString = formtext.getText().toString();
                    String fechaString = Integer.toString(fecha.getYear()) + "/" + Integer.toString(fecha.getMonth()) + "/" + Integer.toString(fecha.getDayOfMonth());

                    Form form = new Form();
                    form.setName(formtextString);
                    form.setDate(fechaString);

                    ArrayList<Form> listaForms = new ArrayList<Form>();
                    listaForms.add(form);

                    mFormViewProvider.insert(listaForms);

                    Toast.makeText(getActivity(), "Formulario Guardado con exito", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
