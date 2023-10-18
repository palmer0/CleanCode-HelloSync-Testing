package es.ulpgc.eite.da.cleancode_hellosync.hello;

public class HelloModel implements HelloContract.Model {

  public static String TAG = HelloModel.class.getSimpleName();

  private String message;

  public HelloModel(String message) {
    this.message = message;
  }

  @Override
  public String getHelloMessage() {
    return message;
  }

}
