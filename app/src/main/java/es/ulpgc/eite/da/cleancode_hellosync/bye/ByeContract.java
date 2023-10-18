package es.ulpgc.eite.da.cleancode_hellosync.bye;

import java.lang.ref.WeakReference;


public interface ByeContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayByeData(ByeViewModel viewModel);
    void finishView();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void onResumeCalled();
    void sayByeButtonClicked();
    void goHelloButtonClicked();

    void onPauseCalled();

    void onBackPressed();
  }

  interface Model {

    String getByeMessage();
  }

}