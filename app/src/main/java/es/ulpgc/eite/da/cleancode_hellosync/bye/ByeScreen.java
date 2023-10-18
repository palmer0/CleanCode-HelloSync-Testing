package es.ulpgc.eite.da.cleancode_hellosync.bye;


import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.cleancode_hellosync.R;
import es.ulpgc.eite.da.cleancode_hellosync.app.AppMediator;


public class ByeScreen {

  public static void configure(ByeContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    String message = context.get().getString(R.string.bye_message);

    AppMediator mediator = AppMediator.getInstance();

    ByeContract.Presenter presenter = new ByePresenter(mediator);
    ByeContract.Model model = new ByeModel(message);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);

    view.injectPresenter(presenter);

  }

}
