package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

    /**
     * 8. MVC와 템플릿 엔진
     * 관심사의 분리라는 원칙으로 각각의 관심사가 명확히 구분한 형태가 MVC
     *
     * ctrl + p 파라미터 정보(Parameter Info)
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody//http Body에 직접 데이터를 직접 넣겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    /**
     * 자동완성 단축키(code completion) ctrl shift enter
     */
    /**
     * @Responsebody가 없었다면
     * ViewResolver를 찾았겠지만 해당 어노테이션이 있기 때문에
     * HttpMessageConverter로 던지게됨
     */

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        /*
        Getter Setter 단추키  alt + insert
         */
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
