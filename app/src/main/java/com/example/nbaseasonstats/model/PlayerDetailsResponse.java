package com.example.nbaseasonstats.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class PlayerDetailsResponse {
  
  @SerializedName("games_played")
  private Long gamesPlayed = null;
  
  @SerializedName("player_id")
  private Long playerId = null;
  
  @SerializedName("min")
  private String min = null;
  
  @SerializedName("pts")
  private Double pts = null;
  
  @SerializedName("reb")
  private Double reb = null;
  
  @SerializedName("oreb")
  private Double oreb = null;
  
  @SerializedName("dreb")
  private Double dreb = null;
  
  @SerializedName("ast")
  private Double ast = null;
  
  @SerializedName("stl")
  private Double stl = null;
  
  @SerializedName("blk")
  private Double blk = null;
  
  @SerializedName("fgm")
  private Double fgm = null;
  
  @SerializedName("fg3m")
  private Double fg3m = null;
  
  @SerializedName("fg_pct")
  private Double fgPct = null;
  
  @SerializedName("fg3_pct")
  private Double fg3Pct = null;
  

  public Long getGamesPlayed() {
    return gamesPlayed;
  }
  public void setGamesPlayed(Long gamesPlayed) {
    this.gamesPlayed = gamesPlayed;
  }


  public Long getPlayerId() {
    return playerId;
  }
  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }


  public String getMin() {
    return min;
  }
  public void setMin(String min) {
    this.min = min;
  }


  public Double getPts() {
    return pts;
  }
  public void setPts(Double pts) {
    this.pts = pts;
  }


  public Double getReb() {
    return reb;
  }
  public void setReb(Double reb) {
    this.reb = reb;
  }


  public Double getOreb() {
    return oreb;
  }
  public void setOreb(Double oreb) {
    this.oreb = oreb;
  }


  public Double getDreb() {
    return dreb;
  }
  public void setDreb(Double dreb) {
    this.dreb = dreb;
  }


  public Double getAst() {
    return ast;
  }
  public void setAst(Double ast) {
    this.ast = ast;
  }


  public Double getStl() {
    return stl;
  }
  public void setStl(Double stl) {
    this.stl = stl;
  }


  public Double getBlk() {
    return blk;
  }
  public void setBlk(Double blk) {
    this.blk = blk;
  }


  public Double getFgm() {
    return fgm;
  }
  public void setFgm(Double fgm) {
    this.fgm = fgm;
  }


  public Double getFg3m() {
    return fg3m;
  }
  public void setFg3m(Double fg3m) {
    this.fg3m = fg3m;
  }


  public Double getFgPct() {
    return fgPct;
  }
  public void setFgPct(Double fgPct) {
    this.fgPct = fgPct;
  }


  public Double getFg3Pct() {
    return fg3Pct;
  }
  public void setFg3Pct(Double fg3Pct) {
    this.fg3Pct = fg3Pct;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerDetailsResponse playerDetails = (PlayerDetailsResponse) o;
    return Objects.equals(gamesPlayed, playerDetails.gamesPlayed) &&
        Objects.equals(playerId, playerDetails.playerId) &&
        Objects.equals(min, playerDetails.min) &&
        Objects.equals(pts, playerDetails.pts) &&
        Objects.equals(reb, playerDetails.reb) &&
        Objects.equals(oreb, playerDetails.oreb) &&
        Objects.equals(dreb, playerDetails.dreb) &&
        Objects.equals(ast, playerDetails.ast) &&
        Objects.equals(stl, playerDetails.stl) &&
        Objects.equals(blk, playerDetails.blk) &&
        Objects.equals(fgm, playerDetails.fgm) &&
        Objects.equals(fg3m, playerDetails.fg3m) &&
        Objects.equals(fgPct, playerDetails.fgPct) &&
        Objects.equals(fg3Pct, playerDetails.fg3Pct);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gamesPlayed, playerId, min, pts, reb, oreb, dreb, ast, stl, blk, fgm, fg3m, fgPct, fg3Pct);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayerDetails {\n");
    
    sb.append("    gamesPlayed: ").append(toIndentedString(gamesPlayed)).append("\n");
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    pts: ").append(toIndentedString(pts)).append("\n");
    sb.append("    reb: ").append(toIndentedString(reb)).append("\n");
    sb.append("    oreb: ").append(toIndentedString(oreb)).append("\n");
    sb.append("    dreb: ").append(toIndentedString(dreb)).append("\n");
    sb.append("    ast: ").append(toIndentedString(ast)).append("\n");
    sb.append("    stl: ").append(toIndentedString(stl)).append("\n");
    sb.append("    blk: ").append(toIndentedString(blk)).append("\n");
    sb.append("    fgm: ").append(toIndentedString(fgm)).append("\n");
    sb.append("    fg3m: ").append(toIndentedString(fg3m)).append("\n");
    sb.append("    fgPct: ").append(toIndentedString(fgPct)).append("\n");
    sb.append("    fg3Pct: ").append(toIndentedString(fg3Pct)).append("\n");
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
