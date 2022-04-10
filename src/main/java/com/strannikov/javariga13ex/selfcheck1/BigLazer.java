package com.strannikov.javariga13ex.selfcheck1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BigLazer implements Gun{


    @Override
    public void shoot() {
      log.info("WAB! WAB WAB! WAB!");
    }
}
