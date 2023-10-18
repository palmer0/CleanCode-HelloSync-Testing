package es.ulpgc.eite.da.cleancode_hellosync.hello;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.cleancode_hellosync.app.AppMediator;
import es.ulpgc.eite.da.cleancode_hellosync.app.ByeToHelloState;
import es.ulpgc.eite.da.cleancode_hellosync.app.HelloToByeState;


public class HelloPresenter implements HelloContract.Presenter {

  public static String TAG = HelloPresenter.class.getSimpleName();

  private WeakReference<HelloContract.View> view;
  private HelloState state;
  private HelloContract.Model model;
  private AppMediator mediator;

  public HelloPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getHelloState();
  }


  @Override
  public void onResumeCalled() {
    //Log.e(TAG, "onResumeCalled()");

    ByeToHelloState savedState = getDataFromByeScreen();
    if(savedState != null){

      // set passed state
      state.helloMessage = savedState.message;
    }

    view.get().displayHelloData(state);
  }

  @Override
  public void onPauseCalled() {
    //Log.e(TAG, "onPauseCalled()");

    HelloToByeState newState = new HelloToByeState(state.helloMessage);
    passDataToByeScreen(newState);

  }

  private void startHelloMessageAsyncTask() {
    //Log.e(TAG, "startHelloMessageAsyncTask()");

    // este codigo puede ir tambien en goByeButtonClicked()
    String message=model.getHelloMessage();
    state.helloMessage = message;

    view.get().displayHelloData(state);
  }

  @Override
  public void sayHelloButtonClicked() {
    //Log.e(TAG, "sayHelloButtonClicked()");

    state.helloMessage = "?";

    view.get().displayHelloData(state);

    // call the model
    startHelloMessageAsyncTask();

  }

  @Override
  public void goByeButtonClicked() {
    //Log.e(TAG, "goByeButtonClicked()");

    /*
    HelloToByeState newState = new HelloToByeState(state.helloMessage);
    passDataToByeScreen(newState);
    */

    view.get().navigateToByeScreen();
  }

  private ByeToHelloState getDataFromByeScreen() {
    return mediator.getByeToHelloState();
  }

  private void passDataToByeScreen(HelloToByeState state) {
    mediator.setHelloToByeState(state);
  }


  @Override
  public void injectView(WeakReference<HelloContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(HelloContract.Model model) {
    this.model = model;
  }
}
