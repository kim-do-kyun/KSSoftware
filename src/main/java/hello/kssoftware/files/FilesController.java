package hello.kssoftware.files;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files")
public class FilesController {

    @RequestMapping
    public String files() {
        return "files/files";
    }
}
