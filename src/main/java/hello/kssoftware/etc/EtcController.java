package hello.kssoftware.etc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/etc")
public class EtcController {

    @RequestMapping("/creditCalculator")
    public String creditCalculator() {
        return "etc/creditCalculator";
    }

    @RequestMapping("/study")
    public String study() {
        return "etc/study";
    }

    @RequestMapping("/usedTrade")
    public String usedTrade() {
        return "etc/usedTrade";
    }
}
