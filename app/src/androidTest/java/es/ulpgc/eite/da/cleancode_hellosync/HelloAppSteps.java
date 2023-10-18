package es.ulpgc.eite.da.cleancode_hellosync;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.RemoteException;

import androidx.test.uiautomator.UiDevice;

/**
* Created by Luis on octubre, 2023
*/

class HelloAppSteps {



  /*
  private Activity activity;

  public HelloAppSteps(Activity activity) {
    this.activity = activity;
  }
  */

  public void iniciarPantallaHello() {

  }
  
  
  public void ocultarMensajeEnPantallaHello(String msg) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    //onView(withId(R.id.helloMessage)).check(matches(not(isDisplayed())));
    onView(withId(R.id.helloMessage)).check(matches(isDisplayed()));
    /*onView(withId(R.id.helloMessage))
        .check(matches(withText(activity.getString(R.string.empty_text))));*/
    onView(withId(R.id.helloMessage)).check(matches(withText(msg)));
  }

  public void pulsarBotonSayHello() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.sayHelloButton)).check(matches(isDisplayed()));
    onView(withId(R.id.sayHelloButton)).perform(click());
  }

  public void girarPantalla(Activity activity) {

    int orientation = activity.getRequestedOrientation();

    if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
      orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

    } else {
      orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    }

    activity.setRequestedOrientation(orientation);

    try {
      UiDevice device = UiDevice.getInstance(getInstrumentation());

      if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
        device.setOrientationNatural();

      } else {
        device.setOrientationLeft();
      }

    } catch (RemoteException e) {
    }

    /*
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }
    */
  }

  public void mostrarMensajeHelloWorldEnPantallaHello(String msg) {

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.helloMessage)).check(matches(isDisplayed()));
    /*onView(withId(R.id.helloMessage))
        .check(matches(withText(activity.getString(R.string.hello_message))));*/
    onView(withId(R.id.helloMessage)).check(matches(withText(msg)));
  }

  public void pulsarBotonGoBye() {
    onView(withId(R.id.goByeButton)).check(matches(isDisplayed()));
    onView(withId(R.id.goByeButton)).perform(click());
  }

  public void iniciarPantallaBye() {

  }

  public void ocultarMensajeEnPantallaBye(String msg) {
    //onView(withId(R.id.byeMessage)).check(matches(not(isDisplayed())));
    onView(withId(R.id.byeMessage)).check(matches(isDisplayed()));
    /*onView(withId(R.id.byeMessage))
        .check(matches(withText(activity.getString(R.string.empty_text))));*/
    onView(withId(R.id.byeMessage)).check(matches(withText(msg)));
  }

  public void pulsarBotonBack() {
    pressBack();

    /*try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }*/
  }

  public void mostrarMensajeHelloWorldEnPantallaBye(String msg) {

    onView(withId(R.id.byeMessage)).check(matches(isDisplayed()));
    /*onView(withId(R.id.byeMessage))
        .check(matches(withText(activity.getString(R.string.hello_message))));*/
    onView(withId(R.id.byeMessage)).check(matches(withText(msg)));
  }

  public void pulsarBotonGoHello() {
    onView(withId(R.id.goHelloButton)).check(matches(isDisplayed()));
    onView(withId(R.id.goHelloButton)).perform(click());
  }

  public void finalizarPantallaBye() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }
  }

  public void resumirPantallaHello() {

  }

  public void pulsarBotonSayBye() {
    onView(withId(R.id.sayByeButton)).check(matches(isDisplayed()));
    onView(withId(R.id.sayByeButton)).perform(click());
  }

  public void mostrarMensajeByeWorldEnPantallaBye(String msg) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.byeMessage)).check(matches(isDisplayed()));
    /*onView(withId(R.id.byeMessage))
        .check(matches(withText(activity.getString(R.string.bye_message))));*/
    onView(withId(R.id.byeMessage)).check(matches(withText(msg)));
  }

  public void mostrarMensajeByeWorldEnPantallaHello(String msg) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {

    }

    onView(withId(R.id.helloMessage)).check(matches(isDisplayed()));
    /*onView(withId(R.id.helloMessage))
        .check(matches(withText(activity.getString(R.string.bye_message))));*/
    onView(withId(R.id.helloMessage)).check(matches(withText(msg)));
  }
}
