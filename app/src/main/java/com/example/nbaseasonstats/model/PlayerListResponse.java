package com.example.nbaseasonstats.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PlayerListResponse {
  
  @SerializedName("data")
  private List<PlayerListItemResponse> data = new ArrayList<PlayerListItemResponse>();
  

  public List<PlayerListItemResponse> getData() {
    return data;
  }
  public void setData(List<PlayerListItemResponse> data) {
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
    PlayerListResponse playerList = (PlayerListResponse) o;
    return Objects.equals(data, playerList.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayerList {\n");
    
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
