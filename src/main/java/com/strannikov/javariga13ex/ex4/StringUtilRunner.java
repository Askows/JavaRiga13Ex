package com.strannikov.javariga13ex.ex4;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StringUtilRunner implements CommandLineRunner {

    private final DummyLogger dummyLogger;

    private final ListUtil listUtil;

    private final StringUtil stringUtil;

    @Override
    public void run(String... args) throws Exception {
        int result = listUtil.sumElements(List.of(1, 2, 3, 4));
        String sentence = stringUtil.formSentence(List.of("words", "one", "ever"));
        dummyLogger.sayHi(result, sentence);

    }
}
