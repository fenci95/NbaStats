package com.example.nbaseasonstats.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Player   {
  
  @SerializedName("data")
  private List<PlayerDetails> data = new ArrayList<PlayerDetails>();

  public List<PlayerDetails> getData() {
    return data;
  }
  public void setData(List<PlayerDetails> data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(data, player.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Player {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
