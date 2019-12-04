package cn.aethli.thoth.dto;

import cn.aethli.thoth.common.enums.LotteryType;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Termite
 * @device Hades
 * @date 2019-12-02 16:33
 */
@Data
@Slf4j
public class Lottery {

  @JsonProperty("values")
  private String values;

  @JsonProperty("term")
  private String term;

  @JsonProperty("type")
  private LotteryType type;

  @JsonProperty("date")
  private Date date;

  private int differentCount = 0;

  public boolean moreSimilarThan(Lottery competitor, Lottery sample) {
    char[] currentChars = values.toCharArray();
    char[] sampleChars = sample.values.toCharArray();
    for (int i = 0; i < currentChars.length; i++) {
      try {
        if (currentChars[i] != sampleChars[i]) {
          differentCount++;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        log.error("current:term={},type={}",term,type.getDesc());
        log.error("sample:term={},type={}",term,type.getDesc());
        log.error(e.getMessage(), e);
      }
    }
    if (differentCount > competitor.differentCount) {
      return false;
    }
    return true;
  }
}
