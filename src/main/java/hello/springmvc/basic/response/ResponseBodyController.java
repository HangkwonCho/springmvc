package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
//@Controller
//@ResponseBody
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyStringV2() throws IOException {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    //@ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyStringV3() {
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    //@ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }

//    ByteArrayHttpMessageConverter : byte[] 데이터를 처리한다.
//    클래스 타입: byte[] , 미디어타입: */* ,
//    요청 예) @RequestBody byte[] data
//    응답 예) @ResponseBody return byte[] 쓰기 미디어타입 application/octet-stream
//    StringHttpMessageConverter : String 문자로 데이터를 처리한다.
//    클래스 타입: String , 미디어타입: */*
//    요청 예) @RequestBody String data
//    응답 예) @ResponseBody return "ok" 쓰기 미디어타입 text/plain
//    MappingJackson2HttpMessageConverter : application/json
//    클래스 타입: 객체 또는 HashMap , 미디어타입 application/json 관련
//    요청 예) @RequestBody HelloData data
//    응답 예) @ResponseBody return helloData 쓰기 미디어타입 application/json 관련

}
