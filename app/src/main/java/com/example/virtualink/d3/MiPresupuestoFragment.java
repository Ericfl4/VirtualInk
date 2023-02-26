package com.example.virtualink.d3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.virtualink.databinding.FragmentMiPresupuestoBinding;

import org.jetbrains.annotations.Nullable;

public class MiPresupuestoFragment extends Fragment {
    private FragmentMiPresupuestoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMiPresupuestoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final MiPresupuestoViewModel miPresupuestoViewModel = new ViewModelProvider(this).get(MiPresupuestoViewModel.class);

        binding.calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int alto = Integer.parseInt(binding.alto.getText().toString());
                int ancho = Integer.parseInt(binding.ancho.getText().toString());

                miPresupuestoViewModel.calcular(alto, ancho);
            }
        });

        miPresupuestoViewModel.precio.observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double precio) {
                binding.precio.setText(String.format("%.2f",precio));
            }
        });

        miPresupuestoViewModel.errorAlto.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer altoMinimo) {
                if (altoMinimo != null) {
                    binding.alto.setError("El alto no puede ser inferor a " + altoMinimo + " cm");
                } else {
                    binding.alto.setError(null);
                }
            }
        });

        miPresupuestoViewModel.errorAncho.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer anchoMinimo) {
                if (anchoMinimo != null) {
                    binding.ancho.setError("El ancho no puede ser inferior a " + anchoMinimo + " cm");
                } else {
                    binding.ancho.setError(null);
                }
            }
        });

        miPresupuestoViewModel.calculando.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean calculando) {
                if (calculando) {
                    binding.calculando.setVisibility(View.VISIBLE);
                    binding.precio.setVisibility(View.GONE);
                } else {
                    binding.calculando.setVisibility(View.GONE);
                    binding.precio.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}