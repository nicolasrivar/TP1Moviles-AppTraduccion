package com.ulpmovil.tp1;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> mMensaje;
    private List<Palabra> palabras;

    public LiveData<String> getMmensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();
        }
        return mMensaje;
    }

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        palabras = new ArrayList<>();
        palabras.add(new Palabra("vaca", "cow", R.drawable.vaca));
        palabras.add(new Palabra("oveja", "sheep", R.drawable.oveja));
        palabras.add(new Palabra("caballo", "horse", R.drawable.caballo));
        palabras.add(new Palabra("chancho", "pig", R.drawable.chancho));
        palabras.add(new Palabra("gallina", "chicken", R.drawable.gallina));
    }

    public void traducir(String palabra) {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();
        }

        Palabra foundPalabra = buscarPalabra(palabra);

        if (foundPalabra != null) {
            mMensaje.setValue(foundPalabra.getTraduccion());
            Intent intent = new Intent(getApplication(), TraduccionActivity.class);
            intent.putExtra("palabra", foundPalabra);
            getApplication().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            mMensaje.setValue("palabra no encontrada");
        }
    }

    private Palabra buscarPalabra(String palabra) {
        for (Palabra p : palabras) {
            if (p.getPalabra().equalsIgnoreCase(palabra)) {
                return p;
            }
        }
        return null;
    }
}
