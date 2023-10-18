package es.ulpgc.eite.da.cleancode_hellosync.hello;

import java.lang.ref.WeakReference;

public interface HelloContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayHelloData(HelloViewModel viewModel);
    void navigateToByeScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void onResumeCalled();
    void sayHelloButtonClicked();
    void goByeButtonClicked();

    void onPauseCalled();
  }

  interface Model {

    String getHelloMessage();
  }
}