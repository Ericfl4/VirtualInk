package com.example.virtualink.d3;

public class CalculoPresupuesto {

    public static class Solicitud {
        public int alto;
        public int ancho;

        public Solicitud(int alto, int ancho) {
            this.alto = alto;
            this.ancho = ancho;
        }
    }
    interface Callback {
        void cuandoEsteCalculadoElPrecio(double precio);
        void cuandoHayaErrorDeAltoInferiorAlMinimo(int altoMinimo);
        void cuandoHayaErrorDeAnchoInferiorAlMinimo(int anchoMinimo);
        void cuandoEmpieceElCalculo();
        void cuandoFinaliceElCalculo();
    }

    public void calcular(Solicitud solicitud, Callback callback) {

        callback.cuandoEmpieceElCalculo();

        int altoMinimo = 0;
        int anchoMinimo = 0;

        try {
            Thread.sleep(1000);  // long run operation
            altoMinimo = 2;
            anchoMinimo = 2;
        } catch (InterruptedException e) {}

        callback.cuandoEsteCalculadoElPrecio((solicitud.alto*solicitud.ancho)*7);


        boolean error = false;
        if (solicitud.alto < altoMinimo) {
            callback.cuandoHayaErrorDeAltoInferiorAlMinimo(altoMinimo);
            error = true;
        }

        if (solicitud.ancho < anchoMinimo) {
            callback.cuandoHayaErrorDeAnchoInferiorAlMinimo(anchoMinimo);
            error = true;
        }

        if(!error) {
            callback.cuandoEsteCalculadoElPrecio((solicitud.alto*solicitud.ancho)*7);
        }

        callback.cuandoFinaliceElCalculo();

    }
}