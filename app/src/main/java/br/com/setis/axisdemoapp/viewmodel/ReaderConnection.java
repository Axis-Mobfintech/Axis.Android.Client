package br.com.setis.axisdemoapp.viewmodel;

class ReaderConnection {
    private static final ReaderConnection ourInstance = new ReaderConnection();

    static ReaderConnection getInstance() {
        return ourInstance;
    }

    private ReaderConnection() {

    }


}
