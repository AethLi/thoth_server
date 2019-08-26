package cn.aethli.thoth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-23 11:02
 **/
@Data
@Table(name = "detail")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true,value = {"lottery"})
public class Detail {

  @Id
  @Column(name = "detail_id", length = 36)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
  private String id;
  @Column(name = "all_money")
  @JsonProperty(value = "allmoney")
  private String allMoney;
  @Column(name = "level")
  @JsonProperty(value = "level")
  private String level;
  @Column(name = "money")
  @JsonProperty(value = "money")
  private String money;
  @Column(name = "num")
  @JsonProperty(value = "num")
  private Integer num;
  @Column(name = "piece")
  @JsonProperty(value = "piece")
  private String piece;
  @Column(name = "sendPrize")
  @JsonProperty(value = "sendPrize")
  private String sendPrize;
  @ManyToOne
  @JoinColumn(name = "lottery_id")
  private Lottery lottery;
}