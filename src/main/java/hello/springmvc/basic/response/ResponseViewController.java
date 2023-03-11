package hello.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!!!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello-v2");
        return "response/hello";
    }

    /**
     * @Controller 를 사용하고, HttpServletResponse , OutputStream(Writer) 같은 HTTP 메시지
     * 바디를 처리 하는 파라미터 가 없으면 요청 URL 을 참고 해서 논리 뷰 이름 으로 사용
     * 요청 URL: /response/hello
     * 실행: templates/response/hello.html
     * 참고로 이 방식은 명시성 이 너무 떨어 지고 이렇게 딱 맞는 경우도 많이 없어서, 권장 하지 않는다.
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello-v3");
        //return "response/hello";
    }
}
