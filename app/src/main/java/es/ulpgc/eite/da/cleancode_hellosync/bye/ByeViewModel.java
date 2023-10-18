package es.ulpgc.eite.da.cleancode_hellosync.bye;

import java.util.Objects;

public class ByeViewModel  {

  public String byeMessage = "?";
  //public String message = "";

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ByeViewModel that = (ByeViewModel) obj;
    return Objects.equals(byeMessage, that.byeMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(byeMessage);
  }

  @Override
  public String toString() {
    return
        "byeMessage: " + byeMessage;
  }
}

