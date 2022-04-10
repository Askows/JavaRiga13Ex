package com.strannikov.javariga13ex.selfcheck1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmallLazer implements Gun{
    @Override
    public int shoot() {
      log.info("pif-paf");
      return 3;
    }
}
