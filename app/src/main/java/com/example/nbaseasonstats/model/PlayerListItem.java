package com.example.nbaseasonstats.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;


public class PlayerListItem   {
  
  @SerializedName("id")
  private Long id = null;
  
  @SerializedName("first_name")
  private String firstName = null;
  
  @SerializedName("last_name")
  private String lastName = null;
  

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }


  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerListItem playerListItem = (PlayerListItem) o;
    return Objects.equals(id, playerListItem.id) &&
        Objects.equals(firstName, playerListItem.firstName) &&
        Objects.equals(lastName, playerListItem.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayerListItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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
