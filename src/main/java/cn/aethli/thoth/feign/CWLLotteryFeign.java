package cn.aethli.thoth.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-26 16:28
 **/
@FeignClient(url = "http://www.cwl.gov.cn", name = "cwl")
public interface CWLLotteryFeign {

  /**
   * 福彩(这个请求需要请求头包含Referer)
   *
   * @param name:彩票种类:双色球(ssq),七乐彩(qlc),福彩3D(3d)
   * @param issueCount:多少期数
   * @param issueStart:开始期号
   * @param issueEnd:结束期号
   * @param dayStart:开始日期
   * @param dayEnd:结束期数
   * @return
   */
  @Headers({"Referer: http://www.cwl.gov.cn"})
  @RequestMapping(value = "/cwl_admin/kjxx/findDrawNotice", method = RequestMethod.GET)
  String getLottery(@RequestParam("name") String name,
      @RequestParam("issueCount") String issueCount,
      @RequestParam("issueStart") String issueStart,
      @RequestParam("issueEnd") String issueEnd,
      @RequestParam("dayStart") String dayStart,
      @RequestParam("dayEnd") String dayEnd);
}