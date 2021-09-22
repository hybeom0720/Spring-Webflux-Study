package sample.webflux.demo.randomnumber.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sample.webflux.demo.randomnumber.domain.RandomNumbers;

@RestController
@RequestMapping("/random")
public class RandomNumberController {

    @GetMapping("")
    public Flux<Map<String,String>> getRandomNumbers() {
        List<Integer> numbers = new LinkedList<>();
        RandomNumbers randomNumbers = new RandomNumbers(numbers);
        randomNumbers.fillRandomNumbers();
        Stream<Integer> stream = randomNumbers.getFigures().stream();
        return Flux.fromStream(stream)
            .map(i -> Collections.singletonMap("data", i + "번째입니다."));
    }

    @GetMapping("/{number}")
    public Mono<String> getRandomNumber(@PathVariable String number) {
        return Mono.just(number + "번째입니다.");
    }


}
