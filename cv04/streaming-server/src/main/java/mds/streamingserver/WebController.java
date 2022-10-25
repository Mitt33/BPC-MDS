package mds.streamingserver;

import mds.streamingserver.components.MyResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class WebController {

    private MyResourceHttpRequestHandler handler;

    @Autowired
    public WebController(MyResourceHttpRequestHandler handler){
        this.handler = handler;
    }
    public final static File MP4_FILE = new File("D:\\MDS\\files\\videos\\bbb_1080p.mp4");

    @GetMapping("video")
    public String video(){
        return "videoMP4";
    }

    @GetMapping(path = "file", produces = "video/mp4")
    @ResponseBody
    public FileSystemResource file(){
        return new FileSystemResource(MP4_FILE);
    }

    @GetMapping("byterange")
    public void byterange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE);
        handler.handleRequest(request, response);
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/player", method = RequestMethod.POST)
    public String player(Model model, @RequestParam String url,
                                      @RequestParam(defaultValue = "false") boolean muted,
                                       @RequestParam(defaultValue = "false") boolean autoplay,
                                      @RequestParam(defaultValue = "1000") String width){
        if(StringUtils.isEmpty(url)){
            model.addAttribute("noUrl", "true");
        }
        model.addAttribute("url", url);
        model.addAttribute("muted", muted ? "true" : "");
        model.addAttribute("width", width);
        model.addAttribute("autoplay", autoplay ? "true" : "");

        return "player";
    }

}
