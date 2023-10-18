package es.ulpgc.eite.da.cleancode_hellosync.hello;


import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.cleancode_hellosync.R;
import es.ulpgc.eite.da.cleancode_hellosync.app.AppMediator;


public class HelloScreen {

  public static void configure(HelloContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    String message = context.get().getString(R.string.hello_message);

    AppMediator mediator = AppMediator.getInstance();

    HelloContract.Presenter presenter = new HelloPresenter(mediator);
    HelloContract.Model model = new HelloModel(message);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);

    view.injectPresenter(presenter);

  }

}
