package com.example.virtualink.d3;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MiPresupuestoViewModel extends AndroidViewModel {

    Executor executor;

    CalculoPresupuesto simulador;

    MutableLiveData<Double> precio = new MutableLiveData<>();
    MutableLiveData<Integer> errorAlto = new MutableLiveData<>();
    MutableLiveData<Integer> errorAncho = new MutableLiveData<>();
    MutableLiveData<Boolean> calculando = new MutableLiveData<>();

    public MiPresupuestoViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new CalculoPresupuesto();
    }

    public void calcular(int alto, int ancho) {

        final CalculoPresupuesto.Solicitud solicitud = new CalculoPresupuesto.Solicitud(alto, ancho);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.calcular(solicitud, new CalculoPresupuesto.Callback() {
                @Override
                public void cuandoEsteCalculadoElPrecio(double precioResultante) {
                    errorAlto.postValue(null);
                    errorAncho.postValue(null);
                    precio.postValue(precioResultante);
                }

                    @Override
                    public void cuandoHayaErrorDeAltoInferiorAlMinimo(int altoMinimo) {
                        errorAlto.postValue(altoMinimo);
                    }

                    @Override
                    public void cuandoHayaErrorDeAnchoInferiorAlMinimo(int anchoMinimo) {
                        errorAncho.postValue(anchoMinimo);
                    }

                    @Override
                    public void cuandoEmpieceElCalculo() {
                        calculando.postValue(true);
                    }

                    @Override
                    public void cuandoFinaliceElCalculo() {
                        calculando.postValue(false);
                    }

            });
            }
        });
    }
}